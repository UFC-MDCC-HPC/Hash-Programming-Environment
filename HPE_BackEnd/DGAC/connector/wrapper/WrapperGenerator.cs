using System;
using br.ufc.pargo.hpe.connector.meta;
using br.ufc.pargo.hpe.basic;
using System.CodeDom;
using System.Collections;
using System.Collections.Generic;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.backend.DGAC.database;

namespace br.ufc.hpe.backend.DGAC
{
	public interface IWrapperGenerator
	{
		IUnit create_wrapper(int id_abstract, string id_unit, int partition_index);				
	}
		
	
	public class WrapperGenerator : IWrapperGenerator
	{
		public static IWrapperGenerator instance = new WrapperGenerator();
		
		private int id_abstract;
		private string id_interface;
		private int partition_index;
				
		#region IWrapperGenerator implementation
		IUnit IWrapperGenerator.create_wrapper (int id_abstract, string id_interface, int partition_index)
		{			
			this.id_abstract = id_abstract;
			this.id_interface = id_interface;
			this.partition_index = partition_index;
			
			// create compile unit
			CodeCompileUnit compileUnit = createCompileUnit();
			
			// compile !
			
			// create unit object !
			IUnit unit_object = null;
			
			return unit_object;
		}
		#endregion
		
		
		private CodeCompileUnit createCompileUnit() 
		{
			CodeCompileUnit compileUnit = new CodeCompileUnit();
			
			#region namespace
			
			string package_path = null;
			CodeNamespace ns = new CodeNamespace(package_path);
			compileUnit.Namespaces.Add(ns);
			
			#endregion
			
			#region using dependencies
			
			//CodeNamespaceImport[] using_dependencies = createUsingDependencies();
			//ns.Imports.AddRange (using_dependencies);
			
			#endregion
								
			#region class
			
			string unit_class_name = null;
			CodeTypeDeclaration unit_class = new CodeTypeDeclaration(unit_class_name);
			ns.Types.Add(unit_class);
			
			#region class / inheritance
			
			string abstract_component_type = null;
			unit_class.BaseTypes.Add("br.ufc.pargo.hpe.ConnectorImpl.IConnectorImpl");
			unit_class.BaseTypes.Add(abstract_component_type);
			
			#endregion
		
			Interface i = BackEnd.idao.retrieve(id_abstract, id_interface, partition_index);
			InterfaceSignature interface_type_descriptor = createSliceAccessorType(i);
			
			#region class / type parameters
			
			unit_class.TypeParameters.AddRange(createContextParameters(interface_type_descriptor));
						
			#endregion 
			
			#region class / public slice accessors
			
			IList<Slice> slice_list = BackEnd.sdao.listByInterface(id_abstract, id_interface, partition_index);
			
			foreach (Slice s in slice_list) 
			{
				if (s.isPublic())
				{
				    string slice_accessor_name = s.PortName;
		
					InterfaceSignature isig_slice = interface_type_descriptor.slice_types[slice_accessor_name];
					CodeTypeReference slice_accessor_type = buildCodeTypeReference(isig_slice);
					
					CodeMemberField slice_accessor_field = createSliceAccessorField(slice_accessor_name.ToLower(), slice_accessor_type);
					unit_class.Members.Add(slice_accessor_field);
					
					CodeMemberProperty slice_accessor_property = createSliceAccessorProperty(slice_accessor_name, slice_accessor_type);
					unit_class.Members.Add(slice_accessor_property);					
				}
			}
			
			#endregion
			
			#region class / actions and condition
			
			IList<InterfaceAction> action_list = BackEnd.iadao.list(id_abstract,id_interface);
			
			foreach (InterfaceAction ia in action_list)
			{
				unit_class.Members.Add(ia.IsCondition ? createActionMethod(ia.Id_action)
				                       				  : createConditionMethod(ia.Id_action));
			}
			#endregion
			
				
			#endregion
			
			return compileUnit;
		}
		
		private CodeTypeParameter[] createContextParameters(InterfaceSignature interface_type_descriptor)
		{
			IList<CodeTypeParameter> context_parameter_list = new List<CodeTypeParameter>();
			
			foreach (KeyValuePair<string, InterfaceSignature> ctx_par in interface_type_descriptor.parameters)
			{
				string var_id = interface_type_descriptor.varId[ctx_par.Key];
				CodeTypeParameter context_variable = new CodeTypeParameter(var_id);
				CodeTypeReference context_type = buildCodeTypeReference(ctx_par.Value);
				context_variable.Constraints.Add (context_type);
				context_parameter_list.Add(context_variable);
			}
		    
			CodeTypeParameter[] context_parameters = new CodeTypeParameter[context_parameter_list.Count];
			context_parameter_list.CopyTo(context_parameters, 0);
			return context_parameters;
		}
		
		private CodeNamespaceImport[] createUsingDependencies()
		{
			IList<CodeNamespaceImport> using_dependencies_list = new List<CodeNamespaceImport>();
			
			
			IList<Slice> slice_list = BackEnd.sdao.listByInterface(id_abstract, id_interface, partition_index);
			
			foreach (Slice s in slice_list) 
			{
				InnerComponent ic = BackEnd.icdao.retrieve(s.Id_abstract, s.Id_inner);
				IList<string> package_list = fetchPackages(ic.Id_functor_app);
				foreach (string package in package_list)
				{
					CodeNamespaceImport using_dependency = new CodeNamespaceImport(package);
					using_dependencies_list.Add(using_dependency);
				}
			}
			
			CodeNamespaceImport[] using_dependencies = new CodeNamespaceImport[using_dependencies_list.Count];
			using_dependencies_list.CopyTo(using_dependencies, 0);
			return using_dependencies;
		}
		
		private IList<string> fetchPackages(int id_functor_app)
		{
			IList<string> package_list = new List<string>();
			AbstractComponentFunctorApplication acfa = BackEnd.acfadao.retrieve(id_functor_app);
			AbstractComponentFunctor acf = BackEnd.acfdao.retrieve(acfa.Id_abstract);
			package_list.Add(acf.Library_path);
			
			IList<SupplyParameter> sp_list = BackEnd.spdao.list(id_functor_app);
			foreach (SupplyParameter sp in sp_list)
			{
				if (sp is SupplyParameterComponent)
				{
					SupplyParameterComponent spc = (SupplyParameterComponent) sp;
					foreach (string pk in fetchPackages(spc.Id_functor_app_actual)) 
					{
						package_list.Add(pk);
					}
				}
				else if (sp is SupplyParameterParameter)
				{
					SupplyParameterParameter spp = (SupplyParameterParameter) sp;
					// NOTHING TO DO ... the parameter depends on the paramter of the component
				}
			}			
			
			return package_list;
		}
		
		
		private InterfaceSignature createSliceAccessorType(Interface i)
		{
			IDictionary<string,string> open_pars = new Dictionary<string, string>();
			IDictionary<string,int> closed_pars = new Dictionary<string, int>();
			IList<InterfaceParameter> ip_list = BackEnd.ipdao.list(i.Id_abstract, i.Id_interface);
			foreach (InterfaceParameter ip in ip_list)
				open_pars.Add(ip.ParId,ip.VarId);
			
			InterfaceSignature isig = calculateParameters(i, closed_pars, open_pars);
			
			return isig;			
		}
		
		private CodeTypeReference buildCodeTypeReference(InterfaceSignature isig)
		{
			CodeTypeReference slice_accessor_type = new CodeTypeReference(isig.the_interface.Class_name);
			
			foreach (KeyValuePair<string, InterfaceSignature> isig_ in isig.parameters) 
			{
				CodeTypeReference slice_accessor_arg_type;
				string par_id = isig_.Key;
				if (isig.varId.ContainsKey(par_id))
				{
					string var_id = isig.varId[isig_.Key];
					slice_accessor_arg_type = new CodeTypeReference(var_id);
				}
				else
				{
					slice_accessor_arg_type = buildCodeTypeReference (isig_.Value);
				}
				slice_accessor_type.TypeArguments.Add(slice_accessor_arg_type);
			}
			
			return slice_accessor_type;			
		}
		
		private CodeMemberField createSliceAccessorField(string slice_accessor_name, CodeTypeReference slice_accessor_type)
		{
			// class - public slice accessor - field 
			CodeMemberField slice_accessor_field = new CodeMemberField();		
			slice_accessor_field.Type = slice_accessor_type;
			slice_accessor_field.Name = slice_accessor_name;
			slice_accessor_field.Attributes = MemberAttributes.Public;
			return slice_accessor_field;
		}
		
		private CodeMemberProperty createSliceAccessorProperty(string slice_accessor_name, CodeTypeReference slice_accessor_type)
		{			  
		  CodeMemberProperty slice_accessor_property = new CodeMemberProperty();
		  slice_accessor_property.Type = slice_accessor_type;
		  slice_accessor_property.Name = slice_accessor_name.ToUpperInvariant();
		  slice_accessor_property.Attributes = MemberAttributes.Public;
		  slice_accessor_property.HasGet = true;
		  slice_accessor_property.HasSet = true;
		
		  // public slice accessor - property - get
		  {
		    // if (<slice_accessor_name> == null) <slice_accessor_name> = connector.Slice["<slice_accessor_name"];
		    {
		      CodeConditionStatement get_statement_test = new CodeConditionStatement();
		      {
		        // <slice_accessor_name> == null
		        CodeBinaryOperatorExpression condition = new CodeBinaryOperatorExpression();
		        condition.Left = new CodeVariableReferenceExpression(slice_accessor_name);
		        condition.Operator = CodeBinaryOperatorType.ValueEquality;
		        condition.Right = new CodePrimitiveExpression(null);
		        get_statement_test.Condition = condition;
		      } 			 
		      {
		        // <slice_accessor_name> = connector.Slice["<slice_accessor_name"]
		        CodeAssignStatement init_slice_stmt = new CodeAssignStatement();			
		        init_slice_stmt.Left = new CodeVariableReferenceExpression(slice_accessor_name);			
		        init_slice_stmt.Right = new CodeIndexerExpression(new CodePropertyReferenceExpression(new CodeThisReferenceExpression(), 
		                                                                                              "Slice"), 
		                                                          new CodeExpression[] {new CodePrimitiveExpression(slice_accessor_name)});
				get_statement_test.TrueStatements.Add(init_slice_stmt);			
		      }
		      slice_accessor_property.GetStatements.Add(get_statement_test);
		    }
		    // return <slice_accessor_name>;
		    {		
 		      CodeMethodReturnStatement get_statement_return = new CodeMethodReturnStatement();
		      get_statement_return.Expression = new CodeVariableReferenceExpression(slice_accessor_name);
              slice_accessor_property.GetStatements.Add(get_statement_return);
		    }
		  }
		
		  {
		    // public slice accessor - property - set
		    // <slice_accessor_name> = value;
		    CodeAssignStatement set_statement = new CodeAssignStatement();
		    set_statement.Left = new CodeVariableReferenceExpression(slice_accessor_name);
		    set_statement.Right = new CodeArgumentReferenceExpression("value");
		    slice_accessor_property.SetStatements.Add (set_statement);
		  }
		  return slice_accessor_property;		  
	    }
		
		private CodeMemberMethod createActionMethod(string action_method_name)
		{
			CodeMemberMethod action_method = new CodeMemberMethod();
			action_method.ReturnType = new CodeTypeReference("void");
			action_method.Name = action_method_name;
			{
				CodeMethodInvokeExpression action_method_invoke = new CodeMethodInvokeExpression();
				action_method_invoke.Method = new CodeMethodReferenceExpression();
				action_method_invoke.Method.TargetObject = new CodeThisReferenceExpression();
				action_method_invoke.Method.MethodName = "perform_action";
				action_method_invoke.Parameters.Add(new CodePrimitiveExpression(action_method_name));
				action_method.Statements.Add(action_method_invoke);
		    }
			return action_method;
		}
		
		private CodeMemberMethod createConditionMethod(string condition_method_name)
		{
			CodeMemberMethod condition_method = new CodeMemberMethod();
			condition_method.ReturnType = new CodeTypeReference("bool"); 
			condition_method.Name = condition_method_name;
			{
				CodeMethodInvokeExpression condition_method_invoke = new CodeMethodInvokeExpression();
				condition_method_invoke.Method = new CodeMethodReferenceExpression();
				condition_method_invoke.Method.TargetObject = new CodeThisReferenceExpression();
				condition_method_invoke.Method.MethodName = "perform_codition";
				condition_method_invoke.Parameters.Add(new CodePrimitiveExpression(condition_method_name));
						
				CodeMethodReturnStatement condition_method_return = new CodeMethodReturnStatement();
				condition_method_return.Expression = condition_method_invoke;
							
				condition_method.Statements.Add(condition_method_return);
			}			
			return condition_method;
		}
		
		private struct InterfaceSignature
		{
			public Interface the_interface;
			public IDictionary<string, InterfaceSignature> parameters; // par_id -> Interface ...			
			public IDictionary<string, string> varId;                  // par_id -> var_id ...
			public IDictionary<string, InterfaceSignature> slice_types; // port_name -> 
		}
		
		private InterfaceSignature calculateParameters(Interface i, IDictionary<string, int> closed_pars, IDictionary<string,string> open_pars)
		{
			// id_abstract, id_interface, partition_index, id_interface_super, partition_index_super, uri_source, class_nargs, id_interface_super_top, partition_index_super_top, order
			// '43', 'compute_rhs', '0', '', '0', 'adi.ComputeRHS.IComputeRHS', '', '2', 'compute_rhs', '0', '1'

			InterfaceSignature isig;
			
			isig.the_interface = i;
			isig.parameters = new Dictionary<string, InterfaceSignature>();
			isig.varId = new Dictionary<string,string>();
			isig.slice_types = new Dictionary<string, InterfaceSignature>();
			
			IList<Slice> slice_list = BackEnd.sdao.listByInterface(i.Id_abstract, i.Id_interface, i.Partition_index);
			// id_abstract, id_inner, id_interface_slice, partition_index, id_interface, property_name, transitive
			// '43', 'cells_info', 'cells', '0', 'compute_rhs', 'Cells', '0'
			// '43', 'problem_data', 'problem', '0', 'compute_rhs', 'Problem', '0'

			foreach (Slice s in slice_list)
			{
				InnerComponent ic = BackEnd.icdao.retrieve(s.Id_abstract,s.Id_inner);				
				// id_abstract_owner, id_functor_app, id_inner, id_abstract_inner, parameter_top, transitive, public
				// 1st loop: 
				// '43', '131', 'cells_info', '31', '', '0', '-1'
				// 2nd loop:
				// '43', '132', 'problem_data', '40', '', '0', '-1'
				
				int id_functor_app_actual = ic.Id_functor_app; 
				// 1st loop: id_functor_app_actual = 131 
				// 2nd loop: id_functor_app_actual = 132
                					
				Interface i_ = BackEnd.idao.retrieve(ic.Id_abstract_inner, s.Id_interface_slice, s.Partition_index);
				// id_abstract, id_interface, partition_index, id_interface_super, partition_index_super, uri_source, class_nargs, id_interface_super_top, partition_index_super_top, order
				// 1st loop:
				// '31', 'cells', '0', '', '0', 'common.datapartition.MultiPartitionCells.ICells', '', '0', 'cells', '0', '1', NULL, NULL, NULL
				// 2nd loop:
				// '40', 'problem', '0', '', '0', 'adi.data.ProblemDefinition.IProblemDefinition', '', '2', 'problem', '0', '1', NULL, NULL, NULL

				if (!ic.Parameter_top.Equals("")) // 1st loop: FALSE  2nd loop: FALSE
				{
					if (closed_pars.ContainsKey(ic.Parameter_top))
						id_functor_app_actual = closed_pars[ic.Parameter_top];
					InterfaceParameter ip = BackEnd.ipdao.retrieve(i_.Id_abstract, i_.Id_interface, ic.Parameter_top);
					AbstractComponentFunctorApplication acfa = BackEnd.acfadao.retrieve(id_functor_app_actual);
					i_ = BackEnd.idao.retrieveTop(acfa.Id_abstract, ip.Id_unit_parameter, i_.Partition_index);
				}
				
				IList<string> parameters = new List<string>();
				IDictionary<string, int> closed_pars_ = new Dictionary<string, int>();
				IDictionary<string, string> open_pars_ = new Dictionary<string, string>();
				IList<SupplyParameter> sp_list = BackEnd.spdao.list(id_functor_app_actual);
				// id_parameter, id_functor_app, id_abstract
				// 1st loop: empty
				// 2nd loop: 
				// 'class', '132', '40'
				// 'instance_type', '132', '40'				
				foreach (SupplyParameter sp in sp_list)
				{
					if (sp is SupplyParameterComponent) // always false
					{
						SupplyParameterComponent spc = (SupplyParameterComponent) sp;
						closed_pars_.Add(spc.Id_parameter, spc.Id_functor_app_actual);
					}
					else if (sp is SupplyParameterParameter)
					{
						SupplyParameterParameter spp = (SupplyParameterParameter) sp;
						// id_parameter, id_functor_app, id_parameter_actual, freeVariable
						// 2nd outer loop / 1st inner loop:
						// 'class', '132', 'class', '0'
						// 2nd outer loop / 2nd inner loop
                        // 'instance_type', '132', 'instance_type', '0'
						int id_functor_app_actual_parameter;
						if (closed_pars.ContainsKey(spp.Id_parameter_actual)) // ALWAYS FALSE
						{
							id_functor_app_actual_parameter = closed_pars[spp.Id_parameter_actual];
							closed_pars_.Add(spp.Id_parameter, id_functor_app_actual_parameter);
						}
						else if (open_pars.ContainsKey(spp.Id_parameter_actual))
						{
							open_pars_.Add(spp.Id_parameter, open_pars[spp.Id_parameter_actual]);
							// 2nd outer loop / 1st inner loop: add 'class' -> 'C'
							// 2nd outer loop / 2nd inner loop: add 'instance_type' -> 'I'
						} 
						else
						{
							// NEVER REACH THIS ARM ...
						}
												
						parameters.Add(spp.Id_parameter);
						// 2nd outer loop / 1st inner loop: add 'class'
						// 2nd outer loop / 2nd inner loop: add 'instance_type'
					}
				}
				
				InterfaceSignature par_ic = calculateParameters(i_, closed_pars_, open_pars_);
				isig.slice_types.Add (s.PortName, par_ic);
				// 1st loop:
				// InterfaceSignature [
				//    the_interface = ('31', 'cells', '0', '', '0', 'common.datapartition.MultiPartitionCells.ICells', '', '0', 'cells', '0', '1')
				//    parameters = {}
				//    parId = {}
				// ]
				// 2nd loop:
				// InterfaceSignature [
				//    the_interface = ('40', 'problem', '0', '', '0', 'adi.data.ProblemDefinition.IProblemDefinition', '', '2', 'problem', '0', '1')
				//    parameters = {C -> InterfaceSignature [ IClass ... ] , I -> InterfaceSignature [ IInstance ... ]}
				//    parId = {C -> class, I -> instance_type}
				// ]
				foreach (KeyValuePair<string, InterfaceSignature> is_par in par_ic.parameters)
				{
					string par_id = is_par.Key;            
					// 2nd outer loop / 1st inner loop: var_id = C, par_id = class
					// 2nd outer loop / 2nd inner loop: var_id = I, par_id = instance_type
					if (parameters.Contains(par_id)) 
					{
						isig.parameters.Add(par_id, is_par.Value);
						// 2nd outer loop / 1st inner loop: add (class, InterfaceSignature [ IClass ... ])
						// 2nd outer loop / 2nd inner loop: add (instance_type, InterfaceSignature [ IInstance[C] ... ])						
						if (open_pars_.ContainsKey(par_id))
							isig.varId.Add(par_id, open_pars_[par_id]);
							// 2nd outer loop / 1st inner loop: add (class, C)
							// 2nd outer loop / 2nd inner loop: add (instance_type, I)
					}
				}
			
				if (!ic.Parameter_top.Equals("")) // never
				{
					isig.parameters.Add(ic.Parameter_top, par_ic);
					if (open_pars.ContainsKey(ic.Parameter_top))
						isig.varId.Add(ic.Parameter_top, open_pars[ic.Parameter_top]);
				}
			}
			
			
			return isig;
		}
		
	}
}


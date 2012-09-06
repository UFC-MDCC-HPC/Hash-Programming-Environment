using System;
using br.ufc.pargo.hpe.connector.meta;
using br.ufc.pargo.hpe.basic;
using System.CodeDom;
using System.Collections;
using System.Collections.Generic;

namespace br.ufc.hpe.backend.DGAC
{
	public interface IWrapperGenerator
	{
		IUnit create_wrapper(MetaHashComponent config);				
	}
		
	
	public class WrapperGenerator : IWrapperGenerator
	{
		public static IWrapperGenerator instance = new WrapperGenerator();

		#region IWrapperGenerator implementation
		IUnit IWrapperGenerator.create_wrapper (MetaHashComponent config)
		{
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
			
			CodeNamespaceImport[] using_dependencies = createUsingDependencies();
			ns.Imports.AddRange (using_dependencies);
			
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
			
			#region class / type parameters
			
			CodeTypeParameter[] context_parameters = createContextParameters();
			unit_class.TypeParameters.AddRange(context_parameters);
			
			#endregion 
			
			#region class / public slice accessors
			
			// for each public slice accessor ...
			{
			    string slice_accessor_name = null;
				string slice_accessor_type_string = null;
	
				CodeTypeReference slice_accessor_type = createSliceAccessorType(slice_accessor_type_string);
				
				CodeMemberField slice_accessor_field = createSliceAccessorField(slice_accessor_name, slice_accessor_type);
				unit_class.Members.Add(slice_accessor_field);
				
				CodeMemberProperty slice_accessor_property = createSliceAccessorProperty(slice_accessor_name, slice_accessor_type);
				unit_class.Members.Add(slice_accessor_property);					
			}
			
			#endregion
			
			#region class / actions		
			// for each action ...
			{
			  	string action_method_name = null;
				unit_class.Members.Add(createActionMethod(action_method_name));
			}
			#endregion
			
			#region class / conditions
			/* class - conditions */
			
			// for each condition ...
			{
				string condition_method_name = null;
				unit_class.Members.Add(createConditionMethod(condition_method_name));
			}
			#endregion
				
			#endregion
			
			return compileUnit;
		}
		
		private CodeTypeParameter[] createContextParameters()
		{
			IList<CodeTypeParameter> context_parameter_list = new List<CodeTypeParameter>();
			
			// for all context parameters ...
			CodeTypeParameter context_parameter = new CodeTypeParameter("???");			
			context_parameter.Constraints.Add (new CodeTypeReference("???"));
			context_parameter_list.Add(context_parameter);
		    
			CodeTypeParameter[] context_parameters = new CodeTypeParameter[context_parameter_list.Count];
			context_parameter_list.CopyTo(context_parameters, 0);
			return context_parameters;
		}
		
		private CodeNamespaceImport[] createUsingDependencies()
		{
			IList<CodeNamespaceImport> using_dependencies_list = new List<CodeNamespaceImport>();
			
			// for all dependencies ...
			CodeNamespaceImport using_dependency = new CodeNamespaceImport(" ??? ");
			using_dependencies_list.Add(using_dependency);
			
			CodeNamespaceImport[] using_dependencies = new CodeNamespaceImport[using_dependencies_list.Count];
			using_dependencies_list.CopyTo(using_dependencies, 0);
			return using_dependencies;
		}
		
		private CodeTypeReference createSliceAccessorType(string slice_accessor_type_string)
		{
			CodeTypeReference slice_accessor_type = new CodeTypeReference(slice_accessor_type_string);
			slice_accessor_type.TypeArguments.Add("");				
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
		
	}
}


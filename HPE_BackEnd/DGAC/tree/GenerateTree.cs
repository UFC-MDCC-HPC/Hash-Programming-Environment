// /home/jefferson/projetos/hashmodel_monodevelop/hashmodel_monodevelop/tree/GenerateTree.cs created with MonoDevelop
// User: jefferson at 09:51 22/5/2008
//
// To change standard headers go to Edit->Preferences->Coding->Standard Headers
//

using System;
using System.Collections.Generic; 
using System.Collections;
using br.ufc.pargo.hpe.basic;

namespace br.ufc.pargo.hpe.backend.DGAC.database
{
	
	
	public class GenerateTree
	{
        private static IDictionary<String, String> mmm = null;


        public static TreeNode generate(IDictionary<string,int> actualParametersTop, AbstractComponentFunctorApplication acfaRef)
        {
            mmm = new Dictionary<String, String>();

            IDictionary<string, TreeNode> memory = new Dictionary<string, TreeNode>();

            IList<AbstractComponentFunctorApplication> lll = new List<AbstractComponentFunctorApplication>();
            lll.Add(acfaRef);

            TreeNode root = new TreeNode(lll, null);
            ArrayList queue = new ArrayList();
            queue.Add(root);

            while (queue.Count != 0)
            {
                TreeNode nodeRef = (TreeNode)queue[0];

                int id_abstract = nodeRef.Functor_app.Id_abstract;
                int id_functor_app_actual = nodeRef.Functor_app.Id_functor_app;
                int id_abstract_top = nodeRef.Functor_app_top.Id_abstract;

                queue.RemoveAt(0);

                IList<SupplyParameter> parameterList = br.ufc.pargo.hpe.backend.DGAC.BackEnd.spdao.list(id_functor_app_actual);
                foreach (SupplyParameter sp in parameterList)
                {
					bool freeVariable = false;
					
                    string parameter_id = sp.Id_parameter;

                    AbstractComponentFunctorApplication acfaTop = null;
                    if (id_abstract_top != id_abstract)
                    {
                        AbstractComponentFunctorParameter acfpTop = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfpdao.retrieve(id_abstract_top, parameter_id);
                        acfaTop = acfpTop == null ? null : br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfadao.retrieve(acfpTop.Bounds_of);
                        if (acfaTop == null)
                        {
                            AbstractComponentFunctorParameter acfp = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfpdao.retrieve(id_abstract, parameter_id);
                            acfaTop = acfp == null ? null : br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfadao.retrieve(acfp.Bounds_of);
                        }
                    }
                    else
                    {
                        AbstractComponentFunctorParameter acfp = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfpdao.retrieve(id_abstract, parameter_id);
                        acfaTop = acfp == null ? null : br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfadao.retrieve(acfp.Bounds_of);
                    }

					//Console.WriteLine("acfaTop is null ? " + (acfaTop==null));
					
                    AbstractComponentFunctorApplication acfaActual = null;
                    if (sp is SupplyParameterComponent)
                    {
                        SupplyParameterComponent spc = (SupplyParameterComponent)sp;
						//Console.WriteLine ("acfaActual 1 ??? " + spc.Id_functor_app_actual);
                        acfaActual = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfadao.retrieve(spc.Id_functor_app_actual);
                    }
                    else if (sp is SupplyParameterParameter)
                    {
						SupplyParameterParameter spp = (SupplyParameterParameter)sp;
                        int Id_functor_app_actual = 0;
                        acfaRef.ParametersList.TryGetValue(parameter_id, out Id_functor_app_actual);
						
						//Console.WriteLine (" acfaRef.ParametersList.Count = " + acfaRef.ParametersList.Count);
						//foreach (KeyValuePair<string,int> p in acfaRef.ParametersList)
							//Console.WriteLine("acfaRef.ParametersList -- " + p.Key + " -> " + p.Value);
						
                        if (Id_functor_app_actual <= 0) // LOOK AT THE TOP PARAMETERS
                        {
                            bool found = actualParametersTop.TryGetValue(spp.Id_parameter_actual, out Id_functor_app_actual);
						   // Console.WriteLine (" actualParametersTop.Count = " + actualParametersTop.Count);
						   // foreach (KeyValuePair<string,int> p in actualParametersTop)
							//     Console.WriteLine("actualParametersTop -- " + p.Key + " -> " + p.Value);
							if (!found)
							{	
								string key = spp.Id_parameter_actual + "#" + sp.Id_functor_app;
								//Console.WriteLine ("key ??? " + key);
								acfaRef.ParametersList.TryGetValue(key, out Id_functor_app_actual);
							}
							
							/* if (acfaActual == null) {
								Console.WriteLine("acfaActial NULL 2 !!!!" + spp.Id_parameter_actual + " - " + parameter_id);
								foreach (KeyValuePair<string,int> par in acfaRef.ParametersList) 
								{
									Console.WriteLine("pair: " + par.Key + " -> " + par.Value);
								}
							}*/
							//Console.WriteLine ("spp.Id_parameter_actual ??? " + spp.Id_parameter_actual);
							//Console.WriteLine ("found ??? " + found);
                        }
						//Console.WriteLine ("acfaRef ??? " + acfaRef.Id_functor_app);
						//Console.WriteLine ("parameter_id ??? " + parameter_id);
						//Console.WriteLine ("acfaActual 2 ??? " + Id_functor_app_actual);
						if (Id_functor_app_actual <= 0) {
							// FREE VARIABLE !!! USE THE BOUND !!!
							//AbstractComponentFunctorApplication acfaParF = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfadao.retrieve(spp.Id_functor_app);
							//AbstractComponentFunctorParameter parF = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfpdao.retrieve(acfaParF.Id_abstract,parameter_id);
							//Id_functor_app_actual = parF.Bounds_of;
							//Console.WriteLine ("FREE VARIABLE !!! BOUND=" + Id_functor_app_actual);
							freeVariable = true;
						} 
                        acfaActual = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfadao.retrieve(Id_functor_app_actual);
                    }
					
					//Console.WriteLine("acfaActual is null ? " + (acfaActual==null));

					if (!freeVariable) 
					{
					
	                    // LOOK FOR ACTUAL PARAMETER IDs for THE NEXT ITERATIONS !!!
	                    IList<SupplyParameter> sss = br.ufc.pargo.hpe.backend.DGAC.BackEnd.spdao.list(acfaTop.Id_functor_app);
	                    foreach (SupplyParameter sssx in sss)
	                    {
	                        if (sssx is SupplyParameterComponent)
	                        {
	                            SupplyParameterComponent ssxc = (SupplyParameterComponent)sssx;
	                            if (!mmm.ContainsKey(acfaActual.Id_functor_app + "." + ssxc.Id_parameter))
	                                mmm.Add(acfaActual.Id_functor_app + "." + ssxc.Id_parameter, ssxc.Id_parameter);
	                        }
	                        else if (sssx is SupplyParameterParameter)
	                        {
	                            SupplyParameterParameter ssxp = (SupplyParameterParameter)sssx;
	                            if (!mmm.ContainsKey(acfaActual.Id_functor_app + "." + ssxp.Id_parameter))
	                                mmm.Add(acfaActual.Id_functor_app + "." + ssxp.Id_parameter, ssxp.Id_parameter_actual);
	                        }
	
	                    }
	                    string parameter_id_2;
	                    mmm.TryGetValue(id_functor_app_actual + "." + parameter_id, out parameter_id_2);
	                    if (parameter_id_2 == null)
	                    {
	                        parameter_id_2 = parameter_id;
	                    }
	
	
	                    IList<AbstractComponentFunctorApplication> generalizeSteps = buildGeneralizationSteps(acfaActual, acfaTop);
	
	                    TreeNode node = null;
						
                        bool b = memory.TryGetValue(parameter_id_2, out node);

						if (node == null)
	                    {
	                        node = new TreeNode(generalizeSteps, nodeRef);
	                        node.addParameterIdSyn(parameter_id);
	                        node.Parameter_id = parameter_id;
	                        queue.Add(node);
	                        memory.Add(parameter_id, node);
	                    }
	                    else
	                    {
	                        node.addParameterIdSyn(parameter_id);
	                    }
						
                        nodeRef.addChild(node);
					}
					else 
					{
						
					}


                }
            }

            return root;
        }



        private static IList<AbstractComponentFunctorApplication> buildGeneralizationSteps(AbstractComponentFunctorApplication acfActual, AbstractComponentFunctorApplication acfaTop)
        {

            AbstractComponentFunctorApplication id_abstract_step = acfActual;
            AbstractComponentFunctorApplication id_abstract_top = acfaTop;
            IList<AbstractComponentFunctorApplication> gs = new List<AbstractComponentFunctorApplication>();
            AbstractComponentFunctor acf;	
            while (id_abstract_step.Id_abstract != id_abstract_top.Id_abstract)
            {
                gs.Add(id_abstract_step);
                acf = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfdao.retrieve(id_abstract_step.Id_abstract);
                id_abstract_step = br.ufc.pargo.hpe.backend.DGAC.BackEnd .acfadao.retrieve(acf.Id_functor_app_supertype);
            }            

            gs.Add(id_abstract_step);

            return gs;
        }
		
		

	}
}

// /home/jefferson/projetos/hashmodel_monodevelop/hashmodel_monodevelop/tree/GenerateTree.cs created with MonoDevelop
// User: jefferson at 09:51 22/5/2008
//
// To change standard headers go to Edit->Preferences->Coding->Standard Headers
//

using System;
using System.Collections.Generic; 
using System.Collections;
using br.ufc.pargo.hpe.basic;
using System.Diagnostics;

namespace br.ufc.pargo.hpe.backend.DGAC.database
{
	public class FreeVariableException : Exception
	{
	}
	
	public class GenerateTree
	{
        private static IDictionary<String, String> mmm = null;


        public static TreeNode generate(IDictionary<string,int> actualParametersTop, AbstractComponentFunctorApplication acfaRef)
        {
			foreach (KeyValuePair<string,int> parTop in actualParametersTop)
				Trace.WriteLine ("actualParametersTop[" + parTop.Key + "] = " + parTop.Value);

			foreach (KeyValuePair<string,int> parTop in acfaRef.ParametersList)
				Trace.WriteLine ("acfaRef.ParametersList[" + parTop.Key + "] = " + parTop.Value);

		    IDictionary<TreeNode, int> level_log = new Dictionary<TreeNode,int> ();

			Trace.WriteLine("begin generate " + acfaRef.Id_functor_app);
            mmm = new Dictionary<String, String>();

            IDictionary<int, TreeNode> memory = new Dictionary<int, TreeNode>();

            IList<AbstractComponentFunctorApplication> lll = new List<AbstractComponentFunctorApplication>();
            lll.Add(acfaRef);

            TreeNode root = new TreeNode(lll, null);
            ArrayList queue = new ArrayList();
            queue.Add(root);

			level_log.Add(root,0);

            while (queue.Count != 0)
            {

                TreeNode nodeRef = (TreeNode)queue[0];

				int level = level_log[nodeRef];
				Trace.WriteLine ("ENTERING LEVEL " + level);

                int id_abstract = nodeRef.Functor_app.Id_abstract;
                int id_functor_app_actual = nodeRef.Functor_app.Id_functor_app;
                int id_abstract_top = nodeRef.Functor_app_top.Id_abstract;

				Trace.WriteLine("Dequeue LOOP " + id_functor_app_actual);

                queue.RemoveAt(0);

                IList<SupplyParameter> parameterList = br.ufc.pargo.hpe.backend.DGAC.BackEnd.spdao.list2(id_functor_app_actual);
                foreach (SupplyParameter sp in parameterList)
                {
					bool flag_par = false;
					Trace.WriteLine("generate LOOP " + sp.Id_parameter + "," + sp.Id_functor_app + "IN LEVEL " + level);
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

					//Trace.WriteLine("acfaTop is null ? " + (acfaTop==null));
					
                    AbstractComponentFunctorApplication acfaActual = null;
                    if (sp is SupplyParameterComponent)
                    {
                        SupplyParameterComponent spc = (SupplyParameterComponent)sp;
						Trace.WriteLine ("acfaActual 1 ??? " + spc.Id_functor_app_actual);
                        acfaActual = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfadao.retrieve(spc.Id_functor_app_actual);	
						if (acfaActual == null)
							throw new FreeVariableException ();
							//flag_par = true;	
                    }
                    else if (sp is SupplyParameterParameter)
                    {
						SupplyParameterParameter spp = (SupplyParameterParameter)sp;
                        int Id_functor_app_actual = 0;

						Trace.WriteLine ("****** parameter_id#??? =" + parameter_id + "#" + sp.Id_functor_app);
						if (!(flag_par= acfaRef.ParametersList.TryGetValue(parameter_id + "#" + sp.Id_functor_app, out Id_functor_app_actual)))
								 acfaRef.ParametersList.TryGetValue(parameter_id, out Id_functor_app_actual);
						
						Trace.WriteLine (" acfaRef.ParametersList.Count = " + acfaRef.ParametersList.Count);
						foreach (KeyValuePair<string,int> p in acfaRef.ParametersList)
							Trace.WriteLine("acfaRef.ParametersList -- " + p.Key + " -> " + p.Value);
						
                        if (Id_functor_app_actual <= 0) // LOOK AT THE TOP PARAMETERS
                        {
                            bool found = actualParametersTop.TryGetValue(spp.Id_argument, out Id_functor_app_actual);
						    Trace.WriteLine (" actualParametersTop.Count = " + actualParametersTop.Count);
						    foreach (KeyValuePair<string,int> p in actualParametersTop)
							     Trace.WriteLine("actualParametersTop -- " + p.Key + " -> " + p.Value);
							if (!found)
							{	
								string key = spp.Id_argument + "#" + sp.Id_functor_app;
								Trace.WriteLine ("key ??? " + key);
								acfaRef.ParametersList.TryGetValue(key, out Id_functor_app_actual);
							}
							
							Trace.WriteLine ("spp.Id_parameter_actual ??? " + spp.Id_argument);
							Trace.WriteLine ("found ??? " + found);
                        }
						Trace.WriteLine ("acfaRef ??? " + acfaRef.Id_functor_app);
						Trace.WriteLine ("parameter_id ??? " + parameter_id);
						Trace.WriteLine ("acfaActual 2 ??? " + Id_functor_app_actual);
						if (Id_functor_app_actual <= 0) {
							// FREE VARIABLE !!! USE THE BOUND !!!
							//AbstractComponentFunctorApplication acfaParF = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfadao.retrieve(spp.Id_functor_app);
							//AbstractComponentFunctorParameter parF = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfpdao.retrieve(acfaParF.Id_abstract,parameter_id);
							//Id_functor_app_actual = parF.Bounds_of;
							//Trace.WriteLine ("FREE VARIABLE !!! BOUND=" + Id_functor_app_actual);
							freeVariable = true;
						} 
                        acfaActual = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfadao.retrieve(Id_functor_app_actual);
                    }
					
					Trace.WriteLine ("acfaActual ??? " + acfaActual.Id_functor_app);

					if (!freeVariable) 
					{					
	                    // LOOK FOR ACTUAL PARAMETER IDs for THE NEXT ITERATIONS !!!
						Trace.WriteLine ("acfaTop.Id_functor_app = " + acfaTop.Id_functor_app);
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
	                                mmm.Add(acfaActual.Id_functor_app + "." + ssxp.Id_parameter, ssxp.Id_argument);
	                        }
	
	                    }

						int memory_key = acfaActual.Id_functor_app;
	                    string parameter_id_2;
	                    mmm.TryGetValue(id_functor_app_actual + "." + parameter_id, out parameter_id_2);
	                    if (parameter_id_2 == null)
	                        parameter_id_2 = parameter_id;
						else
						    acfaRef.ParametersList.TryGetValue (parameter_id_2, out memory_key);

						TreeNode node = null;
						bool node_found = memory.TryGetValue(memory_key, out node);

						foreach (KeyValuePair<string, string> ppp in mmm)
							Trace.WriteLine ("mmm[" + ppp.Key + "]=" + ppp.Value);
						foreach (KeyValuePair<int, TreeNode> pair in memory)
							Trace.WriteLine ("memory: key=" + pair.Key + ", value=" + pair.Value.Functor_app.Id_functor_app);

						if (!node_found)
	                    {
							IList<AbstractComponentFunctorApplication> generalizeSteps = buildGeneralizationSteps(acfaActual, acfaTop);

							foreach (AbstractComponentFunctorApplication yyy in generalizeSteps) 
								Trace.WriteLine("generate - " + yyy.Id_functor_app);

	                        node = new TreeNode(generalizeSteps, nodeRef);
							level_log.Add(node, level+1);
	                        node.addParameterIdSyn(parameter_id_2);
	                        node.Parameter_id = parameter_id_2;
	                        queue.Add(node);
							Trace.WriteLine("BEGIN " + parameter_id + "," + parameter_id_2 + "," + flag_par + " *** "  + node.Functor_app.Id_functor_app);
							if (level == 0 || flag_par) 
								memory.Add (node.Functor_app.Id_functor_app/*parameter_id_2 + (flag_par ? sp.Id_functor_app.ToString () : "")*/, node);
							else 
								Trace.WriteLine ("LEVEL " + level);
							Trace.WriteLine("END" + parameter_id + "," + parameter_id_2);
	                    }
	                    else
	                    {
							Trace.WriteLine ("parameter_id_2 = " + parameter_id_2 + (flag_par ? sp.Id_functor_app.ToString() : ""));
	                        node.addParameterIdSyn(parameter_id_2);
	                    }
						
                        nodeRef.addChild(node);
					}
					else 
					{
						
					}


                }
            }

			Trace.WriteLine("end generate " + root.Parameter_id + "," +  root.Functor_app.Id_functor_app);
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
                id_abstract_step = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfadao.retrieve(acf.Id_functor_app_supertype);
            }            

            gs.Add(id_abstract_step);

            return gs;
        }
		
		

	}
}

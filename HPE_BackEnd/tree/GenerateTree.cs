// /home/jefferson/projetos/hashmodel_monodevelop/hashmodel_monodevelop/tree/GenerateTree.cs created with MonoDevelop
// User: jefferson at 09:51 22/5/2008
//
// To change standard headers go to Edit->Preferences->Coding->Standard Headers
//

using System;
using System.Collections.Generic; 
using System.Collections;
using hpe.basic;

namespace DGAC.database
{
	
	
	public class GenerateTree
	{
		public static TreeNode generate(IUnit unit, AbstractComponentFunctorApplication acfaRef){

            IList<AbstractComponentFunctorApplication> lll = new List<AbstractComponentFunctorApplication>();
            lll.Add(acfaRef);

			TreeNode root = root = new TreeNode(lll,null);
			ArrayList queue = new ArrayList();
			queue.Add(root);
            
			AbstractComponentFunctorApplicationDAO acfaDAO = new AbstractComponentFunctorApplicationDAO();
			AbstractComponentFunctorDAO acfDAO = new AbstractComponentFunctorDAO();
			AbstractComponentFunctorParameterDAO acfpDAO = new AbstractComponentFunctorParameterDAO();
            SupplyParameterDAO spDAO = new SupplyParameterDAO();

			while(queue.Count!=0){
				
				TreeNode nodeRef = (TreeNode)queue[0];
                int id_abs_ref = nodeRef.Functor_app.Id_abstract;
                int id_functor_app_actual = nodeRef.Functor_app.Id_functor_app;
                queue.RemoveAt(0);		

				IList<AbstractComponentFunctorParameter> parameterList = acfpDAO.list(id_abs_ref);
				foreach(AbstractComponentFunctorParameter acfp in parameterList)
				{
                    string parameter_id = acfp.Id_parameter;
					AbstractComponentFunctorApplication acfaTop = acfaDAO.retrieve(acfp.Bounds_of);
                    SupplyParameter sp = spDAO.retrieve(parameter_id, id_functor_app_actual);
                    AbstractComponentFunctorApplication acfaActual = null;
                    if (sp is SupplyParameterComponent)
                    {
                        SupplyParameterComponent spc = (SupplyParameterComponent)sp;
                        acfaActual = acfaDAO.retrieve(spc.Id_functor_app_actual);
                    }
                    else if (sp is SupplyParameterParameter)
                    {

                        int Id_functor_app_actual = 0;
                        acfaRef.ParametersList.TryGetValue(parameter_id, out Id_functor_app_actual);
                        if (Id_functor_app_actual <= 0) // LOOK AT THE TOP PARAMETERS
                        {
                            SupplyParameterParameter spp = (SupplyParameterParameter) sp;
                            unit.ActualParametersTop.TryGetValue(spp.Id_parameter_actual, out Id_functor_app_actual);
                        }
                        acfaActual = acfaDAO.retrieve(Id_functor_app_actual);
                        

                    }

                    IList<AbstractComponentFunctorApplication> generalizeSteps = buildGeneralizationSteps(acfaActual, acfaTop);

                    TreeNode node = new TreeNode(generalizeSteps, nodeRef);
					node.Parameter_id = acfp.Id_parameter;
					queue.Add(node);
					nodeRef.addChild(node);
				}
			}                                                    
			
			return root;
		}

        private static IList<AbstractComponentFunctorApplication> buildGeneralizationSteps(AbstractComponentFunctorApplication acfActual, AbstractComponentFunctorApplication acfaTop)
        {
            AbstractComponentFunctorApplication id_abstract_step = acfActual;
            AbstractComponentFunctorApplication id_abstract_top = acfaTop;
            IList<AbstractComponentFunctorApplication> gs = new List<AbstractComponentFunctorApplication>();

            AbstractComponentFunctorDAO acfdao = new AbstractComponentFunctorDAO();
            AbstractComponentFunctorApplicationDAO acfadao = new AbstractComponentFunctorApplicationDAO();

            while (id_abstract_step.Id_abstract != id_abstract_top.Id_abstract)
            {
                gs.Add(id_abstract_step);
                AbstractComponentFunctor acf = acfdao.retrieve(id_abstract_step.Id_abstract);                
                id_abstract_step = acfadao.retrieve(acf.Id_functor_app_supertype);
            }
            

            gs.Add(id_abstract_step);

            return gs;
        }
		
		

	}
}

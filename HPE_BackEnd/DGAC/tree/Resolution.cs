// /home/jefferson/projetos/hashmodel_monodevelop/hashmodel_monodevelop/tree/Resolution.cs created with MonoDevelop
// User: jefferson at 14:24 2/6/2008
//
// To change standard headers go to Edit->Preferences->Coding->Standard Headers
//

using System;
using System.Collections.Generic;
using hpe.basic; 

namespace DGAC.database
{
	
	
	public class Resolution
	{

        private static bool last_generalized = true;

		public static Component tryGeneralize(TreeNode CTop, TreeNode C){


            Component CTopImpl = null;
           // if (last_generalized)
            {
               // writeTreeNode(CTop); Console.WriteLine(); 
                CTopImpl = findImplementation(CTop);
                last_generalized = false;
            }
			
			if(C != null /* end of list */ && CTopImpl == null /* an implementation was not yet found */) {			
				C.reset();
                //Console.WriteLine("Reset: " + C.Functor_app.Id_abstract);
				do {
                    CTopImpl = tryGeneralize(CTop, C.Next);
                    C.generalize();
                    last_generalized = true;
				} while (!C.OnTop && CTopImpl == null);
                //if (C.OnTop)
               // {
               //     Console.WriteLine("Teto atingido : " + C.trace());
               // }
			}
			
			return CTopImpl;			
		}

        private static void writeTreeNode(TreeNode t)
        {
            Console.Write(t.Functor_app.Id_abstract + (t.Children.Count > 0 ? "[" : ""));
            foreach (TreeNode child in t.Children) {
                writeTreeNode(child);
                Console.Write(",");
            }
            Console.Write((t.Children.Count > 0 ? "]" : ""));
        }

        // EFFICIENCY IS NOT YET A CONCERN ! NEED TO IMPROVE !
        private static Component findImplementation(TreeNode CTop)
        {
			int id_abstract = CTop.Functor_app.Id_abstract; 

            AbstractComponentFunctorApplicationDAO acfadao = new AbstractComponentFunctorApplicationDAO();
			IList<AbstractComponentFunctorApplication> acfaList = acfadao.listByIdAbstract(id_abstract);

//            writeTreeNode(CTop); Console.Write("TESTING ... ");
            foreach (AbstractComponentFunctorApplication acfa in acfaList)
            {
//                Console.Write(acfa.Id_functor_app + ",");
                if (recMatchParameters(CTop, acfa)) {
					ComponentDAO cdao = new ComponentDAO();
//                    Console.WriteLine("... END TEST");
					return cdao.retrieveByFunctorApp(acfa.Id_functor_app);
				}
            }
//            Console.WriteLine("... END TEST");

            return null;
        }

        private static bool recMatchParameters(TreeNode node, AbstractComponentFunctorApplication acfa)
        {
            AbstractComponentFunctorApplication acfaSon = null;

			AbstractComponentFunctorApplicationDAO acfadao = new AbstractComponentFunctorApplicationDAO();
			
            SupplyParameterComponentDAO spdao = new SupplyParameterComponentDAO();
			IList<SupplyParameterComponent> spList = spdao.list(acfa.Id_functor_app);
			
			IDictionary<string, int> ttt = new Dictionary<string,int>();
			foreach (SupplyParameterComponent sp_ in spList) {
				SupplyParameterComponent sp = (SupplyParameterComponent) sp_;
				ttt.Add(sp.Id_parameter, sp.Id_functor_app_actual);				
			}
			
            foreach (TreeNode nodeSon in node.Children)
            {
                string parameter_id = nodeSon.Parameter_id;
//                Console.Write("CHK PARAM: " + parameter_id);
				int id_functor_app_actual = -1;
				if (ttt.ContainsKey(parameter_id)) {			
	                ttt.TryGetValue(parameter_id, out id_functor_app_actual); // TODO
					acfaSon = acfadao.retrieve(id_functor_app_actual);
					if (acfaSon.Id_abstract != nodeSon.Functor_app.Id_abstract) {
//                        Console.WriteLine("FAIL 1! ");
                        return false;
					}
//                    Console.WriteLine("MATCH! ");
				} else {
                    return false; // UNEXPECTED CONDITION ...
				}

                if (!recMatchParameters(nodeSon, acfaSon))
                       return false;

            }

            return true;        
        }


        public static void sort(TreeNode root)
        {
            lastMarked = null;
            while (!root.Closed)
               sort_(root);
        }


        private static TreeNode lastMarked = null;

        private static void sort_(TreeNode root)
        {			
			IList<TreeNode> parameters = root.Children;
			//has umarked parameters
            if (!root.Closed)
            {
                root.Closed = true;
                foreach (TreeNode parameter in parameters)
                {
                    if (parameter.Mark == false)
                    {
                        root.Closed = false;
                        parameter.Parent = root; // not really necessary.
                        sort_(parameter);
                        parameter.Parent = null;
                    }
                }
            }

            if (root.Closed)
            {
                root.Mark = true;
                root.Next = lastMarked;
                lastMarked = root;
            }			
		}
		
		public static Component findHashComponent(IUnit unit, AbstractComponentFunctorApplication acfaRef) {
			
			TreeNode root = GenerateTree.generate(unit, acfaRef);
			
			Resolution.sort(root);

//            TreeNode heron = root;
//            while (heron != null)
 //           {
//                Console.Write(heron.Functor_app.Id_abstract + " -> ");
//                heron = heron.Next;
//            }

			Component c = Resolution.tryGeneralize(root,root);

           writeTreeNode(root); Console.WriteLine(" FOUND !!!!!!");
						
			return c; // if c is null, there is not an implementation ....			
		}
	}
}

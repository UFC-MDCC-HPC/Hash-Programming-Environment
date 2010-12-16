// /home/jefferson/projetos/hashmodel_monodevelop/hashmodel_monodevelop/tree/Resolution.cs created with MonoDevelop
// User: jefferson at 14:24 2/6/2008
//
// To change standard headers go to Edit->Preferences->Coding->Standard Headers
//

using System;
using System.Collections.Generic;
using br.ufc.pargo.hpe.basic; 

namespace br.ufc.pargo.hpe.backend.DGAC.database
{
	
	
	public class Resolution
	{

		public static Component tryGeneralize(TreeNode CTop, TreeNode C){
            
            Component CTopImpl = null;
            //CTopImpl = findImplementation(CTop);
			
			if(C != null) {			
				C.reset();
				do {
                    CTopImpl = tryGeneralize(CTop, C.Next);
                    if (CTopImpl != null) return CTopImpl;
                    CTopImpl = findImplementation(CTop);
                    if (CTopImpl != null) return CTopImpl;
                    else
                    {
                    //Console.Write("BEFORE GENERALIZE:"); writeTreeNode(CTop); Console.WriteLine("...");
                        C.generalize();
                      //  Console.Write("AFTER GENERALIZE:"); writeTreeNode(CTop); Console.WriteLine("...");
                    }
				} while (!C.OnTop);
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
         
           // AbstractComponentFunctorApplicationDAO acfadao = new AbstractComponentFunctorApplicationDAO();
            IList<AbstractComponentFunctorApplication> acfaList = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfadao.listByIdAbstract(id_abstract);

//            writeTreeNode(CTop); Console.Write("TESTING ... ");
            foreach (AbstractComponentFunctorApplication acfa in acfaList)
            {
//                Console.Write(acfa.Id_functor_app + ",");
                if (recMatchParameters(CTop, acfa)) {
					//ComponentDAO cdao = new ComponentDAO();
//                    Console.WriteLine("... END TEST");
                    return br.ufc.pargo.hpe.backend.DGAC.BackEnd.cdao.retrieveByFunctorApp(acfa.Id_functor_app);
				}
            }
//            Console.WriteLine("... END TEST");

            return null;
        }

        private static bool recMatchParameters(TreeNode node, AbstractComponentFunctorApplication acfa)
        {
            AbstractComponentFunctorApplication acfaSon = null;

			//AbstractComponentFunctorApplicationDAO acfadao = new AbstractComponentFunctorApplicationDAO();
           // AbstractComponentFunctorParameterDAO acfpdao = new AbstractComponentFunctorParameterDAO();
			
          //  SupplyParameterComponentDAO spdao = new SupplyParameterComponentDAO();
            IList<SupplyParameterComponent> spList = br.ufc.pargo.hpe.backend.DGAC.BackEnd.spcdao.list(acfa.Id_functor_app);
			
			IDictionary<string, int> ttt = new Dictionary<string,int>();
			foreach (SupplyParameterComponent sp_ in spList) {
				SupplyParameterComponent sp = (SupplyParameterComponent) sp_;
				ttt.Add(sp.Id_parameter, sp.Id_functor_app_actual);				
			}
			
            foreach (TreeNode nodeSon in node.Children)
            {
                string parameter_id = nodeSon.Parameter_id;
              //  Console.Write("CHK PARAM: " + parameter_id);
                int id_functor_app_actual = -1;
                bool found = false;
                foreach (string parid in nodeSon.getParameterIdSyns())
                {
                    if (ttt.ContainsKey(parid))
                    {
                        found = true;
                        ttt.TryGetValue(parid, out id_functor_app_actual); // TODO
                        acfaSon = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfadao.retrieve(id_functor_app_actual);
                        if (acfaSon.Id_abstract != nodeSon.Functor_app.Id_abstract)
                        {
                          //  Console.WriteLine("FAIL 1! ");
                            return false;
                        }
                       // Console.WriteLine("MATCH! ");
                    }
                }

                if (found)
                {
                    if (!recMatchParameters(nodeSon, acfaSon))
                        return false;
                }

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

        private static IDictionary<int, Component> cache = new Dictionary<int, Component>();

		public static Component findHashComponent(IUnit unit, AbstractComponentFunctorApplication acfaRef) {

            Component c;

            if (acfaRef.ParametersList.Count == 0)
            {
                if (cache.TryGetValue(acfaRef.Id_abstract, out c)) {
                    return c; 
                }
            }

			TreeNode root = GenerateTree.generate(unit, acfaRef);
			
			Resolution.sort(root);

//            TreeNode heron = root;
//            while (heron != null)
 //           {
//                Console.Write(heron.Functor_app.Id_abstract + " -> ");
//                heron = heron.Next;
//            }

			c = Resolution.tryGeneralize(root,root);

            if (acfaRef.ParametersList.Count == 0)
            {
                cache.Add(acfaRef.Id_abstract, c);
            }

       //    writeTreeNode(root); Console.WriteLine(" FOUND !!!!!!");
						
			return c; // if c is null, there is not an implementation ....			
		}
	}
}

// /home/jefferson/projetos/hashmodel_monodevelop/hashmodel_monodevelop/tree/Resolution.cs created with MonoDevelop
// User: jefferson at 14:24 2/6/2008
//
// To change standard headers go to Edit->Preferences->Coding->Standard Headers
//

using System;
using System.Collections.Generic;
using br.ufc.pargo.hpe.basic;
using System.Diagnostics; 

namespace br.ufc.pargo.hpe.backend.DGAC.database
{	
	public class Resolution
	{

		public static Component tryGeneralize(TreeNode CTop, TreeNode C)
		{
			C.reset ();
			do {
				Component CTopImpl = C.Next != null ? tryGeneralize (CTop, C.Next) : findImplementation(CTop);

				if (CTopImpl != null) 
					return CTopImpl;
				else 
					C.generalize ();
				
			} while (!C.OnTop);

			return null;
		}

		public static Component[] tryGeneralizeAll(TreeNode CTop, TreeNode C)
		{
			IDictionary<string,Component> cList = new Dictionary<string,Component> ();

			C.reset ();
			do {
				Component[] CTopImpl;
				if (C.Next != null)
					CTopImpl = tryGeneralizeAll (CTop, C.Next);
				else {
					Component c = findImplementation(CTop);
					CTopImpl = c != null ? new Component[1] {c} : new Component[0];
				}

				foreach (Component c in CTopImpl)
					if (!cList.ContainsKey(c.Library_path))
						cList.Add(c.Library_path, c);

				C.generalize ();

			} while (!C.OnTop);

			Component[] cArray = new Component[cList.Count];
			cList.Values.CopyTo (cArray, 0);

			return cArray;
		}

        private static string writeTreeNode(TreeNode t)
        {
			string result = t.Parameter_id + "@" + t.GetHashCode() + "=" + t.Functor_app.Id_abstract + (t.Children.Count > 0 ? "[" : ""); 
            Trace.Write(result);
            foreach (TreeNode child in t.Children) {
                result += writeTreeNode(child);
				result += ",";
                Trace.Write(",");
            }
			string s = t.Children.Count > 0 ? "]" : "";
			result += s;
            Trace.Write(s);
			return result;
        }

		private static string readTreeNode(TreeNode t)
		{
			string result = t.Functor_app.Id_abstract + (t.Children.Count > 0 ? "[" : ""); 
			foreach (TreeNode child in t.Children) {
				result += readTreeNode(child);
				result += ",";
			}
			result += t.Children.Count > 0 ? "]" : "";
			return result;
		}

		private static IDictionary<int,  IList<AbstractComponentFunctorApplication>> cache2 = new Dictionary<int,  IList<AbstractComponentFunctorApplication>>();

        // EFFICIENCY IS NOT YET A CONCERN ! NEED TO IMPROVE !
        private static Component findImplementation(TreeNode CTop)
        {
			int id_abstract = CTop.Functor_app.Id_abstract;
            

			IList<AbstractComponentFunctorApplication> acfaList;

			if (!cache2.TryGetValue (id_abstract, out acfaList)) 
			{
				acfaList = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfadao.listByIdAbstract (id_abstract);			
				cache2.Add (id_abstract, acfaList);
			} 

            foreach (AbstractComponentFunctorApplication acfa in acfaList)
            {

					if (recMatchParameters(CTop, acfa)) 
					{
						Trace.Write ("IMPLEMENTATION FOUND !!!! ");
					//	writeTreeNode (CTop);						

	                    return br.ufc.pargo.hpe.backend.DGAC.BackEnd.cdao.retrieveByFunctorApp(acfa.Id_functor_app);
					} 
            }

            return null;
        }



		private static bool recMatchParameters(TreeNode node, AbstractComponentFunctorApplication acfa)
        {
            AbstractComponentFunctorApplication acfaSon = null;

            IList<SupplyParameterComponent> spList = br.ufc.pargo.hpe.backend.DGAC.BackEnd.spcdao.list(acfa.Id_functor_app);
			
			IDictionary<string, int> ttt = new Dictionary<string,int>();
			foreach (SupplyParameterComponent sp_ in spList) {
				SupplyParameterComponent sp = (SupplyParameterComponent) sp_;
				ttt.Add(sp.Id_parameter, sp.Id_functor_app_actual);				
			}
			
            foreach (TreeNode nodeSon in node.Children)
            {
                string parameter_id = nodeSon.Parameter_id;
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
                            // Console.WriteLine("FAIL 1! ");
                            return false;
                        }
                        //Console.WriteLine("MATCH! ");
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
				sort_(root, new List<TreeNode>());
        }


        private static TreeNode lastMarked = null;

        private static void sort_(TreeNode root, IList<TreeNode> ddd)
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
						if (ddd.Contains(parameter))
						{
							foreach (TreeNode ttt in ddd)
								Console.WriteLine("CYCLE PATH: argument=" + ttt.Parameter_id + "; value=" + ttt.Functor_app.Id_functor_app);

							throw new Exception("CYCLE DETECTED " + parameter.Parameter_id + ", " + parameter.Functor_app.Id_functor_app);
						}
						ddd.Add(parameter);
                        sort_(parameter,ddd);
						ddd.Remove(parameter);
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



        public static Component findHashComponent(IDictionary<string, int> actualParametersTop, AbstractComponentFunctorApplication acfaRef)
        {
			Console.WriteLine("FIND HASH COMPONENT: " + acfaRef.Id_functor_app + " === " + acfaRef.Id_abstract);
            IList<SupplyParameter> spdao_list = BackEnd.spdao.list(acfaRef.Id_functor_app);
            foreach (SupplyParameter par in spdao_list)
                if (par is SupplyParameterComponent) Console.WriteLine("PAR-C " + ((SupplyParameterComponent)par).Id_functor_app_actual);
                else Console.WriteLine("PAR-P " + ((SupplyParameterParameter)par).Id_parameter);

			Component c;

            if (acfaRef.ParametersList.Count == 0)
            {
                if (cache.TryGetValue(acfaRef.Id_functor_app, out c))
                {
                    return c;
                }
            }

            TreeNode root = GenerateTree.generate(actualParametersTop, acfaRef);

            Resolution.sort(root);

			TreeNode tn = root;
			while (tn != null) 
			{
				    Trace.Write (tn.Functor_app.Id_abstract + "@" + tn.GetHashCode() + "->");
					tn = tn.Next;
			}

			writeTreeNode (root);

			Console.WriteLine ("AFTER Resolution.sort(root)");

            c = Resolution.tryGeneralize(root, root);

			Console.WriteLine ("AFTER Resolution.tryGeneralize(root, root) --- " + (c == null));

            if (acfaRef.ParametersList.Count == 0)
            {
                cache.Add(acfaRef.Id_functor_app, c);
            }

			Console.WriteLine("FINISH - FIND HASH COMPONENT");

			return BackEnd.cdao.retrieve_libraryPath (c.Library_path);; // if c is null, there is not an implementation ....			
        }

		public static Component[] findHashComponentAll(AbstractComponentFunctorApplication acfaRef)
		{
			try 
			{
				
			Connector.openConnection();

			Console.WriteLine("FIND HASH COMPONENT ALL: " + acfaRef.Id_functor_app);

			Component[] cAll;

			TreeNode root = GenerateTree.generate(new Dictionary<string, int>(), acfaRef);

			Resolution.sort(root);

			TreeNode tn = root;
			while (tn != null) 
			{
				Trace.Write (tn.Functor_app.Id_abstract + "@" + tn.GetHashCode() + "->");
				tn = tn.Next;
			}

			writeTreeNode (root);

			Console.WriteLine ("AFTER Resolution.sort(root) - ALL");

			cAll = Resolution.tryGeneralizeAll(root, root);

			Console.WriteLine ("AFTER Resolution.tryGeneralize(root, root) - ALL");

			return cAll; // if c is null, there is not an implementation ....
			}
			catch (Exception e) 
			{
				throw e;
			}
			finally 
			{
				Connector.closeConnection ();
			}
		}

	}
}

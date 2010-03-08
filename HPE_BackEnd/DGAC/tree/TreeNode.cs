// /home/jefferson/projetos/hashmodel_monodevelop/hashmodel_monodevelop/tree/Node.cs created with MonoDevelop
// User: jefferson at 08:24 22/5/2008
//
// To change standard headers go to Edit->Preferences->Coding->Standard Headers
//

using System;
using System.Collections.Generic;
using System.Collections;

namespace DGAC.database
{	
	
	public class TreeNode
	{
		private TreeNode parent = null; // The parent during traversing ... after traversing, it is resetted to null.
		private TreeNode next;
		private IList<TreeNode> childList;
        private string parameter_id;
        private IList<string> parameter_id_syn;
		private int current_id_functor_app = -1; /* it points to an index in the list id_functor_app */
        private IList<AbstractComponentFunctorApplication> functor_app = null; 
		private int level;
		private bool mark;
        private bool closed;
        private string name;

        public bool Closed
        {
            get { return closed; }
            set { closed = value; }
        }
		
		
		public TreeNode Parent{
			get {return this.parent;}
	        set {
				this.parent = value;
				if(this.parent==null)
					this.Level=0;
				else
					this.Level = this.Parent.Level + 1;
			}
		}

        public void addParameterIdSyn(String parid)
        {
            if (parameter_id_syn == null) 
                parameter_id_syn = new List<string>();
            if (!parameter_id_syn.Contains(parid))
               parameter_id_syn.Add(parid);
        }

        public IList<string> getParameterIdSyns()
        {
            if (parameter_id_syn == null)
                parameter_id_syn = new List<string>();
            return parameter_id_syn;
        }

        public string Parameter_id
        {
            get { return parameter_id; }
            set { parameter_id = value; }
        }

        private bool onTop = false;		
		
        public void generalize() {
			if (!onTop) {
				
				if (this.current_id_functor_app + 1 >= this.functor_app.Count)
				   onTop = true;
                else
                   this.current_id_functor_app++;
			}
		}
		
        public AbstractComponentFunctorApplication Functor_app        
        {
			get {return this.functor_app != null ? this.functor_app[this.current_id_functor_app] : null;}
		}

        public AbstractComponentFunctorApplication Functor_app_top
        {
            get { return this.functor_app != null ? this.functor_app[this.functor_app.Count-1] : null; }
        }

        public IList<TreeNode> Children
        
{
			get{return this.childList;}
		}
			
		public int Level{
			get {return this.level;}
	        set {this.level = value;}
		}
		
		public string Name{
			get {return this.name;}
	        set {this.name = value;}
		}
		
		public void addChild(TreeNode child){
		
			this.childList.Add(child);
		}
		
		public TreeNode(IList<AbstractComponentFunctorApplication> functor_app, TreeNode parent)
		{
			this.childList = new List<TreeNode>();
            this.functor_app = functor_app; this.reset();
			this.Parent = parent;
		}
		
		public TreeNode Next{
			set{this.next = value;}
			get{return this.next;}
		}
		
		public bool Mark{
			set{this.mark = value;}
			get{return this.mark;}
		}

		public bool OnTop {
			get {
				return onTop;
			}
		}
		
		public void reset(){
			this.current_id_functor_app = 0;
			onTop = false;
		}
		
		
		public TreeNode()
		{
			this.childList = new List<TreeNode>();
		}


        internal string trace()
        {
            return " >" + this.onTop + "," + this.Functor_app.Id_abstract + "," + this.current_id_functor_app + "," + this.functor_app.Count;
        }
    }
}

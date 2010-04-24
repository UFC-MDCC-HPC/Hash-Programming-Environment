using System;
using DGAC;
using hpe.basic;
using hpe.kinds;
using jefferson.data.Data;
using data.List;

namespace data.impl.List { 

public class IListImpl<T> : BaseIListImpl<T>, IList<T>
where T:IData, new()
{

    private System.Collections.Generic.IDictionary<T,T> dict = new System.Collections.Generic.Dictionary<T,T>();

	public IListImpl() { 
	
	} 

    public T createNew() {
       T e = new T ();
       return e;
    }
    
    public void add(T element) {
       dict.Add(element,element);
    }
    
    public void remove(T element) {
       dict.Remove(element);
    }
    
    public bool contains(T element) {       
       return dict.ContainsKey(element);
    }
    
    public bool isEmpty() {
       return dict.Count == 0;
    }
    
    public System.Collections.Generic.IList<T> getList() {       
       System.Collections.Generic.IList<T> r = new System.Collections.Generic.List<T>();
       foreach (T e in dict.Values) 
            r.Add(e);
       return r;
    }

}

}

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using jefferson.data.Data;
using data.List;

//using data.Function.TestingFunction;
//using data.IntegralCase;
//using data.Function;

namespace data.impl.List { 

public class IListImpl<T> : BaseIListImpl<T>, IList<T>
where T:IData
{

	public Object createNew() {
	   return new IListImpl<T>();
	}
	
    private System.Collections.Generic.IDictionary<T,T> dict = new System.Collections.Generic.Dictionary<T,T>();

	public IListImpl() { 
//	     IListImpl<IIntegralCase<ITestingFunction>> ll1 = new IListImpl<IIntegralCase<ITestingFunction>>();
//	     IListImpl<ITestingFunction> ll2 = new IListImpl<ITestingFunction>();
//	     IListImpl<IFunction> ll3 = new IListImpl<IFunction>();
	} 
    
    public T createElement() {
         T element = (T) this.data.createNew();
         this.add(element);
         return (T) element;
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

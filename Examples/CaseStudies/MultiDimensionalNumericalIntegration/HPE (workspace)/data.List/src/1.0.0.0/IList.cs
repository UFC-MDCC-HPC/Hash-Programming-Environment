using hpe.kinds;
using jefferson.data.Data;

namespace data.List { 

public interface IList<T> : BaseIList<T>, IData
where T:IData
{   
    T createElement();
    void add(T element);
    void remove(T element);
    bool contains(T element);
    bool isEmpty();
    System.Collections.Generic.IList<T> getList();
    
} // end main interface 

} // end namespace 

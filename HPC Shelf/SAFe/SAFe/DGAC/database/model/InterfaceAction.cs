using System;
using System.IO;
using System.Runtime.Serialization;
using System.Collections.Generic;
using br.ufc.pargo.hpe.backend.DGAC.utils;
using System.Xml.Serialization;
using System.Xml;

namespace br.ufc.pargo.hpe.backend.DGAC.database
{

[Serializable()]
public class InterfaceAction 
{
 
	private string id_interface;
    private int id_abstract;	
	private int partition_index;
	private string id_action;
	private string protocol;
	private bool is_condition;
	
	public string Id_interface{
        get {return id_interface;}
        set {id_interface = value;}
    }


	public int Id_abstract{
        get {return id_abstract;}
        set {id_abstract = value;}
    }

	public int PartitionIndex {
        get {return partition_index;}
        set {partition_index = value;}
    }
		
	public string Id_action{
        get {return id_action;}
        set {id_action = value;}
    }
		
	public string Protocol {
        get {return protocol;}
        set {protocol = value;}
    }
     
	public bool IsCondition {
        get {return is_condition;}
        set {is_condition = value;}
    }
	
}//class

}//namespace
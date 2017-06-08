using System;
using System.IO;
using System.Runtime.Serialization;
using System.Collections.Generic;
using br.ufc.pargo.hpe.backend.DGAC.utils;
using System.Xml.Serialization;
using System.Xml;

namespace br.ufc.pargo.hpe.backend.DGAC.database{

[Serializable()]
public class InterfaceParameter {
 
	private string id_interface;
    private int id_abstract;
    private int parorder;
    private string parid;
    private string varid;
    private string id_interface_parameter;
    private string id_unit_parameter;    
	 
	
	public string Id_interface{
        get {return id_interface;}
        set {id_interface = value;}
    }

    public string ParId
    {
        get {return parid;}
        set {parid = value;}
    }
    
	public string VarId{
        get {return varid;}
        set {varid = value;}
    }

	public string Id_interface_parameter{
        get {return id_interface_parameter;}
        set {id_interface_parameter = value;}
    }

	public string Id_unit_parameter{
        get {return id_unit_parameter;}
        set {id_unit_parameter = value;}
    }

	public int Id_abstract{
        get {return id_abstract;}
        set {id_abstract = value;}
    }
    public int ParOrder
    {
        get { return parorder; }
        set { parorder = value; }
    }

     
	
}//class

}//namespace
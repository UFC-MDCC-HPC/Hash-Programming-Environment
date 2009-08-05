package hPE.frontend.HCL.symbol_table;
import java.util.ArrayList;

public class SemanticError {
	static ArrayList <String> error_list = new ArrayList <String>();;
	
	static public void addError(String error){
		error_list.add(error);
	}
	
	static public boolean hasError(){
		return !error_list.isEmpty();
	}
	
	static public void printErrors(){
		for(int i=0;i<=error_list.size()-1;i++)
			System.out.println("Error: "+error_list.get(i));
	}
}

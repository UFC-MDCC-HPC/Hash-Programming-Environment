package hPE.frontend.HCL.symbol_table;
import java.util.ArrayList;

public class SemanticError {
	static ArrayList <String> error_list = new ArrayList <String>();
	static ArrayList <String> warning_list = new ArrayList <String>();
	
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
	
	static public void addWarning(String warning){
		warning_list.add(warning);
	}
	
	static public boolean hasWarning(){
		return !warning_list.isEmpty();
	}
	
	static public void printWarnings(){
		for(int i=0;i<=warning_list.size()-1;i++)
			System.out.println("Warning: "+warning_list.get(i));
	}
}

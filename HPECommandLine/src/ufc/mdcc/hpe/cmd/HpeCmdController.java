package ufc.mdcc.hpe.cmd;

import java.util.ArrayList;
import java.util.List;

import ufc.mdcc.hpe.util.HpeTreeNode;

public class HpeCmdController {

	private HpeTreeNode root;
	private boolean initialized = false;
	
	public HpeCmdController(HpeTreeNode root) {
		this.root = root;
		 
	}
	
	public void insertNode(HpeTreeNode newNode, HpeTreeNode parentNode){
		List<HpeTreeNode> list = new ArrayList<HpeTreeNode>();
		list.add(root);
		 
		while(list.size()!=0){
			HpeTreeNode nodeRef = list.remove(0);	
			if(nodeRef.equals(parentNode)){
				nodeRef.getChildreen().add(newNode);
				return;
			}
			list.addAll(nodeRef.getChildreen());
			
		}
		this.initialized = true;
	}
	
	public boolean validateInCmd(String[] tokens){
		if(!this.initialized)
			return false;
		boolean res = false;
		for(String token:tokens){
			
		}
		return res;
	}
	
	public void printTree(){
		List<HpeTreeNode> list = new ArrayList<HpeTreeNode>();
		list.add(root);
		while(list.size()!=0){
			HpeTreeNode nodeRef = list.remove(0);
			System.out.println(nodeRef.getData().getName() +" - "+ nodeRef.getData().getValue());
			list.addAll(nodeRef.getChildreen());
		}
	}
	
}

package ufc.mdcc.hpe.util;

import java.util.ArrayList;
import java.util.List;

import ufc.mdcc.hpe.cmd.HpeCmd;

public class HpeTreeNode {

	private HpeCmd data;
	private List<HpeTreeNode> childreen;
	private int id;
	private static int publicId;
	
	public HpeTreeNode() {
		this.id = publicId;
		publicId++;
	}
	
	public HpeTreeNode(HpeCmd data) {
		this.data = data;
		this.childreen = new ArrayList<HpeTreeNode>();
		this.id = publicId;
		publicId++;
	}

	public HpeCmd getData() {
		return data;
	}

	public void setData(HpeCmd data) {
		this.data = data;
	}

	public List<HpeTreeNode> getChildreen() {
		return childreen;
	}

	public void setChildreen(List<HpeTreeNode> childreen) {
		this.childreen = childreen;
	}
	
	public int getId(){
		return id;
	}
	
	@Override
	public boolean equals(Object obj) {
		HpeTreeNode hpeTreeNode = (HpeTreeNode)obj;
		if(hpeTreeNode.getId() == this.id)
			return true;
		return false;
	}
	
}

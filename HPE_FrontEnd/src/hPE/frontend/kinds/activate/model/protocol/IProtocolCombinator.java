package hPE.frontend.kinds.activate.model.protocol;

import hPE.frontend.connector.xml.component.ProtocolCombinatorType;

import java.util.List;

public interface IProtocolCombinator extends IProtocol, ProtocolCombinatorType {

	static int PAR_COMBINATOR = 0;
	static int SEQ_COMBINATOR = 1;
	static int ALT_COMBINATOR = 2;
	static int NO_COMBINATOR = 3;
	
	void setCombinator(int combinator);
	int getCombinator();
	List<IProtocol> getActions();
	boolean isRepeat();
	List<String> getEntryConnectionIDs();
	List<String> getExitConnectionIDs();
	
	void updateChildren();
	void setEntryExit(HActionEntry entry, HActionExit exit);
	void updateEntryExitConnections();
	
}
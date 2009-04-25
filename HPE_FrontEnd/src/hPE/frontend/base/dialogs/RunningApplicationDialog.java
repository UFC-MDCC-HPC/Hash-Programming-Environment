package hPE.frontend.base.dialogs;

import javax.swing.JPanel;
import java.awt.Frame;
import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JTabbedPane;
import java.awt.Rectangle;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.JTextArea;

public class RunningApplicationDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JTabbedPane jTabbedPaneOutputProcesses = null;
	private JTextArea jTextArea = null;
	/**
	 * @param owner
	 */
	public RunningApplicationDialog(Frame owner) {
		super(owner);
		initialize();		
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(708, 316);
		this.setContentPane(getJContentPane());
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJTabbedPaneOutputProcesses(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jTabbedPaneOutputProcesses	
	 * 	
	 * @return javax.swing.JTabbedPane	
	 */
	private JTabbedPane getJTabbedPaneOutputProcesses() {
		if (jTabbedPaneOutputProcesses == null) {
			jTabbedPaneOutputProcesses = new JTabbedPane();
			jTabbedPaneOutputProcesses.setBounds(new Rectangle(0, 0, 700, 286));
			//jTabbedPaneOutputProcesses.addTab(null, null, getJTextArea(), null);
		}
		return jTabbedPaneOutputProcesses;
	}

	public void newTab(String processId, String contents) {
		JTextArea jt = new JTextArea(contents);
		JScrollPane p = new JScrollPane(jt);
		jt.setAutoscrolls(true);
		jt.setEditable(false);
		jTabbedPaneOutputProcesses.addTab(processId, null, p, null);
	}
	
	/**
	 * This method initializes jTextArea	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextArea() {
		if (jTextArea == null) {
			jTextArea = new JTextArea();
		}
		return jTextArea;
	}

}  //  @jve:decl-index=0:visual-constraint="22,54"

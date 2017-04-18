package hPE;

import hPE.frontend.kinds.application.model.HApplicationComponent;
import hPE.frontend.kinds.binding.model.HBindingComponent;
import hPE.frontend.kinds.certifier.model.HCertifierComponent;
import hPE.frontend.kinds.computation.model.HComputationComponent;
import hPE.frontend.kinds.data.model.HDataComponent;
import hPE.frontend.kinds.environment.model.HEnvironmentComponent;
import hPE.frontend.kinds.platform.model.HPlatformComponent;
import hPE.frontend.kinds.qualifier.model.HQualifierComponent;
import hPE.frontend.kinds.synchronization.model.HSynchronizationComponent;
import hPE.frontend.kinds.tactical.model.HTacticalComponent;
import hPE.frontend.kinds.topology.model.HTopologyComponent;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;

public class SetVersionDialog extends Composite {

	private Spinner spinnerV1 = null;
	private Spinner spinnerV2 = null;
	private Spinner spinnerV3 = null;
	private Spinner spinnerV4 = null;
	private Label labelVersion = null;
	private Group groupKinds = null;
	private Button radioApplication = null;
	private Button radioComputation = null;
	private Button radioSynchronizer = null;
	private Button radioDataStructure = null;
	private Button radioEnvironment = null;
	private Button radioArchitecture = null;
	private Button radioQualifier = null;
	private Button radioService = null;
	private Button radioCertifier = null;
	private Button radioTactical = null;
	private Button radioBinding = null;
	
	public SetVersionDialog(SelectionListener sl, Composite parent, int style) {
		super(parent, style);
		this.sl = sl;
		initialize();		
	}

	private SelectionListener sl = null;
	
	private Group group = null;
	private Button radioButtonAbstract = null;
	private Button radioButtonConcrete = null;
	
	private void initialize() {
		labelVersion = new Label(this, SWT.NONE);
		labelVersion.setText("Initial Version:");
		labelVersion.setBounds(new Rectangle(5, 2, 100, 17));
		spinnerV1 = new Spinner(this, SWT.NONE);
		spinnerV1.setDigits(0);
		spinnerV1.setSelection(1);
		spinnerV1.setMaximum(99999);
		spinnerV1.setEnabled(false);
		spinnerV1.setBounds(new Rectangle(110, 2, 53, 17));
		spinnerV2 = new Spinner(this, SWT.NONE);
		spinnerV2.setMaximum(99999);
		spinnerV2.setEnabled(false);
		spinnerV2.setBounds(new Rectangle(175, 2, 53, 17));
		spinnerV3 = new Spinner(this, SWT.NONE);
		spinnerV3.setMaximum(99999);
		spinnerV3.setEnabled(false);
		spinnerV3.setBounds(new Rectangle(240, 2, 53, 17));
		spinnerV4 = new Spinner(this, SWT.NONE);
		spinnerV4.setMaximum(99999);
		spinnerV4.setEnabled(false);
		spinnerV4.setBounds(new Rectangle(305, 2, 53, 17));
		this.setLayout(null);
		createGroup();
		createGroupKinds();
		setSize(new Point(466, 116));
	}

	/**
	 * This method initializes groupKinds	
	 *
	 */
	private void createGroupKinds() {
		
		groupKinds = new Group(this, SWT.NONE);
		groupKinds.setText("Component Kinds");
		groupKinds.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
		groupKinds.setLayout(null);
		groupKinds.setBounds(new Rectangle(5, 30, 500, 100));
		
		radioApplication = new Button(groupKinds, SWT.RADIO);
		radioApplication.setText(HApplicationComponent.KIND);
		radioApplication.setBounds(new Rectangle(13, 10, 120, 16));
		radioApplication.addSelectionListener(sl);
		radioApplication.setSelection(true);

		radioEnvironment = new Button(groupKinds, SWT.RADIO);
		radioEnvironment.setText(HEnvironmentComponent.KIND);
		radioEnvironment.setBounds(new Rectangle(13, 30, 120, 18));
		radioEnvironment.addSelectionListener(sl);
		radioEnvironment.setSelection(false);
		
		radioDataStructure = new Button(groupKinds, SWT.RADIO);
		radioDataStructure.setText(HDataComponent.KIND);
		radioDataStructure.setBounds(new Rectangle(13, 50, 120, 18));
		radioDataStructure.addSelectionListener(sl);
		radioDataStructure.setSelection(false);

		radioComputation = new Button(groupKinds, SWT.RADIO);
		radioComputation.setText(HComputationComponent.KIND);
		radioComputation.setBounds(new Rectangle(138, 10, 120, 18));
		radioComputation.addSelectionListener(sl);
		radioComputation.setSelection(false);
		
		radioArchitecture = new Button(groupKinds, SWT.RADIO);
		radioArchitecture.setText(HPlatformComponent.KIND);
		radioArchitecture.setBounds(new Rectangle(138, 30, 120, 18));
		radioArchitecture.addSelectionListener(sl);
		radioArchitecture.setSelection(false);

		radioSynchronizer = new Button(groupKinds, SWT.RADIO);
		radioSynchronizer.setText(HSynchronizationComponent.KIND);
		radioSynchronizer.setBounds(new Rectangle(138, 50, 120, 18));
		radioSynchronizer.addSelectionListener(sl);
		radioSynchronizer.setSelection(false);

		radioQualifier = new Button(groupKinds, SWT.RADIO);
		radioQualifier.setText(HQualifierComponent.KIND);
		radioQualifier.setBounds(new Rectangle(263, 10, 120, 18));
		radioQualifier.addSelectionListener(sl);
		radioQualifier.setSelection(false);

		radioService = new Button(groupKinds, SWT.RADIO);
		radioService.addSelectionListener(sl);
		radioService.setSelection(false);
		radioService.setBounds(new Rectangle(263, 30, 120, 18));
		radioService.setText(HTopologyComponent.KIND);		
		
		radioBinding = new Button(groupKinds, SWT.RADIO);
		radioBinding.addSelectionListener(sl);
		radioBinding.setEnabled(true);
		radioBinding.setSelection(false);
		radioBinding.setBounds(new Rectangle(263, 50, 120, 18));
		radioBinding.setText(HBindingComponent.KIND);

		radioCertifier = new Button(groupKinds, SWT.RADIO);
		radioCertifier.addSelectionListener(sl);
		radioCertifier.setEnabled(true);
		radioCertifier.setSelection(false);
		radioCertifier.setBounds(new Rectangle(388, 10, 120, 18));
		radioCertifier.setText(HCertifierComponent.KIND);

		radioTactical = new Button(groupKinds, SWT.RADIO);
		radioTactical.addSelectionListener(sl);
		radioTactical.setEnabled(true);
		radioTactical.setSelection(false);
		radioTactical.setBounds(new Rectangle(388, 30, 120, 18));
		radioTactical.setText(HTacticalComponent.KIND);
	}

	public Button getRadioApplication() {
  		return radioApplication;
	}
	
	public Button getRadioComputation() {
  		return this.radioComputation;
	}

	public Button getRadioSynchronizer() {
  		return this.radioSynchronizer;
	}

	public Button getRadioDataStructure() {
  		return this.radioDataStructure;
	}

	public Button getRadioEnumerator() {
  		return this.radioEnumerator;
	}

	public Button getRadioEnvironment() {
		return this.radioEnvironment;
	}

	public Button getRadioArchitecture() {
  		return this.radioArchitecture;
	}

	public Button getRadioQualifier() {
  		return this.radioQualifier;
	}

	public Button getRadioTopology() {
		return this.radioService;
	}
	
	public Button getRadioCertifier() {
		return this.radioCertifier;
	}

	public Button getRadioTactical() {
		return this.radioTactical;
	}

	public Button getRadioBinding() {
		return this.radioBinding;
	}

	public Button getRadioButtonAbstract() {
		return this.radioButtonAbstract;
	}

	public Button getRadioButtonConcrete() {
		return this.radioButtonConcrete;
	}

	public int getVersionField(int k) {
		switch (k) {
		case 0: return spinnerV1.getSelection(); 
		case 1: return spinnerV2.getSelection();
		case 2: return spinnerV3.getSelection();
		case 3: return spinnerV4.getSelection();
		}
		return -1;		
	}
	
	private Integer[] safeVersion = new Integer[] {1,0,0,0};
	private Button radioEnumerator = null;
	public void SetEnabledVersionSetting(boolean enable) {
		if (!enable) {
			if (!(spinnerV1.getSelection() == 1 && 
				  spinnerV2.getSelection() == 0 && 
				  spinnerV3.getSelection() == 0 && 
				  spinnerV4.getSelection() == 0)) 
			{ 
				safeVersion[0] = spinnerV1.getSelection();
				safeVersion[1] = spinnerV2.getSelection();
				safeVersion[2] = spinnerV3.getSelection();
				safeVersion[3] = spinnerV4.getSelection();
			}
			spinnerV1.setSelection(1);
			spinnerV2.setSelection(0);
			spinnerV3.setSelection(0);
			spinnerV4.setSelection(0);
		} else {
			spinnerV1.setSelection(safeVersion[0]);
			spinnerV2.setSelection(safeVersion[1]);
			spinnerV3.setSelection(safeVersion[2]);
			spinnerV4.setSelection(safeVersion[3]);
		}
         spinnerV1.setEnabled(enable);		
         spinnerV2.setEnabled(enable);		
         spinnerV3.setEnabled(enable);		
         spinnerV4.setEnabled(enable);		
	}

	/**
	 * This method initializes group	
	 *
	 */
	private void createGroup() {
		group = new Group(this, SWT.NONE);
		group.setLayout(null);
		group.setText("");
		group.setBounds(new Rectangle(510, 39, 130, 91));
		org.eclipse.swt.events.SelectionListener sl = new org.eclipse.swt.events.SelectionListener() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				Object src = e.getSource();
				SetEnabledVersionSetting(radioButtonConcrete.getSelection());
			}
			public void widgetDefaultSelected(
					org.eclipse.swt.events.SelectionEvent e) {
			}
		};
		radioButtonAbstract = new Button(group, SWT.RADIO);
		radioButtonAbstract.setText("Abstract");
		radioButtonAbstract.setBounds(new Rectangle(8, 23, 90, 16));
		radioButtonAbstract.setSelection(true);
		radioButtonAbstract.addSelectionListener(sl);
		radioButtonConcrete = new Button(group, SWT.RADIO);
		radioButtonConcrete.setText("Concrete");
		radioButtonConcrete.setBounds(new Rectangle(8, 53, 90, 16));
		radioButtonConcrete.addSelectionListener(sl);
	}
	
	public boolean isAbstract() {
	  return radioButtonAbstract.getSelection();	
	}
	
}  //  @jve:decl-index=0:visual-constraint="18,27"

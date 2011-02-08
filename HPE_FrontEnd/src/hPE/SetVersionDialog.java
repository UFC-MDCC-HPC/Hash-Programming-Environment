package hPE;

import hPE.frontend.base.dialogs.DialogUtil;
import hPE.frontend.base.exceptions.HPEException;
import hPE.frontend.kinds.KindConfiguration;
import hPE.frontend.kinds.KindManager;

import java.util.Set;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
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
	private final Button radioApplication = null;
	private final Button radioComputation = null;
	private final Button radioSynchronizer = null;
	private final Button radioDataStructure = null;
	private final Button radioEnvironment = null;
	private final Button radioArchitecture = null;
	private final Button radioQualifier = null;
	private final Button radioService = null;
	private final Button radioFacet = null;
	private final Button radioDomain = null;

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
		labelVersion.setBounds(new Rectangle(5, 7, 71, 13));
		spinnerV1 = new Spinner(this, SWT.NONE);
		spinnerV1.setDigits(0);
		spinnerV1.setSelection(1);
		spinnerV1.setMaximum(99999);
		spinnerV1.setEnabled(false);
		spinnerV1.setBounds(new Rectangle(85, 5, 53, 17));
		spinnerV2 = new Spinner(this, SWT.NONE);
		spinnerV2.setMaximum(99999);
		spinnerV2.setEnabled(false);
		spinnerV2.setBounds(new Rectangle(150, 5, 53, 17));
		spinnerV3 = new Spinner(this, SWT.NONE);
		spinnerV3.setMaximum(99999);
		spinnerV3.setEnabled(false);
		spinnerV3.setBounds(new Rectangle(215, 5, 53, 17));
		spinnerV4 = new Spinner(this, SWT.NONE);
		spinnerV4.setMaximum(99999);
		spinnerV4.setEnabled(false);
		spinnerV4.setBounds(new Rectangle(280, 5, 53, 17));
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
		createComboKinds();
		groupKinds.setBounds(new Rectangle(5, 30, 390, 81));

		//TODO RAFAEL: REMOVER SE ESTIVER OK:
		//		radioApplication = new Button(groupKinds, SWT.RADIO);
		//		radioApplication.setText(HApplicationComponent.KIND);
		//		radioApplication.setBounds(new Rectangle(13, 18, 111, 16));
		//		radioApplication.addSelectionListener(sl);
		//		radioApplication.setSelection(true);
		//
		//		radioEnvironment = new Button(groupKinds, SWT.RADIO);
		//		radioEnvironment.setText(HEnvironmentComponent.KIND);
		//		radioEnvironment.setBounds(new Rectangle(13, 38, 111, 16));
		//		radioEnvironment.addSelectionListener(sl);
		//		radioEnvironment.setSelection(false);
		//
		//		radioDataStructure = new Button(groupKinds, SWT.RADIO);
		//		radioDataStructure.setText(HDataComponent.KIND);
		//		radioDataStructure.setBounds(new Rectangle(13, 58, 111, 16));
		//		radioDataStructure.addSelectionListener(sl);
		//		radioDataStructure.setSelection(false);
		//
		//		radioComputation = new Button(groupKinds, SWT.RADIO);
		//		radioComputation.setText(HComputationComponent.KIND);
		//		radioComputation.setBounds(new Rectangle(128, 18, 106, 16));
		//		radioComputation.addSelectionListener(sl);
		//		radioComputation.setSelection(false);
		//
		//		radioArchitecture = new Button(groupKinds, SWT.RADIO);
		//		radioArchitecture.setText(HArchitectureComponent.KIND);
		//		radioArchitecture.setBounds(new Rectangle(128, 38, 106, 16));
		//		radioArchitecture.addSelectionListener(sl);
		//		radioArchitecture.setSelection(false);
		//
		//		radioEnumerator = new Button(groupKinds, SWT.RADIO);
		//		radioEnumerator.setBounds(new Rectangle(128, 58, 106, 16));
		//		radioEnumerator.setText(HEnumeratorComponent.KIND);
		//		radioEnumerator.addSelectionListener(sl);
		//		radioEnumerator.setSelection(false);
		//
		//		radioSynchronizer = new Button(groupKinds, SWT.RADIO);
		//		radioSynchronizer.setText(HSynchronizationComponent.KIND);
		//		radioSynchronizer.setBounds(new Rectangle(238, 18, 100, 16));
		//		radioSynchronizer.addSelectionListener(sl);
		//		radioSynchronizer.setSelection(false);
		//
		//		radioQualifier = new Button(groupKinds, SWT.RADIO);
		//		radioQualifier.setText(HQualifierComponent.KIND);
		//		radioQualifier.setBounds(new Rectangle(238, 38, 100, 16));
		//		radioQualifier.addSelectionListener(sl);
		//		radioQualifier.setSelection(false);
		//
		//		radioService = new Button(groupKinds, SWT.RADIO);
		//		radioService.addSelectionListener(sl);
		//		radioService.setSelection(false);
		//		radioService.setBounds(new Rectangle(238, 58, 100, 16));
		//		radioService.setText(HServiceComponent.KIND);
		//
		//		radioFacet = new Button(groupKinds, SWT.RADIO);
		//		radioFacet.addSelectionListener(sl);
		//		radioFacet.setEnabled(true);
		//		radioFacet.setSelection(false);
		//		radioFacet.setBounds(new Rectangle(343, 18, 70, 16));
		//		radioFacet.setText(HFacetComponent.KIND);
		//
		//		radioDomain = new Button(groupKinds, SWT.RADIO);
		//		radioDomain.addSelectionListener(sl);
		//		radioDomain.setEnabled(true);
		//		radioDomain.setSelection(false);
		//		radioDomain.setBounds(new Rectangle(343, 38, 70, 16));
		//		radioDomain.setText(HDomainComponent.KIND);

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

	public Button getRadioService() {
		return this.radioService;
	}

	public Button getRadioFacet() {
		return this.radioFacet;
	}

	public Button getRadioDomain() {
		return this.radioDomain;
	}

	public Button getRadioButtonAbstract() {
		return this.radioButtonAbstract;
	}

	public Button getRadioButtonConcrete() {
		return this.radioButtonConcrete;
	}

	public Combo getComboKinds() {
		return comboKinds;
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

	private final Integer[] safeVersion = new Integer[] {1,0,0,0};
	private final Button radioEnumerator = null;
	private Combo comboKinds = null;

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
		group.setText("Type");
		group.setBounds(new Rectangle(405, 30, 110, 81));
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
		radioButtonConcrete.setBounds(new Rectangle(8, 53, 89, 16));
		radioButtonConcrete.addSelectionListener(sl);
	}

	public boolean isAbstract() {
		return radioButtonAbstract.getSelection();
	}

	/**
	 * This method initializes comboKinds
	 *
	 */
	private void createComboKinds() {
		comboKinds = new Combo(groupKinds, SWT.NONE);
		comboKinds.setBounds(new Rectangle(13, 24, 360, 26));
		comboKinds.addSelectionListener(sl);

		//TODO Rafael - remover
		//		comboKinds.add(HApplicationComponent.KIND);
		//		comboKinds.add(HEnvironmentComponent.KIND);
		//		comboKinds.add(HDataComponent.KIND);
		//		comboKinds.add(HComputationComponent.KIND);
		//		comboKinds.add(HArchitectureComponent.KIND);
		//		comboKinds.add(HEnumeratorComponent.KIND);
		//		comboKinds.add(HSynchronizationComponent.KIND);
		//		comboKinds.add(HQualifierComponent.KIND);
		//		comboKinds.add(HServiceComponent.KIND);
		//		comboKinds.add(HFacetComponent.KIND);
		//		comboKinds.add(HDomainComponent.KIND);

		try {
			Set<KindConfiguration> kinds = KindManager.getKinds();
			for (KindConfiguration kindConfiguration : kinds) {
				comboKinds.add(kindConfiguration.getName());
			}
		} catch (HPEException e) {
			DialogUtil.openError(e.getMessage(), e);
		}
	}

}  //  @jve:decl-index=0:visual-constraint="18,27"

package frontend.views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.apache.log4j.Logger;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import frontend.beans.DataType;
import frontend.beans.DomainAttributeBean;
import logic.GeneratorService;
import net.miginfocom.swing.MigLayout;
import javax.swing.UIManager;
import javax.swing.JCheckBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class GeneratorJPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private BindingGroup m_bindingGroup;
	private JTableBinding<DomainAttributeBean, List<DomainAttributeBean>, JTable> tableBinding;
	private frontend.beans.GeneratorSetupBean generatorSetupBean = new frontend.beans.GeneratorSetupBean();
	private JTextField projectNameJTextField;
	private JTextField projectPathJTextField;
	private JTextField templatePathJTextField;
	private JTextField domainNameJTextField;
	private JTable table;
	private JPanel panel;
	private JButton btnOk;
	private JButton btnAbbrechen;
	private JButton btnNewButton;
	private JPanel panel_1;
	private JButton btnNewButton_1;
	private final GeneratorService generatorService = new GeneratorService();
	private JPanel panel_2;
	private JButton button;
	private JFileChooser fileChooser;
	
	Logger LOG = Logger.getLogger(GeneratorJPanel.class);
	private JPanel panel_3;
	private JButton templatePathChooserButton;
	private JPanel generatorOptionPanel;
	private JCheckBox chckbxFrontend;

	public GeneratorJPanel(frontend.beans.GeneratorSetupBean newGeneratorSetupBean) {
		this();
		setGeneratorSetupBean(newGeneratorSetupBean);
	}

	public GeneratorJPanel() {
		setBackground(SystemColor.inactiveCaptionBorder);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 77, 205, 51, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 21, 19, 20, 31, 63, 69, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0, 1.0E-4 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0E-4 };
		setLayout(gridBagLayout);
		
		fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new java.io.File("."));
		fileChooser.setDialogTitle("Select Directory");
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fileChooser.setAcceptAllFileFilterUsed(false);
		
				JLabel projectNameLabel = new JLabel("Project Name:");
				GridBagConstraints labelGbc_0 = new GridBagConstraints();
				labelGbc_0.insets = new Insets(5, 5, 5, 5);
				labelGbc_0.gridx = 0;
				labelGbc_0.gridy = 0;
				add(projectNameLabel, labelGbc_0);
		
				projectNameJTextField = new JTextField();
				GridBagConstraints componentGbc_0 = new GridBagConstraints();
				componentGbc_0.insets = new Insets(5, 0, 5, 5);
				componentGbc_0.fill = GridBagConstraints.HORIZONTAL;
				componentGbc_0.gridx = 1;
				componentGbc_0.gridy = 0;
				add(projectNameJTextField, componentGbc_0);

		JLabel projectPathLabel = new JLabel("Project Path:");
		GridBagConstraints labelGbc_1 = new GridBagConstraints();
		labelGbc_1.insets = new Insets(5, 5, 5, 5);
		labelGbc_1.gridx = 0;
		labelGbc_1.gridy = 1;
		add(projectPathLabel, labelGbc_1);

		projectPathJTextField = new JTextField();
		GridBagConstraints componentGbc_1 = new GridBagConstraints();
		componentGbc_1.insets = new Insets(5, 0, 5, 5);
		componentGbc_1.fill = GridBagConstraints.HORIZONTAL;
		componentGbc_1.gridx = 1;
		componentGbc_1.gridy = 1;
		add(projectPathJTextField, componentGbc_1);
		
		panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.inactiveCaptionBorder);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_2.gridx = 2;
		gbc_panel_2.gridy = 1;
		add(panel_2, gbc_panel_2);
		
		button = new JButton("");
		button.setIcon(new ImageIcon(GeneratorJPanel.class.getResource("/com/sun/java/swing/plaf/windows/icons/Directory.gif")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooseFile(projectPathJTextField);
			}
		});
		button.setBackground(UIManager.getColor("Button.background"));
		panel_2.add(button);
		
		JLabel templatePathLabel = new JLabel("Template Path:");
		GridBagConstraints labelGbc_2 = new GridBagConstraints();
		labelGbc_2.anchor = GridBagConstraints.BASELINE;
		labelGbc_2.insets = new Insets(5, 5, 5, 5);
		labelGbc_2.gridx = 0;
		labelGbc_2.gridy = 2;
		add(templatePathLabel, labelGbc_2);
		
		templatePathJTextField = new JTextField();
		GridBagConstraints componentGbc_2 = new GridBagConstraints();
		componentGbc_2.anchor = GridBagConstraints.BASELINE;
		componentGbc_2.insets = new Insets(5, 0, 5, 5);
		componentGbc_2.fill = GridBagConstraints.HORIZONTAL;
		componentGbc_2.gridx = 1;
		componentGbc_2.gridy = 2;
		add(templatePathJTextField, componentGbc_2);
		
		panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.inactiveCaptionBorder);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.anchor = GridBagConstraints.BASELINE;
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_3.gridx = 2;
		gbc_panel_3.gridy = 2;
		add(panel_3, gbc_panel_3);
		
		templatePathChooserButton = new JButton("");
		templatePathChooserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooseFile(templatePathJTextField);
			}
		});
		templatePathChooserButton.setIcon(new ImageIcon(GeneratorJPanel.class.getResource("/com/sun/java/swing/plaf/windows/icons/Directory.gif")));
		templatePathChooserButton.setBackground(UIManager.getColor("Button.background"));
		panel_3.add(templatePathChooserButton);

		JLabel domainNameLabel = new JLabel("Domain Name:");
		GridBagConstraints labelGbc_3 = new GridBagConstraints();
		labelGbc_3.anchor = GridBagConstraints.ABOVE_BASELINE;
		labelGbc_3.insets = new Insets(5, 5, 5, 5);
		labelGbc_3.gridx = 0;
		labelGbc_3.gridy = 3;
		add(domainNameLabel, labelGbc_3);

		domainNameJTextField = new JTextField();
		GridBagConstraints componentGbc_3 = new GridBagConstraints();
		componentGbc_3.anchor = GridBagConstraints.ABOVE_BASELINE;
		componentGbc_3.insets = new Insets(5, 0, 5, 5);
		componentGbc_3.fill = GridBagConstraints.HORIZONTAL;
		componentGbc_3.gridx = 1;
		componentGbc_3.gridy = 3;
		add(domainNameJTextField, componentGbc_3);

		table = new JTable();
		table.setFillsViewportHeight(true);

		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);

		GridBagConstraints scrollPaneC = new GridBagConstraints();
		scrollPaneC.gridheight = 2;
		scrollPaneC.gridwidth = 2;
		scrollPaneC.insets = new Insets(0, 0, 5, 5);
		scrollPaneC.fill = GridBagConstraints.BOTH;
		scrollPaneC.gridx = 0;
		scrollPaneC.gridy = 4;
		add(scrollPane, scrollPaneC);

		panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaptionBorder);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridheight = 2;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 2;
		gbc_panel_1.gridy = 4;
		add(panel_1, gbc_panel_1);

		btnNewButton_1 = new JButton("+");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				generatorSetupBean.getDomainAttributes().add(new DomainAttributeBean());
				tableBinding.unbind();
				tableBinding.bind();
			}
		});
		panel_1.setLayout(new MigLayout("", "[41px]", "[23px][23px]"));
		panel_1.add(btnNewButton_1, "cell 0 0,alignx left,aligny top");

		btnNewButton = new JButton("-");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = table.getSelectedRow();
				if (index > -1) {
					generatorSetupBean.getDomainAttributes().remove(index);
					tableBinding.unbind();
					tableBinding.bind();
				}
			}
		});
		panel_1.add(btnNewButton, "cell 0 1,alignx center,aligny top");
		
		JLabel lblGenerate = new JLabel("Generate:");
		GridBagConstraints gbc_lblGenerate = new GridBagConstraints();
		gbc_lblGenerate.insets = new Insets(0, 0, 5, 5);
		gbc_lblGenerate.gridx = 0;
		gbc_lblGenerate.gridy = 6;
		add(lblGenerate, gbc_lblGenerate);
		
		generatorOptionPanel = new JPanel();
		generatorOptionPanel.setBackground(SystemColor.inactiveCaptionBorder);
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.gridwidth = 3;
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 1;
		gbc_panel_4.gridy = 6;
		add(generatorOptionPanel, gbc_panel_4);
		
		chckbxFrontend = new JCheckBox("Frontend");
		chckbxFrontend.setBackground(SystemColor.inactiveCaptionBorder);
		
		JCheckBox chckbxRestfulWebservices = new JCheckBox("Restful Webservices");
		chckbxRestfulWebservices.setBackground(SystemColor.inactiveCaptionBorder);
		
		JCheckBox chckbxBackendservices = new JCheckBox("BackendServices");
		chckbxBackendservices.setBackground(SystemColor.inactiveCaptionBorder);
		
		JCheckBox chckbxTestdata = new JCheckBox("Testdata");
		chckbxTestdata.setBackground(SystemColor.inactiveCaptionBorder);
		
		JCheckBox chckbxEntity = new JCheckBox("Entity");
		chckbxEntity.setBackground(SystemColor.inactiveCaptionBorder);
		GroupLayout gl_generatorOptionPanel = new GroupLayout(generatorOptionPanel);
		gl_generatorOptionPanel.setHorizontalGroup(
			gl_generatorOptionPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_generatorOptionPanel.createSequentialGroup()
					.addGroup(gl_generatorOptionPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_generatorOptionPanel.createSequentialGroup()
							.addGroup(gl_generatorOptionPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(chckbxEntity)
								.addComponent(chckbxBackendservices))
							.addGap(36)
							.addGroup(gl_generatorOptionPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(chckbxTestdata)
								.addComponent(chckbxFrontend)))
						.addComponent(chckbxRestfulWebservices))
					.addGap(75))
		);
		gl_generatorOptionPanel.setVerticalGroup(
			gl_generatorOptionPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_generatorOptionPanel.createSequentialGroup()
					.addGroup(gl_generatorOptionPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxEntity)
						.addComponent(chckbxFrontend))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_generatorOptionPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxBackendservices)
						.addComponent(chckbxTestdata))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chckbxRestfulWebservices)
					.addContainerGap(20, Short.MAX_VALUE))
		);
		generatorOptionPanel.setLayout(gl_generatorOptionPanel);

		panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.anchor = GridBagConstraints.EAST;
		gbc_panel.fill = GridBagConstraints.VERTICAL;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 7;
		add(panel, gbc_panel);

		btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m_bindingGroup.bind();
				generatorService.generate(generatorSetupBean);
			}
		});
		panel.add(btnOk);

		btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		panel.add(btnAbbrechen);

		if (generatorSetupBean != null) {
			m_bindingGroup = initDataBindings();
		}
	}

	private JComboBox<DataType> generateBox() {
		JComboBox<DataType> bx = new JComboBox<DataType>();
		for (DataType dataType : DataType.values()) {
			bx.addItem(dataType);
		}
		bx.setModel(new DefaultComboBoxModel<DataType>(DataType.values()));
		return bx;

	}

	protected BindingGroup initDataBindings() {
		BeanProperty<frontend.beans.GeneratorSetupBean, java.lang.String> projectNameProperty = BeanProperty
				.create("projectName");
		BeanProperty<javax.swing.JTextField, java.lang.String> textProperty = BeanProperty.create("text");
		AutoBinding<frontend.beans.GeneratorSetupBean, java.lang.String, javax.swing.JTextField, java.lang.String> autoBinding = Bindings
				.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, generatorSetupBean, projectNameProperty,
						projectNameJTextField, textProperty);
		autoBinding.bind();
		//
		BeanProperty<frontend.beans.GeneratorSetupBean, java.lang.String> projectPathProperty = BeanProperty
				.create("projectPath");
		BeanProperty<javax.swing.JTextField, java.lang.String> textProperty_1 = BeanProperty.create("text");
		AutoBinding<frontend.beans.GeneratorSetupBean, java.lang.String, javax.swing.JTextField, java.lang.String> autoBinding_1 = Bindings
				.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, generatorSetupBean, projectPathProperty,
						projectPathJTextField, textProperty_1);
		autoBinding_1.bind();
		//
		BeanProperty<frontend.beans.GeneratorSetupBean, java.lang.String> domainNameProperty = BeanProperty
				.create("domainName");
		BeanProperty<javax.swing.JTextField, java.lang.String> textProperty_2 = BeanProperty.create("text");
		AutoBinding<frontend.beans.GeneratorSetupBean, java.lang.String, javax.swing.JTextField, java.lang.String> autoBinding_2 = Bindings
				.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, generatorSetupBean, domainNameProperty,
						domainNameJTextField, textProperty_2);
		autoBinding_2.bind();
		//
		BindingGroup bindingGroup = new BindingGroup();
		bindingGroup.addBinding(autoBinding);
		bindingGroup.addBinding(autoBinding_1);
		bindingGroup.addBinding(autoBinding_2);
		//

		generatorSetupBean.getDomainAttributes().add(new DomainAttributeBean());
		// create the binding from List to JTable
		tableBinding = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ_WRITE,
				generatorSetupBean.getDomainAttributes(), table);

		// define the properties to be used for the columns
		BeanProperty<DomainAttributeBean, Integer> max = BeanProperty.create("max");
		BeanProperty<DomainAttributeBean, Integer> min = BeanProperty.create("min");
		BeanProperty<DomainAttributeBean, java.lang.String> pattern = BeanProperty.create("pattern");
		BeanProperty<DomainAttributeBean, java.lang.String> columnName = BeanProperty.create("columnName");
		BeanProperty<DomainAttributeBean, DataType> dataType = BeanProperty.create("dataType");
		BeanProperty<DomainAttributeBean, Boolean> nullable = BeanProperty.create("nullable");

		// configure how the properties map to columns
		tableBinding.addColumnBinding(columnName).setColumnName("Name");
		tableBinding.addColumnBinding(dataType).setColumnName("Data Type").setColumnClass(DataType.class);
		tableBinding.addColumnBinding(nullable).setColumnName("Nullable").setColumnClass(Boolean.class);
		tableBinding.addColumnBinding(max).setColumnName("Max").setColumnClass(Integer.class);
		tableBinding.addColumnBinding(min).setColumnName("Min").setColumnClass(Integer.class);
		tableBinding.addColumnBinding(pattern).setColumnName("Pattern");
		// realize the binding
		tableBinding.bind();
		
		table.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(generateBox()));
		table.setColumnSelectionAllowed(true);

		bindingGroup.addBinding(tableBinding);
		return bindingGroup;
	}

	public frontend.beans.GeneratorSetupBean getGeneratorSetupBean() {
		return generatorSetupBean;
	}
	
	public BindingGroup getBindingGroup() {
		return m_bindingGroup;
	}

	public void setGeneratorSetupBean(frontend.beans.GeneratorSetupBean newGeneratorSetupBean) {
		setGeneratorSetupBean(newGeneratorSetupBean, true);
	}

	public void setGeneratorSetupBean(frontend.beans.GeneratorSetupBean newGeneratorSetupBean, boolean update) {
		generatorSetupBean = newGeneratorSetupBean;
		if (update) {
			if (m_bindingGroup != null) {
				m_bindingGroup.unbind();
				m_bindingGroup = null;
			}
			if (generatorSetupBean != null) {
				m_bindingGroup = initDataBindings();
			}
		}
	}

	private void chooseFile(JTextField jTextField) {
		fileChooser.setSelectedFile(new File(jTextField.getText()));
		int returnVal = fileChooser.showOpenDialog(jTextField);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
        	jTextField.setText(fileChooser.getSelectedFile().getAbsolutePath()); 
            try {
              // return the file path 
            } catch (Exception ex) {
            	LOG.error("Problem accessing file.");
            }
        } 
        else {
        	LOG.info("File access cancelled by user.");
        }
	}   
}

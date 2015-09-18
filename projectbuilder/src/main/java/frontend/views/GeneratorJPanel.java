package frontend.views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import frontend.beans.DataType;
import frontend.beans.DomainAttributeBean;
import net.miginfocom.swing.MigLayout;
import java.awt.SystemColor;

public class GeneratorJPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private BindingGroup m_bindingGroup;
	private JTableBinding<DomainAttributeBean, List<DomainAttributeBean>, JTable> tableBinding;
	private frontend.beans.GeneratorSetupBean generatorSetupBean = new frontend.beans.GeneratorSetupBean();
	private JTextField projectNameJTextField;
	private JTextField projectPathJTextField;
	private JTextField domainNameJTextField;
	private JTable table;
	private JPanel panel;
	private JButton btnOk;
	private JButton btnAbbrechen;
	private JButton btnNewButton;
	private JPanel panel_1;
	private JButton btnNewButton_1;

	public GeneratorJPanel(frontend.beans.GeneratorSetupBean newGeneratorSetupBean) {
		this();
		setGeneratorSetupBean(newGeneratorSetupBean);
	}

	public GeneratorJPanel() {
		setBackground(SystemColor.inactiveCaptionBorder);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 77, 205, 51, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 124, 31, 26, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0, 1.0E-4 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0E-4 };
		setLayout(gridBagLayout);

		JLabel projectNameLabel = new JLabel("ProjectName:");
		GridBagConstraints labelGbc_0 = new GridBagConstraints();
		labelGbc_0.insets = new Insets(5, 5, 5, 5);
		labelGbc_0.gridx = 0;
		labelGbc_0.gridy = 0;
		add(projectNameLabel, labelGbc_0);

		projectNameJTextField = new JTextField();
		projectNameJTextField.setColumns(5);
		GridBagConstraints componentGbc_0 = new GridBagConstraints();
		componentGbc_0.insets = new Insets(5, 0, 5, 5);
		componentGbc_0.fill = GridBagConstraints.HORIZONTAL;
		componentGbc_0.gridx = 1;
		componentGbc_0.gridy = 0;
		add(projectNameJTextField, componentGbc_0);

		JLabel projectPathLabel = new JLabel("ProjectPath:");
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

		JLabel domainNameLabel = new JLabel("DomainName:");
		GridBagConstraints labelGbc_2 = new GridBagConstraints();
		labelGbc_2.insets = new Insets(5, 5, 5, 5);
		labelGbc_2.gridx = 0;
		labelGbc_2.gridy = 2;
		add(domainNameLabel, labelGbc_2);

		domainNameJTextField = new JTextField();
		GridBagConstraints componentGbc_2 = new GridBagConstraints();
		componentGbc_2.insets = new Insets(5, 0, 5, 5);
		componentGbc_2.fill = GridBagConstraints.HORIZONTAL;
		componentGbc_2.gridx = 1;
		componentGbc_2.gridy = 2;
		add(domainNameJTextField, componentGbc_2);

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
		scrollPaneC.gridy = 3;
		add(scrollPane, scrollPaneC);

		panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaptionBorder);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridheight = 2;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 2;
		gbc_panel_1.gridy = 3;
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

		panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.anchor = GridBagConstraints.EAST;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.VERTICAL;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 5;
		add(panel, gbc_panel);

		btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m_bindingGroup.bind();
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

}

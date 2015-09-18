package frontend.views;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class ProjectBuilder {

	private JFrame frmProjectSetup;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProjectBuilder window = new ProjectBuilder();
					window.frmProjectSetup.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ProjectBuilder() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProjectSetup = new JFrame();
		frmProjectSetup.setTitle("Project Setup");
		frmProjectSetup.setBackground(SystemColor.inactiveCaptionBorder);
		frmProjectSetup.setBounds(100, 100, 491, 195);
		frmProjectSetup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		frmProjectSetup.getContentPane().setLayout(gridBagLayout);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 1;
		frmProjectSetup.getContentPane().add(tabbedPane, gbc_tabbedPane);
		
		JPanel panel = new ProjectBuilderJPanel();
		tabbedPane.addTab("Setup", null, panel, null);
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Generate", null, panel_1, null);
	}

}

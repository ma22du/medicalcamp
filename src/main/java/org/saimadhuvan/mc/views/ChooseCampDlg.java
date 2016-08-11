package org.saimadhuvan.mc.views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.saimadhuvan.mc.common.CampActivity;
import org.saimadhuvan.mc.controller.MainWorkFlow;
import org.saimadhuvan.mc.dao.entity.Camp;
import org.saimadhuvan.mc.dao.impl.CampImpl;

public class ChooseCampDlg extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static final long serialVersionUID = 1L;
	
	private Set<CampActivity> workFlow;
	
	/**
	 * @param the workFlow to set
	 */
	public void setWorkFlow(Set<CampActivity> workFlow) {
		this.workFlow = workFlow;
	}

	private JComboBox<String> comboBox;
	private List<Camp> Camps;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ChooseCampDlg dialog = new ChooseCampDlg();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ChooseCampDlg() {
		setTitle("Choose the camp");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(ChooseCampDlg.class.getResource("/medical-camp-512.png")));
		setResizable(false);
		setBounds(100, 100, 291, 102);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setModal(true);
		setLocationRelativeTo(null);

		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			comboBox = new JComboBox<String>();
			contentPanel.add(comboBox, BorderLayout.CENTER);
			CampImpl campManage = new CampImpl();
			Camps = campManage.GetCamps();
			System.out.println(Camps.size());
			for (Camp cmp : Camps) {
				comboBox.addItem(cmp.getCampName());
			}
		}

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		{
			JButton okButton = new JButton("OK");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					System.out.println("Work flow => " + workFlow);
					String cmpName = comboBox.getItemAt(comboBox.getSelectedIndex());

					Camp selectedCamp = null;
					for (Camp cmp : Camps) {
						if (cmp.getCampName().compareTo(cmpName) == 0) {
							selectedCamp = cmp;
						}
					}
					
					System.out.println("For Medical camp - " + selectedCamp.getCampName());
					dispose();
					
					//Relay to the controller
					MainWorkFlow controller = new MainWorkFlow(selectedCamp,workFlow);
					controller.performActivity();
					
				}
			});
			okButton.setActionCommand("OK");
			okButton.setText("OK");
			buttonPane.add(okButton);
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("Cancel");
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			cancelButton.setActionCommand("Cancel");
			cancelButton.setText("Cancel");
			buttonPane.add(cancelButton);
		}	
	}
}

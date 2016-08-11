package org.saimadhuvan.mc.views;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.Component;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import org.saimadhuvan.mc.common.CampActivity;




public class MainView extends JFrame {

	private JPanel contentPane;
	private static final long serialVersionUID = 1L;
	private static final int NEW_WIDTH = 64;
	private static final int NEW_HEIGHT = 64;
	
	private static JButton btnPatientRegister;
	private static JButton btnStockRegister;
	private static JButton btnPharmacy;
	
	private final Action selectCampAction = new ChooseCampAction();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainView() {
		initializeComponents();		
	}

	private void initializeComponents() {
		
		//System.out.println(System.getProperty("java.class.path"));
		setResizable(false);
		setTitle("\u0D2E\u0D27\u0D41\u0D35\u0D28\u0D02 - Medical Camp");///MedicalCamp/resources/
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/application.png")));
		setBounds(100, 100, 699, 435);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(173, 216, 230));
		setContentPane(contentPane);
		
		setLocationRelativeTo(null);
		
		
		ImageIcon iconPatientRegister = new ImageIcon(MainView.class.getResource("/patient-profile-icon.png"));
		Image originalImgPR = iconPatientRegister.getImage() ;  
		Image scaledImagePR = originalImgPR.getScaledInstance( NEW_WIDTH, NEW_HEIGHT,  java.awt.Image.SCALE_SMOOTH ) ;  
		iconPatientRegister = new ImageIcon( scaledImagePR );
		
		btnPatientRegister = new JButton("");			
		btnPatientRegister.setAction(selectCampAction);
		btnPatientRegister.setText("Patient Register");
		btnPatientRegister.setMnemonic(KeyEvent.VK_A);	
		btnPatientRegister.setIcon(iconPatientRegister);
		btnPatientRegister.setBounds(10, 11, 216, 173);
		
		ImageIcon iconStockRegister = new ImageIcon(MainView.class.getResource("/drug-asset.png"));
		Image originalImgSR = iconStockRegister.getImage() ;  
		Image scaledImageSR = originalImgSR.getScaledInstance( NEW_WIDTH, NEW_HEIGHT,  java.awt.Image.SCALE_SMOOTH ) ;  
		iconStockRegister = new ImageIcon( scaledImageSR );
		
		btnStockRegister = new JButton("");		
		btnStockRegister.setAction(selectCampAction);
		btnStockRegister.setText("Stock Register");
		btnStockRegister.setMnemonic(KeyEvent.VK_O);		
		btnStockRegister.setIcon(iconStockRegister);
		btnStockRegister.setBounds(10, 195, 216, 189);
	
		ImageIcon iconPharmacy = new ImageIcon(MainView.class.getResource("/blue-hospital-icon-14.png"));
		Image originalImgPY = iconPharmacy.getImage() ;  
		Image scaledImagePY = originalImgPY.getScaledInstance( 128, 128,  java.awt.Image.SCALE_SMOOTH ) ;  
		iconPharmacy = new ImageIcon( scaledImagePY );
		
		
		btnPharmacy = new JButton("");		
		btnPharmacy.setAction(selectCampAction);
		btnPharmacy.setText("Pharmacy");
		btnPharmacy.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnPharmacy.setMnemonic(KeyEvent.VK_H);		
		btnPharmacy.setIcon(iconPharmacy);
		btnPharmacy.setBounds(246, 11, 423, 373);
		
		getContentPane().add(btnPatientRegister);
		getContentPane().add(btnStockRegister);
		getContentPane().add(btnPharmacy);

		getRootPane().setDefaultButton(btnPharmacy);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnPharmacy, btnStockRegister, btnPatientRegister}));
		btnPharmacy.requestFocusInWindow();
		
	}

	private class ChooseCampAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public ChooseCampAction() {
			putValue(NAME, "ChooseCamp");
			putValue(SHORT_DESCRIPTION, "Enter Medical Camp Pharmacy");
		}
		public void actionPerformed(ActionEvent e) {
		
		 ChooseCampDlg curCampChooser = new ChooseCampDlg();
		 		 
		 if(e.getSource() == btnPharmacy)
			 curCampChooser.setWorkFlow(CampActivity.PharmacyActivities);
		 else if(e.getSource() == btnPatientRegister)
			 curCampChooser.setWorkFlow(CampActivity.PatientActivities);
		 else if(e.getSource() == btnStockRegister)
			 curCampChooser.setWorkFlow(CampActivity.StockActivities);	
		 
		 curCampChooser.setVisible(true);	 
	 
		}

	}
}

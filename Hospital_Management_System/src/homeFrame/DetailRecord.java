package homeFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class DetailRecord {

	private JLabel lblDoctorID;
	private JLabel lblRoom;
	private JTextArea txtDescription;
	private JLabel lblDate;
	private JFrame frame;
	private JLabel lblDateout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DetailRecord window = new DetailRecord();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DetailRecord() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(64, 224, 208));
		frame.setBounds(100, 100, 660, 350);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		 txtDescription = new JTextArea();
		txtDescription.setColumns(10);
		txtDescription.setBounds(112, 140, 522, 160);
		frame.getContentPane().add(txtDescription);
		
		JLabel lblDetailRecord = new JLabel("Detail record");
		lblDetailRecord.setHorizontalAlignment(SwingConstants.CENTER);
		lblDetailRecord.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDetailRecord.setBounds(206, 0, 200, 35);
		frame.getContentPane().add(lblDetailRecord);
		
		JLabel lblDoctorId = new JLabel("Doctor ID :");
		lblDoctorId.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDoctorId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDoctorId.setBounds(10, 40, 89, 20);
		frame.getContentPane().add(lblDoctorId);
		
		JLabel lblR = new JLabel("Room :");
		lblR.setHorizontalAlignment(SwingConstants.TRAILING);
		lblR.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblR.setBounds(10, 71, 89, 20);
		frame.getContentPane().add(lblR);
		
		JLabel lblDescription = new JLabel("Description :");
		lblDescription.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDescription.setBounds(10, 140, 89, 20);
		frame.getContentPane().add(lblDescription);
		
		 lblDoctorID = new JLabel("");
		lblDoctorID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDoctorID.setBounds(112, 40, 89, 20);
		frame.getContentPane().add(lblDoctorID);
		
		 lblRoom = new JLabel("");
		lblRoom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRoom.setBounds(109, 71, 89, 20);
		frame.getContentPane().add(lblRoom);
		
		JLabel labelDate = new JLabel("Date in :");
		labelDate.setHorizontalAlignment(SwingConstants.TRAILING);
		labelDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelDate.setBounds(10, 109, 89, 20);
		frame.getContentPane().add(labelDate);
		
		 lblDate = new JLabel("");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDate.setBounds(112, 109, 200, 20);
		frame.getContentPane().add(lblDate);
		
		JLabel lblDateOut = new JLabel("Date out :");
		lblDateOut.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDateOut.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDateOut.setBounds(318, 109, 89, 20);
		frame.getContentPane().add(lblDateOut);
		
		 lblDateout = new JLabel("");
		lblDateout.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDateout.setBounds(420, 109, 200, 20);
		frame.getContentPane().add(lblDateout);
	}

	public JLabel getLblDoctorID() {
		return lblDoctorID;
	}

	public void setLblDoctorID(JLabel lblDoctorID) {
		this.lblDoctorID = lblDoctorID;
	}

	public JLabel getLblRoom() {
		return lblRoom;
	}

	public void setLblRoom(JLabel lblRoom) {
		this.lblRoom = lblRoom;
	}

	public JTextArea getTxtDescription() {
		return txtDescription;
	}

	public void setTxtDescription(JTextArea txtDescription) {
		this.txtDescription = txtDescription;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JLabel getLblDate() {
		return lblDate;
	}

	public void setLblDate(JLabel lblDate) {
		this.lblDate = lblDate;
	}

	public JLabel getLblDateout() {
		return lblDateout;
	}

	public void setLblDateout(JLabel lblDateout) {
		this.lblDateout = lblDateout;
	}
	
}

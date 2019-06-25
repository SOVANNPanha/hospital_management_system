package homeFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import classes.PatientRecord;
import database.DatabasePatientRecords;

import javax.swing.JTable;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TableRecords {

	
	
	private JFrame frame;
	private JTable table;
	private JLabel lblName;
	private JLabel lblGender;
	private JLabel lblAge;
	private JLabel lblContact;
	
	
	private int patient_id;
	private DefaultTableModel recordModel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableRecords window = new TableRecords();
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
	public TableRecords() {
		initialize();
	}
	public TableRecords(int pateint_id) {
	
		this.patient_id=pateint_id;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(64, 224, 208));
		frame.setBounds(100, 100, 800, 424);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int indexNumber= table.getSelectedRow();
				int record_id= Integer.parseInt(table.getValueAt(indexNumber, 1).toString());
				
				try {
					DatabasePatientRecords databasePatientRecords= new DatabasePatientRecords();
					PatientRecord patientRecord= databasePatientRecords.getAPatientRecordByID(record_id);
					
					DetailRecord detailRecord= new DetailRecord();
					detailRecord.getLblDoctorID().setText(patientRecord.getDoctor_id());
					detailRecord.getLblRoom().setText(patientRecord.getRoom());
					detailRecord.getLblDate().setText(patientRecord.getDate()+"");
					detailRecord.getLblDateout().setText(patientRecord.getDate_out()+"");
					detailRecord.getTxtDescription().setText(patientRecord.getDescription());
					detailRecord.getFrame().setVisible(true);
					
					databasePatientRecords.closeConnection();
					
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		});
		DefaultTableModel recordModel= new DefaultTableModel();
		String[] column= {"ID","Record ID","Doctor ID","Room","Date in","Date out","Description"};
		recordModel.setColumnIdentifiers(column);
		
		table.setModel(recordModel);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(75);
		table.getColumnModel().getColumn(2).setPreferredWidth(75);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		table.getColumnModel().getColumn(4).setPreferredWidth(150);
		table.getColumnModel().getColumn(5).setPreferredWidth(150);
		table.getColumnModel().getColumn(6).setPreferredWidth(210);
		try {
			
			DatabasePatientRecords patientRecords = new DatabasePatientRecords();
			patientRecords.setModelPatientRecords(recordModel);
			patientRecords.getAllRecordsOfPatientID(patient_id);
			patientRecords.closeConnection();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 129, 764, 245);
		frame.getContentPane().add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("Pateint's History");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(258, 11, 250, 35);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Patient :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 57, 82, 30);
		frame.getContentPane().add(lblNewLabel_1);
		
		 lblName = new JLabel();
	
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblName.setBounds(115, 57, 161, 30);
		frame.getContentPane().add(lblName);
		
		JLabel dd = new JLabel("Gender :");
		dd.setFont(new Font("Tahoma", Font.BOLD, 16));
		dd.setBounds(10, 88, 82, 30);
		frame.getContentPane().add(dd);
		
		lblGender = new JLabel();
		
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGender.setBounds(102, 88, 82, 30);
		frame.getContentPane().add(lblGender);
		
		 lblAge = new JLabel();
		
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAge.setBounds(319, 88, 82, 30);
		frame.getContentPane().add(lblAge);
		
		JLabel lbl = new JLabel("Age  :");
		lbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl.setBounds(244, 88, 65, 30);
		frame.getContentPane().add(lbl);
		
		JLabel lblCon = new JLabel("Contact :");
		lblCon.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCon.setBounds(411, 88, 82, 30);
		frame.getContentPane().add(lblCon);
		
		 lblContact = new JLabel();
		
		lblContact.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblContact.setBounds(503, 88, 161, 30);
		frame.getContentPane().add(lblContact);
	}


	public int getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public DefaultTableModel getRecordModel() {
		return recordModel;
	}

	public void setRecordModel(DefaultTableModel recordModel) {
		this.recordModel = recordModel;
	}

	public JLabel getLblName() {
		return lblName;
	}

	public void setLblName(JLabel lblName) {
		this.lblName = lblName;
	}

	public JLabel getLblGender() {
		return lblGender;
	}

	public void setLblGender(JLabel lblGender) {
		this.lblGender = lblGender;
	}

	public JLabel getLblAge() {
		return lblAge;
	}

	public void setLblAge(JLabel lblAge) {
		this.lblAge = lblAge;
	}

	public JLabel getLblContact() {
		return lblContact;
	}

	public void setLblContact(JLabel lblContact) {
		this.lblContact = lblContact;
	}
	
}

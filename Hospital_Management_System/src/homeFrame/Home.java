package homeFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

import classes.Doctor;
import classes.Patient;
import classes.PatientRecord;
import database.DatabaseDoctor;
import database.DatabasePatient;
import database.DatabasePatientRecords;
import database.DatabaseReceipt;

import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;

public class Home {

	private JFrame frmHospitalManagementSysytem;
	JPanel patient;
	JLabel patienOption;
	JPanel doctor;
	JLabel doctorOption;
	JPanel receipts;
	JLabel receiptOption;
	JButton btnCreatePatient;
	DatabasePatient databaseP;
	DatabasePatientRecords databasePatientRecords;
	DatabaseDoctor databaseD;
	FormCreatePatient formCreatePatient;
	FormCreateDoctor formCreateDoctor;
	
	JTable tablePatient;
	DefaultTableModel modelPatient;
	JScrollPane scrollPanePatient;
	JTable doctorTable;
	DefaultTableModel modelDoctor;
	JScrollPane scrollPaneDoctor;
	
	JTable receiptTable;
	DefaultTableModel modelReceipt;
	JScrollPane scrollPaneReceipt;
	
	JLabel historylb;
	DefaultTableModel historyModel;
	
	private ArrayList<Integer> arrayPatientID = new ArrayList<Integer>();
	private String signalOfPatient;
	private JButton btnRefresh;
	
	private String firstName;
	private String lastName;
	private String date;
	private JLabel lblNewLabel;
	
	
	private JPanel historyPanel;
	private JTable tableHistory;
	private JLabel LabelOfHistoryPatient;
	
	/**
	 * Launch 
	 * 4/
	 * the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home("getAllPatients");
					window.getFrame().setVisible(true);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home(String signal) {
		this.signalOfPatient = signal;
		initialize();
	}
	public Home(String signal,String firstName,String lastName) {
		this.signalOfPatient = signal;
		this.firstName=firstName;
		this.lastName= lastName;
		initialize();	
	}
	public Home(String signal,String date) {
		this.signalOfPatient = signal;
		this.date=date;
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHospitalManagementSysytem = new JFrame();
		frmHospitalManagementSysytem.setTitle("Hospital Management System");
		frmHospitalManagementSysytem.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
		frmHospitalManagementSysytem.setBounds(100, 100, 1200, 600);
		frmHospitalManagementSysytem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHospitalManagementSysytem.getContentPane().setLayout(null);
	
		
		
	//Block Side bar
		JPanel sidebar = new JPanel();
		sidebar.setBorder(new LineBorder(new Color(0, 0, 0)));
		sidebar.setBackground(new Color(64, 224, 208));
		sidebar.setForeground(Color.BLACK);
		sidebar.setBounds(0, 0, 184, 561);
		frmHospitalManagementSysytem.getContentPane().add(sidebar);
		sidebar.setLayout(null);
		
		 patienOption = new JLabel("Hospitalized Patients");
		patienOption.setForeground(Color.RED);
		patienOption.setBackground(Color.PINK);
		patienOption.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				patient.setVisible(true);
				patienOption.setForeground(Color.RED);
				doctor.setVisible(false);
				doctorOption.setForeground(Color.BLACK);
				receipts.setVisible(false);
				receiptOption.setForeground(Color.BLACK);
				historyPanel.setVisible(false);
				historylb.setForeground(Color.BLACK);
				
			}
		});
		patienOption.setFont(new Font("Tahoma", Font.BOLD, 14));
		patienOption.setHorizontalAlignment(SwingConstants.LEFT);
		patienOption.setBounds(10, 59, 164, 30);
		sidebar.add(patienOption);
		
		 doctorOption = new JLabel("Doctors");
		doctorOption.setBackground(Color.WHITE);
		doctorOption.setForeground(Color.BLACK);
		doctorOption.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				patient.setVisible(false);
				patienOption.setForeground(Color.BLACK);
				doctor.setVisible(true);
				doctorOption.setForeground(Color.RED);
				receipts.setVisible(false);
				receiptOption.setForeground(Color.BLACK);
				historyPanel.setVisible(false);
				historylb.setForeground(Color.BLACK);
				
			}
		});
		doctorOption.setHorizontalAlignment(SwingConstants.LEFT);
		doctorOption.setFont(new Font("Tahoma", Font.BOLD, 14));
		doctorOption.setBounds(10, 100, 125, 30);
		sidebar.add(doctorOption);
		
		 receiptOption = new JLabel("Receipts");
		 receiptOption.setBackground(Color.WHITE);
		 receiptOption.setForeground(Color.BLACK);
		receiptOption.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				patient.setVisible(false);
				patienOption.setForeground(Color.BLACK);
				doctor.setVisible(false);
				doctorOption.setForeground(Color.BLACK);
				receipts.setVisible(true);
				receiptOption.setForeground(Color.RED);
				historyPanel.setVisible(false);
				historylb.setForeground(Color.BLACK);
			}
		});
		receiptOption.setHorizontalAlignment(SwingConstants.LEFT);
		receiptOption.setFont(new Font("Tahoma", Font.BOLD, 14));
		receiptOption.setBounds(10, 141, 125, 30);
		sidebar.add(receiptOption);
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblWelcome.setBounds(10, 11, 164, 30);
		sidebar.add(lblWelcome);
		
		 historylb = new JLabel("Hostory");
		 historylb.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent arg0) {
		 		
		 		patient.setVisible(false);
				patienOption.setForeground(Color.BLACK);
				doctor.setVisible(false);
				doctorOption.setForeground(Color.BLACK);
				receipts.setVisible(false);
				receiptOption.setForeground(Color.BLACK);
				historyPanel.setVisible(true);
				historylb.setForeground(Color.RED);
		 		
		 	}
		 });
		historylb.setHorizontalAlignment(SwingConstants.LEFT);
		historylb.setForeground(Color.BLACK);
		historylb.setFont(new Font("Tahoma", Font.BOLD, 14));
		historylb.setBackground(Color.WHITE);
		historylb.setBounds(10, 182, 125, 30);
		sidebar.add(historylb);
		//End of Block Side Bar
		
	//Block PetientOption 
		patient = new JPanel();
		patient.setBackground(new Color(64, 224, 208));
		patient.setBorder(new LineBorder(new Color(0, 0, 0)));
		patient.setBounds(184, 0, 1000, 561);
		frmHospitalManagementSysytem.getContentPane().add(patient);
		patient.setLayout(null);
		
		JLabel lblListOfPatients = new JLabel("List of Hospitalized Patients");
		lblListOfPatients.setBackground(Color.WHITE);
		lblListOfPatients.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblListOfPatients.setBounds(21, 11, 289, 30);
		patient.add(lblListOfPatients);
	
		 btnCreatePatient = new JButton("Add");
		 btnCreatePatient.setForeground(new Color(255, 255, 255));
		btnCreatePatient.setBackground(new Color(0, 0, 255));
		btnCreatePatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					 formCreatePatient = new FormCreatePatient();
					 formCreatePatient.getFramePatientForm().setVisible(true);
					 
					 DatabasePatient databasePatient= new DatabasePatient();
					 formCreatePatient.getPatient_id().setText(databasePatient.getRecommentPatientID()+"");
					 arrayPatientID= databasePatient.getPatientID();
					 formCreatePatient.setArrayPatientID(arrayPatientID);
					 databasePatient.closeConnection();
					 
					 formCreatePatient.setModelPatient(modelPatient);
					 formCreatePatient.getBtnPrint().setVisible(false);
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		});
		btnCreatePatient.setBounds(856, 59, 125, 30);
		patient.add(btnCreatePatient);
		btnCreatePatient.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tablePatient = new JTable();
		tablePatient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int rowNumber= tablePatient.getSelectedRow();
				int idP = Integer.parseInt(tablePatient.getValueAt(rowNumber, 0).toString()) ;
				
				databaseP= new DatabasePatient();
				Patient patient= databaseP.getPatientByID(idP);
				arrayPatientID= databaseP.getPatientID();
				databaseP.closeConnection();
				
				databasePatientRecords= new DatabasePatientRecords();
				int lastID= databasePatientRecords.getLastID(patient.getId());
				PatientRecord patientlastRecord= databasePatientRecords.getAPatientRecordByID(lastID);
				databasePatientRecords.closeConnection();
				
				try {					
					FormCreatePatient formCreatePatient = new FormCreatePatient(patient);
					formCreatePatient.getFramePatientForm().setVisible(true);
					
					formCreatePatient.setModelPatient(modelPatient);
					formCreatePatient.setIndexTable(rowNumber);
					
					formCreatePatient.getPatient_id().setText(patient.getId()+"");
					formCreatePatient.getFirstName().setText(patient.getFirstName());
					formCreatePatient.getLastName().setText(patient.getLastName());
					formCreatePatient.getGender().setText(patient.getGender());
					formCreatePatient.getAge().setText(patient.getAge()+"");
					formCreatePatient.getPhoneNumberP().setText(patient.getPhone());
					
				//Address
					formCreatePatient.getVillege().setText(patient.getAddress().getVillege());
					formCreatePatient.getCommune().setText(patient.getAddress().getCommune());
					formCreatePatient.getCity().setText(patient.getAddress().getCity());
					formCreatePatient.getProvinceP().setText(patient.getAddress().getProvince());
					formCreatePatient.getCountry().setText(patient.getAddress().getCountry());
				
					formCreatePatient.getRoomP().setSelectedItem(patientlastRecord.getRoom());
					formCreatePatient.getDescriptionA().setText(patientlastRecord.getDescription());
					formCreatePatient.getDoctor_id().setSelectedItem(patientlastRecord.getDoctor_id());
					
				//Change The value of the Button
					formCreatePatient.getBtnCreatePatient().setText("Update");
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		});
		tablePatient.setBackground(Color.WHITE);
		String[] columnPatient= {"ID","First Name","Last Name","Gender","Age","Date","Phone Contact"};
		modelPatient= new DefaultTableModel();
		modelPatient.setColumnIdentifiers(columnPatient);

		
		tablePatient.setModel(modelPatient);
		tablePatient.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tablePatient.getColumnModel().getColumn(0).setPreferredWidth(50);
		tablePatient.getColumnModel().getColumn(1).setPreferredWidth(200);
		tablePatient.getColumnModel().getColumn(2).setPreferredWidth(200);
		tablePatient.getColumnModel().getColumn(3).setPreferredWidth(100);
		tablePatient.getColumnModel().getColumn(4).setPreferredWidth(50);
		tablePatient.getColumnModel().getColumn(5).setPreferredWidth(200);
		tablePatient.getColumnModel().getColumn(6).setPreferredWidth(160);
		
		
		try {
			databaseP= new DatabasePatient();
			databaseP.setModelPatient(modelPatient);
			switch (getSignalOfPatient()) {
				case "getAllPatients":
					databaseP.getAllPatients();
					System.out.println("In the getAllPatients Block");
					break;
				default:
					break;
			}
			databaseP.closeConnection();
		} catch (Exception e) {
			System.out.println(e);
		}
		 scrollPanePatient = new JScrollPane(tablePatient);
		scrollPanePatient.setBounds(21, 100, 960, 450);
		patient.add(scrollPanePatient);
				
		btnRefresh = new JButton("Refresh");
		btnRefresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					getFrame().dispose();
					getBtnCreatePatient().setVisible(true);
					Home home= new Home("getAllPatients");
					databaseP= new DatabasePatient();
					databaseP.getPatientID().clear();
					databaseP.closeConnection();
					home.getFrame().setVisible(true);
				} catch (Exception e2) {
					System.out.println(e2);
				}
			}
		});
		
		btnRefresh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRefresh.setBackground(new Color(255, 255, 255));
		btnRefresh.setBounds(856, 11, 125, 30);
		patient.add(btnRefresh);
//	//End of Block PatientOption	
//	//Block doctorOption 
		doctor = new JPanel();
		doctor.setBackground(new Color(64, 224, 208));
		doctor.setBorder(new LineBorder(new Color(0, 0, 0)));
		doctor.setBounds(184, 0, 1000, 561);
		frmHospitalManagementSysytem.getContentPane().add(doctor);
		doctor.setLayout(null);
		
		JButton addDoctorbtn;
		addDoctorbtn = new JButton("Add Doctor");
		addDoctorbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					 formCreateDoctor = new FormCreateDoctor();
					 DatabaseDoctor databaseDoctor= new DatabaseDoctor();
					 formCreateDoctor.getDoctor_id().setText(databaseDoctor.getRecommentDoctorID());
					 databaseDoctor.closeConnection();
					 
					 formCreateDoctor.getBtnStopWorking().setVisible(false);
					 formCreateDoctor.getFrame().setVisible(true);
					 formCreateDoctor.setModelD(modelDoctor);
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		});
		addDoctorbtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		addDoctorbtn.setBounds(856, 59, 125, 30);
		doctor.add(addDoctorbtn);
		
		JLabel labelDoctor = new JLabel("List of Doctors");
		labelDoctor.setFont(new Font("Tahoma", Font.BOLD, 18));
		labelDoctor.setBounds(20, 11, 200, 30);
		doctor.add(labelDoctor);
		
		 doctorTable= new JTable();
		 doctorTable.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		int row= doctorTable.getSelectedRow();
		 		String getID=  (String) modelDoctor.getValueAt(row, 0);// We get value from JTable is the String Object
		 		try {
		 			databaseD= new DatabaseDoctor();
					Doctor doctor= databaseD.getDoctorById(getID);
					databaseD.closeConnection();
					
					formCreateDoctor= new FormCreateDoctor(doctor);
					formCreateDoctor.getFrame().setVisible(true);
					formCreateDoctor.setIndexTable(row);
					formCreateDoctor.setModelD(modelDoctor);
					formCreateDoctor.setDoctor(doctor);
					
					formCreateDoctor.getDoctor_id().setText(doctor.getId());
					formCreateDoctor.setPrev_DoctorID(doctor.getId());
					formCreateDoctor.getFirstD().setText(doctor.getFirstName());
					formCreateDoctor.getLastD().setText(doctor.getLastName());
					formCreateDoctor.getGenderD().setText(doctor.getGender());
					formCreateDoctor.getAgeD().setText(doctor.getAge()+"");
					formCreateDoctor.getSkillD().setText(doctor.getSkill());
					
					formCreateDoctor.getBtnCreate().setText("Update");
					if(modelDoctor.getValueAt(row, 6).equals("Stop working")) {
						formCreateDoctor.getBtnStopWorking().setVisible(false);
						formCreateDoctor.getBtnCreate().setVisible(false);
					}
					formCreateDoctor.getTitleFormDoctor().setText("Dortor Form");
				} catch (Exception e2) {
					System.out.println(e);
				}
		 	}
		 });
		doctorTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		doctorTable.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		doctorTable.setBackground(Color.WHITE);
		
		String[] columnDoctor= {"ID","First Name","Last Name","Gender","Age","Skill","Status"};
		 modelDoctor= new DefaultTableModel();
		doctorTable.setModel(modelDoctor);
		modelDoctor.setColumnIdentifiers(columnDoctor);
		try {
			databaseD= new DatabaseDoctor();
			databaseD.setModelDoctor(modelDoctor);
			databaseD.getAllDoctor();
			databaseD.closeConnection();
		} catch (Exception e) {
			System.out.println(e);
		}
		scrollPaneDoctor = new JScrollPane(doctorTable);
		scrollPaneDoctor.setBounds(21, 100, 960, 450);
		doctor.add(scrollPaneDoctor);
		
//End of Block DoctorOption
//Block Receipt
		receipts = new JPanel();
		receipts.setBackground(new Color(64, 224, 208));
		receipts.setBorder(new LineBorder(new Color(0, 0, 0)));
		receipts.setBounds(184, 0, 1000, 561);
		frmHospitalManagementSysytem.getContentPane().add(receipts);
		receipts.setLayout(null);
		
		lblNewLabel = new JLabel("Receipt List");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(21, 11, 200, 34);
		receipts.add(lblNewLabel);
		
		 receiptTable= new JTable();
		 receiptTable.addMouseListener(new MouseAdapter() {
			@Override
		 	public void mouseClicked(MouseEvent arg0) {
		 		int rowNumber= receiptTable.getSelectedRow();
		 		int id_patient= Integer.parseInt(receiptTable.getValueAt(rowNumber, 1).toString());
		 		String date_in= receiptTable.getValueAt(rowNumber, 3).toString();
		 		String date_out= receiptTable.getValueAt(rowNumber, 4).toString();
		 		String price= receiptTable.getValueAt(rowNumber, 5).toString();
		 		
		 		DatabaseReceipt databaseReceipt= new DatabaseReceipt();
		 		Patient receiptGet= databaseReceipt.getReceipt(id_patient);
		 		RecieptForm formReceipt = new RecieptForm();
		 		formReceipt.getFrame().setVisible(true);
	
		 		formReceipt.getP_id().setText(receiptGet.getId()+"");
		 		formReceipt.getP_first().setText(receiptGet.getFirstName());
		 		formReceipt.getP_last().setText(receiptGet.getLastName());
		 		formReceipt.getP_gender().setText(receiptGet.getGender());
		 		formReceipt.getP_age().setText(receiptGet.getAge()+"");
		 		formReceipt.getP_phone().setText(receiptGet.getPhone());
		 		formReceipt.getR_date().setText(date_in);
		 		formReceipt.getLblDateout().setText(date_out);
		 		formReceipt.getP_prix().setText(price);
		 		databaseReceipt.closeConnection();
		 	}
		 });
		receiptTable.setBounds(22, 73, 968, 478);
		receiptTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		receiptTable.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		receiptTable.setBackground(Color.WHITE);
		
		String[] column= {"ID","Patient ID","Name","Date in","Date out","Prix"};
		 modelReceipt= new DefaultTableModel();
		receiptTable.setModel(modelReceipt);
		modelReceipt.setColumnIdentifiers(column);
		try {
			DatabaseReceipt databaseReceipt= new DatabaseReceipt();
			databaseReceipt.getAllReceipts(modelReceipt);
			databaseReceipt.closeConnection();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		 scrollPaneReceipt = new JScrollPane(receiptTable);
		scrollPaneReceipt.setBounds(21, 100, 968, 478);
		receipts.add(scrollPaneReceipt);
	//End of Receipt Block
		//Block of History block
		historyPanel = new JPanel();
		historyPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		historyPanel.setBackground(new Color(64, 224, 208));
		historyPanel.setBounds(184, 0, 1000, 561);
		frmHospitalManagementSysytem.getContentPane().add(historyPanel);
		historyPanel.setLayout(null);
		
		
		tableHistory = new JTable();
		tableHistory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int IndexNumber= tableHistory.getSelectedRow();
				int patient_id= Integer.parseInt(tableHistory.getValueAt(IndexNumber, 0).toString());
				System.out.println(patient_id);
				databaseP= new DatabasePatient();
				Patient patient= databaseP.getPatientByID(patient_id);
				databaseP.closeConnection();
				try {	
					
					TableRecords tableRecords = new TableRecords(patient_id);
					tableRecords.getLblName().setText(patient.getFirstName()+" "+patient.getLastName() );
					tableRecords.getLblGender().setText(patient.getGender());
					tableRecords.getLblAge().setText(patient.getAge()+"");
					tableRecords.getLblContact().setText(patient.getPhone());
				
					tableRecords.getFrame().setVisible(true);
					
					
					
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		});
		 historyModel= new DefaultTableModel();
		String[] columnHistory= {"Patient ID","First name","Last name","Gender","Age","Contact"};
		historyModel.setColumnIdentifiers(columnHistory);
		tableHistory.setModel(historyModel);
		try {
			DatabasePatient databasePatient= new DatabasePatient();
			databasePatient.setModelHostory(historyModel);
			databasePatient.displayAllPatients();
			databasePatient.closeConnection();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		JScrollPane scrollPane = new JScrollPane(tableHistory);
		scrollPane.setBounds(21, 100, 960, 450);
		historyPanel.add(scrollPane);
		
		LabelOfHistoryPatient = new JLabel("History Of Each Patient");
		LabelOfHistoryPatient.setFont(new Font("Tahoma", Font.BOLD, 22));
		LabelOfHistoryPatient.setHorizontalAlignment(SwingConstants.CENTER);
		LabelOfHistoryPatient.setBounds(293, 11, 300, 35);
		historyPanel.add(LabelOfHistoryPatient);
	//End of History BLock

	}
	public JFrame getFrame() {
		return frmHospitalManagementSysytem;
	}

	public void setFrame(JFrame frame) {
		this.frmHospitalManagementSysytem = frame;
	}

	public String getSignalOfPatient() {
		return signalOfPatient;
	}

	public void setSignalOfPatient(String signal) {
		this.signalOfPatient = signal;
	}

	public JButton getBtnCreatePatient() {
		return btnCreatePatient;
	}

	public void setBtnCreatePatient(JButton btnCreatePatient) {
		this.btnCreatePatient = btnCreatePatient;
	}

	public JFrame getFrmHospitalManagementSysytem() {
		return frmHospitalManagementSysytem;
	}

	public void setFrmHospitalManagementSysytem(JFrame frmHospitalManagementSysytem) {
		this.frmHospitalManagementSysytem = frmHospitalManagementSysytem;
	}

	public ArrayList<Integer> getArrayPatientID() {
		return arrayPatientID;
	}

	public void setArrayPatientID(ArrayList<Integer> arrayPatientID) {
		this.arrayPatientID = arrayPatientID;
	}
}

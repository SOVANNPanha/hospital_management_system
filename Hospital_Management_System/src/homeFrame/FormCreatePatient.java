package homeFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JCalendar;

import classes.Address;
import classes.Patient;
import classes.PatientRecord;
import classes.Receipt;
import database.DatabaseDoctor;
import database.DatabasePatient;
import database.DatabasePatientRecords;
import database.DatabaseReceipt;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class FormCreatePatient {

	private JFrame framePatientForm;
	private JTextField firstNameP;
	private JTextField lastNameP;
	private JTextField genderP;
	private JTextField ageP;
	private JTextField villegeP;
	private JTextField communeP;
	private JTextField cityP;
	private JTextField provinceP;
	private JTextField countryP;
	private JTextField patient_id;
	private JComboBox doctor_id;
	private JComboBox roomP;
	private JTextField phoneNumberP;
	private JTextArea descriptionA;
	private JButton btnCreatePatient;
	private JButton btnPrint;
	private Patient patient;
	
	
	private ArrayList<Integer> arrayPatientID = new ArrayList<Integer>();
	private int searchID;
	
	private boolean createPatientRecordOnly=false;
	private DefaultTableModel modelPatient;
	private int indexTable;
	private String typePatient;
	private DefaultTableModel modelReceipt;
	private Timestamp timestamp;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormCreatePatient window = new FormCreatePatient();
					window.getFramePatientForm().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the application.
	 */
	public FormCreatePatient() {
		initialize();
	}

	public FormCreatePatient(Patient patient) {
		super();
		this.patient = patient;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		framePatientForm = new JFrame();
		framePatientForm.getContentPane().setBackground(new Color(64, 224, 208));
		framePatientForm.setBounds(100, 100, 800, 600);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framePatientForm.getContentPane().setLayout(null);
		
		JLabel lblCreatePatient = new JLabel("Register Form");
		lblCreatePatient.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreatePatient.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCreatePatient.setBounds(250, 11, 200, 30);
		framePatientForm.getContentPane().add(lblCreatePatient);
		
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(38, 118, 80, 25);
		framePatientForm.getContentPane().add(lblNewLabel);
		
		firstNameP = new JTextField();
		firstNameP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		firstNameP.setBounds(38, 148, 130, 30);
		framePatientForm.getContentPane().add(firstNameP);
		firstNameP.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLastName.setBounds(211, 118, 80, 25);
		framePatientForm.getContentPane().add(lblLastName);
		
		lastNameP = new JTextField();
		lastNameP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lastNameP.setColumns(10);
		lastNameP.setBounds(211, 148, 130, 30);
		framePatientForm.getContentPane().add(lastNameP);
		
		JLabel lblGe = new JLabel("Gender");
		lblGe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGe.setBounds(38, 189, 80, 25);
		framePatientForm.getContentPane().add(lblGe);
		
		genderP = new JTextField();
		genderP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		genderP.setColumns(10);
		genderP.setBounds(38, 214, 130, 30);
		framePatientForm.getContentPane().add(genderP);
		
		JLabel label = new JLabel(" Age");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(211, 189, 80, 25);
		framePatientForm.getContentPane().add(label);
		
		ageP = new JTextField();
		ageP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ageP.setColumns(10);
		ageP.setBounds(211, 214, 130, 30);
		framePatientForm.getContentPane().add(ageP);
		
		JLabel lblVillege = new JLabel("Villege");
		lblVillege.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblVillege.setBounds(38, 255, 80, 25);
		framePatientForm.getContentPane().add(lblVillege);
		
		villegeP = new JTextField();
		villegeP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		villegeP.setColumns(10);
		villegeP.setBounds(38, 280, 130, 30);
		framePatientForm.getContentPane().add(villegeP);
		
		communeP = new JTextField();
		communeP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		communeP.setColumns(10);
		communeP.setBounds(211, 280, 130, 30);
		framePatientForm.getContentPane().add(communeP);
		
		JLabel lblComminute = new JLabel("Commune");
		lblComminute.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblComminute.setBounds(211, 255, 80, 25);
		framePatientForm.getContentPane().add(lblComminute);
		
		cityP = new JTextField();
		cityP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cityP.setColumns(10);
		cityP.setBounds(38, 345, 130, 30);
		framePatientForm.getContentPane().add(cityP);
		
		JLabel lblDestrict = new JLabel("Destrict/City");
		lblDestrict.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDestrict.setBounds(38, 321, 80, 25);
		framePatientForm.getContentPane().add(lblDestrict);
		
		provinceP = new JTextField();
		provinceP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		provinceP.setColumns(10);
		provinceP.setBounds(211, 345, 130, 30);
		framePatientForm.getContentPane().add(provinceP);
		
		JLabel lblCountry = new JLabel("Province");
		lblCountry.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCountry.setBounds(211, 321, 80, 25);
		framePatientForm.getContentPane().add(lblCountry);
		
		countryP = new JTextField();
		countryP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		countryP.setColumns(10);
		countryP.setBounds(38, 408, 130, 30);
		framePatientForm.getContentPane().add(countryP);
		
		JLabel lblPhonrNumber = new JLabel("Country");
		lblPhonrNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhonrNumber.setBounds(38, 386, 100, 25);
		framePatientForm.getContentPane().add(lblPhonrNumber);
		
		 btnCreatePatient = new JButton("Create");
		btnCreatePatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				if(patient_id.getText().isEmpty() || firstNameP.getText().isEmpty() || lastNameP.getText().isEmpty() || genderP.getText().isEmpty() || ageP.getText().isEmpty() || phoneNumberP.getText().isEmpty() || doctor_id.getSelectedItem().toString().isEmpty() ||  roomP.getSelectedItem().toString().isEmpty() ) {
					JOptionPane.showMessageDialog(null, "Please fill the Information");
				}else {
					try {
						//Patient
						int pid=Integer.parseInt(patient_id.getText());
						String firstName= firstNameP.getText();
						String lastName= lastNameP.getText();
						String gender=genderP.getText();
						int age=Integer.parseInt(ageP.getText());
						String phone=phoneNumberP.getText();
						
						String villege=villegeP.getText();
						String commune=communeP.getText();
						String city = cityP.getText();
						String province= provinceP.getText();
						String country= countryP.getText();
						Address address= new Address(villege, commune, city, province, country);
			//Please Attention for this value !!!
						String type= "curing";
						//Create Patient Object
						Patient patient= new Patient(pid, firstName, lastName, gender, age, phone, address, type);
						
						String doctorID= doctor_id.getSelectedItem().toString();
						String room= roomP.getSelectedItem().toString();
						String description= descriptionA.getText();
						long time = System.currentTimeMillis();
						Timestamp date= new Timestamp(time);
						DatabasePatientRecords dRecords= new DatabasePatientRecords();
						int lastRecordID= dRecords.getLastID(pid);
						//Create Patient Record
						PatientRecord pRecord= new PatientRecord(lastRecordID, pid, doctorID, date, room, description);

						
						DatabasePatient databasePatient = new DatabasePatient();
						databasePatient.setModelPatient(modelPatient);
						
						switch (getBtnCreatePatient().getText()) {
							case "Create":			
								if(createPatientRecordOnly){
									if(pid != searchID) {
										JOptionPane.showMessageDialog(null, "Invalid Patient ID. You can not change the Patient ID's value.");
										return;
									}
									for(int id: arrayPatientID) {
										System.out.println(id);
									}
									for(int id: arrayPatientID) {
										if(id == pid) {
											JOptionPane.showMessageDialog(null, "Such Patient is curing.You can not create a record.");
											return;
										}
									}
									dRecords.createRecord(pRecord);
									dRecords.closeConnection();
									databasePatient= new DatabasePatient();
									databasePatient.changeType(pid,"curing");
									
									String[] row= new String[9];
									row[0]= patient.getId()+"";
									row[1]= patient.getFirstName();
									row[2]= patient.getLastName();
									row[3]= patient.getGender();
									row[4]= patient.getAge()+"";
									row[5]= date+"";
									row[6]= patient.getPhone();
									modelPatient.addRow(row);
									createPatientRecordOnly=false;
									JOptionPane.showMessageDialog(null, "Created a new record is succeed.");
									getFramePatientForm().dispose();
									return;
								}
								if(databasePatient.createPatient(patient,pRecord)) {
									databasePatient.closeConnection();
									//Then Create a new record of the patient
									dRecords.createRecord(pRecord);
									dRecords.closeConnection();
									
									getFramePatientForm().dispose();
									JOptionPane.showMessageDialog(null, "You have created a record ");
								}else {
									JOptionPane.showMessageDialog(null, "Invalid Patient ID. It maybe duplicate the Patinet ID");
								}
								break;
							case "Update":
								databasePatient.setIndexTable(indexTable);
								pRecord.setDate(dRecords.getLastDate(pid));
								if(databasePatient.updatePatient(patient,pRecord)) {
									modelPatient.setValueAt(patient_id.getText(), indexTable, 0);
									modelPatient.setValueAt(firstNameP.getText(), indexTable, 1);
									modelPatient.setValueAt(lastNameP.getText(), indexTable, 2);
									modelPatient.setValueAt(genderP.getText(), indexTable, 3);
									modelPatient.setValueAt(ageP.getText(), indexTable, 4);
									modelPatient.setValueAt(phoneNumberP.getText(), indexTable, 6);
									databasePatient.closeConnection();
									getFramePatientForm().dispose();
									JOptionPane.showMessageDialog(null, "You have updated a record ");
								}else {
									JOptionPane.showMessageDialog(null, "Update Failed.");
								}
								break;
							default:
								break;
						}
						
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "Age's Value must be the number type");
						System.out.println(e);
					}
				}
			}
		});
		btnCreatePatient.setForeground(Color.WHITE);
		btnCreatePatient.setBackground(Color.BLUE);
		btnCreatePatient.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCreatePatient.setBounds(361, 471, 100, 30);
		framePatientForm.getContentPane().add(btnCreatePatient);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				framePatientForm.dispose();
			}
		});
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setBackground(Color.RED);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancel.setBounds(672, 13, 100, 30);
		framePatientForm.getContentPane().add(btnCancel);
		
		JLabel lblDoctorId = new JLabel("Doctor ID");
		lblDoctorId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDoctorId.setBounds(361, 52, 100, 25);
		framePatientForm.getContentPane().add(lblDoctorId);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBackground(Color.BLACK);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(351, 47, 2, 477);
		framePatientForm.getContentPane().add(separator);
		
		 descriptionA = new JTextArea();
		descriptionA.setBounds(361, 218, 411, 220);
		framePatientForm.getContentPane().add(descriptionA);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescription.setBounds(361, 189, 100, 25);
		framePatientForm.getContentPane().add(lblDescription);
		
		JLabel lblRoomNumber = new JLabel("Room ");
		lblRoomNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRoomNumber.setBounds(361, 123, 100, 25);
		framePatientForm.getContentPane().add(lblRoomNumber);
		
		phoneNumberP = new JTextField();
		phoneNumberP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		phoneNumberP.setColumns(10);
		phoneNumberP.setBounds(38, 472, 130, 30);
		framePatientForm.getContentPane().add(phoneNumberP);
		
		JLabel label_1 = new JLabel("Phone Number");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(38, 450, 100, 25);
		framePatientForm.getContentPane().add(label_1);
		
		patient_id = new JTextField();
		patient_id.setFont(new Font("Tahoma", Font.PLAIN, 14));
		patient_id.setColumns(10);
		patient_id.setBounds(38, 77, 130, 30);
		framePatientForm.getContentPane().add(patient_id);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblId.setBounds(38, 47, 26, 25);
		framePatientForm.getContentPane().add(lblId);
		
		JCalendar jCalendar= new JCalendar();
		jCalendar.setBounds(530, 80, 250, 100);
		framePatientForm.getContentPane().add(jCalendar);
		
		 btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int patient_id=patient.getId();
				long mills= System.currentTimeMillis();
				
				DatabasePatientRecords databasePatientRecords= new DatabasePatientRecords();
				Timestamp date_in= databasePatientRecords.getLastDate(patient_id);
				Timestamp date_out= new Timestamp(mills);
				int record_id= databasePatientRecords.getLastID(patient_id);
				//Set status column value to "cured" and if success then return true else return false
				if(!databasePatientRecords.setDateOutColumnValue(record_id, date_out)) {
					JOptionPane.showMessageDialog(null, "Error !!!");
					return;
				}
				Receipt reciept= new Receipt(0, patient_id,date_in ,date_out,"10$");
				databasePatientRecords.closeConnection();
				
				//Create a record in Receipt table
				DatabaseReceipt databaseReceipt= new DatabaseReceipt();
				databaseReceipt.createRecord(reciept);
				Patient patientGet= databaseReceipt.getReceipt(patient_id);
				
				
				//Open Form Receipt
				RecieptForm formReceipt = new RecieptForm();
		 		formReceipt.getFrame().setVisible(true);
		 		
		 		formReceipt.getP_id().setText(patientGet.getId()+"");
		 		formReceipt.getP_first().setText(patientGet.getFirstName());
		 		formReceipt.getP_last().setText(patientGet.getLastName());
		 		formReceipt.getP_gender().setText(patientGet.getGender());
		 		formReceipt.getP_age().setText(patientGet.getAge()+"");
		 		formReceipt.getP_phone().setText(patientGet.getPhone());
		 		formReceipt.getR_date().setText(date_in+"");
		 		formReceipt.getLblDateout().setText(date_out+"");
		 		formReceipt.getP_prix().setText(reciept.getPrice());
		 		databaseReceipt.closeConnection();
		 		
		 		//Change type value to cured 
				DatabasePatient databasePatient= new DatabasePatient();
				databasePatient.changeType(patient_id,"cured");
				modelPatient.removeRow(indexTable);
				
		 		getFramePatientForm().dispose();
			}
		});
		btnPrint.setForeground(Color.WHITE);
		btnPrint.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPrint.setBackground(Color.GREEN);
		btnPrint.setBounds(515, 471, 100, 30);
		framePatientForm.getContentPane().add(btnPrint);
		
		JButton btnSearchID = new JButton("Search");
		btnSearchID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int p_id= Integer.parseInt(patient_id.getText());
				DatabasePatient databasePatient= new DatabasePatient();
				Patient patient= databasePatient.getPatientByID(p_id);
				
				if(patient !=null) {
					createPatientRecordOnly=true;
					searchID=patient.getId();
					firstNameP.setText(patient.getFirstName());
					lastNameP.setText(patient.getLastName());
					genderP.setText(patient.getGender());
					ageP.setText(patient.getAge()+"");
					phoneNumberP.setText(patient.getPhone());
					villegeP.setText(patient.getAddress().getVillege());
					communeP.setText(patient.getAddress().getCommune());
					cityP.setText(patient.getAddress().getCity());
					provinceP.setText(patient.getAddress().getProvince());
					countryP.setText(patient.getAddress().getCountry());
					
				}else {
					JOptionPane.showMessageDialog(null, "There is no such Patient ID. Please create a new patient record .");
				}
			}
		});
		btnSearchID.setForeground(Color.BLACK);
		btnSearchID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSearchID.setBackground(Color.WHITE);
		btnSearchID.setBounds(178, 77, 100, 30);
		framePatientForm.getContentPane().add(btnSearchID);
		
		DatabaseDoctor databaseDoctor = new DatabaseDoctor();
		 doctor_id = new JComboBox(databaseDoctor.getActiveDoctorID());
		 doctor_id.setFont(new Font("Tahoma", Font.PLAIN, 14));
		databaseDoctor.closeConnection();
		doctor_id.setBounds(361, 78, 130, 30);
		framePatientForm.getContentPane().add(doctor_id);
		
		String[] room= {"R001","R002","R003","R004","ACU"};
		 roomP = new JComboBox(room);
		roomP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		roomP.setBounds(361, 147, 130, 30);
		framePatientForm.getContentPane().add(roomP);

	}
	public JFrame getFramePatientForm() {
		return framePatientForm;
	}
	public void setFramePatientForm(JFrame frame) {
		this.framePatientForm = frame;
	}
	public JTextField getFirstName() {
		return firstNameP;
	}
	public void setFirstName(JTextField firstName) {
		this.firstNameP = firstName;
	}
	public JTextField getLastName() {
		return lastNameP;
	}
	public void setLastName(JTextField lastName) {
		this.lastNameP = lastName;
	}
	public JTextField getGender() {
		return genderP;
	}
	public void setGender(JTextField gender) {
		this.genderP = gender;
	}
	public JTextField getAge() {
		return ageP;
	}
	public void setAge(JTextField age) {
		this.ageP = age;
	}
	public JTextField getVillege() {
		return villegeP;
	}
	public void setVillege(JTextField villege) {
		this.villegeP = villege;
	}
	public JTextField getCommune() {
		return communeP;
	}
	public void setCommune(JTextField commune) {
		this.communeP = commune;
	}
	public JTextField getCity() {
		return cityP;
	}
	public void setCity(JTextField city) {
		this.cityP = city;
	}
	public JTextField getCountry() {
		return provinceP;
	}
	public void setCountry(JTextField country) {
		this.provinceP = country;
	}
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public JTextArea getDescriptionA() {
		return descriptionA;
	}

	public void setDescriptionA(JTextArea descriptionA) {
		this.descriptionA = descriptionA;
	}
	public JTextField getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(JTextField patient_id) {
		this.patient_id = patient_id;
	}
	public JTextField getVillegeP() {
		return villegeP;
	}
	public void setVillegeP(JTextField villegeP) {
		this.villegeP = villegeP;
	}
	public JTextField getProvinceP() {
		return provinceP;
	}
	public void setProvinceP(JTextField provinceP) {
		this.provinceP = provinceP;
	}
	public JTextField getPhoneNumberP() {
		return phoneNumberP;
	}
	public void setPhoneNumberP(JTextField phoneNumberP) {
		this.phoneNumberP = phoneNumberP;
	}
	public JButton getBtnCreatePatient() {
		return btnCreatePatient;
	}
	public void setBtnCreatePatient(JButton btnCreatePatient) {
		this.btnCreatePatient = btnCreatePatient;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public DefaultTableModel getModelPatient() {
		return modelPatient;
	}
	public void setModelPatient(DefaultTableModel modelPatient) {
		this.modelPatient = modelPatient;
	}
	public int getIndexTable() {
		return indexTable;
	}
	public void setIndexTable(int indexTable) {
		this.indexTable = indexTable;
	}
	public JButton getBtnPrint() {
		return btnPrint;
	}
	public void setBtnPrint(JButton btnPrint) {
		this.btnPrint = btnPrint;
	}
	public DefaultTableModel getModelReceipt() {
		return modelReceipt;
	}
	public void setModelReceipt(DefaultTableModel modelReceipt) {
		this.modelReceipt = modelReceipt;
	}
	public String getTypePatient() {
		return typePatient;
	}
	public void setTypePatient(String typePatient) {
		this.typePatient = typePatient;
	}
	public ArrayList<Integer> getArrayPatientID() {
		return arrayPatientID;
	}
	public void setArrayPatientID(ArrayList<Integer> arrayPatientID) {
		this.arrayPatientID = arrayPatientID;
	}


	public JComboBox getDoctor_id() {
		return doctor_id;
	}


	public void setDoctor_id(JComboBox doctor_id) {
		this.doctor_id = doctor_id;
	}
	public JComboBox getRoomP() {
		return roomP;
	}
	public void setRoomP(JComboBox roomP) {
		this.roomP = roomP;
	}
	
}

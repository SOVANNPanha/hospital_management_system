package homeFrame;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import classes.Doctor;
import database.DatabaseDoctor;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class FormCreateDoctor {

	private JFrame frame;
	private JTextField firstD;
	private JTextField lastD;
	private JTextField genderD;
	private JTextField ageD;
	private JTextField skillD;
	private JButton btnCreate;
	private JButton btnStopWorking;
	private  JLabel titleFormDoctor;
	
	private DefaultTableModel modelD;
	private int indexTable;
	private Doctor doctor;
	private String prev_DoctorID;
	private JTextField doctor_idTextField;
	private JLabel lblId;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {					
					FormCreateDoctor window = new FormCreateDoctor( );
					window.frame.setVisible(true);
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		});
	}

	
	/**
	 * Create the application.
	 */
	public FormCreateDoctor(Doctor doctor) {
		this.doctor= doctor;
		initialize();
	}
	public FormCreateDoctor() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(64, 224, 208));
		frame.setBounds(100, 100, 546, 441);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		 titleFormDoctor = new JLabel("Create Doctor");
		 titleFormDoctor.setHorizontalAlignment(SwingConstants.CENTER);
		titleFormDoctor.setFont(new Font("Tahoma", Font.BOLD, 18));
		titleFormDoctor.setBounds(158, 11, 242, 30);
		frame.getContentPane().add(titleFormDoctor);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(105, 125, 100, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		firstD = new JTextField();
		firstD.setBounds(105, 152, 150, 30);
		frame.getContentPane().add(firstD);
		firstD.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLastName.setBounds(286, 123, 100, 25);
		frame.getContentPane().add(lblLastName);
		
		lastD = new JTextField();
		lastD.setColumns(10);
		lastD.setBounds(286, 150, 150, 30);
		frame.getContentPane().add(lastD);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGender.setBounds(105, 193, 100, 25);
		frame.getContentPane().add(lblGender);
		
		genderD = new JTextField();
		genderD.setColumns(10);
		genderD.setBounds(105, 220, 79, 30);
		frame.getContentPane().add(genderD);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAge.setBounds(286, 193, 100, 25);
		frame.getContentPane().add(lblAge);
		
		ageD = new JTextField();
		ageD.setColumns(10);
		ageD.setBounds(286, 220, 79, 30);
		frame.getContentPane().add(ageD);
		
		JLabel lblSkill = new JLabel("Skill");
		lblSkill.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSkill.setBounds(105, 258, 100, 25);
		frame.getContentPane().add(lblSkill);
		
		skillD = new JTextField();
		skillD.setColumns(10);
		skillD.setBounds(105, 285, 150, 30);
		frame.getContentPane().add(skillD);
		
		 btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				if(firstD.getText().isEmpty() || lastD.getText().isEmpty() || genderD.getText().isEmpty() || ageD.getText().isEmpty() || skillD.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "All Fields need to be filled");
				}else {
					try {
						switch (btnCreate.getText()) {
						case "Create":
							String id= doctor_idTextField.getText();
							String firstName=firstD.getText();
							String lastName= lastD.getText();
							String gender= genderD.getText();
							int age= Integer.parseInt(ageD.getText());
							String skill= skillD.getText();
							Doctor doctorCreate= new Doctor(id, firstName, lastName, gender, age, skill);
							DatabaseDoctor databaseToCreate= new DatabaseDoctor();
							databaseToCreate.setModelDoctor(modelD);
							
							if(databaseToCreate.createDoctor(doctorCreate)) {
									databaseToCreate.closeConnection();
									getFrame().dispose();
									JOptionPane.showMessageDialog(null, "You have created Doctor record");
							}else {
								JOptionPane.showMessageDialog(null, "Create is Failed, it maybe the Doctor ID");
								databaseToCreate.closeConnection();
								return;
							}
							break;
						case "Update":
				
							doctor.setId(doctor_idTextField.getText());
							doctor.setFirstName(firstD.getText());
							doctor.setLastName(lastD.getText());
							doctor.setGender(genderD.getText());
							doctor.setAge(Integer.parseInt(ageD.getText()));
							doctor.setSkill(skillD.getText());
							
							DatabaseDoctor databaseToUpdate= new DatabaseDoctor();
							databaseToUpdate.setModelDoctor(modelD);
							databaseToUpdate.setIndexTable(indexTable);
							if(databaseToUpdate.updateDoctor(doctor,getPrev_DoctorID())) {
								modelD.setValueAt(doctor_idTextField.getText(), indexTable, 0);
								modelD.setValueAt(firstD.getText(), indexTable, 1);
								modelD.setValueAt(lastD.getText(), indexTable, 2);
								modelD.setValueAt(genderD.getText(), indexTable, 3);
								modelD.setValueAt(ageD.getText(), indexTable, 4);
								modelD.setValueAt(skillD.getText(), indexTable, 5);
								databaseToUpdate.closeConnection();
								getFrame().dispose();
								JOptionPane.showMessageDialog(null, "You have updated a Doctor record");
							}else {
								JOptionPane.showMessageDialog(null, "Update Failed.");
							}
							
							break;
						default:
							break;
						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "The Value of Age must be the number");
						return;
					}
				}
			}
		});
		btnCreate.setForeground(Color.WHITE);
		btnCreate.setBackground(Color.BLUE);
		btnCreate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCreate.setBounds(105, 338, 125, 30);
		frame.getContentPane().add(btnCreate);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setBackground(Color.RED);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancel.setBounds(395, 12, 125, 30);
		frame.getContentPane().add(btnCancel);
		
		doctor_idTextField = new JTextField();
		doctor_idTextField.setColumns(10);
		doctor_idTextField.setBounds(105, 84, 150, 30);
		frame.getContentPane().add(doctor_idTextField);
		
		lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblId.setBounds(105, 57, 100, 25);
		frame.getContentPane().add(lblId);
		
		 btnStopWorking = new JButton("Stop working");
		btnStopWorking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DatabaseDoctor databaseDoctor = new DatabaseDoctor();
				databaseDoctor.changeStatusValue(doctor_idTextField.getText());
				modelD.setValueAt("Stop Working", indexTable, 6);
				getFrame().setVisible(false);
				
			}
		});
		btnStopWorking.setForeground(Color.WHITE);
		btnStopWorking.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnStopWorking.setBackground(Color.RED);
		btnStopWorking.setBounds(286, 338, 125, 30);
		frame.getContentPane().add(btnStopWorking);
	}
	
	public JFrame getFrame() {
		return frame;
	}
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	public DefaultTableModel getModelD() {
		return modelD;
	}
	public void setModelD(DefaultTableModel modelD) {
		this.modelD = modelD;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public JTextField getFirstD() {
		return firstD;
	}
	public void setFirstD(JTextField firstD) {
		this.firstD = firstD;
	}
	public JTextField getLastD() {
		return lastD;
	}
	public void setLastD(JTextField lastD) {
		this.lastD = lastD;
	}
	public JTextField getGenderD() {
		return genderD;
	}
	public void setGenderD(JTextField genderD) {
		this.genderD = genderD;
	}
	public JTextField getAgeD() {
		return ageD;
	}
	public void setAgeD(JTextField ageD) {
		this.ageD = ageD;
	}
	public JTextField getSkillD() {
		return skillD;
	}
	public void setSkillD(JTextField skillD) {
		this.skillD = skillD;
	}
	public JButton getBtnCreate() {
		return btnCreate;
	}
	public void setBtnCreate(JButton btnCreate) {
		this.btnCreate = btnCreate;
	}
	public JLabel getTitleFormDoctor() {
		return titleFormDoctor;
	}
	public void setTitleFormDoctor(JLabel titleFormDoctor) {
		this.titleFormDoctor = titleFormDoctor;
	}

	public JTextField getDoctor_id() {
		return doctor_idTextField;
	}
	public void setDoctor_id(JTextField doctor_id) {
		this.doctor_idTextField = doctor_id;
	}
	public int getIndexTable() {
		return indexTable;
	}
	public void setIndexTable(int indexTable) {
		this.indexTable = indexTable;
	}
	public String getPrev_DoctorID() {
		return prev_DoctorID;
	}
	public void setPrev_DoctorID(String prev_DoctorID) {
		this.prev_DoctorID = prev_DoctorID;
	}


	public JButton getBtnStopWorking() {
		return btnStopWorking;
	}


	public void setBtnStopWorking(JButton btnStopWorking) {
		this.btnStopWorking = btnStopWorking;
	}
	public JLabel getLblId() {
		return lblId;
	}
	public void setLblId(JLabel lblId) {
		this.lblId = lblId;
	}
	
}

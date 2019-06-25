package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import classes.Address;
import classes.Patient;
import classes.PatientRecord;

public class DatabasePatient extends Database{
	private DefaultTableModel modelPatient;
	private DefaultTableModel modelHostory;
	private int indexTable;
	private static ArrayList<Integer> patientID = new ArrayList<Integer>();
//	private boolean existPatient;
	
	public DatabasePatient() {
		super();
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		DatabasePatient data= new DatabasePatient();
		try {
			data.getAllPatients();
			System.out.println(data.getRecommentPatientID());
			for(int id: patientID) {
				System.out.println(id);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	
		data.closeConnection();
	}
	
	//get Last Id row in table patients
	public int getRecommentPatientID() {
		int nextPatientID=1000;
		
		try {
			String query= "SELECT * FROM  patients ";
			Statement stm= super.getConnection().createStatement();
			ResultSet results= stm.executeQuery(query);
			while(results.next()) {
				results.last();
				nextPatientID= results.getInt(1);
			}
		
		} catch (Exception e) {
			System.out.println(e);
		}
		nextPatientID++;
		return nextPatientID;
	}
	//Get all patients both Type
	public void displayAllPatients() {
		try {
			String query= "SELECT * FROM  patients";
			Statement stm= super.getConnection().createStatement();
			ResultSet results= stm.executeQuery(query);
			while(results.next()) {
				String[] row= new String[7];
				row[0]= results.getInt(1)+"";
				row[1]= results.getString(2);
				row[2]= results.getString(3);
				row[3]= results.getString(4);
				row[4]= results.getString(5);
				row[5]= results.getInt(6)+"";
				modelHostory.addRow(row);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	//Get all patients
	public void getAllPatients() {
		try {
			String[] row= new String[16];
			String query= "SELECT * FROM  patients WHERE type LIKE ? ";
			PreparedStatement preparedStatement= super.getConnection().prepareStatement(query);
			preparedStatement.setString(1, "curing");
			ResultSet results= preparedStatement.executeQuery();
			while(results.next()) {
				//Patient table
				int id= results.getInt(1);
				String fname= results.getString(2);
				String lname= results.getString(3);
				String gender= results.getString(4);
				int age= results.getInt(5);
				String phone= results.getString(6);
				String villege= results.getString(7);
				String commune= results.getString(8);
				String city= results.getString(9);
				String province= results.getString(10);
				String country= results.getString(11);
				Address address= new Address(villege, commune, city, province, country);
				String type= results.getString(12);
				
				Patient patient= new  Patient(id, fname, lname, gender, age, phone, address, type);
				
				patientID.add(id);
				DatabasePatientRecords dRecords= new DatabasePatientRecords();
				row[0]= patient.getId()+"";
				row[1]= patient.getFirstName();
				row[2]= patient.getLastName();
				row[3]= patient.getGender();
				row[4]= patient.getAge()+"";
				row[5]= dRecords.getLastDate(id)+"";
				row[6]=  patient.getPhone();
				modelPatient.addRow(row);
			}	

		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	
	//get a patients by ID
	public Patient getPatientByID(int pid) {
		Patient patient=null;
		try {
			String query= "SELECT * FROM  patients  WHERE id = ? ";
			PreparedStatement pStatement= super.getConnection().prepareStatement(query);
			pStatement.setInt(1, pid);
			ResultSet results= pStatement.executeQuery();
			while(results.next()) {
				//Patient table
				int idPatient= results.getInt(1);
				String fname= results.getString(2);
				String lname= results.getString(3);
				String gender= results.getString(4);
				int age= results.getInt(5);
				String phone= results.getString(6);
				String villege= results.getString(7);
				String commune= results.getString(8);
				String city= results.getString(9);
				String province= results.getString(10);
				String country= results.getString(11);
				Address address= new Address(villege, commune, city, province, country);
				String type= results.getString(12);
				
				patient= new Patient(idPatient, fname, lname, gender, age, phone, address, type);
				System.out.println("Get Patients succeed From DatabasePatient");
			}
		} catch (Exception e) {
			System.out.println(e);
		}	
		return patient;
	}
		
	//Create a patient and also create its record into patient_record 
	public boolean createPatient(Patient patient,PatientRecord patientRecord)  {
		boolean isCreated= false;
		String[] row= new String[9];
		try {
			String query = "INSERT INTO patients VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pStatement= super.getConnection().prepareStatement(query);
			pStatement.setInt(1, patient.getId());
			pStatement.setString(2, patient.getFirstName());
			pStatement.setString(3, patient.getLastName());
			pStatement.setString(4, patient.getGender());
			pStatement.setInt(5, patient.getAge());
			pStatement.setString(6, patient.getPhone());
			pStatement.setString(7, patient.getAddress().getVillege());
			pStatement.setString(8, patient.getAddress().getCommune());
			pStatement.setString(9, patient.getAddress().getCity());
			pStatement.setString(10, patient.getAddress().getProvince());
			pStatement.setString(11, patient.getAddress().getCountry());
			pStatement.setString(12, patient.getType());
			
			if(pStatement.executeUpdate() > 0) {
				patientID.add(patient.getId());
				row[0]= patient.getId()+"";
				row[1]= patient.getFirstName();
				row[2]= patient.getLastName();
				row[3]= patient.getGender();
				row[4]= patient.getAge()+"";
				row[5]= patientRecord.getDate()+"";
				row[6]= patient.getPhone();
				modelPatient.addRow(row);
				isCreated= true;
				System.out.println("You have insert a patient record");
				
			};
		}catch (Exception e) {
			System.out.println(e);
		}
		return isCreated;
	}
	
	//Update patient
	public boolean updatePatient(Patient patient,PatientRecord patientRecord) {
		boolean isUpdated= false;
		try {
			String query= "UPDATE patients SET first_name=?,last_name=?,gender=?,age=?,phone=?,villege=?,commune=?,city=?,province=?,country=? WHERE id = ?";
			PreparedStatement pStatement= super.getConnection().prepareStatement(query);
			
			pStatement.setString(1, patient.getFirstName());
			pStatement.setString(2, patient.getLastName());
			pStatement.setString(3, patient.getGender());
			pStatement.setInt(4, patient.getAge());
			pStatement.setString(5, patient.getPhone());
			pStatement.setString(6, patient.getAddress().getVillege());
			pStatement.setString(7, patient.getAddress().getCommune());
			pStatement.setString(8, patient.getAddress().getCity());
			pStatement.setString(9, patient.getAddress().getProvince());
			pStatement.setString(10, patient.getAddress().getCountry());
			pStatement.setInt(11, patient.getId());
			
			if(pStatement.executeUpdate() > 0) {
				DatabasePatientRecords dRecords= new DatabasePatientRecords();				
				dRecords.updatePatientRecord(patientRecord);
				isUpdated= true;
				System.out.println("Update Patient succeed");
			};
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return isUpdated;
	}
	//update Patient type to cured value
	public void changeType(int patient_id,String type) {
		try {
			
			String query= "UPDATE patients SET type=? WHERE id = ?";
			PreparedStatement pStatement= super.getConnection().prepareStatement(query);
			pStatement.setString(1, type);
			pStatement.setInt(2, patient_id);
			pStatement.executeUpdate();
			patientID.remove(patientID.indexOf(patient_id));
			System.out.println("You have change type value to cured");
		} catch (Exception e) {
			System.out.println(e);
		}
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
	public ArrayList<Integer> getPatientID() {
		return patientID;
	}
	public void setPatientID(ArrayList<Integer> patientID) {
		this.patientID = patientID;
	}
	public DefaultTableModel getModelHostory() {
		return modelHostory;
	}
	public void setModelHostory(DefaultTableModel modelHostory) {
		this.modelHostory = modelHostory;
	}
	
}

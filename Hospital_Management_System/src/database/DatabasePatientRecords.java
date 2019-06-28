package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import javax.swing.table.DefaultTableModel;

import classes.PatientRecord;

public class DatabasePatientRecords extends Database {
	private DefaultTableModel modelPatientRecords;
	private int indexTable;
	public DatabasePatientRecords() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		DatabasePatientRecords dRecords= new DatabasePatientRecords();
		
		dRecords.closeConnection();
	}
	
	//Create a record into Table PatientsRecords
	public void createRecord(PatientRecord patientRecord) {
		try {
			String query= "INSERT INTO patient_records VALUES(null,?,?,?,?,?,null)";
			PreparedStatement pStatement= super.getConnection().prepareStatement(query);
			pStatement.setInt(1, patientRecord.getPatient_id());
			pStatement.setString(2, patientRecord.getDoctor_id());
			pStatement.setTimestamp(3, patientRecord.getDate());
			pStatement.setString(4, patientRecord.getRoom());
			pStatement.setString(5, patientRecord.getDescription());
			pStatement.executeUpdate();
			System.out.println("You have create a patient record.");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	//get Update date out value When the patient get out the hospital
	public boolean setDateOutColumnValue(int record_id,Timestamp date_out) {
		boolean isSuccuess= false;
		try {
			String query = "UPDATE patient_records set date_out= ? WHERE id = ?";
			PreparedStatement preparedStatement= super.getConnection().prepareStatement(query);
			preparedStatement.setTimestamp(1, date_out);
			preparedStatement.setInt(2, record_id);
			if(preparedStatement.executeUpdate() > 0) {
				isSuccuess= true;
			};
		} catch (Exception e) {
			System.out.println(e);
		}
		return isSuccuess;
	}
	//Get all patient records
	public void getAllRecordsOfPatientID(int patient_id) {
		try {
			String[] row= new String[7];
			String query= "SELECT * FROM patient_records WHERE patient_id = ? ";
			PreparedStatement pStatement= super.getConnection().prepareStatement(query);
			pStatement.setInt(1, patient_id);
			ResultSet results= pStatement.executeQuery();
			int i=0;
			while(results.next()) {
				i++;
				row[0]=i+"";
				row[1]=results.getInt(1)+"";
				row[2]=results.getString(3);
				row[3]=results.getString(5);
				row[4]=results.getTimestamp(4)+"";
				row[5]=results.getTimestamp(7)+"";
				row[6]=results.getString(6);
				
				modelPatientRecords.addRow(row);
			}
			System.out.println("You have get all records of a patient");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//Get a patient's record
	public PatientRecord getAPatientRecordByID(int record_id) {
		PatientRecord patientRecord=null;
		try {
			String query= "SELECT * FROM patient_records WHERE id = ?";
			PreparedStatement pStatement= super.getConnection().prepareStatement(query);
			pStatement.setInt(1, record_id);
			ResultSet results= pStatement.executeQuery();
			while(results.next()) {
				int idR=results.getInt(1);
				int patient_id=results.getInt(2);
				String doctor_id=results.getString(3);
				Timestamp date=results.getTimestamp(4);
				String room=results.getString(5);
				String description=results.getString(6);
				Timestamp date_out=results.getTimestamp(7);
				
				patientRecord= new PatientRecord(idR,patient_id, doctor_id, date,date_out, room, description);
				
			}
			System.out.println("You have get a record of a patient");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return patientRecord;
	}
	
	//Update a patient's record by ID
		// Remove that record from table in frame and add again
	public void updatePatientRecord(PatientRecord patientRecord) {
		try {
			String query= "UPDATE patient_records SET doctor_id=?, room=?, description= ? WHERE id =?";
			PreparedStatement pStatement= super.getConnection().prepareStatement(query);
			pStatement.setString(1, patientRecord.getDoctor_id());
			pStatement.setString(2, patientRecord.getRoom());
			pStatement.setString(3, patientRecord.getDescription());
			pStatement.setInt(4, patientRecord.getId());
			pStatement.executeUpdate();
			
			modelPatientRecords.removeRow(indexTable);
			
			String[] row= new String[6];
			row[0]=patientRecord.getId()+"";
			row[1]=patientRecord.getPatient_id()+"";
			row[2]=patientRecord.getDoctor_id();
			row[3]=patientRecord.getDate()+"";
			row[4]=patientRecord.getRoom();
			row[5]=patientRecord.getDescription();
			modelPatientRecords.addRow(row);
			System.out.println("You have updated a record of a patient");
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	public Timestamp getLastDate(int patient_id) {
		Timestamp date=null;
		try {
			String query= "SELECT date FROM patient_records WHERE patient_id = ?";
			PreparedStatement pStatement= super.getConnection().prepareStatement(query);
			pStatement.setInt(1, patient_id);
			ResultSet results= pStatement.executeQuery();
			while(results.next()) {
				results.last();
				date= results.getTimestamp(1);
			}
		} catch (Exception e) {
			System.out.println();
		}
		
		return date;
	}
	
	public int getLastID(int patient_id) {
		int record_id=0;
		try {
			String query= "SELECT id FROM patient_records WHERE patient_id LIKE ?";
			PreparedStatement pStatement= super.getConnection().prepareStatement(query);
			pStatement.setInt(1, patient_id);
			ResultSet results= pStatement.executeQuery();
			while(results.next()) {
				results.last();
				record_id= results.getInt(1);
			}
		} catch (Exception e) {
			System.out.println();
		}
		
		return record_id;
	}
	
	public DefaultTableModel getModelPatientRecords() {
		return modelPatientRecords;
	}
	public void setModelPatientRecords(DefaultTableModel modelPatientRecords) {
		this.modelPatientRecords = modelPatientRecords;
	}
	public int getIndexTable() {
		return indexTable;
	}
	public void setIndexTable(int indexTable) {
		this.indexTable = indexTable;
	}
	
}

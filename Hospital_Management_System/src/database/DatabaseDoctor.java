package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

import classes.Doctor;

public class DatabaseDoctor extends Database {
	private DefaultTableModel modelDoctor;
	private int indexTable;
	public DatabaseDoctor() {
		super();
	}

	public static void main(String[] args) {
		try {
			DatabaseDoctor database= new DatabaseDoctor();
			System.out.println(database.numberOfAvtiveDoctor());
			for(String id : database.getActiveDoctorID()) {
				System.out.println(id);
			}
			database.closeConnection();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//Get Recommend Doctor ID
	public String getRecommentDoctorID() {
		String doctor_id="D00";
		String temp="";
		int numberINC=0;
		try {
			String query="SELECT * FROM doctors";
			Statement statement= super.getConnection().createStatement();
			ResultSet results= statement.executeQuery(query);
			while(results.next()) {
				results.last();
				temp= results.getString(1);
			}
			numberINC= Integer.parseInt(temp.split("D")[1])+1;
			doctor_id= doctor_id + numberINC;
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return doctor_id;
	}
	//Create a doctor record
	public boolean createDoctor(Doctor doctor) {
		boolean isCreated= false;
		try {
			String query="INSERT INTO doctors VALUES(?,?,?,?,?,?,?)";
			PreparedStatement pStatement= super.getConnection().prepareStatement(query);
			pStatement.setString(1, doctor.getId());
			pStatement.setString(2,doctor.getFirstName());
			pStatement.setString(3,doctor.getLastName());
			pStatement.setString(4,doctor.getGender());
			pStatement.setInt(5,doctor.getAge());
			pStatement.setString(6,doctor.getSkill());
			pStatement.setString(7,"active");
			if(pStatement.executeUpdate() > 0) {
				isCreated = true;
				String[] row= new String[6];
				row[0]= doctor.getId();
				row[1]= doctor.getFirstName();
				row[2]= doctor.getLastName();
				row[3]= doctor.getGender();
				row[4]= doctor.getAge()+"";
				row[5]= doctor.getSkill();
				modelDoctor.addRow(row);
			}

			System.out.println("You have created a doctor record");
		} catch (Exception e) {
			System.out.println(e);
		}
		return isCreated;
	}
	
	//Get all Doctor
	public void getAllDoctor() {
		
		try {
			String[] row= new String[7];
			String query="SELECT * FROM doctors ORDER BY status ";
			PreparedStatement preparedStatement= super.getConnection().prepareStatement(query);
			ResultSet results= preparedStatement.executeQuery();
			while(results.next()) {
				row[0]= results.getString(1);
				row[1]= results.getString(2);
				row[2]= results.getString(3);
				row[3]= results.getString(4);
				row[4]= results.getInt(5)+"";
				row[5]= results.getString(6);
				row[6]= results.getString(7);
				
				modelDoctor.addRow(row);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//Get a  doctor record by ID
	public Doctor getDoctorById(String id) {
		Doctor doctor = null;
		try {
			String query="SELECT * FROM doctors WHERE id LIKE ?";
			PreparedStatement pStatement= super.getConnection().prepareStatement(query);
			pStatement.setString(1, id);
			ResultSet result= pStatement.executeQuery();
			while(result.next()) {	
				String idd= result.getString(1);
				String first= result.getString(2);
				String last= result.getString(3);
				String gendetD= result.getString(4);
				int age= result.getInt(5);
				String skill= result.getString(6);
				doctor = new Doctor(idd, first, last, gendetD, age, skill);
			}
			System.out.println("You have got a doctor record");
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return doctor;
	}
	
	//Update a doctor record
	public boolean updateDoctor(Doctor doctor,String prev_DoctorID) {
		boolean isUpdated= false;
		try {
			String query= "UPDATE  doctors SET id=?, first_name=? , last_name=?, gender=?, age=?, skill=?  WHERE id LIKE ?";
			PreparedStatement pStatement= super.getConnection().prepareStatement(query);
			pStatement.setString(1, doctor.getId());
			pStatement.setString(2, doctor.getFirstName());
			pStatement.setString(3, doctor.getLastName());
			pStatement.setString(4, doctor.getGender());
			pStatement.setInt(5, doctor.getAge());
			pStatement.setString(6, doctor.getSkill());
			pStatement.setString(7, prev_DoctorID);
			if(pStatement.executeUpdate() > 0) {
				
				isUpdated = true;
				System.out.println("You have update a doctor record");
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return isUpdated;
	}
	//Change Status column value
	public void changeStatusValue(String doctor_id) {
		try {
			String query= "UPDATE doctors set status= ? WHERE id LIKE ?"; 
			PreparedStatement preparedStatement= super.getConnection().prepareStatement(query);
			preparedStatement.setString(1, "Stop working");
			preparedStatement.setString(2, doctor_id);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	// get all active doctor's ID
	public String[] getActiveDoctorID() {
		String[] doctorIDs= new String[this.numberOfAvtiveDoctor()];
		try {
			String query= "SELECT id FROM doctors WHERE status LIKE 'active' ";
			Statement statement= super.getConnection().createStatement();
			ResultSet results= statement.executeQuery(query);
			int i=0;
			while(results.next()) {
				doctorIDs[i]= results.getString(1);
				i++;
				
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return doctorIDs;
	}
	//Get the number of active doctor
	public int numberOfAvtiveDoctor() {
		int number=0;
		try {
			String query= "SELECT * FROM doctors WHERE status LIKE 'active' ";
			Statement statement= super.getConnection().createStatement();
			ResultSet results= statement.executeQuery(query);
			while(results.next()) {
				results.last();
				number= results.getRow();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return number;
	}
	public DefaultTableModel getModelDoctor() {
		return modelDoctor;
	}
	public void setModelDoctor(DefaultTableModel modelDoctor) {
		this.modelDoctor = modelDoctor;
	}
	public int getIndexTable() {
		return indexTable;
	}
	public void setIndexTable(int indexTable) {
		this.indexTable = indexTable;
	}
	
	
}

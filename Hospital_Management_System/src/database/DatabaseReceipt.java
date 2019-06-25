package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;

import javax.swing.table.DefaultTableModel;

import classes.Patient;
import classes.Receipt;

public class DatabaseReceipt extends Database{
	private String price;
	private Timestamp date_in;
	private Timestamp date_out;
	public DatabaseReceipt() {
		super();
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		
	}
	
	//Create A receipt record
	public void createRecord(Receipt reciept) {
		try {
			String query= "INSERT INTO receipts VALUES(NULL,?,?,?,?)";
			PreparedStatement pStatement= super.getConnection().prepareStatement(query);
			pStatement.setInt(1, reciept.getPatient_id());
			pStatement.setTimestamp(2, reciept.getDate_in());
			pStatement.setTimestamp(3, reciept.getDate_out());
			pStatement.setString(4, reciept.getPrice());
			pStatement.executeUpdate();
			
			System.out.println("You have insert a receipt record.");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	//Get all receipts
	public void getAllReceipts(DefaultTableModel modelReceipt) {
		try {
			String[] row= new String[7];
			String query= "SELECT r.*,p.first_name,p.last_name FROM patients AS p JOIN receipts AS r ON p.id = r.patient_id ORDER BY r.id desc";
			Statement statement= super.getConnection().createStatement();
			ResultSet results= statement.executeQuery(query);
			while(results.next()) {
				int id= results.getInt(1);
				int patient_id=results.getInt(2);
				Timestamp date_in= results.getTimestamp(3);
				Timestamp date_out= results.getTimestamp(4);
				String price= results.getString(5);
				String firstName= results.getString(6);
				String lastName= results.getString(7);
				
				
				row[0]= id+"";
				row[1]=patient_id+"";
				row[2]=firstName+"  "+lastName;
				row[3]=date_in +"";
				row[4]=date_out+"";
				row[5]=price;
				modelReceipt.addRow(row);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public int getRecordID(int patient_id) {
		int rid=1;
		try {
			String query= "SELECT id FROM receipts WHERE patient_id LIKE ? ";
			PreparedStatement pStatement= super.getConnection().prepareStatement(query);
			pStatement.setInt(1, patient_id);
			ResultSet result= pStatement.executeQuery();
			while(result.next()) {
				rid= result.getInt(1);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return rid;
	}
	//Get A record from receipt and patient table
	@SuppressWarnings("null")
	public Patient getReceipt(int patient_id) {
		Patient patient=null;
		try {
			String query= "SELECT * FROM patients WHERE id = ?";
			PreparedStatement pStatement= super.getConnection().prepareStatement(query);
			pStatement.setInt(1, patient_id);
			ResultSet  results= pStatement.executeQuery();
			while(results.next()) {
				int idPatient=results.getInt(1);
				String firstName=results.getString(2);
				String lastName=results.getString(3);
				String gender= results.getString(4);
				int age=results.getInt(5);
				String phone= results.getString(6);
	
				patient= new Patient(idPatient, firstName, lastName, gender, age, phone, null, null);
					
			}
			System.out.println("You have got a  receipt record");
		} catch (Exception e) {
			System.out.println(e);
		}
		return patient;
	}

	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Timestamp getDate_in() {
		return date_in;
	}
	public void setDate_in(Timestamp date_in) {
		this.date_in = date_in;
	}
	public Timestamp getDate_out() {
		return date_out;
	}
	public void setDate_out(Timestamp date_out) {
		this.date_out = date_out;
	}
	
	
}

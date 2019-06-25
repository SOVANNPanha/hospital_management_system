package classes;

import java.sql.Timestamp;

public class Receipt {

	private int id;
	private int patient_id;
	private java.sql.Timestamp date_in;
	private java.sql.Timestamp date_out; 
	private String price;
	//Constructor
	public Receipt() {
		super();
	}

	public Receipt(int id, int patient_id, Timestamp date_in, Timestamp date_out, String price) {
		super();
		this.id = id;
		this.patient_id = patient_id;
		this.date_in = date_in;
		this.date_out = date_out;
		this.price = price;
	}



	//Getter and setter
	public int getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}
	public java.sql.Timestamp getDate_in() {
		return date_in;
	}

	public void setDate_in(java.sql.Timestamp date_in) {
		this.date_in = date_in;
	}

	public java.sql.Timestamp getDate_out() {
		return date_out;
	}

	public void setDate_out(java.sql.Timestamp date_out) {
		this.date_out = date_out;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}
	
	
}

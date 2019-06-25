package classes;

import java.sql.Timestamp;

public class PatientRecord {
	private int id;
	private int patient_id;
	private String doctor_id;
	private Timestamp date;
	private Timestamp date_out;
	private String room;
	private String description;
	
	
	public PatientRecord() {
		super();
	}

	public PatientRecord(int patient_id, String doctor_id, Timestamp date, String room, String description) {
		super();
		this.patient_id = patient_id;
		this.doctor_id = doctor_id;
		this.date = date;
		this.room = room;
		this.description = description;
	}

	public PatientRecord(int id, int patient_id, String doctor_id, Timestamp date, String room, String description) {
		super();
		this.id = id;
		this.patient_id = patient_id;
		this.doctor_id = doctor_id;
		this.date = date;
		this.room = room;
		this.description = description;
	}
	
	
	public PatientRecord(int id, int patient_id, String doctor_id, Timestamp date, Timestamp date_out, String room,
			String description) {
		super();
		this.id = id;
		this.patient_id = patient_id;
		this.doctor_id = doctor_id;
		this.date = date;
		this.date_out = date_out;
		this.room = room;
		this.description = description;
	}

	@Override
	public String toString() {
		return "PatientRecord [patient_id=" + patient_id + ", doctor_id=" + doctor_id + ", date=" + date + ", room="
				+ room + ", description=" + description + "]";
	}

	public int getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}
	public String getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(String doctor_id) {
		this.doctor_id = doctor_id;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getDate_out() {
		return date_out;
	}

	public void setDate_out(Timestamp date_out) {
		this.date_out = date_out;
	}
	
	
}

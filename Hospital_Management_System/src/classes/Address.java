package classes;

public class Address {

	private String villege;
	private String commune;
	private String city;
	private String province;
	private String country;
	
//Constructors
	
	public Address() {
		super();
	}

	public Address(String villege, String commune, String city, String province, String country) {
		super();
		this.villege = villege;
		this.commune = commune;
		this.city = city;
		this.province = province;
		this.country = country;
	}

//Getter and setter methods
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public String getVillege() {
		return villege;
	}

	public void setVillege(String village) {
		this.villege = village;
	}

	public String getCommune() {
		return commune;
	}

	public void setCommune(String commune) {
		this.commune = commune;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
	
	
	
}

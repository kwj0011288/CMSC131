package sysutilities;

public class Address {

	private String street;
	private String city;
	private String state;
	private String zipCode;

	private final String FINAL_STREET = "8223 Paint Branch Dr.";
	private final String FINAL_CITY = "College Park";
	private final String FINAL_STATE = "MD";
	private final String FINAL_ZIPCODE = "20742";

	public Address () { // default constructor

		street = FINAL_STREET;
		city = FINAL_CITY;
		state = FINAL_STATE;
		zipCode = FINAL_ZIPCODE;

	}
	//constructors with four parameters
	public Address (String street, String city, String state, String zipCode) {
		if (street == null || city == null || state == null 
				|| zipCode == null) {
			//exception thrown if argument is invalid
			throw new IllegalArgumentException("Invalid Address Argument");

		}
		//trim the blank space
		this.street = street.trim();
		this.city = city.trim();
		this.state = state.trim();
		this.zipCode = zipCode.trim();	
	}
	//copy constructor
	public Address (Address address) {

		this.street = address.street;
		this.city = address.city;
		this.state = address.state;
		this.zipCode = address.zipCode;


	}
	// constructor with one parameter
	public Address (String street) {


		this.street = street.trim();
		this.city = FINAL_CITY;
		this.state = FINAL_STATE;
		this.zipCode = FINAL_ZIPCODE;

	}

	public String getStreet() {
		return street;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public String getZipCode() {
		return zipCode;
	}
	// check if the addresses are equals or not
	public boolean equal(Object obj) {

		if (obj == this) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Address address = (Address) obj;
		return this.getStreet().equals(address.getStreet()) &&
				this.getCity().equals(address.getCity()) &&
				this.getState().equals(address.getState()) &&
				this.getZipCode() == address.getZipCode();
	}
	// street + ctiy + state + zipcode with spaces
	public String toString() {
		return street + " " + city + " " + state + " " + zipCode;
	}
}


package sysutilities;

public class Name {

	private String firstname;
	private String lastname;
	private String middlename;
	private String nickname;
	private char separator;
	private static int NumberOfNameObjects; 
	// static = variable 을 쉐어함
	// non static = has each variable so that they do not share

	public Name() { //default constructor

		firstname = "NOFIRSTNAME";
		lastname = "NOLASTNAME";
		middlename =  "NOMIDDLENAME";
		separator = '#';
		NumberOfNameObjects++;

	}
	public Name(String firstname, String lastname) { //constructor with two parameters

		this.firstname = firstname;
		this.lastname = lastname;
		this.middlename = "";
		this.separator = ',';
		NumberOfNameObjects++;
	}

	public Name(String firstname, String middlename, String lastname) { //constructor with three parameters

		this.firstname = firstname;
		this.lastname = lastname;
		this.middlename = middlename;
		this.separator = ',';
		NumberOfNameObjects++;
	}
	//constructor with four parameters
	public Name(String firstname, String middlename, String lastname, char separator) {


		this.firstname = firstname;
		this.lastname = lastname;
		this.middlename = middlename;

		// call validSeparator method to check if separator is valid or not
		if (!validSeparator(separator)) {

			this.separator = ',';

		} else {

			this.separator = separator;


		}

		NumberOfNameObjects++;

	}

	//Getter and Setter method
	public String getFirstname() {

		return firstname;

	}
	public void setFirstname(String firstname) {

		this.firstname = firstname;

	}
	public String getMiddlename() {

		return middlename;

	}
	public void setMiddlename(String middlename) {

		this.middlename = middlename;

	}
	public String getLastname() {

		return lastname;

	}
	public void setLastname(String lastname) {

		this.lastname = lastname;

	}
	public String getNickname() {

		if (this.nickname == "") {

			return null;

		} else {

			return this.nickname;

		}


	}
	public void setNickname(String nickname) {

		this.nickname = nickname;

	}
	public char getSeparator() {

		return separator;

	}
	// set separator if it is valid
	public void setSeparator(char separator) {


		if (validSeparator(separator)) {

			this.separator = separator;
		}

	}

	// if name is equal return true
	public boolean equals (Object obj) {

		if (obj == this) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Name name = (Name) obj;
		return this.getFirstname().equals(name.getFirstname()) &&
				this.getMiddlename().equals(name.getMiddlename()) &&
				this.getLastname().equals(name.getLastname());
	}
	public String toString() {
		// set default string
		String str;
		if (getMiddlename().equals("")) {

			str = lastname + separator + firstname;

		} else

			str = lastname + separator + firstname + separator + middlename;


		//if nickname is valid, add it at the end of the string str
		if (getNickname() != null) {

			return str += "(" + getNickname() + ")";

		}

		return str;
	}

	public int compareTo (Name Name) {
		//initialize the compare so that it could return the positive, 0, or negative number
		int compare = 0;

		if (this.lastname.compareTo(Name.getLastname()) != 0) {

			return compare +=  this.lastname.compareTo(Name.getLastname());
		}

		if (this.firstname.compareTo(Name.getFirstname()) != 0) {

			return compare += this.firstname.compareTo(Name.getFirstname());
		}

		if (this.middlename.compareTo(Name.getMiddlename()) != 0 ) {

			return compare+= this.middlename.compareTo(Name.getMiddlename());
		}

		return compare;

	}

	public static int getNumberOfNameObjects() {

		return NumberOfNameObjects;

	}


	public static Name normalize (Name name, boolean bol) {

		//set string normal name
		String norFirst, norMiddle, norLast;

		if (bol == true) {
			// if they are true, change to uppercase
			norFirst = name.getFirstname().toUpperCase();
			norMiddle = name.getMiddlename().toUpperCase();
			norLast = name.getLastname().toUpperCase();

		} else {
			// else lowercase
			norFirst = name.getFirstname().toLowerCase();
			norMiddle = name.getMiddlename().toLowerCase();
			norLast = name.getLastname().toLowerCase();
		}
		//return normal name and separator string with new object 
		return new Name(norFirst, norMiddle, norLast, ',');


	}

	//set valid separator
	private  boolean validSeparator (char separator) {

		if (separator == ',' || separator == '-' || separator == '#') {

			return true;

		} else {

			return false;

		}

	}

	public static void main(String[] args) {
		Name name1 = new Name("Claudia", "I.", "Smith");
		System.out.println(name1);

		Name name2 = new Name("Rachel", "I.", "Green", '#');
		System.out.println(name2);

		Name name3 = new Name("Joseph", "K", "Falk");
		name3.setNickname("Joe");
		System.out.println(name3);

		Name name4 = new Name();
		System.out.println(name4);

		System.out.println("Same: " + name1.equals(name2));

		System.out.println("Comparing: " + (name1.compareTo(name2) < 0));

		Name name5 = Name.normalize(name3, true);
		System.out.println("Normalized: " + name5);

		System.out.println("Total number of name objects: " + Name.getNumberOfNameObjects());
	}
}

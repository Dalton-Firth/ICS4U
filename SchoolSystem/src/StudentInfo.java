
public class StudentInfo {
	/* StudentInfo.java
	 * This class acts as the template for the student records
	 * @author Dalton Firth
	 * @version 2016/09/28
	 */
	private String firstName, lastName, address, city, province, postalCode, phoneNumber, birthDate;
	private long studentID;
	
	/**
	 * Default constructor (empty except for a student number)
	 */
	public StudentInfo() {
		setBirthDate("");
		setCity("");
		setFirstName("");
		setLastName("");
		setPhoneNumber("");
		setPostalCode("");
		setProvince("");
		setAddress("");
		setStudentID(++studentID);
	}

	/**
	 * Makes a new Student with a first name
	 * 
	 * @param firstName
	 *           String - the student's first name
	 */
	public StudentInfo(String firstName) {
		setBirthDate("");
		setCity("");
		setFirstName(firstName);
		setLastName("");
		setPhoneNumber("");
		setPostalCode("");
		setProvince("");
		setAddress("");
		setStudentID(++studentID);
	}

	/**
	 * Makes a new Student with a first name and a last name
	 * 
	 * @param firstName
	 *           String - the student's first name
	 * @param lastName
	 *           String - the student's last name
	 */
	public StudentInfo(String firstName, String lastName) {
		setBirthDate("");
		setCity("");
		setFirstName(firstName);
		setLastName(lastName);
		setPhoneNumber("");
		setPostalCode("");
		setProvince("");
		setAddress("");
		setStudentID(++studentID);
	}

	/**
	 * Makes a new Student with a first name, a last name and a birth date
	 * 
	 * @param firstName
	 *           String - the student's first name
	 * @param lastName
	 *           String - the student's last name
	 * @param birth
	 *           String - the student's birth date
	 */
	public StudentInfo(String firstName, String lastName, String birth) {
		 
		setBirthDate(birth);
		setCity("");
		setFirstName(firstName);
		setLastName(lastName);
		setPhoneNumber("");
		setPostalCode("");
		setProvince("");
		setAddress("");
		setStudentID(++studentID);
	}

	/**
	 * Makes a new Student with a first name, a last name, a birth date and a home city
	 * 
	 * @param firstName
	 *           String - the student's first name
	 * @param lastName
	 *           String - the student's last name
	 * @param birth
	 *           String - the student's birth date
	 * @param city
	 *           String - the student's home city
	 */
	public StudentInfo(String firstName, String lastName, String birth, String city) {
		 
		setBirthDate(birth);
		setCity(city);
		setFirstName(firstName);
		setLastName(lastName);
		setPhoneNumber("");
		setPostalCode("");
		setProvince("");
		setAddress("");
		setStudentID(++studentID);
	}

	/**
	 * Makes a new Student with a first name, a last name, a birth date, a home city and a phone number
	 * 
	 * @param firstName
	 *           String - the student's first name
	 * @param lastName
	 *           String - the student's last name
	 * @param birth
	 *           String - the student's birth date
	 * @param city
	 *           String - the student's home city
	 * @param phoneNumber
	 *           String - the student's phone number
	 */
	public StudentInfo(String firstName, String lastName, String birth, String city, String phoneNumber) {
		 
		setBirthDate(birth);
		setCity(city);
		setFirstName(firstName);
		setLastName(lastName);
		setPhoneNumber(phoneNumber);
		setPostalCode("");
		setProvince("");
		setAddress("");
		setStudentID(++studentID);
	}

	/**
	 * Makes a new Student with a first name, a last name, a birth date, a home city, a phone number and a postal code
	 * 
	 * @param firstName
	 *           String - the student's first name
	 * @param lastName
	 *           String - the student's last name
	 * @param birth
	 *           String - the student's birth date
	 * @param city
	 *           String - the student's home city
	 * @param phoneNumber
	 *           String - the student's phone number
	 * @param postalCode
	 *           String - the student's postal code
	 */
	public StudentInfo(String firstName, String lastName, String birth, String city, String phoneNumber, String postalCode) {
		
		setBirthDate(birth);
		setCity(city);
		setFirstName(firstName);
		setLastName(lastName);
		setPhoneNumber(phoneNumber);
		setPostalCode(postalCode);
		setProvince("");
		setAddress("");
		setStudentID(++studentID);
	}

	/**
	 * Makes a new Student with a first name, a last name, a birth date, a home city, a phone number, a postal code and a province
	 * 
	 * @param firstName
	 *           String - the student's first name
	 * @param lastName
	 *           String - the student's last name
	 * @param birth
	 *           String - the student's birth date
	 * @param city
	 *           String - the student's home city
	 * @param phoneNumber
	 *           String - the student's phone number
	 * @param postalCode
	 *           String - the student's postal code
	 * @param province
	 *           String - the student's home province
	 */
	public StudentInfo(String firstName, String lastName, String birth, String city, String phoneNumber, String postalCode, String province) {
		 
		setBirthDate(birth);
		setCity(city);
		setFirstName(firstName);
		setLastName(lastName);
		setPhoneNumber(phoneNumber);
		setPostalCode(postalCode);
		setProvince(province);
		setAddress("");
		setStudentID(++studentID);
	}

	/**
	 * Makes a new Student with a first name, a last name, a birth date, a home city, a phone number, a postal code, a province and street address
	 * 
	 * @param firstName
	 *           String - the student's first name
	 * @param lastName
	 *           String - the student's last name
	 * @param birth
	 *           String - the student's birth date
	 * @param city
	 *           String - the student's home city
	 * @param phoneNumber
	 *           String - the student's phone number
	 * @param postalCode
	 *           String - the student's postal code
	 * @param province
	 *           String - the student's home province
	 * @param Address
	 *           String - the student's street address
	 */
	public StudentInfo(String firstName, String lastName, String birth, String city, String phoneNumber, String postalCode, String province, String Address) {
		 
		setBirthDate(birth);
		setCity(city);
		setFirstName(firstName);
		setLastName(lastName);
		setPhoneNumber(phoneNumber);
		setPostalCode(postalCode);
		setProvince(province);
		setAddress(Address);
		setStudentID(++studentID);
	}
	
	
	     /////////////////////////////////////////////
	    //										   //
	   //										  //
	  //				HERE					 //
	 //	 									    //
	//										   //
   /////////////////////////////////////////////
	
	
	
	
	/**
	 * Gets the student's first name
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the student's first name
	 * @param firstName
	 *            the firstName to set
	 */	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the student's last name
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the student's last name
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the student's address
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the student's address
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Gets the student's city
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the student's city
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Gets the student's province
	 * @return the province
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * Sets the student's province
	 * @param province
	 *            the province to set
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * Gets the student's postal code
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * Sets the student's postal code
	 * @param postalCode
	 *            the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * Gets the student's phone number
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets the student's phone number
	 * @param phoneNumber
	 *            the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Gets the student's birth date
	 * @return the birthDate
	 */
	public String getBirthDate() {
		return birthDate;
	}

	/**
	 * Sets the student's birth date
	 * @param birthDate
	 *            the birthDate to set
	 */
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @return the studentID
	 */
	public long getStudentID() {
		return studentID;
	}

	/**
	 * @param studentID the studentID to set
	 */
	public void setStudentID(long studentID) {
		this.studentID = studentID;
	}


}

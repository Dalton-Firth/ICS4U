import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* StudentInfo.java
 * This program creates a studentInfo object with various fields that store data related to keeping student records
 * @author Dalton Firth
 * @version 2016/10/31
 */


public class StudentInfo implements Comparable {
	
	
	public static long studentConstant = makeStudentConstant();
	private String firstName, lastName, birthDate, address, city, postalCode, phoneNumber;
	private long studentID = studentConstant;
	private Province province;

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
		setProvince(Province.ALBERTA);
		setAddress("");
		setStudentID(++studentID);
	}

	/**
	 * Makes a new Student with a first name, a last name, a birth date, a home
	 * city, a phone number, a postal code, a province and street address
	 * 
	 * @param firstName
	 *            String - the student's first name
	 * @param lastName
	 *            String - the student's last name
	 * @param birth
	 *            String - the student's birth date
	 * @param city
	 *            String - the student's home city
	 * @param phoneNumber
	 *            String - the student's phone number
	 * @param postalCode
	 *            String - the student's postal code
	 * @param province
	 *            String - the student's home province
	 * @param Address
	 *            String - the student's street address
	 */
	public StudentInfo(String firstName, String lastName, String birth, String address, String city, Province province,
			String postalCode, String phoneNumber) {

		
		setFirstName(firstName);
		setLastName(lastName);
		setBirthDate(birth);
		setAddress(address);
		setCity(city);
		setProvince(province);
		setPostalCode(postalCode);
		setPhoneNumber(phoneNumber);
		setStudentID(++studentConstant);
	}

	
/**
 * puts all the fields of the object into 1 string with "," separating them
 */
	public String toString() {
		return firstName + "," + lastName + "," + birthDate + "," + address + "," + city + "," + province + ","
				+ postalCode + "," + phoneNumber+","+studentID;
	}

	/**
	 * checks to see if the student ids are equal
	 * @param iD a long value that is compared
	 * @return true if equal
	 */
	public boolean equals(StudentInfo iD) {
		if (this.studentID == iD.getStudentID())
			return true;
		return false;
	}
	
/**
 * compares the elements of the current object to another one
 */
	public int compareTo(Object E) {

		StudentInfo tempStudent = (StudentInfo) E;

		return this.getLastName().compareTo(tempStudent.getLastName());

	}

	/**
	 * Gets the student's first name
	 * 
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the student's first name
	 * 
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the student's last name
	 * 
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the student's last name
	 * 
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the student's address
	 * 
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the student's address
	 * 
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Gets the student's city
	 * 
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the student's city
	 * 
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Gets the student's province
	 * 
	 * @return the province
	 */
	public Province getProvince() {
		return province;
	}

	/**
	 * Sets the student's province
	 * 
	 * @param province
	 *            the province to set
	 */
	public void setProvince(Province province) {
		this.province = province;
	}

	/**
	 * Gets the student's postal code
	 * 
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * Sets the student's postal code
	 * 
	 * @param postalCode
	 *            the postalCode to set
	 */
	public void setPostalCode(String postalCode){		
		this.postalCode = postalCode;
	}

	/**
	 * Gets the student's phone number
	 * 
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets the student's phone number
	 * 
	 * @param phoneNumber
	 *            the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Gets the student's birth date
	 * 
	 * @return the birthDate
	 */
	public String getBirthDate() {
		return birthDate;
	}

	/**
	 * Sets the student's birth date
	 * 
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
	 * @param studentID
	 *            the studentID to set
	 */
	public void setStudentID(long studentID) {
		this.studentID = studentID;
		studentConstant++;
	}
	
	/**
	 * sets the base value for the student number
	 * @return a long used for the base value
	 */
	public static long makeStudentConstant() {
		try {
			
			BufferedReader read = new BufferedReader(new FileReader(Student.f));

			String lineOne = read.readLine();
			String[] splitFile = lineOne.split(",");

			return Long.parseLong(splitFile[1]);

		} catch (IOException | NullPointerException | NumberFormatException e) {
			return 323000000;
		}

	}
}

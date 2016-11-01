import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/* Student.java
 * This program acts as a hub in order to perform a number of tasks related to student records
 * @author Dalton Firth
 * @version 2016/10/28
 */

public class Student {

	public static Scanner scan = new Scanner(System.in);
	public static ArrayList<StudentInfo> studentRecords = new ArrayList<StudentInfo>();
	public static File f = new File("src\\student.txt");
	public static BufferedReader fbr = null;
	public static FileOutputStream fileOutputStream = null;
	public static PrintStream fps = null;

	/**
	 * This is the main method where code is executed
	 * 
	 * @param args
	 *            String array of arguments
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		 readFile();// loads the information saved to the file and adds in to
		// the arrayList


		int options = 0;

		// gets input and selects an action to perform
		do {
			System.out.println("");
			System.out.println("To add a student into the records please press: 1");
			System.out.println("To find a student please press: 2");
			System.out.println("To print all student records please press: 3");
			System.out.println("To save the student records please press: 4");
			System.out.println("To exit the program please press: 10");

			// this try catch insures that the user inputs an integer value
			try {

				options = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("");
				System.out.println("invalid input");
				System.out.println("");
				continue;

			}

			if (options == 1)
				addStudent();
			if (options == 2)
				findStudent();
			if (options == 3)
				printAllStudents();
			if (options == 4)
				saveFile();

		} while (options != 10);// runs infinitely unless the user wishes to
								// exit

	}

	/**
	 * This method creates and sets the information of a student
	 */
	public static void addStudent() {

		studentRecords.trimToSize();

		String firstName = null, lastName = null, birthDate = null, address = null, city = null, postalCode = null,
				phoneNumber = null;
		String provinceIn = null;

		System.out.println("Enter your first name");
		firstName = scan.nextLine();

		System.out.println("Enter your last name");
		lastName = scan.nextLine();

		System.out.println("Enter your birth date (yyyy/mm/dd)");
		address = scan.nextLine();

		System.out.println("Enter your address");
		birthDate = scan.nextLine();

		System.out.println("Enter your city");
		city = scan.nextLine();

		System.out.println("Enter your province");
		provinceIn = scan.nextLine();

		while(true){
			
			System.out.println("Enter your postal code (X#X#X#)");
			postalCode = scan.nextLine();

			if(checkPostalCode(postalCode))
				break;
			else{
				System.out.println("Please input the proper format (X#X#X#)");
				System.out.println("");
			}
		}

		System.out.println("Enter your phone number");
		phoneNumber = scan.nextLine();

		studentRecords.add(new StudentInfo(firstName, lastName, birthDate, address, city, selectProvince(provinceIn),
				postalCode, phoneNumber));

	}

	/**
	 * this method changes the value of province into an enum of provinces for
	 * storage
	 * 
	 * @param provinceIn
	 *            a String input from the user that is converted to an enum
	 * @return returns the enum value for the selected province
	 */
	public static Province selectProvince(String provinceIn) {

		provinceIn= provinceIn.toLowerCase();
		switch (provinceIn) {
		case "bc":
		case "britishcolumbia":
		case "british columbia":
			return Province.BRITISHCOLUMBIA;
		case "yk":
		case "yukon":
			return Province.YUKON;
		case "ab":
		case "alberta":
			return Province.ALBERTA;
		case "nwt":
		case "northwestterritories":
		case "northwest territories":
			return Province.NORTHWESTTERRITORIES;
		case "sk":
		case "saskatchewan":
			return Province.SASKATCHEWAN;
		case "nu":
		case "nunavut":
			return Province.NUNAVUT;
		case "mb":
		case "manitoba":
			return Province.MANITOBA;
		case "on":
		case "ontario":
			return Province.ONTARIO;
		case "qb":
		case "quebec":
			return Province.QUEBEC;
		case "nb":
		case "newbrunswick":
		case "new brunswick":
			return Province.NEWBRUNSWICK;
		case "nl":
		case "newfoundlandandlabrador":
		case "newfoundland and labrador":
			return Province.NEWFOUNDLANDANDLABRADOR;
		case "pe":
		case "princeedwardisland":
		case "prince edward island":
			return Province.PRINCEEDWARDISLAND;
		case "ns":
		case "novascotia":
		case "nova scotia":
			return Province.NOVASCOTIA;
		default:
			try {
				throw new InvalidInputExceptions("Invalid province.");
			} catch (InvalidInputExceptions e) {
			}
			return null;
		}
	}

	/**
	 * This method prints the fields of a student
	 * 
	 * @param location
	 *            Int that determines which student in the array list is printed
	 */
	public static void printStudent(int location) {
		System.out.println("first name: " + studentRecords.get(location).getFirstName());
		System.out.println("last name: " + studentRecords.get(location).getLastName());
		System.out.println("birth date: " + studentRecords.get(location).getBirthDate());
		System.out.println("address: " + studentRecords.get(location).getAddress());
		System.out.println("city: " + studentRecords.get(location).getCity());
		System.out.println("province: " + studentRecords.get(location).getProvince());
		System.out.println("postal code: " + studentRecords.get(location).getPostalCode());
		System.out.println("phone number: " + studentRecords.get(location).getPhoneNumber());
		System.out.println("Student ID: " + studentRecords.get(location).getStudentID());
	}

	/**
	 * Prints all students in the array list
	 */
	@SuppressWarnings("unchecked")
	public static void printAllStudents() {

		Collections.sort(studentRecords);
		for (int i = 0; i < studentRecords.size(); i++) {
			System.out.println();
			System.out.println("first name: " + studentRecords.get(i).getFirstName());
			System.out.println("last name: " + studentRecords.get(i).getLastName());
			System.out.println("birth date: " + studentRecords.get(i).getBirthDate());
			System.out.println("address: " + studentRecords.get(i).getAddress());
			System.out.println("city: " + studentRecords.get(i).getCity());
			System.out.println("province: " + studentRecords.get(i).getProvince());
			System.out.println("postal code: " + studentRecords.get(i).getPostalCode());
			System.out.println("phone number: " + studentRecords.get(i).getPhoneNumber());
			System.out.println("Student ID: " + studentRecords.get(i).getStudentID());

		}
	}

	/**
	 * Finds a student in the array list with multiple sorting options
	 */
	public static void findStudent() {

		int options = 0;

		System.out.println("To search by first name please press: 1");
		System.out.println("To search by last name please press: 2");
		System.out.println("To search by birth date please press: 3");
		System.out.println("To search by address please press: 4");
		System.out.println("To search by city please press: 5");
		System.out.println("To search by province please press: 6");
		System.out.println("To search by postal code please press: 7");
		System.out.println("To search by phone number please press: 8");
		System.out.println("To search by student number press: 9");

		try {

			options = Integer.parseInt(scan.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("");
			System.out.println("invalid input");
			System.out.println("");

		}

		if (options == 1)
			sortFirst();
		if (options == 2)
			sortLast();
		if (options == 3)
			sortBirthDate();
		if (options == 4)
			sortAddress();
		if (options == 5)
			sortCity();
		if (options == 6)
			sortProvince();
		if (options == 7)
			sortPostalCode();
		if (options == 8)
			sortPhoneNumber();
		if (options == 9)
			sortStudentId();

	}

	/**
	 * Edits the fields of an already existing user
	 * 
	 * @param location
	 *            Int The location of the student in the array list
	 */
	public static void editStudent(int location) {
		System.out.println("Enter your first name");
		studentRecords.get(location).setFirstName(scan.nextLine());

		System.out.println("Enter your last name");
		studentRecords.get(location).setLastName(scan.nextLine());

		System.out.println("Enter your birth date (yyyy/mm/dd)");
		studentRecords.get(studentRecords.size() - 1).setBirthDate(scan.nextLine());

		System.out.println("Enter your address");
		studentRecords.get(location).setAddress(scan.nextLine());

		System.out.println("Enter your city");
		studentRecords.get(location).setCity(scan.nextLine());

		System.out.println("Enter your province");
		studentRecords.get(location).setProvince(selectProvince(scan.nextLine()));

		System.out.println("Enter your postal code");
		studentRecords.get(location).setPostalCode(scan.nextLine());

		System.out.println("Enter your phone number");
		studentRecords.get(studentRecords.size() - 1).setPhoneNumber(scan.nextLine());

	}

	/**
	 * Sorts students by first name
	 */
	public static void sortFirst() {

		System.out.println("Please enter their first name");
		String firstname = scan.nextLine();

		String isUser = null, userEdit = null;

		for (int i = 0; i < studentRecords.size(); i++) {
			if (studentRecords.get(i).getFirstName().equalsIgnoreCase(firstname)) {
				printStudent(i);
				System.out.println("Is this the student you are looking for? (y/n)");
				isUser = scan.nextLine();
				if (isUser.equals("y") || isUser.equals("yes")) {
					System.out.println("Would you like to edit or delete this user(edit/delete/none)");
					userEdit = scan.nextLine();
					if (userEdit.equalsIgnoreCase("edit"))
						editStudent(i);
					else if (userEdit.equalsIgnoreCase("delete"))
						studentRecords.remove(i);
					break;
				}
			} else if (scan.nextLine().equals("n") || scan.nextLine().equals("no"))
				continue;

		}
	}

	/**
	 * Sorts students by last name
	 */
	public static void sortLast() {

		System.out.println("Please enter their last name");
		String Lastname = scan.nextLine();

		String isUser = null, userEdit = null;

		for (int i = 0; i < studentRecords.size(); i++) {
			if (studentRecords.get(i).getLastName().equalsIgnoreCase(Lastname)) {
				printStudent(i);
				System.out.println("Is this the student you are looking for? (y/n)");
				isUser = scan.nextLine();
				if (isUser.equals("y") || isUser.equals("yes")) {
					System.out.println("Would you like to edit or delete this user(edit/delete/none)");
					userEdit = scan.nextLine();
					if (userEdit.equalsIgnoreCase("edit"))
						editStudent(i);
					else if (userEdit.equalsIgnoreCase("delete"))
						studentRecords.remove(i);
					break;
				}
			} else if (scan.nextLine().equals("n") || scan.nextLine().equals("no"))
				continue;

		}
	}

	/**
	 * Sorts students by birth date
	 */
	public static void sortBirthDate() {

		System.out.println("Please enter their BirthDate");
		String birthDate = scan.nextLine();

		String isUser = null, userEdit = null;

		for (int i = 0; i < studentRecords.size(); i++) {
			if (studentRecords.get(i).getBirthDate().equalsIgnoreCase(birthDate)) {
				printStudent(i);
				System.out.println("Is this the student you are looking for? (y/n)");
				isUser = scan.nextLine();
				if (isUser.equals("y") || isUser.equals("yes")) {
					System.out.println("Would you like to edit or delete this user(edit/delete/none)");
					userEdit = scan.nextLine();
					if (userEdit.equalsIgnoreCase("edit"))
						editStudent(i);
					else if (userEdit.equalsIgnoreCase("delete"))
						studentRecords.remove(i);
					break;
				}
			} else if (scan.nextLine().equals("n") || scan.nextLine().equals("no"))
				continue;

		}
	}

	/**
	 * Sorts students by address
	 */
	public static void sortAddress() {

		System.out.println("Please enter their address");
		String address = scan.nextLine();

		String isUser = null, userEdit = null;

		for (int i = 0; i < studentRecords.size(); i++) {
			if (studentRecords.get(i).getAddress().equalsIgnoreCase(address)) {
				printStudent(i);
				System.out.println("Is this the student you are looking for? (y/n)");
				isUser = scan.nextLine();
				if (isUser.equals("y") || isUser.equals("yes")) {
					System.out.println("Would you like to edit or delete this user(edit/delete/none)");
					userEdit = scan.nextLine();
					if (userEdit.equalsIgnoreCase("edit"))
						editStudent(i);
					else if (userEdit.equalsIgnoreCase("delete"))
						studentRecords.remove(i);
					break;
				}
			} else if (scan.nextLine().equals("n") || scan.nextLine().equals("no"))
				continue;

		}
	}

	/**
	 * Sorts students by city
	 */
	public static void sortCity() {

		System.out.println("Please enter their City");
		String city = scan.nextLine();

		String isUser = null, userEdit = null;

		for (int i = 0; i < studentRecords.size(); i++) {
			if (studentRecords.get(i).getCity().equalsIgnoreCase(city)) {
				printStudent(i);
				System.out.println("Is this the student you are looking for? (y/n)");
				isUser = scan.nextLine();
				if (isUser.equals("y") || isUser.equals("yes")) {
					System.out.println("Would you like to edit or delete this user(edit/delete/none)");
					userEdit = scan.nextLine();
					if (userEdit.equalsIgnoreCase("edit"))
						editStudent(i);
					else if (userEdit.equalsIgnoreCase("delete"))
						studentRecords.remove(i);
					break;
				}
			} else if (scan.nextLine().equals("n") || scan.nextLine().equals("no"))
				continue;

		}
	}

	/**
	 * Sorts students by province
	 */
	public static void sortProvince() {

		System.out.println("Please enter their Province");
		String province = scan.nextLine();

		String isUser = null, userEdit = null;

		for (int i = 0; i < studentRecords.size(); i++) {
			if (studentRecords.get(i).getProvince() == selectProvince(province)) {
				printStudent(i);
				System.out.println("Is this the student you are looking for? (y/n)");
				isUser = scan.nextLine();
				if (isUser.equals("y") || isUser.equals("yes")) {
					System.out.println("Would you like to edit or delete this user(edit/delete/none)");
					userEdit = scan.nextLine();
					if (userEdit.equalsIgnoreCase("edit"))
						editStudent(i);
					else if (userEdit.equalsIgnoreCase("delete"))
						studentRecords.remove(i);
					break;
				}
			} else if (scan.nextLine().equals("n") || scan.nextLine().equals("no"))
				continue;

		}
	}

	/**
	 * Sorts students by postal code
	 */
	public static void sortPostalCode() {

		System.out.println("Please enter their PostalCode");
		String postalCode = scan.nextLine();

		String isUser = null, userEdit = null;

		for (int i = 0; i < studentRecords.size(); i++) {
			if (studentRecords.get(i).getPostalCode().equalsIgnoreCase(postalCode)) {
				printStudent(i);
				System.out.println("Is this the student you are looking for? (y/n)");
				isUser = scan.nextLine();
				if (isUser.equals("y") || isUser.equals("yes")) {
					System.out.println("Would you like to edit or delete this user(edit/delete/none)");
					userEdit = scan.nextLine();
					if (userEdit.equalsIgnoreCase("edit"))
						editStudent(i);
					else if (userEdit.equalsIgnoreCase("delete"))
						studentRecords.remove(i);
					break;
				}
			} else if (scan.nextLine().equals("n") || scan.nextLine().equals("no"))
				continue;

		}
	}

	/**
	 * Sorts students by phone number
	 */
	public static void sortPhoneNumber() {

		System.out.println("Please enter their PhoneNumber");
		String phoneNumber = scan.nextLine();

		String isUser = null, userEdit = null;

		for (int i = 0; i < studentRecords.size(); i++) {
			if (studentRecords.get(i).getPhoneNumber().equalsIgnoreCase(phoneNumber)) {
				printStudent(i);
				System.out.println("Is this the student you are looking for? (y/n)");
				isUser = scan.nextLine();
				if (isUser.equals("y") || isUser.equals("yes")) {
					System.out.println("Would you like to edit or delete this user(edit/delete/none)");
					userEdit = scan.nextLine();
					if (userEdit.equalsIgnoreCase("edit"))
						editStudent(i);
					else if (userEdit.equalsIgnoreCase("delete"))
						studentRecords.remove(i);
					break;
				}
			} else if (scan.nextLine().equals("n") || scan.nextLine().equals("no"))
				continue;

		}
	}

	/**
	 * Sorts students by student id
	 */
	public static void sortStudentId() {

		System.out.println("Please enter their StudentId");
		String studentId = scan.nextLine();

		String isUser = null, userEdit = null;

		for (int i = 0; i < studentRecords.size(); i++) {
			if (studentRecords.get(i).getStudentID() == Long.parseLong(studentId)) {
				printStudent(i);
				System.out.println("Is this the student you are looking for? (y/n)");
				isUser = scan.nextLine();
				if (isUser.equals("y") || isUser.equals("yes")) {
					System.out.println("Would you like to edit or delete this user(edit/delete/none)");
					userEdit = scan.nextLine();
					if (userEdit.equalsIgnoreCase("edit"))
						editStudent(i);
					else if (userEdit.equalsIgnoreCase("delete"))
						studentRecords.remove(i);
					break;
				}
			} else if (scan.nextLine().equals("n") || scan.nextLine().equals("no"))
				continue;

		}
	}
	
	/**
	 * this method checks to see if the postal code entered is the expected format
	 * @param postalCode a string input that is compared
	 * @return true if the postal code is the correct format
	 */
	public static boolean checkPostalCode(String postalCode) {
		for (int i = 0; i < postalCode.length(); i++) {
			if (i % 2 == 0) {
				if (!equalsUpperCaseLetter(postalCode.charAt(i))) {
					return false;
				}
			} else {
				if (!equalsNumber(postalCode.charAt(i))) {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean equalsUpperCaseLetter(char letter) {
		if (letter == 'A' || letter == 'B' || letter == 'C' || letter == 'D' || letter == 'E' || letter == 'F'
				|| letter == 'G' || letter == 'H' || letter == 'I' || letter == 'J' || letter == 'K' || letter == 'L'
				|| letter == 'M' || letter == 'N' || letter == 'O' || letter == 'P' || letter == 'Q' || letter == 'R'
				|| letter == 'S' || letter == 'T' || letter == 'U' || letter == 'V' || letter == 'W' || letter == 'X'
				|| letter == 'Y' || letter == 'Z') {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * checks to see if the inputed value is a number
	 * @param number a char that may be a number
	 * @return true if the value is a number
	 */
	public static boolean equalsNumber(char number) {
		if (number == '1' || number == '2' || number == '3' || number == '4' || number == '5' || number == '6'
				|| number == '7' || number == '8' || number == '9') {
			return true;
		} else {
			return false;
		}
	}


	/**
	 * this method saves toe values stored in the studentInfo arrayList to a
	 * file for storage
	 */
	public static void saveFile() {
		if (studentRecords.size() > 0) {
			try {
				FileOutputStream fos = new FileOutputStream(f);
				long largestStudentNumber = -1;
				@SuppressWarnings("resource")
				PrintStream write = new PrintStream(fos);

				if (!f.exists()) {
					f.createNewFile();
				}

				for (int i = 0; i < studentRecords.size(); i++){
					if (largestStudentNumber < studentRecords.get(i).getStudentID()){
						largestStudentNumber = studentRecords.get(i).getStudentID();
					}
				}
				
				write.println(studentRecords.size() + ", " + largestStudentNumber);

				for (int i = 0; i < studentRecords.size(); i++) {
					write.println(studentRecords.get(i).toString());
				}

			} catch (IOException e) {
			}
		}
		else {
			System.out.println("You have no students to save.");
		}

	}
	

	/**
	 * This methods reads the information that is stored in the file
	 * @throws IOException 
	 */
	public static void readFile() throws IOException {
		ArrayList<StudentInfo> tempStudentList = null;

		
			BufferedReader read = new BufferedReader(new FileReader(f));

			String lineOne = read.readLine();
			String[] splitFile = lineOne.split(",");
			tempStudentList = new ArrayList<StudentInfo>();

			for (int i = 0; i < studentRecords.size() - 1; i++) {
				studentRecords.remove(i);
			}

			for (int i = 0; i < Integer.parseInt(splitFile[0]); i++) {
				String[] nextLine = read.readLine().split(",");

				tempStudentList.add(new StudentInfo(nextLine[0], nextLine[1], nextLine[2], nextLine[3], nextLine[4], selectProvince(nextLine[5]), nextLine[6], nextLine[7]));

				tempStudentList.get(i).setStudentID(Long.parseLong(nextLine[8]));
			}

		
		studentRecords = tempStudentList;

	}

}

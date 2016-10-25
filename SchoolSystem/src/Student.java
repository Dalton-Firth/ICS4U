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
 * @version 2016/09/28
 */

public class Student {

	public static Scanner scan = new Scanner(System.in);
	public static ArrayList<StudentInfo> studentRecords = new ArrayList<StudentInfo>();
	public static File f = new File("src\\student.txt");
	public static BufferedReader fbr = null;
	public static FileOutputStream fileOutputStream = null;
	public static PrintStream fps =null;
	//public enum Province {BRITISHCOLUMBIA, YUKON, ALBERTA, NORTHWESTTERRITORIES, SASKATCHEWAN, NUNAVUT, MANITOBA, ONTARIO, QUEBEC, NEWBRUNSWICK, NEWFOUNDLANDANDLABRADOR, PRINCEEDWARDISLAND, NOVASCOTIA, NULL}


	
	//enum Month {JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER}
	

/**
 * this methods sets the values for the bufferedReader, fileOutputStream and printStream and creates a file if it does not exist
 */
	public static void setUp(){
		
		try {
			fbr = new BufferedReader(new FileReader("src\\student.txt"));
			fileOutputStream = new FileOutputStream(f);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			if (!f.exists())
			{
				try {
					f.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		PrintStream fps = new PrintStream(fileOutputStream);
	}
	
	
	/**
	 * this method saves toe values stored in the studentInfo arrayList to a file for storage
	 */
	public static void saveToFile() {
		try {
			f.createNewFile();

			if (studentRecords.size() > 0) {
				fps.println(studentRecords.size() + "," + studentRecords.get(studentRecords.size() - 1).getStudentID());

				for (int i = 0; i < studentRecords.size(); i++) {
					fps.println(studentRecords.get(i).toString());
				}
			}
			else {
				System.out.println("You have no students to save.");
			}
		} catch (IOException e) {

		}
	}
	
	/**
	 * This methods reads the information that is stored in the file
	 */
	public static void readFromFile() {
		try {
			

			String lineOne = fbr.readLine();
			String[] splitFile = lineOne.split(", ");
			ArrayList<StudentInfo> tempStudentList = new ArrayList<StudentInfo>();

			for (int i = 0; i < Integer.parseInt(splitFile[0]); i++) {
				String[] nextLine = fbr.readLine().split(",");

				tempStudentList.get(i).setFirstName(nextLine[0]);
				tempStudentList.get(i).setLastName(nextLine[1]);
				tempStudentList.get(i).setStudentID(Long.parseLong(nextLine[2]));
				tempStudentList.get(i).setAddress(nextLine[3]);
				tempStudentList.get(i).setCity(nextLine[4]);
				tempStudentList.get(i).setProvince(selectProvince(nextLine[5]));
				tempStudentList.get(i).setPostalCode(nextLine[6]);
				tempStudentList.get(i).setPhoneNumber(nextLine[7]);

			}

		} catch (IOException | InvalidInputExceptions e) {
		}

	}
	
	
	
	/**
	 * This is the main method where code is executed
	 * @param args
	 */
	public static void main(String[] args) {

		setUp();
		
		//fps.println();
		

		int options = 0;
		do {
			System.out.println("To add a student into the records please press: 1");
			System.out.println("To find a student please press:2");
			System.out.println("To print all student records please press:3");
			System.out.println("To exit the program please press: 10");

			// this try catch insure that the user inputs an integer value
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
				saveToFile();
			

		} while (options != 10);

	}

	/**
	 * This method creates and sets the information of a student
	 */
	public static void addStudent() {

		studentRecords.trimToSize();
		//studentRecords.add(new StudentInfo());
		
		String firstName=null, lastName=null, birthDate=null, address=null, city=null, postalCode=null, phoneNumber=null;
		String provinceIn=null;
		
		
		
		//studentRecords.get(studentRecords.size() - 1).setStudentID();

		System.out.println("Enter your first name");
		firstName = scan.nextLine();
		//studentRecords.get(studentRecords.size() - 1).setFirstName(scan.nextLine());

		System.out.println("Enter your last name");
		lastName = scan.nextLine();
		//studentRecords.get(studentRecords.size() - 1).setLastName(scan.nextLine());

		System.out.println("Enter your birth date (yyyy/mm/dd)");
		address = scan.nextLine();
		//studentRecords.get(studentRecords.size() - 1).setBirthDate(scan.nextLine());

		System.out.println("Enter your address");
		birthDate = scan.nextLine();
		//studentRecords.get(studentRecords.size() - 1).setAddress(scan.nextLine());

		System.out.println("Enter your city");
		city = scan.nextLine();
		//studentRecords.get(studentRecords.size() - 1).setCity(scan.nextLine());

		System.out.println("Enter your province");
		provinceIn = scan.nextLine();
		
		//studentRecords.get(studentRecords.size() - 1).setProvince(scan.nextLine());
		
		
		
		
		

		System.out.println("Enter your postal code (X#X#X#)");
		postalCode = scan.nextLine();
		
		
		

			//studentRecords.get(studentRecords.size() - 1).setPostalCode(postalCode);
		//} else {
		//	studentRecords.remove(studentRecords.size() - 1);
		//	System.out.println("");
		//	System.out.println("Invalid input, please try again.");
		//	System.out.println("");
		//	return;
		//}

		System.out.println("Enter your phone number");
		phoneNumber = scan.nextLine();
		//studentRecords.get(studentRecords.size() - 1).setPhoneNumber(scan.nextLine());
		
		
		studentRecords.add(new StudentInfo(firstName, lastName, birthDate, address, city, selectProvince(provinceIn), postalCode, phoneNumber ));

		
	}

	/**
	 * this method changes the value of province into an enum of provinces for storage
	 * @param provinceIn a String input from the user that is converted to an enum
	 * @return returns the enum value for the selected province
	 */
	public static Province selectProvince (String provinceIn){
		
		switch (provinceIn){
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
			if (studentRecords.get(i).getProvince()==selectProvince(province)) {
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

}

import java.util.ArrayList;
import java.util.Scanner;
/* Student.java
 * This program acts as a hub in order to perform a number of tasks related to student records
 * @author Dalton Firth
 * @version 2016/09/28
 */

public class Student {

	public static Scanner scan = new Scanner(System.in);

	public static ArrayList<StudentInfo> studentRecords = new ArrayList<StudentInfo>();
	
	private static long idGenerator=0;

	public static void main(String[] args) {

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

		} while (options != 10);

	}

	/**
	 * This method creates and sets the information of a student
	 */
	public static void addStudent() {

		studentRecords.trimToSize();
		studentRecords.add(new StudentInfo());
		
		idGenerator++;
		studentRecords.get(studentRecords.size() - 1).setStudentID(idGenerator);

		System.out.println("Enter your first name");
		studentRecords.get(studentRecords.size() - 1).setFirstName(scan.nextLine());

		System.out.println("Enter your last name");
		studentRecords.get(studentRecords.size() - 1).setLastName(scan.nextLine());
		
		System.out.println("Enter your birth date (yyyy/mm/dd)");
		studentRecords.get(studentRecords.size() - 1).setBirthDate(scan.nextLine());

		System.out.println("Enter your address");
		studentRecords.get(studentRecords.size() - 1).setAddress(scan.nextLine());

		System.out.println("Enter your city");
		studentRecords.get(studentRecords.size() - 1).setCity(scan.nextLine());

		System.out.println("Enter your province");
		studentRecords.get(studentRecords.size() - 1).setProvince(scan.nextLine());

		System.out.println("Enter your postal code");
		studentRecords.get(studentRecords.size() - 1).setPostalCode(scan.nextLine());

		System.out.println("Enter your phone number");
		studentRecords.get(studentRecords.size() - 1).setPhoneNumber(scan.nextLine());

		
	}
	
	/**
	 * This method prints the fields of a student
	 * @param location Int that determines which student in the array list is printed
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
		
	}

	/**
	 * Prints all students in the array list
	 */
	public static void printAllStudents() {

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
	 * @param location Int The location of the student in the array list
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
		studentRecords.get(location).setProvince(scan.nextLine());

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
			if (studentRecords.get(i).getProvince().equalsIgnoreCase(province)) {
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
			if (studentRecords.get(i).getStudentID()==Long.parseLong(studentId)) {
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


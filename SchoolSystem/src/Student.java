import java.util.Scanner;

public class Student {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StudentInfo student1 = new StudentInfo();
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter your first name");
		student1.setFirstName(scan.nextLine());
		
		System.out.println("Enter your last name");
		student1.setLastName(scan.nextLine());
		
		System.out.println("Enter your address");
		student1.setaddress(scan.nextLine());
		
		System.out.println("Enter your city");
		student1.setCity(scan.nextLine());
		
		System.out.println("Enter your province");
		student1.setProvince(scan.nextLine());
		
		System.out.println("Enter your postal code");
		student1.setPostalCode(scan.nextLine());
		
		System.out.println("Enter your phone number");
		student1.setPhoneNumber(scan.nextLine());
		
		System.out.println("Enter your birth date");
		student1.setBirthDate(scan.nextLine());

		System.out.println("first name: "+student1.getFirstName());
		System.out.println("last name: "+student1.getLastName());
		System.out.println("address: "+student1.getaddress());
		System.out.println("city: "+student1.getCity());
		System.out.println("province: "+student1.getProvince());
		System.out.println("postal code: "+student1.getPostalCode());
		System.out.println("phone number: "+student1.getPhoneNumber());
		System.out.println("birth date: "+student1.getBirthDate());

		scan.close();
	}

}

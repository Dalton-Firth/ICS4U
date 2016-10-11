package firth;

public class TestField {
	public static void sortStudentId() {

		System.out.println("Please enter their StudentId");
		String studentId = scan.nextLine();

		String isUser = null, userEdit = null;

		for (int i = 0; i < studentRecords.size(); i++) {
			if (studentRecords.get(i).getStudentId().equalsIgnoreCase(studentId)) {
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


//import java.io.FileWriter;
import java.util.Scanner;
//import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {

		// SECTION 1: Permanent data read-in
		Lists lister = new Lists();
		String fileName = "permData.txt";
		TextFileReader readText = new TextFileReader(fileName);
		readText.getFile(lister);

		 
		// SECTION 2: Interactive console
		// Administrators and Class Directors can access courses/teachers and perform a limited set of actions
		// Admins can View Courses, View Teachers, Assign Teacher to Course, and Add Training
		// Class Directors can View Courses, Add Courses, and Add Requirements to Course
		boolean active = true;
		Scanner input = new Scanner(System.in);
		while(active) {
			System.out.println("Select User Type: Administrator or Course Director");
			String userType = input.nextLine();
			User currentUser; // initialize user variable

			// creating the user object based on input
			if (userType.equals("Administrator")) {
				currentUser = new Admin();
			} else if (userType.equals("Course Director")) {
				System.out.println("Please input Course Director ID:");
				String courseDirID = input.nextLine();
				currentUser = lister.findCourseDirector(courseDirID);
			} else {
				System.out.println("Invalid User Type!");
				continue;
			}

			currentUser.getOptions(lister); // provides different options if user is an Admin or a CD

			active = false;
		}
		input.close();

		// SECTION 3: rewrite into file
		// delete existing file
		readText.deleteFile();
		// write new file
		TextFileWriter writeText = new TextFileWriter("permData.txt");
		writeText.getFile(lister);

	}
}
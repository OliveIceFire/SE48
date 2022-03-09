import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static final String fileName = "permData.txt";
	public static void main(String[] args) {

		// SECTION 1: Permanent data read-in
		// setting up file reader to read in permanent data
		FileReader reader = null;
		Lists lister = new Lists();
		try {
			reader = new FileReader(fileName);
			Scanner scan = new Scanner(reader);
			while(scan.hasNextLine()) {
				String line = scan.nextLine();
				if(line.isEmpty()) break;
				String[] values = line.split("[\\,]"); // splits line into array based on commas
				boolean isTeacher = false; // determines whether data is for a teacher or a course
				if(line.contains("Teacher")) {
					isTeacher = true;
				}

				// if line is for a Teacher object
				if (isTeacher) {
					String name = values[1];
					String id = values[2];
					String[] qualifications = values[3].split("\\|");
					Teacher t = new Teacher(name, id); // create new teacher object
					for(int x = 0; x < qualifications.length; x++) {
						t.addQualification(qualifications[x]); // add qualifications to object t
					}

					// add object to teacher list
					lister.addTeach(t);

				} else { // if line is for a Course object
					String name = values[1];
					String id = values[2];
					String[] requirements = values[3].split("\\|");
					String dirID = values[4];
					Course c = new Course(name, id, dirID);
					for(int x = 0; x < requirements.length; x++) {
						c.addRequirement(requirements[x]);
					}
					// add object to course list
					lister.addCourse(c);
				}

		}
			scan.close();
			
			for(Course c:lister.getCourses()) {
				System.out.println(c.getName());
			}

		} catch (FileNotFoundException e) {
			System.out.println("The file " + fileName + " can't be found!");
		}

		// SECTION 2: Interactive console
		// Administrators and Class Directors can access courses/teachers and perform a limited set of actions
		// Admins can View Courses, View Teachers, Assign Teacher to Course, and Add Training
		// Class Directors can View Courses, Add Courses, and Add Requirements to Course
		boolean active = true;
		
		while(active) {
			Scanner input = new Scanner(System.in);
			System.out.println("Select User Type: Administrator or Course Director");
			String userType = input.nextLine();
			if (userType.equals("Administrator")) {
				Administrator currentUser = new Administrator();
				//View Courses, View Teachers, Assign Teacher to Course, and Add Training
				System.out.println("If you want ot view courses, please enter 0");
				System.out.println("If you want to view teachers, please enter 1");
				System.out.println("If you want to assign teacher to course, please enter 2");
				System.out.println("If you want to add training, please enter 3");
				int order = Integer.parseInt(input.nextLine());
				
				currentUser.getOptions(order,lister);
			} else if (userType.equals("Course Director")) {
				CourseDirector currentUser = new CourseDirector();
				// Class Directors can View Courses, Add Courses, and Add Requirements to Course
				System.out.println("If you want ot view courses, please enter 0");
				System.out.println("If you want to add courses, please enter 1");
				System.out.println("If you want to add requirements to course, please enter 2");
				int order = Integer.parseInt(input.nextLine());
				currentUser.getOptions(order, lister);
			} else {
				System.out.println("Invalid User Type!");
				active = false;
				break;
			}

			input.close();
			///// TBD

			active = false;
		}

		// SECTION 3: rewrite into file

		
	}
}
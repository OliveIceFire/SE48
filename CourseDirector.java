import java.util.Scanner;

public class CourseDirector {
	public CourseDirector() {}
	
	public  void getOptions(int order, Lists lister) {
		//Class Directors can View Courses, Add Courses, and Add Requirements to Course
		switch(order) {
		
		case 0:
			//0.View Courses
			System.out.println(lister.getCourses());
			break;
		case 1:
			//1.Add Courses
			Scanner sc = new Scanner(System.in);
			System.out.println("Please enter the name of the course");
			String courseName = sc.nextLine();
			System.out.println("Please enter the id of the course");
			String id = sc.nextLine();
			System.out.println("Please enter the dirId of the course");
			String dirId = sc.nextLine();
			Course newCourse = new Course(courseName, id, dirId);
			lister.addCourse(newCourse);
			System.out.println("Add course successfully.");
			break;
		case 2:
			Scanner sc2 = new Scanner(System.in);
			//2.Add Requirements to Course
			System.out.println("Please enter the id of the course");
			String id2= sc2.nextLine();
			Course course = null;
			for(Course c: lister.getCourses()) {
				if(c.getId().equals(id2)) {
					course=c;
				}
			}
			if(course==null) {
				System.out.println("The id does not exist.");
				return;
			}
			System.out.println("Please enter a requirement of the course");
			String requirement = sc2.nextLine();	
			course.addRequirement(requirement);			
		
		
		break;
		}
	}
}

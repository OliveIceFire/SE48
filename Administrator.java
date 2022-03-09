import java.util.Scanner;

public class Administrator {
	public Administrator() {}
	
	public void getOptions(int order, Lists lister) {
		switch(order) {
//		View Courses, View Teachers, Assign Teacher to Course, and Add Training
		case 0:
			//0.View Courses,
			System.out.println(lister.getCourses());
			break;
		case 1:
			//1.View Teachers
			System.out.println(lister.getTeachers());
			break;
		case 2:
			//2.Assign Teacher to Course
			Scanner sc = new Scanner(System.in);
			System.out.println("Please enter teacher name");
			String teacherName= sc.nextLine();
			System.out.println("Please enter course name");
			String courseName = sc.nextLine();
			Teacher teacher=null;
			for(Teacher t:lister.getTeachers()) {
				if(t.getName().equals(teacherName)) {
					teacher=t;
				}
			}
			for(Course c: lister.getCourses()) {
				if(c.getName().equals(courseName)) {
					c.assignTeach(teacher);
				}
			}
			break;
		case 3:
			//3.Add Training

			break;

		}
	}
}

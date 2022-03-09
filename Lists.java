import java.io.PrintStream;
import java.util.ArrayList;

// based on LoP class

public class Lists {
	private ArrayList<Teacher> teachList;
	private ArrayList<Course> courseList;

	public Lists() {
		teachList = new ArrayList<Teacher>();
		courseList = new Arraylist<Course>();
	}

	// add and remove for teachers
	public void addTeach(Teacher t) {
		teachList.add(t);
	}

	public void removeTeach(Teacher t) {
		teachList.remove(t);
	}

	// add and remove for courses
	public void addCourse(Course c) {
		courseList.add(c);
	}

	public void removeCourse(Course c) {
		courseList.remove(c);
	}

	// print teacher list
	public void printTeach(PrintStream pt) {
		for (int x = 0; x < teachList.size(); x++) {
			pt.print(teachList.get(x).toString()); // using Teacher class's toString method
		}
		pt.println();
	}

	// print course list
	public void printCourse(PrintStream pc) {
		for (int x = 0; x < courseList.size(); x++) {
			pc.print(courseList.get(x).toString()); // using Course class's toString method
		}
		pc.println();
	}


	
}
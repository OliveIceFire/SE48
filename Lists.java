import java.io.PrintStream;
import java.util.ArrayList;

// based on LoP class

public class Lists {
	private ArrayList<Teacher> teachList;
	private ArrayList<Course> courseList;
	private ArrayList<CourseDirector> cDirList;

	public Lists() {
		teachList = new ArrayList<Teacher>();
		courseList = new ArrayList<Course>();
		cDirList = new ArrayList<CourseDirector>();
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

	// add and remove for course directors (no need for print statements for CDs)
	public void addDir(CourseDirector cd) {
		cDirList.add(cd);
	}

	public void removeDir(CourseDirector cd) {
		cDirList.remove(cd);
	}

	// print teacher list
	public void printTeach(PrintStream pt) {
		for (int x = 0; x < teachList.size(); x++) {
			pt.print(teachList.get(x).toString() + "\n"); // using Teacher class's toString method
		}
		pt.println();
	}

	// print course list
	public void printCourse(PrintStream pc) {
		for (int x = 0; x < courseList.size(); x++) {
			pc.print(courseList.get(x).toString() + "\n"); // using Course class's toString method
		}
		pc.println();
	}


	
}
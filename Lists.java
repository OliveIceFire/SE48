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

	// getter for teachlist
	public ArrayList<Teacher> getTeachList() {
		return teachList;
	}
	// add, remove, and find for teachers
	public void addTeach(Teacher t) {
		teachList.add(t);
	}

	public void removeTeach(Teacher t) {
		teachList.remove(t);
	}

	public Teacher findTeach(String id) {
		for (int x = 0; x < teachList.size(); x++) {
			if (teachList.get(x).getID().equals(id)) {
				return teachList.get(x);
			}
		}
		return null;
	}

	// getter for courselist
	public ArrayList<Course> getCourseList() {
		return courseList;
	}
	// add, remove, and find for courses
	public void addCourse(Course c) {
		courseList.add(c);
	}

	public void removeCourse(Course c) {
		courseList.remove(c);
	}

	public Course findCourse(String id) {
		for (int x = 0; x < courseList.size(); x++) {
			if (courseList.get(x).getID().equals(id)) {
				return courseList.get(x);
			}
		}
		return null;
	}

	// add, remove, and find for course directors (no need for print statements for CDs)
	public void addDir(CourseDirector cd) {
		cDirList.add(cd);
	}

	public void removeDir(CourseDirector cd) {
		cDirList.remove(cd);
	}

	public CourseDirector findCourseDirector(String id) {
		for (int x = 0; x < cDirList.size(); x++) {
			if (cDirList.get(x).getID().equals(id)) {
				return cDirList.get(x);
			}
		}
		return null;
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
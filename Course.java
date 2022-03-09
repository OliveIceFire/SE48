import java.util.ArrayList; // using an ArrayList rather than an array as it's more dynamic

public class Course {
	private String name;
	private String id; // use ID numbers as a Primary Key
	private ArrayList<String> requirements;
	private Teacher teacher;
	private String dirID; // ID for course director


	public Course(name, id, dirID) {
		this.name = name;
		this.id = id;
		this.dirID = dirID;
		this.teacher = null;
		requirements = new ArrayList<String>();

	}

	public void addRequirement(String r) {
		requirements.add(r);
	}
	public void removeRequirement(String r) {
		requirements.remove(r);
	}

	// setter and getter for teacher
	public void assignTeach(Teacher t) {
		this.teacher = t;
	}
	public String getTeacher() {
		return this.teacher.toString();
	}


	// setter and getter for dirID
	public void changeDirector(String d) {
		this.dirID = d;
	}
	public String getDirectorID() {
		return this.dirID;
	}

	public String toString() {
		String result = "Course Name: " + this.name + "\n";
		result = result + "\tCourse Requirements: ";
		// for loop to go through and append requirements to result
		for (int x = 0; x < requirements.size(); x++) {
			result = result + ", " + requirements.get(x);
		}
		return result;

	}
}
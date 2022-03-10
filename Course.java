import java.util.ArrayList; // using an ArrayList rather than an array as it's more dynamic

public class Course {
	private String name;
	private String id; // use ID numbers as a Primary Key
	private ArrayList<String> requirements;
	private Teacher teacher;
	private CourseDirector director;


	public Course(String name, String id, CourseDirector cd) {
		this.name = name;
		this.id = id;
		this.director = cd;
		this.teacher = null;
		requirements = new ArrayList<String>();

	}

	public String getName() {
		return this.name;
	}

	public String getID() {
		return this.id;
	}

	public void addRequirement(String r) {
		requirements.add(r);
	}
	public void removeRequirement(String r) {
		requirements.remove(r);
	}

	public ArrayList<String> getRequirements() {
		return this.requirements;
	}

	// setter and getter for teacher
	public void assignTeach(Teacher t) {
		this.teacher = t;
		t.addCourse(this);
	}
	public Teacher getTeacher() {
		return this.teacher;
	}


	// setter and getter for dirID
	public void changeDirector(CourseDirector d) {
		this.director = d;
	}
	public String getDirectorID() {
		return this.director.getID();
	}

	public String toString() {
		String result = "Course Name: " + this.name + "\n"
						+ "Course ID: " + this.id + "\n";
		result = result + "Assigned Teacher: ";
		if (this.teacher != null) {
			result = result + this.teacher.getName() + ", ID: " + this.teacher.getID() + "\n";
		} else {
			result = result + "None\n";
		}

		result = result + "\tCourse Teaching Requirements: " + requirements.get(0);
		// for loop to go through and append rest of requirements to result
		if (requirements.size() > 1) {
            // for loop to go through and append rest of qualifications to result
		    for (int x = 1; x < requirements.size(); x++) {
			    result = result + ", " + requirements.get(x);
	    	}
        } 
		return result + "\n";

	}
}
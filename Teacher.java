import java.util.ArrayList;

public class Teacher implements DataType {
    private String name;
    private String id;
    private ArrayList<String> qualifications;
    private Course course;

    public Teacher(String name, String id) {
        this.name = name;
        this.id = id;
        this.qualifications = new ArrayList<String>();
        this.course = null;
    }

    public String getID() {
        return this.id;
    }

    public void addQualification(String q) {
        qualifications.add(q);
    }
    public void removeQualification(String q) {
        qualifications.remove(q);
    }

    public void addCourse(Course c) {
        this.course = c;
    }

    public void removeCourse(Course c) {
        this.course = null;
    }

    public String toString() {
        String result = "Teacher Name: " + this.name + "\n";
        if (this.course != null) {
            result = result + "Course Taught: " + this.course.getName();
        }
        result = result + "\tQualifications: " + qualifications.get(0);
        // for loop to go through and append rest of qualifications to result
		for (int x = 1; x < qualifications.size(); x++) {
			result = result + ", " + qualifications.get(x);
		}
        return result;

    }

}

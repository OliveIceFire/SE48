import java.util.ArrayList;

public class Teacher {
    private String name;
    private String id;
    private ArrayList<String> qualifications;
    private ArrayList<String> needsTraining;
    private Course course;

    public Teacher(String name, String id) {
        this.name = name;
        this.id = id;
        this.qualifications = new ArrayList<String>();
        this.needsTraining = new ArrayList<String>();
        this.course = null;
    }

    public String getName() {
        return this.name;
    }

    public String getID() {
        return this.id;
    }

    // get, add and remove qualifications
    public ArrayList<String> getQualifications() {
        return this.qualifications;
    }

    public void addQualification(String q) {
        qualifications.add(q);
    }
    public void removeQualification(String q) {
        qualifications.remove(q);
    }

    // get, add and remove trainings
    public ArrayList<String> getTrainings() {
        return this.needsTraining;
    }
    public void addTraining(String t) {
        needsTraining.add(t);
    }
    public void removeTraining(String t) {
        needsTraining.remove(t);
    }

    // add and remove course
    public void addCourse(Course c) {
        this.course = c;
    }

    public void removeCourse(Course c) {
        this.course = null;
    }

    // toString method
    public String toString() {
        String result = "Teacher Name: " + this.name + "\n";
        result = result + "Teacher ID: " + this.id + "\n";
        result = result + "Course Taught: ";
        if (this.course != null) {
            result = result + this.course.getName();
        } else {
            result = result + "None";
        }

        result = result + "\n\tTeaching Qualifications: ";
        if (this.qualifications.size() < 0) {
             result = result + qualifications.get(0);
            if (qualifications.size() > 1) {
                // for loop to go through and append rest of qualifications to result
		        for (int x = 1; x < qualifications.size(); x++) {
			        result = result + ", " + qualifications.get(x);
	    	    }
            } 
        }

        result = result + "\n\tNeeds Training In: ";
        if (this.needsTraining.size() > 0) {
            if (needsTraining.size() == 1) {
                result = result + needsTraining.get(0);
            } else {
                if (needsTraining.size() > 1) {
                    result = result + needsTraining.get(1);
                    // for loop to go through and append rest of training reqs to result
                    for (int x = 2; x < needsTraining.size(); x++) {
                        result = result + ", " + needsTraining.get(x);
                    }
                } 
            } 
        }
        return result + "\n";

    }

}

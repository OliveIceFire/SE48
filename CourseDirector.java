import java.util.ArrayList;
//import java.util.Scanner;

public class CourseDirector implements User {
    private String id;
    private ArrayList<Course> courses;

    public CourseDirector(String id) {
        this.id = id;
        courses = new ArrayList<Course>();
    }

    public void assignCourse(Course c) {
        courses.add(c);
        c.changeDirector(this);
    }

    public String getID() {
        return this.id;
    }

    public void getOptions() {

    }
    
}

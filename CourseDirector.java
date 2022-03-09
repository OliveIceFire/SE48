import java.util.ArrayList;
import java.util.Scanner;

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

    public void getOptions(Lists l) {
        String intromessage = "You are the director for:\n\t" + courses.get(0).getName() + " ID: " + courses.get(0).getID();
        // additional courses
        if (courses.size() > 1) {
            for (int x = 1; x < courses.size(); x++) {
                intromessage = intromessage + "\n\t" + courses.get(x).getName() + " ID: " + courses.get(x).getID();
            }
        }
        System.out.println(intromessage);
        boolean active = true;
        while(active) {
            Scanner input = new Scanner(System.in);
            System.out.println("Please Select an Action:\n\tEnter Requirements\n\tAdd Course\n\tView My Courses\n\tView All Courses");
            String action1 = input.nextLine();

            if (action1.equals("Enter Requirements")) {
                System.out.println("Please enter the course ID.");
                String courseID = input.nextLine();
                Course changedCourse = l.findCourse(courseID); // locating course to be amended
                System.out.println("Please enter new requirements, " + 
                "separated by a comma (e.g., English, Math, French)");
                String[] newReqs = (input.nextLine()).split("[\\,]");
                for (int x = 0; x < newReqs.length; x++) {
                    changedCourse.addRequirement(newReqs[x]);
                }
                System.out.println("Requirements added!");
            } else if (action1.equals("Add Course")) {
                System.out.println("Please enter the course name:");
                String coursename = input.nextLine();
                System.out.println("Please enter the course ID:");
                String courseID = input.nextLine();
                l.addCourse(new Course(coursename, courseID, this));
                System.out.println("Course added!");
            } else if (action1.equals("View My Courses")) {
                if (this.courses.size() > 0) {
                    for (int x = 0; x < this.courses.size(); x++) {
                        System.out.println(courses.get(x).toString());
                    }
                 } else {
                        System.out.println("You are not the director for any courses.");
                    }
            } else if (action1.equals("View All Courses")) {
                l.printCourse(System.err);
            } else {
                System.out.println("Invalid choice!");
                continue;
            }

            // ask if User wants to go to other options
            System.out.println("Please Select an Action: \n\tExit\n\tChoose Another Action");
            String action2 = input.nextLine();
            if (action2.equals("Exit")) {
                active = false;
            } else if (action2.equals("Choose Another Action")) {
                continue;
            } else {
                System.out.println("Invalid choice!");
                continue;
            }
            input.close();
        }

    }
    
}

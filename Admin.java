import java.util.Scanner;

public class Admin implements User {
    public void getOptions(Lists l) {
        String intromessage = "Welcome to the Admin Page!";
        System.out.println(intromessage);
        
        boolean active = true;
        while (active) {
            Scanner input = new Scanner(System.in);
            System.out.println("Please Select an Action:\n\tView All Courses\n\tView Specific Course\n\tView All Teachers\n\tView Specific Teacher"
            + "\n\tAdd Teacher\n\tAssign Teacher to Course\n\tAssign Trainings to Teacher");
            String action1 = input.nextLine();

            if (action1.equals("View All Courses")) {
                l.printCourse(System.err);
            } else if (action1.equals("View All Teachers")) {
                l.printTeach(System.err);
            } else if (action1.equals("View Specific Course")) {
                System.out.println("Enter Course ID:");
                String courseID = input.nextLine();
                Course currentCourse = l.findCourse(courseID);
                System.out.println(currentCourse.toString());
            } else if (action1.equals("View Specific Teacher")) {
                System.out.println("Enter Teacher ID: ");
                String teachID = input.nextLine();
                Teacher currentTeacher = l.findTeach(teachID);
                System.out.println(currentTeacher.toString());
            } else if (action1.equals("Add Teacher")) {
                System.out.println("Please enter the new teacher's name:");
                String teachname = input.nextLine();
                System.out.println("Please enter the teacher ID:");
                String teachID = input.nextLine();
                l.addTeach(new Teacher(teachname, teachID));
                System.out.println("Teacher added!");
            } else if (action1.equals("Assign Teacher to Course")) {
                System.out.println("Enter Course ID: ");
                String courseID = input.nextLine();
                System.out.println("Enter Teacher ID: ");
                String teachID = input.nextLine();
                Course currentCourse = l.findCourse(courseID);
                Teacher currentTeacher = l.findTeach(teachID);
                // assign teacher to this course
                currentCourse.assignTeach(currentTeacher);
                System.out.println(currentTeacher.toString()); // FOR TESTING PURPOSES
                System.out.println("Assigned teacher to course.");
            } else if (action1.equals("Assign Trainings to Teacher")) {
                System.out.println("Please enter the teacher ID.");
                String teachID = input.nextLine();
                Teacher currentTeacher = l.findTeach(teachID);
                System.out.println("Please enter trainings, separated by " +
                                    "a comma (e.g., English, Math, French)");
                String[] newTrains = (input.nextLine()).split(", ");
                for (int x = 0; x < newTrains.length; x++) {
                    currentTeacher.addTraining(newTrains[x]);
                }
                System.out.println("Trainings added!");
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

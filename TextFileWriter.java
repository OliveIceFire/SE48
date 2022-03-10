import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TextFileWriter implements FileInterface {
    private String fileName;

    public TextFileWriter(String fileName) {
        this.fileName = fileName;
    }

    // used to write existing Lists object into the file
    public void getFile(Lists l) {
        ArrayList<Course> courseList = l.getCourseList();
        ArrayList<Teacher> teachList = l.getTeachList();

        // create new file (as original was deleted)
        try {
            File finalFile = new File(this.fileName);
            finalFile.createNewFile();
        } catch (IOException e) {
            System.out.println("Error, file not created.");
        }

        // use ArrayLists to write new file
        try {
            FileWriter writer = new FileWriter(this.fileName);

            //TEACHERS
            if (teachList.size() > 0) {
                for(int x = 0; x < teachList.size(); x++) {
                    Teacher current = teachList.get(x);
                    String toWrite = "Teacher," + current.getName() + "," +
                                    current.getID() + ",";
                    // loop for qualifications
                    ArrayList<String> quals = current.getQualifications();
                    if (quals.size() > 0) {
                        toWrite = toWrite + quals.get(0);
                        if (quals.size() > 1) {
                            for(int y = 1; y < quals.size(); y++) {
                                toWrite = toWrite + "|" + quals.get(y);
                            }
                        }
                    }

                    toWrite = toWrite + ",";

                    //loop for trainings
                    ArrayList<String> trainings = current.getTrainings();
                    if (trainings.size() > 0) {
                        toWrite = toWrite + trainings.get(0);
                        if (trainings.size() > 1) {
                            for(int y = 1; y < trainings.size(); y++) {
                                toWrite = toWrite + "|" + trainings.get(y);
                            }
                        }
                    } else { // add space (required for future read-ins)
                        toWrite = toWrite + " ";
                    }

                    // write line to file
                    writer.write(toWrite + "\n");
                }
            }

            //COURSES
            if (courseList.size() > 0) {
                for(int x = 0; x < courseList.size(); x++) {
                    Course current = courseList.get(x);
                    String toWrite = "Course," + current.getName() + "," +
                                    current.getID() + ",";
                    // loop for requirements
                    ArrayList<String> reqs = current.getRequirements();
                    if (reqs.size() > 0) {
                        toWrite = toWrite + reqs.get(0);
                        if (reqs.size() > 1) {
                            for(int y = 1; y < reqs.size(); y++) {
                                toWrite = toWrite + "|" + reqs.get(y);
                            }
                        }
                    }
                    // add director ID
                    toWrite = toWrite + "," + current.getDirectorID() + ",";

                    // add potential teacher ID
                    if (current.getTeacher() != null) {
                        toWrite = toWrite + current.getTeacher().getID();
                    } else { // add space (required for future read-ins)
                        toWrite = toWrite + " ";
                    }

                    // write line to file
                    writer.write(toWrite + "\n");
                }
            }

            writer.close();
            System.out.println("Wrote to file.");
        } catch (IOException e) {
            System.out.println("Error.");
        }




        

    }
}

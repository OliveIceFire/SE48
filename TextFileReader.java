import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextFileReader implements FileInterface {
    private String fileName;

    public TextFileReader(String fileName) {
        this.fileName = fileName;
    }

    // read from permData.txt file and create Lists object
    public void getFile(Lists l) {
        FileReader reader = null;
        try {
            reader = new FileReader(this.fileName);
            Scanner scan = new Scanner(reader);
            while(scan.hasNextLine()) {
				String line = scan.nextLine();
				String[] values = line.split("[\\,]"); // splits line into array based on commas

				// if line is for a Teacher object
				if (line.contains("Teacher")) {
					String name = values[1];
					String id = values[2];
					String[] qualifications = values[3].split("\\|");
                    String [] trainings = values[4].split("\\|");
					Teacher t = new Teacher(name, id); // create new teacher object
					for(int x = 0; x < qualifications.length; x++) {
						t.addQualification(qualifications[x]); // add qualifications to object t
					}
                    for(int x = 0; x < trainings.length; x++) {
                        t.addTraining(trainings[x]);
                    }

					// add object to teacher list
					l.addTeach(t);

				} else if (line.contains("Course")) { // if line is for a Course object
					String name = values[1];
					String id = values[2];
					String[] requirements = values[3].split("\\|");
                    CourseDirector director; // initializing director, BUT one director can have multiple courses
					String cdID = values[4];
                    if (l.findCourseDirector(cdID) != null) {
                        director = l.findCourseDirector(cdID);
                    } else {
                        director = new CourseDirector(cdID);
                    }
					Course c = new Course(name, id, director);
					for(int x = 0; x < requirements.length; x++) {
						c.addRequirement(requirements[x]);
					}
					// check if there is an existing teacher assigned to this course
					Teacher teach; //initializing teacher
					String teachID = values[5];
					if (!teachID.equals(" ")) { // if there is an assigned teacher
							teach = l.findTeach(teachID); // find in teacher list
							c.assignTeach(teach); // assign to course
						} 
					
					// add object to course list
					l.addCourse(c);
					// assign course to appropriate director
					director.assignCourse(c);
					l.addDir(director);
				}

		}
			scan.close();


		} catch (FileNotFoundException e) {
			System.out.println("The file " + fileName + " can't be found!");
		}
        
    }

    public void deleteFile() {
        File deletable = new File(this.fileName);
        if(deletable.delete()) {
            System.out.println(this.fileName + " deleted.");
        } else {
            System.out.println("Failed to delete.");
        }
    }
}

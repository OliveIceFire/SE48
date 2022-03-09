import java.util.ArrayList;

public class TextFileWriter implements FileInterface {
    private String fileName;

    public TextFileWriter(String fileName) {
        this.fileName = fileName;
    }

    // used to write existing Lists object into the file
    public void getFile(Lists l) {
        ArrayList<Course> courseList = l.getCourseList();
        ArrayList<Teacher> teachList = l.getTeachList();
        ArrayList<CourseDirector> dirList = l.getDirList();

    }
}

import java.util.ArrayList;
import java.util.List;

public class Teacher {
	String name;
	String id;
	List<String> Teachers = new ArrayList<>();
	public Teacher(String name, String id) {
		this.name=name;
		this.id=id;
	}
	public void addQualification(String string) {
		// TODO Auto-generated method stub
		Teachers.add(string);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<String> getTeachers() {
		return Teachers;
	}
	public void setTeachers(List<String> teachers) {
		Teachers = teachers;
	}
}

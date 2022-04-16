import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Group {
	private ArrayList<Student> group;
	private String name;
	
	public Group(Student[] students,String name) {
		this.group = Arrays.stream(students)
		.collect(Collectors.toCollection(ArrayList::new));
		this.name = name;
	}
	
	public ArrayList<Student> getFirstLatterStud(char lat) {
		ArrayList<Student> list = group.stream().filter(n -> n.getName().substring(0,1).equals(String.valueOf(lat)))
		.collect(Collectors.toCollection(ArrayList::new));
		return list;
	}
	
	@Override
	public String toString() {
		String res = "Group: "+name+"\n";
		for (Student temp: group) {
			res = res +temp.toString();
		} 
		return res;
	}
}

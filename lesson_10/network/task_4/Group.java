import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Collectors;

public class Group {
	private ArrayList<Human> group = new ArrayList<Human>();
	private String name;
	private int course;
	
	public Group(String name,int course) {
		this.name = name;
		this.course = course;
	}
	
	public void addStudent(Human h) {
		boolean check = true;
		Iterator<Human> itr = group.iterator();
		while (itr.hasNext()) {
			if (itr.next().equals(h)) {
				check = false;
			}
		}
		if (check == true) {
			group.add(h);
		}
		System.out.println("Added student to group");
	}
	
	public void deleteStudent(Human h) {
		group.remove(h);
		System.out.println("Deleted student form group");
	}
	
	public Human searchBylastName(String lastame) {
		Iterator <Human> itr = group.iterator();
		for (;itr.hasNext();) {
			Human temp = itr.next();
			if (temp.getLastName().equals(lastame)) {
				return temp;
			}
		}
		return null;
	}
	
	public String sortBylastName() {
		group = group.stream().sorted((a,b)-> a.getLastName().compareTo(b.getLastName())).collect(Collectors.toCollection(ArrayList::new));
		return "Group sorted by lastname";
	}
	
	@Override
	public String toString() {
		return "Group name:"+name+"\tCourse:"+course+" "+group.toString();
	}
}

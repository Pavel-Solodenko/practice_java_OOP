import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Iterator;

public class Group {
	private SortedSet<Human> group = new TreeSet<Human>(new GroupComparator());
	private String name;
	
	public Group(String name) {
		this.name = name;
	}
	
	public void addToGroup(Human human) {
		group.add(human);
	}
	
	public void removeFromGroup(String name) {
		Human temp;
		Iterator<Human> i = group.iterator();
		for (;i.hasNext();) {
			temp = i.next();
			if (temp.getName().equals(name)) {
				group.remove(temp);
				System.out.println("Deleted");
				return;
			}
		}
		System.out.println("Student not found");
	}
	
	@Override
	public String toString() {
		return "Group "+ name +" :" + "\n" +Arrays.toString(group.toArray());
	}
}

import java.io.Serializable;

public class Group implements Serializable{
	private Human[] group;
	private static final long serialVersionUID = 1L;
	
	public Group() {
		group = new Human[0];
	}
	
	public void addHuman(String name, int age, char sex) {
		Human[] c = new Human[group.length+1];
		System.arraycopy(group, 0, c, 0, group.length);
		c[c.length-1] = new Human(name,age,sex);
		group = c;
	}
	
	public void printGroup() {
		for (Human k: group) {
			System.out.println(k);
		}
	}
}

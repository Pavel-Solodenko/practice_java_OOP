import java.util.*;

public class Main {
	public static void main(String[] args) {
		Group group1 = new Group("IPZ-22");
		group1.addToGroup(new Human("Vasya",19,'ì'));
		group1.addToGroup(new Human("Katya",20,'æ'));
		group1.addToGroup(new Human("Alex",17,'ì'));
		System.out.println(group1.toString());
		group1.removeFromGroup("Katya");
		System.out.println(group1.toString());
	}
}

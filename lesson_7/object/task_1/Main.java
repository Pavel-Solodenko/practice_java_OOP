import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
	public static void main(String[] args) {
		Human h1 = new Human("Vasya",19,'ì');
		Human h2 = new Human("Petya",20,'ì');
		
		Group IPZ22 = new Group();
		IPZ22.addHuman("Vasya",19,'ì');
		IPZ22.addHuman("Petya",20,'ì');
		Group IPZ222 = new Group();
		
		try (ObjectOutputStream OOS = new ObjectOutputStream(new FileOutputStream("fil.txt"))) {
			OOS.writeObject(IPZ22);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		try(ObjectInputStream IOS = new ObjectInputStream(new FileInputStream("fil.txt"))) {
			IPZ222 = (Group)IOS.readObject();
		}
		catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		IPZ222.printGroup();
	}
}

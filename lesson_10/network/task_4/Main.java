import java.io.IOException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
	public static void main(String[] args) {
		String ansver = "";
		Group gr1 = new Group("EP-41",4);
		gr1.addStudent(new Human("Nikita","Petrov",20,'m'));
		gr1.addStudent(new Human("Kate","Lushanka",21,'f'));
		gr1.addStudent(new Human("Pavel","Reznikov",19,'m'));
		gr1.addStudent(new Human("Petr","Vasylev",18,'m'));
		gr1.addStudent(new Human("Yaroslav","Boyko",20,'m'));
		gr1.addStudent(new Human("Nastya","Andreeva",19,'f'));
		
		ansver += "<html><head><title>Interface group</title><meta charset='utf-8'></head><body>";
		Method[] m = gr1.getClass().getDeclaredMethods();
		for (int i = 0; i < m.length;++i) {
			if (m[i].getName().equals("lambda$0")) {
				continue;
			}
			ansver += "<p>"+"<a href=\"http://127.0.0.1:8080/"+m[i].getName()+"\">"+m[i].getName()+"</a>"+"</p>";
		}
		ansver += "</body></html>";
		try (ServerSocket soc = new ServerSocket(8080))	{
			for (;;) {
				Socket cl = soc.accept();
				Client client = new Client(cl,ansver,gr1);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}

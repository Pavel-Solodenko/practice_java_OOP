import java.io.IOException;
import java.net.*;

public class Main {
	public static void main(String[] args) {
		int num = 0;
		String ansver = "<html><head><meta charset='utf-8'></head><body>";
//		String end = "</body></html>";
		try (ServerSocket soc = new ServerSocket(1111)) {
			for(;;) {
				Socket socket = soc.accept();
				ansver += "<p>"+System.getProperty("os.name")+"</p>";
				ansver += "<p>"+num++ + "</p>";
				Client cli = new Client(socket,ansver);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void a(Socket soc) {
		try {
			System.out.println(soc.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

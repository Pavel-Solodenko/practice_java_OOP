import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.*;

public class Client implements Runnable{
	private Socket soc;
	private String ansv;
	private Thread t;
	
	public Client(Socket soc,String ansv) {
		super();
		this.soc = soc;
		this.ansv = ansv;
		t = new Thread(this);
		t.start();
	}
	
	@Override
	public void run() {
		try (InputStream is = soc.getInputStream();OutputStream os = soc.getOutputStream();
				PrintWriter pw = new PrintWriter(os)) {
			byte[] buffer = new byte[is.available()];
			is.read(buffer);
			String text = "";
			for (int i = 0; i < buffer.length;++i) {
				text = text + Character.toString((char)buffer[i]);
			}
			System.out.println(text);
			String response = "HTTP/1.1 200 OK\r\n"+"Server: My_Server\r\n"+"Content-type:text/html\r\n"
			+"Content-Length: "+"\r\n"+"Connection: close\r\n\r\n";
			pw.write(response+ansv);
			pw.flush();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}

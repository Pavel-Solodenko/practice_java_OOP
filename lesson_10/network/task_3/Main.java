import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
	public static void main(String[] args) {
		ArrayList<String> links = new ArrayList<String>();
		String html = "https://geekhacker.ru/elektronnaya-pochta-registraciya-besplatno/";
		String path_out = "C:\\eclipse_present_projects\\Network_3\\links.txt";
		String text ="";
		try {
			URL url = new URL(html);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			InputStream is = con.getInputStream();
			byte[] buffer = new byte[1024];
			while (is.available() > 0) {
				is.read(buffer);
				text = text + new String(buffer,"UTF-8");
			}
			System.out.println(text+"\n\n"+"end of the text"+"\n\n");
			is.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		if (text.contains("href=")) {
			while (text.contains("http://")) {
			int begin = text.indexOf("href=");
			String temp = text.substring(begin);
			begin = temp.indexOf("http://");
			temp = temp.substring(begin);
			int end = temp.indexOf("\"");
			links.add(temp.substring(0,end));
			text = temp.substring(end);
			}	
		}
		
		if (text.contains("href=")) {
			while (text.contains("https://")) {
			int begin = text.indexOf("href=");
			String temp = text.substring(begin);
			begin = temp.indexOf("https://");
			if (begin < 0) {break;}
			temp = temp.substring(begin);
			int end = temp.indexOf("\"");
			links.add(temp.substring(0,end));
			text = temp.substring(end);
			}	
		}
		links.forEach(System.out::println);
		saveToFile(path_out,links);
	}
	public static void saveToFile(String path,ArrayList<String> links) {
		
		try (FileOutputStream fout = new FileOutputStream(path))	{
			Iterator<String> itr = links.iterator();
			for (;itr.hasNext();) {
				fout.write((itr.next()+"\r\n").getBytes());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

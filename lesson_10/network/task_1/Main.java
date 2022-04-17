import java.io.FileInputStream;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		String path = "C:\\eclipse_present_projects\\Network_1\\sites.txt";
		checkURL(readFromFile(path));
	}
	public static void checkURL(ArrayList<String> links) {
		for (String link : links) {
			try {
				URL url = new URL(link);
				HttpURLConnection hurl = (HttpURLConnection) url.openConnection();
				System.out.println("Status:"+hurl.getResponseCode()+"\tMessage:"+hurl.getResponseMessage()+"\tSite: "+link+"\n");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static ArrayList<String> readFromFile(String path) {
		String text = "";
		try {
			FileInputStream fis = new FileInputStream(path);
			while (fis.available() > 0) {
				text = text + Character.toString((char)fis.read());
			}
			fis.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		ArrayList<String> links = new ArrayList<String>(Arrays.asList(text.split("\r\n")));
		return links;
	}
}

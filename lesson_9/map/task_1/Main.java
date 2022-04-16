import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String path = "C:\\eclipse_present_projects\\Map_1\\in.txt";
		String path_out = "C:\\eclipse_present_projects\\Map_1\\out.txt";
		String text = "";
		text = readText(path);
		Vocabulary voc = new Vocabulary("C:\\eclipse_present_projects\\Map_1\\Vocabulary.txt");
		voc.init();
		askAdd(voc,sc);
		sc.close();
		writeText(path_out,voc.translate(findWords(text)));
	}
	public static void askAdd(Vocabulary voc,Scanner sc) {
		System.out.println("Do you want to add some words?"+"\n"+"Enter yes or no");
		if (sc.nextLine().equals("yes")) {
			boolean stop = false;
			while(!stop) {
				voc.manualAdd(sc);
				System.out.println("Contunue adding?");
				if (sc.nextLine().equals("no")) {
					stop = true;
				}
			}
		}
	}
	
	public static ArrayList<String> findWords(String text) {
		ArrayList<String> all_words = new ArrayList<String>();
		ArrayList<String> lines = new ArrayList<String>(Arrays.asList(text.split("\n")));
		Iterator<String> itr_lines = lines.iterator();
		for (;itr_lines.hasNext();) {
			String temp_line = itr_lines.next();
			ArrayList<String> temp_words = new ArrayList<String>(Arrays.asList(temp_line.split(" ")));
			all_words.addAll(temp_words);
		}
		return all_words;
	}
	
	public static void writeText(String path,ArrayList<String> translate_word) {
		Iterator<String> itr_word = translate_word.iterator();
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		try (FileOutputStream fot = new FileOutputStream(path)) {
			writer = new BufferedWriter(new OutputStreamWriter(fot));
			while(itr_word.hasNext()) {
				String temp = itr_word.next();
				if (temp.contains("\r")) {
					writer.write(temp+" ");
					writer.newLine();
				}
				else {
					writer.write(temp+" ");	
				}
			}
			writer.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Writing end");
	}
	
	public static String readText(String path) {
		String text = "";
		try (FileInputStream fis = new FileInputStream(path)) {
			while (fis.available() > 0) {
				text = text + Character.toString(fis.read());
			}
//			System.out.println(text);
//			System.out.println();
//			byte[] buffer = new byte[128];
//			for (;fis.read(buffer) > 0;) {
//				String temp_text = "";
//				for (int i = 0;i < buffer.length;++i) {
//					if (buffer[i] == 0) {
//						continue;
//					}
//					else {
//						temp_text = temp_text + Character.toString(buffer[i]);
//					}
//				}
//				text = text + temp_text;
//			}
		}
		catch (IOException e) {
			e.printStackTrace();		
			}
		return text;
	}
}
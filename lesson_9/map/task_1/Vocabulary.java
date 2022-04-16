import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Vocabulary {
	private Map<String,String> hm = new HashMap();
	private String path;
	
	public Vocabulary(String path) {
		this.path = path;
	}
	
	public void init() {
		String text = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try (FileInputStream fis = new FileInputStream(path);) {
			reader = new BufferedReader(new InputStreamReader(fis));
			while (reader.ready()) {
				text =  text + Character.toString((char)reader.read());
			}
			reader.close();
//			System.out.println(text);
//			byte[] buffer = new byte[128];
//			for (;fis.read(buffer) > 0;) {
//				String temp_text = "";
//				for (int i = 0; i < buffer.length;++i) {
//					if (buffer[i] == 0) {
//						continue;
//					}
//					System.out.println(buffer[i]);
//					temp_text = temp_text + Character.toString(buffer[i]);
//				}
//				text = text + temp_text;
//			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		ArrayList<String> pars = new ArrayList<String>(Arrays.asList(text.split("\n")));
		Iterator<String> itr_pars = pars.iterator();
		for (;itr_pars.hasNext();) {
			String temp = itr_pars.next();
			String[] K_V = temp.split(" ");
			hm.put(K_V[0], K_V[1]);
		}
	}
	
	@Override
	public String toString() {
		return hm.toString();
	}
	
	public ArrayList<String> translate(ArrayList<String> words) {
		ArrayList<String> translate_word = new ArrayList<String>();
		Iterator<String> itr_words = words.iterator();
		while (itr_words.hasNext()) {
			String temp = itr_words.next();
			if (temp.contains("\r")) {
				String t = temp.replace("\r", "");
				translate_word.add(hm.get(t)+"\r");
//				System.out.println();
			}
			else {
				if (hm.containsKey(temp)) {
//					System.out.println(hm.get(temp).replaceAll("r", "").replaceAll(" ", ""));
					translate_word.add(hm.get(temp).replaceAll("\r", "").replaceAll(" ", ""));
				}
				else {
					System.out.println("Not find in vocabulary - "+temp);
				}
			}	
		}
		return translate_word;
	}
}

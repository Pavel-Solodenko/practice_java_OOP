import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
  public static void main(String[] args) {
    String path1 = "C:\\Users\\User\\Desktop\\test_IO_NIO\\ответы_на_скрининг.txt";
		String path2 = "C:\\Users\\User\\Desktop\\test_IO_NIO\\Тест_ответы_на_скрининг.txt";
		String path_in = "C:\\Users\\User\\Desktop\\test_IO_NIO\\ответы_на_скрининг_total.txt";
		try (BufferedReader bf = new BufferedReader(new FileReader(path1));
			 PrintWriter pw = new PrintWriter(path_in);
			) {
			BufferedReader bf2 = new BufferedReader(new FileReader(path2));
			String str = "";
			for (;(str = bf.readLine()) != null;) {
				String[] words = str.split(" ");
				for (int i = 0;i < words.length;++i) {
					if (words[i].length() >= 3) {
						String st = "";
						//System.out.println(words[i]);
						bf2.close();
						bf2 = new BufferedReader(new FileReader(path2));
						for (;(st = bf2.readLine()) != null;) {
							String[] words2 = st.split(" ");
							for (int j = 0; j < words2.length;++j) {
								
								if (words2[j].length() >= 3 && words[i].equals(words2[j]) == true) {
									pw.println(words2[j]);
									//System.out.println(words2[j]);
								}
							}
						}
					}
				}
				str = "";
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		}
  }
}

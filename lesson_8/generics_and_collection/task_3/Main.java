import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		String path = "C:\\eclipse_present_projects\\Generics and Collection_2\\a.txt";
		Map <Character,Integer> map = new HashMap();
		try (FileInputStream fis = new FileInputStream(path)) {
			byte[] buffer = new byte[1024];
			for(;(fis.read(buffer)) > 0;) {
				fis.read(buffer);
				for (int k = 0; k < buffer.length;++k) {
					char t = (char)buffer[k];
					if (t == 0 || t == '\n' || t == '\r') {
						continue;
					}
//					System.out.print((char)buffer[k]);
					if (!map.containsKey((t))) {
						map.put(t, 1);
					}
					else {
						int temp = map.get((t));
						map.remove(t);
						temp++;
						map.put(t,temp);
					}
				}
			}
			fis.close();
			Stream<Entry<Character, Integer>> set = map.entrySet().stream().sorted(Map.Entry.<Character,Integer>comparingByValue().reversed());
			set.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

/*
 * —читайте из файла текст на английском €зыке, вычислите относительную частоту потворени€ каждой буквы и выведите на экран результат в пор€дке убывани€ относительной частоты повторени€.
 * */

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		//10,-10,0,8,12,-2,-1,-6  (numbers in file)
		String path = "C:\\eclipse_present_projects\\Stream API (Generics and Collection)_4\\a.txt";
		try (FileInputStream fis = new FileInputStream(path))	{
			ArrayList<Integer> list = new ArrayList<Integer>();
			byte[] buffer = new byte[1024];
			String temp ="";
			for (;fis.read(buffer) > 0;) {
				for (int i = 0; i < buffer.length;++i) {
					if (buffer[i] == 0) {
						continue;
					}
					temp = temp + Character.getNumericValue(buffer[i]);
				}
			}
			fis.close();
			String[] t = temp.split("-1");
			for (int i = 0;i < t.length;++i) {
				if(t[i].isEmpty()) {
					t[i+1] = "-"+t[i+1];
					list.add(Integer.valueOf(t[i+1]));
					i++;
				}
				else {
					list.add(Integer.valueOf(t[i]));
				}
			}
			int max = list.stream().max((a,b) -> a - b).get();
//			int min = list.stream().min((a,b)-> a - b).get();
			System.out.println(max);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}

/*
	Ќайдите максимальное число из набора чисел,которые хран€тс€ в текстовом файле.
*/
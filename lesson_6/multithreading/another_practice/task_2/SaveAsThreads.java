package another_practice_multithreading_2;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class SaveAsThreads implements Runnable{
	private Thread thr;
	private int[] numbers;
	private String path = "C:\\eclipse_present_projects\\another_practice_multithreading_2\\";
	
	public SaveAsThreads(int[] numbers) {
		this.numbers = numbers;
		thr = new Thread(this);
		thr.start();
		path = path + getEnter() + ".txt";
	}
	
	private int getEnter() {
		String all = thr.getName();
		String[] part = all.split("-");
		return Integer.parseInt(part[1]); 
	}
	
	
	@Override
	public void run() {
		System.out.println("Begin thread: " + thr.getName());
		try {
			FileOutputStream fOut = new FileOutputStream(path);
			PrintStream pS = new PrintStream(fOut);
			for (int i = 0; i < numbers.length;++i) {
				pS.print(numbers[i] + " ");
			}
			pS.close();
			fOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("End thread: " + thr.getName());
	}
}

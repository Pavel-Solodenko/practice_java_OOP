package another_practice_multithreading_1;

public class Max implements Runnable{
	private int[] numbers;
	private int maximum = 0;
	private Thread curThr;
	
	public Max(int[] numbers) {
		this.numbers = numbers;
		curThr = new Thread(this);
		curThr.start();
	}
	
	@Override
	public void run() {
		for (int i = 0; i < numbers.length;++i) {
			if (numbers[i] > maximum) {
				maximum = numbers[i];
			}
		}
		System.out.println(curThr.getName()+"\n");
		System.out.println(maximum + "\n");
	}
	
	
}

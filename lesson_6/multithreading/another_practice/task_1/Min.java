package another_practice_multithreading_1;

public class Min implements Runnable{
	private int[] numbers;
	private int minimum;
	private Thread curThr;
	
	public Min(int[] numbers) {
		this.numbers = numbers;
		this.minimum = numbers[0];
		curThr = new Thread(this);
		curThr.start();
	}
	
	@Override
	public void run() {
		for (int i = 0; i < numbers.length;++i) {
			if (numbers[i] < minimum) {
				minimum = numbers[i];
			}
		}
		System.out.println(curThr.getName()+"\n");
		System.out.println(minimum + "\n");
	}
	
}

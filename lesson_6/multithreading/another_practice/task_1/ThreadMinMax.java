package another_practice_multithreading_1;

public class ThreadMinMax implements Runnable{
	private int[] numbers;
	private Thread thr;
	
	public ThreadMinMax(int[] numbers) {
		this.numbers = numbers;
		thr = new Thread(this);
		thr.start();
	}
	
	@Override
	public void run() {
		Max max = new Max(numbers);
		Min min = new Min(numbers);
	}
}

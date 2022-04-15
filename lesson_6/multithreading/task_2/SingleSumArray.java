package multithreading_part_1;

public class SingleSumArray implements Runnable{
	private int[] numbers;
	private int begin;
	private int end;
	private Thread thr;
	private int sum = 0;
	SingleSumArray(int[] array,int begin,int end) {
		super();
		this.numbers = array;
		this.begin = begin;
		this.end = end;
		thr = new Thread(this);
		thr.start();
	}
	@Override
	public void run() {
		for (int i = begin; i < end;++i) {
			sum = sum + numbers[i];
		}
	}
	public int getSum() {
		return sum;
	}
	public Thread getThread() {
		return thr;
	}
}

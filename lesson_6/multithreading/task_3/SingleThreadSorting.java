package multithreading_part_1_2;

public class SingleThreadSorting implements Runnable{
	private int[] array;
	private int begin;
	private int end;
	private Thread thr;
	private int index;
	public SingleThreadSorting(int[] arr,int begin,int end) {
		this.array = arr;
		this.begin = begin;
		this.end = end;
		thr = new Thread(this);
		thr.start();
		this.index = begin;
	}
	
	public Thread getThr() {
		return thr;
	}
	public int poolElement() {
		int temp = array[index];
		return temp;
	}
	
	public int peekElement() {
		return array[index];
	}
	
	@Override
	public void run() {
		int temp;
		for (int o = 0; o < array.length;++o) {
			for (int i = 0; i < array.length - 1; ++i) {
				if (array[i] > array[i+1]) {
					temp = array[i];
					array[i] = array[i+1];
					array[i+1] = temp;
				}
			}
		}
	}
	
	public void printArray() {
		for (int i = 0;i < array.length;++i) {
			System.out.print(array[i] + " ");
		}
	}
}

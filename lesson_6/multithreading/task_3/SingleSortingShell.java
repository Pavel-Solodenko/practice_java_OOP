package multithreading_part_1_2;

public class SingleSortingShell implements Runnable{
	private int[] array;
	private int begin;
	private int end;
	private int index;
	private Thread thr;
	private boolean stop = false;
	
	public SingleSortingShell(int array[],int begin,int end) {
		super();
		this.array = array;
		this.begin = begin;
		this.end = end;
		thr = new Thread(this);
		thr.start();
		this.index = begin;
	}
	
	@Override
	public void run() {
		int i,j,step;
		int temp;
		int n = end - begin;
		for (step = n / 2; step > 0; step /= 2) {
			for (i = step; i < n;i++) {
				temp = array[i];
				for (j = i; j >= step; j -=step) {
					if (temp < array[j - step]) {
						array[j] = array[j - step];
					}
					else {
						break;
					}
				}
				array[j] = temp;
			}
		}
	}
	
	public Thread getThread() {
		return thr;
	}
	public int peekElement() {
		return array[index];
	}
	public boolean isStop() {
		return stop;
	}
	public int pollElement() {
		int temp = array[index];
		check();
		return temp;
	}
	private void check() {
		this.index++;
		if (this.index >= this.end) {
			this.stop = true;
		}
	}
	
}

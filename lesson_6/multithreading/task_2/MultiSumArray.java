package multithreading_part_1;

public class MultiSumArray {
	static int sum(int [] numbers,int threadNumber) {
		int begin;
		SingleSumArray[] threadArray = new SingleSumArray[threadNumber];
		for (int i = 0; i < threadNumber;++i) {
			int size = numbers.length / threadNumber;
			begin = size * i;
			int end = begin + size;
			if ((numbers.length - end) < size ) {
				end = numbers.length;
			}
			threadArray[i] = new SingleSumArray(numbers,begin,end);
		}
		for (int i = 0;i < threadArray.length;i++) {
			try {
				threadArray[i].getThread().join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return sumArray(threadArray);
	}
	private static int sumArray(SingleSumArray[] threadArray) {
		int sum = 0;
		for (int i = 0;i < threadArray.length; ++i) {
			if (threadArray[i].getThread().isAlive() == true) {
				--i;
				continue;
			}
			else {
				sum = threadArray[i].getSum() + sum;
			}
		}
		return sum;
	}
}

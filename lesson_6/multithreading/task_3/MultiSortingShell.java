package multithreading_part_1_2;

public class MultiSortingShell {
	static void start(int[] array,int threadNumber) {
		SingleSortingShell[] threadArray = new SingleSortingShell[threadNumber];
		for (int i = 0; i < threadArray.length; i++) {
			int size = array.length / threadNumber;
			int begin = size * i;
			int end = (i + 1) * size;
			if ((array.length - end) < size) {
				end = array.length;
			}
			threadArray[i] = new SingleSortingShell(array,begin,end);
		}
		for (int k = 0; k < threadArray.length;k++) {
			try {
				threadArray[k].getThread().join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.arraycopy(mergeArrays(array,threadArray),0,array,0,array.length);
	}
	
	private static int[] mergeArrays(int[] array,SingleSortingShell[] threadArray) {
		int[] arr = new int[array.length];
		for (int i = 0;i < arr.length;i++) {
			int min = Integer.MAX_VALUE;
			int k = -1;
			for (int j = 0;j < threadArray.length;j++) {
				if (!threadArray[j].isStop() && min > threadArray[j].peekElement()) {
					min = threadArray[j].peekElement();
					k = j;
				}
			}
			if (k != -1) {
				arr[i] = threadArray[k].pollElement();
			}
		}
		return finalArray(array);
	}
	
	private static int[] finalArray(int[] array) {
		SingleThreadSorting tempthr = new SingleThreadSorting(array,0,array.length - 1);
		try {
			tempthr.getThr().join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return array;
	}
}

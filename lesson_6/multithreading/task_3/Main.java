package multithreading_part_1_2;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		int[] numbers = new int [1000000];
		
		Random rn = new Random();
		for (int i = 0; i < numbers.length;++i) {
			numbers[i] = rn.nextInt(999);
			System.out.print(numbers[i] + " ");
		}
		int[] numbers2 = numbers.clone();
		
		//---------
		System.out.println("\n");
		long tstart = System.currentTimeMillis();
		MultiSortingShell.start(numbers, 10);
		long tend = System.currentTimeMillis();
		System.out.println((tend - tstart) + "  ms" + " MultiSort " +"\n");
//		for (int i = 0;i < numbers.length;i++) {
//			System.out.print(numbers[i] + " ");
//		}
		//----------
		
		System.out.println("\n");
		long tstart1 = System.currentTimeMillis();
		SingleShell(numbers2);
		long tend1 = System.currentTimeMillis();
		System.out.println((tend1 - tstart1) + "  ms" + " SingleSort" + "\n");
//		for (int i = 0;i < numbers.length;i++) {
//			System.out.print(numbers2[i] + " ");
//		}
		
		
	}
	
	static void SingleShell(int[] numbers) {
		int i,j,step;
		int temp;
		int n = numbers.length;
		for (step = n / 2; step > 0; step /= 2) {
			for (i = step; i < n;i++) {
				temp = numbers[i];
				for (j = i; j >= step; j -=step) {
					if (temp < numbers[j - step]) {
						numbers[j] = numbers[j - step];
					}
					else {
						break;
					}
				}
				numbers[j] = temp;
			}
		}
	}
	
	static void SingleSortShell(int[] numbers) {
		for (int step = numbers.length / 2;step > 0;) {
			int index = 0;
			for (int i = step; i > 0;--i) {
				int j = 0;
				if (numbers.length % step != 0) {
					j = (numbers.length / step) + 1;
				}
				else {
					j = numbers.length / step;
				}
				int m;
				if (index+j > numbers.length) {
					m = (numbers.length) - index;
				} else {
					m = j;
				}
				int[] temp = new int[m];
				for (; j > 0;--j) {
					
					if (index > numbers.length - 1) {
						continue;
					}
					if (temp.length < j) {
						int len = temp.length - (j - m);
						temp[len] = numbers[index];
					}
					else {
						temp[temp.length - j] = numbers[index];
					}
//					System.out.println(numbers[index]);
					++index;
				}
				for (int o = 0;o < temp.length;++o) {
					for (int k = 0;k < temp.length - 1;k++) {
						if (temp[k] > temp[k+1]) {
							int tm= temp[k];
							temp[k] = temp[k+1];
							temp[k+1] = tm;
						}
					}
				}
				
				
				int o = 0;
				for (int k = index - temp.length; k < index;++k) {
					numbers[k] = temp[o];
					++o;
				}
				
//				System.out.println("-----------");
//				for (int k = 0; k < numbers.length;++k) {
//					System.out.print(numbers[k] + " ");
//				}
//				System.out.println();
//				System.out.println("-----------");
			}
			if (step % 2 != 0 && step != 1 && step != 3) {
				step = (step /2) + 1;
			}
			else {
				step = step / 2;
			}
		}
	}
}

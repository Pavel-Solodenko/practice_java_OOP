package multithreading_part_1;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		int [] numbers = new int[100000000];
		Random rn = new Random();
		for (int i = 0; i < numbers.length; ++i) {
			numbers[i] = rn.nextInt(9999);
		}
		long start = System.currentTimeMillis();
		MultiSumArray.sum(numbers, 2);
		long tend = System.currentTimeMillis();
		System.out.println((tend - start) + " ms" + " multi summ");
		start = System.currentTimeMillis();
		sumArray(numbers);
		tend = System.currentTimeMillis();
		System.out.println((tend - start) + " ms" + " single sum");
	}
	public static int sumArray(int [] numbers) {
		int sum = 0;
		for (int i = 0; i < numbers.length;++i) {
			sum = sum + numbers[i];
		}
		return sum;
	}
}
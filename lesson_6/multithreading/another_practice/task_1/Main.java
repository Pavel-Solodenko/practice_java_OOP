package another_practice_multithreading_1;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] numbers = new int[10];
		for (int i = 0; i < numbers.length;++i) {
			System.out.println("Enter a["+i+"] = ");
			numbers[i] = sc.nextInt();
		}
		sc.close();
		ThreadMinMax n = new ThreadMinMax(numbers);
	}
}

/*
������������ ������ � ���������� �������� � ������. ����� ���� ����������� ��� ������. 
������ ����� ������� �������� � �������, ������ � �������. 
*/
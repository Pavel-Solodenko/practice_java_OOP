import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		int[] numbers = {6,-7,-3,5,5,-1,1};
		System.out.println(getNearestToZero(numbers));
	}
	public static int getNearestToZero(int[] numbers) {
		ArrayList<Integer> list_plus = Arrays.stream(numbers)
		.mapToObj(n->n).filter(n -> n > 0).collect(Collectors.toCollection(ArrayList::new));
		ArrayList<Integer> list_minus = Arrays.stream(numbers)
		.mapToObj(n->n).filter(n -> n < 0).collect(Collectors.toCollection(ArrayList::new));
		int min_plus = list_plus.stream().min((a,b) -> a - b).get();
		int min_minus = list_minus.stream().max((a,b) -> a - b).get();
		if (Math.abs(min_minus) < Math.abs(min_plus)) {
			return min_minus;
		} else {
			return min_plus;
		}
	}
}

/*
	Напишите метод,котрый найдет в массиве целых чисел, число, модуль которого ближе всего к 0.
	Если есть два таких числа (например 2 и -2), верните положительное.
*/
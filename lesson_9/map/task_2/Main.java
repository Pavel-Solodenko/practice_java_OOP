import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		Random rn = new Random();
		int[] array = new int[20];
		for (int i = 0;i < array.length;++i) {
			array[i] = 0 + rn.nextInt(5);
			System.out.print(array[i]+" ");
		}
		Map<Integer,Integer> not_unique = new HashMap<Integer,Integer>();
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for (int i = 0;i < array.length;++i) {
			 if (map.put(array[i], array[i]) != null) {
				 if (not_unique.containsKey(array[i])) {
					 int temp =not_unique.get(array[i]);
					 ++temp;
					 not_unique.remove(array[i]);
					 not_unique.put(array[i], temp);
				 }
				 else {
					 not_unique.put(array[i], 2);
				 }
			 }
		}
		System.out.print("\n");
		not_unique.entrySet().stream().sorted(Map.Entry.<Integer,Integer>comparingByValue().reversed()).forEach(System.out::println);
	}
}

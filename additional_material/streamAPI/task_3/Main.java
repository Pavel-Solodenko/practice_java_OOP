import java.util.stream.Collectors;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		String str ="ahg";
		ArrayList<Integer> list = str.chars().mapToObj(n->n)
		.collect(Collectors.toCollection(ArrayList::new));
		System.out.println(list);
	}
}

/*
	�� ������ ������ ������������ ������ ����� �����, 
	��� ������ ����� ������ ���� ASCII ����� ��������������� �����.
*/
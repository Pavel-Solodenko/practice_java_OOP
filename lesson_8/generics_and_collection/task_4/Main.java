import java.util.ArrayDeque;

public class Main {
	public static void main(String[] args) {
		ArrayDeque<String> que = new ArrayDeque<String>();
		int countColas = 0;
		que.push("Volovitc");
		que.push("Kutrapali");
		que.push("Penny");
		que.push("Sheldon");
		que.push("Leonard");
		for(int i = 0; i < 7;i++) {
			countColas = giftCola(que,countColas);
		}
		
		printDeque(que,countColas);
		
	}
	public static int giftCola(ArrayDeque<String> que,int countColas) {
		String temp = que.poll();
		String temp_clone = temp;
		que.add(temp_clone);
		que.add(temp);
		return ++countColas;
	}
	public static void printDeque(ArrayDeque<String> que,int countColas) {
		System.out.println("Count gift cola - "+countColas);
		System.out.println(que.toString()+"\n"+"\n");
	}
}

/*
 * ������,�������,�������, ���������� � ����� ����� � ������� �� "������� �����".
 * ��� ������ ������� ������ ����� ����, �� ������������� � ��� ���������� � ����� �������,����� ������ ���.
 * �������� ���������,������� ������� �� ����� ��������� ������� � ����������� �� ����,������� �������� ���� ����� ������.
 * ��������, ���� ������ ��� : [Volovitc,Kutrapali,Penny,Sheldon,Sheldon,Leonard,Leonard].
 */

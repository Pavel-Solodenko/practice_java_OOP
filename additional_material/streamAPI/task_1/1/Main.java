
public class Main {
	public static void main(String[] args) {
		Student[] students = {new Student("Petr",21,'�'),new Student("Pavel",20,'�'),
		new Student("Katya",18,'�'),new Student("Sveta",22,'�')};
		
		Group group1 = new Group(students,"IPZ-22");
		System.out.println(group1.toString());
		System.out.println("----------------------------");
		System.out.println(group1.getFirstLatterStud('P'));
	}
}

/*
�������� ������,������� �������� �������� �� ������ ��������� ���,� ���� ������� ����������
� ������������ �����.
*/
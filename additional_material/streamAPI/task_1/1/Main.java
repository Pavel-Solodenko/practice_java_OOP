
public class Main {
	public static void main(String[] args) {
		Student[] students = {new Student("Petr",21,'м'),new Student("Pavel",20,'м'),
		new Student("Katya",18,'ж'),new Student("Sveta",22,'ж')};
		
		Group group1 = new Group(students,"IPZ-22");
		System.out.println(group1.toString());
		System.out.println("----------------------------");
		System.out.println(group1.getFirstLatterStud('P'));
	}
}

/*
Ќапишите методы,которые позвол€т выделить из группы студентов тех,у кого фамили€ начинаетс€
с определенной буквы.
*/
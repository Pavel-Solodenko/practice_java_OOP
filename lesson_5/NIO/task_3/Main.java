import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Student s1 = new Student(21,"Petr","Vovchenko","male",2);
		//s1.getInfo();
		//h1.getInfo();
		Group gr1 = new Group("EP-2");
		//plusStudent(gr1,s1);
		
//		addStudentQuestion(gr1,false);
//		plusStudent(gr1,new Student(19,"Pavel","Reznikov","male",3));
//		plusStudent(gr1,new Student(17,"Alexander","Korshun","male",1));
//		plusStudent(gr1,new Student(20,"Masha","Virchenko","female",3));
//		plusStudent(gr1,new Student(18,"Lena","Petroshenko","female",2));
//		plusStudent(gr1,new Student(21,"Henri","Oncen","male",6));
//		plusStudent(gr1,new Student(22,"Katerina","Boyko","female",5));
//		plusStudent(gr1,new Student(17,"Pavel","Killari","male",3));
//		plusStudent(gr1,new Student(17,"Pavel","Aoutopi","male",3));
//		plusStudent(gr1,new Student(17,"Pavel","Mollaiev","male",3));
		//plusStudent(gr1,new Student(19,"Pavel","Reznikov","male",3));
		//minusStudent(gr1,s1);
		//gr1.findStudent("Vovchenko");
		
//		System.out.println();
		//gr1.sortBylastName();
//		System.out.println("Input parametr for search");
		//gr1.sortByParametr("course");
		gr1.readGroupTxt();
		gr1.getInfo();
//		gr1.saveGroupTxt();
//		System.out.println("\n" + "\n" + "\n");
//		Student [] st = gr1.getPriziv();
//		for (Student stud : st) {
//			stud.getInfo();
//		}
	}
	static void plusStudent(Group gr,Student s) {
		try {
			gr.addStudent(s);
			System.out.println("Add to group");
		}
		catch (GroupFullException e) {
			System.out.println(e);
		}
		
	}
	static void minusStudent(Group gr,Student s) {
		try {
			gr.removeStudent(s);
		}
		catch (NotFoundStudentException e) {
			System.out.println(e);
		}
	}
	static void addStudentQuestion(Group group, boolean again) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if (again== false ) {
			System.out.println("Do you want add student?");
		}
//		try {
//			br.readLine();
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		Scanner sc1 = new Scanner(System.in);
		
		String answer = sc1.nextLine();//br.toString();
		if (answer.equals("yes") == true) {
			System.out.println("Input: age name lastname gender course");
			try {
				BufferedReader bf1 = new BufferedReader(br);
				String text = bf1.readLine();
				String [] param = text.split(" ");
				Student s = new Student(Integer.parseInt(param[0]),param[1],param[2],param[3],Integer.parseInt(param[4]));
				plusStudent(group,s);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc1.close();
	}
}

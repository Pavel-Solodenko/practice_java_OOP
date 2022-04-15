import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Group implements Voenkom{
	private Student[] students = new Student[10];
	private String group_name;
	public Group(String name) {
		this.group_name = name;
	}
	public void readGroupTxt() {
		String path = "C:\\eclipse_present_projects\\OPP_polymorph_les\\Students_read.txt";
		String lastName = "";
		try (BufferedReader bf = new BufferedReader(new FileReader(path))) {
			for (;(lastName = bf.readLine()) != null;) {
				String name = "";
				String age = "";
				String gender = "";
				String Course = "";
					name = bf.readLine();
					age = bf.readLine();
					gender = bf.readLine();
					Course = bf.readLine();
				if (lastName.equals("") == false &&
					name.equals("") == false &&
					age.equals("") == false &&
					gender.equals("") == false &&
					Course.equals("") == false
					) {
					addStudent(new Student(Integer.parseInt(age),name,lastName,gender,Integer.parseInt(Course)));
				}
				lastName ="";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void saveGroupTxt() {
		String path = "C:\\eclipse_present_projects\\OPP_polymorph_les\\Students.txt";
		try (PrintWriter pw = new PrintWriter(path)) {
		for (int i = 0;i < students.length;++i) {
			if (students[i] != null) {
					pw.println(students[i].getLastName());
					pw.println(students[i].getName());
					pw.println(students[i].getAge());
					pw.println(students[i].getGender());
					pw.println(students[i].getCourse());
					pw.println("----------------------------------------------------------------------");
			}
		}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public Student[] getPriziv() {
		String[] a = new String[10];
		int kol = 0;
		for (int i = 0;i<students.length;++i) {
			if (students[i] != null && students[i].getGender().equals("male") == true && students[i].getAge() >= 18) {
				a[i] = students[i].getLastName();
			}
		}
		for (int i = 0;i<a.length;++i) {
			if (a[i] != null) {
				++kol;
			}
		}
		Student [] students_priziv = new Student[kol];
		kol = 0;
		for (int i = 0;i<a.length;++i) {
			for (int j = 0;j<students.length;++j) {
				if (students[j] != null && students[j].getLastName().equals(a[i]) == true) {
					students_priziv[kol] = (Student) students[j].clone();
					++kol;
				}
			}
		}
		return students_priziv;
	}
	public void addStudent(Student student) throws GroupFullException{
		for (int i = 0;; ++i) {
			if (i == 10) throw new GroupFullException();
			if (students[i] == null) {
				students[i] = student;
//				System.out.println("Add to group");
				break;
			}
		}
	}
	public void removeStudent(Student student) throws NotFoundStudentException{
		for (int i = 0;; ++i) {
			if (i == 10) throw new NotFoundStudentException();
			if (students[i] != null && students[i].equals(student) == true) {
				students[i] = null;
				System.out.println("Student remove");
				break;
			}
		}
	}
	public void findStudent(String lastname) {
		int check = 0;
		for (int i = 0; i < students.length; ++i) {
			if (students[i] != null && students[i].getLastName().equals(lastname) == true) {
				System.out.println("Student found:");
				students[i].getInfo();
				break;
			}
			++check;
		}
		if (check == students.length) {
			System.out.println("Student not found");
		}
	}
	public void getInfo() {
		System.out.println("Group " + group_name + ":");
		//Arrays.sort(students,Comparator.comparing(Student::getLastName));
		for (Student student : students) {
			if (student != null) {
				student.getInfo();
			}
		}
	}
	public void sortByCourse() {
		try {
			Arrays.sort(students,Comparator.comparing(Student::getCourse));
		}
		catch (NullPointerException e) {
			studentsHaveNull();
			Arrays.sort(students,Comparator.comparing(Student::getCourse));
			studentsDelNull();
		}
	}
	public void sortByName() {
		try {
			Arrays.sort(students,Comparator.comparing(Student::getName));
		}
		catch (NullPointerException e) {
			studentsHaveNull();
			Arrays.sort(students,Comparator.comparing(Student::getName));
			studentsDelNull();
		}
	}
	public void sortByAge() {
		try {
			Arrays.sort(students,Comparator.comparing(Student::getAge));
		}
		catch (NullPointerException e) {
			studentsHaveNull();
			Arrays.sort(students,Comparator.comparing(Student::getAge));
			studentsDelNull();
		}
	}
	public void sortBylastName() {
		try {
			Arrays.sort(students,Comparator.comparing(Student::getLastName));
		}
		catch (NullPointerException e) {
			studentsHaveNull();
			Arrays.sort(students,Comparator.comparing(Student::getLastName));
			studentsDelNull();
		}
	}
	public void studentsHaveNull() {
		for (int i = 0; i < students.length; ++i) {
			if (students[i] == null) {
				students[i] = new Student(0,"null","null","null",0);
			}
		}
	}
	public void studentsDelNull() {
		for (int i = 0; i < students.length; ++i) {
			if (students[i].getLastName().equals("null")) {
				students[i] = null;
			}
		}
	}
	public void sortByParametr(String answer) {
//		System.out.println("Input parametr for search");
//		String answer = sc.nextLine();
		switch(answer) {
		case "age": 
			sortByAge();
			break;
		case "name": 
			sortByName();
			break;
		case "lastname":
			sortBylastName();
			break;
		case "course":
			sortByCourse();
			break;
		default: 
			System.out.println("Incorrect parametr");
		}
	}
}

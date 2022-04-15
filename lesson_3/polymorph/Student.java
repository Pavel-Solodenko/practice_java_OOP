import java.util.Scanner;

public class Student extends Human implements Cloneable{
	private int course;
	private boolean check = false;
	public Student(int age, String name,String lastname,String gender,int course) {
		super(age,name,lastname,gender);
		this.course = course;
	}
	@Override
	public void getInfo() {
		checkCourse();
		System.out.printf("Age = %d\n" + "Name = %s\n" + "Lastname = %s\n" + "Gender = %s\n" + "Course = %d\n",getAge(),getName(),getLastName(),getGender(),course);
		
	}
	private void checkCourse() {
		Scanner sc = new Scanner(System.in);
		if (course < 1 || course > 6) {
			while (check != true) {
				System.out.println("Incorrect course!\nEnter again");
				course = sc.nextInt();
				if (course >= 1 && course <= 6) {
					check = true;
				}
			}
		}
		sc.close();
	}
	public int getCourse() {
		return course;
	}
	@Override
	protected Object clone() {
		try {
			return (Student) super.clone();
		}
		catch (CloneNotSupportedException e) {
			return null;
		}
	}
}

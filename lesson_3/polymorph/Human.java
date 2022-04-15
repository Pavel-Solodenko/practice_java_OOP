import java.util.Scanner;

public class Human {
	private Scanner sc = new Scanner(System.in);
	private int age;
	private String name;
	private String LastName;
	private Gender gender;
	public Human(int age,String name, String lastname ,String gen) {
		this.age = age;
		this.name = name;
		this.LastName = lastname;
		this.gender = new Gender(gen);
	}
	public void getInfo() {
		if (gender.getGender() != null) {
			System.out.printf("Age = %d\n" + "Name = %s\n" + "Lastname = %s\n" + "Gender = %s\n",age,name,LastName,gender.getGender());
		}
		else {
			gender = null;
			System.out.print("Only male or female !!" + "\n" + "Input correct gender" + "\n");
			String gen = sc.nextLine();
			gender = new Gender(gen);
			getInfo();
		}	
	}
	public int getAge() {
		return age;
	}
	public String getName() {
		return name;
	}
	public String getLastName() {
		return LastName;
	}
	public String getGender() {
		return gender.getGender();
	}
	public void setLastName(String lastname) {
		this.LastName = lastname;
	}
}

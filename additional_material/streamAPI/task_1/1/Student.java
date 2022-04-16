
public class Student {
	private String name;
	private int age;
	private char sex;
	
	public Student(String name,int age,char sex) {
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	
	@Override
	public String toString() {
		return "\n"+"Name: " + name + "\n" + "Age: " + age + "\n" + "Sex: " + sex + "\n";
	}
	
	public String getName() {
		return name;
	}
}

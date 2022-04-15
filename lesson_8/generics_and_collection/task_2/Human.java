
public class Human {
	private int age;
	private String name;
	private char sex;
	
	public Human(String name,int age,char sex) {
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	
	@Override
	public String toString() {
		return "Name: " + this.name + " Age: " + this.age+" Sex: "+this.sex;
	}
	
	public String getName() {
		return this.name;
	}
}

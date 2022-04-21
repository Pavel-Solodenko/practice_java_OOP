import java.util.ArrayList;

public class Human {
	private String name;
	private String lastname;
	private int age;
	private char sex;
	
	public Human(String name,String lastname,int age,char sex) {
		this.name = name;
		this.lastname = lastname;
		this.age = age;
		this.sex = sex;
	}
	
	public Human(ArrayList<String> b) {
		this.name = b.get(0);
		this.lastname = b.get(1);
		this.age = Integer.valueOf(b.get(2));
		this.sex = b.get(3).charAt(0);
	}
	
	@Override
	public String toString() {
		return "\r"+"Name:"+name+" Lastname:"+lastname+" Age:"+age+" Sex:"+sex+"\n";
	}
	
	public String getLastName() {
		return lastname;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof Human)) {
			return false;
		}
		Human c = (Human) o;
		return name.compareTo(c.name) == 0 && lastname.compareTo(c.lastname) == 0
				&& Integer.compare(age, c.age) == 0 && Character.compare(sex, c.sex) == 0;
	}
}

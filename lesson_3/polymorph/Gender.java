
public class Gender {
	final String [] gender = {"male","female"};
	private String gen;
	public Gender(String gen) {
		this.gen = gen;
	}
	public String getGender() {
		if (gen.equals(gender[0])) {
			return gender[0];
		} 
		else {
			if (gen.equals(gender[1])) {
				return gender[1];
			}
		}
		return null;
	}
}

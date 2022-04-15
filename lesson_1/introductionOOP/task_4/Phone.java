public class Phone {
	private String number, model;
	Phone (String number, String model) {
		this.number = number;
		this.model = model;
	}
	public void regInNetwork(Network netw) {
		Phone ph = new Phone(number,model);
		netw.setPhone(ph);
	}
	void Call(String number, Network netw) {
		String a[] = netw.getPhones();
		int b = 0;
		for (int i = 0; i < a.length; ++i) {
			if (a[i].equals(number) == true) {
				System.out.println("Call sucсessful");
				break;
			}
			else {
				++b;
			}
		}
		if (b == a.length) {
			System.out.println("Call failed");
		}
	}
	public void UpdatePhone(String number, String model) {
		this.number = number;
		this.model = model;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
}

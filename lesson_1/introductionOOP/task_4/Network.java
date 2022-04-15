public class Network {
	private String name;
	private int Network_type;
	private Phone[] phones = new Phone[5];
	public String getName() {
		return name;
	}
	Network(String name, int Network_type) {
		this.name = name;
		this.Network_type = Network_type;
	}
	
	void UpdateNetwork(String name, int Network_type) {
		this.name = name;
		this.Network_type = Network_type;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNetwork_type() {
		return Network_type;
	}
	public void setNetwork_type(int network_type) {
		Network_type = network_type;
	}
	public String[] getPhones() {
		String all = "";
		for (int i = 0; i < phones.length; ++i) {
			if (phones[i] != null) {
				all = all +phones[i].getNumber() + "/";
			}
		}
		String a[] = all.split("/");
		return a;
	}
	public void setPhone(Phone phone) {
		int a = 0;
		for (int i = 0; i < phones.length; ++i) {
			if (phones[i] == null) {
				phones[i] = phone;
				break;
			}
			else {
				++a;
			}
		}
		if (a == phones.length) {
			System.out.println("Network is full!");
		}
	}
}

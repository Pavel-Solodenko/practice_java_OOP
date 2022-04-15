public class Main {
	public static void main(String[] args) {
		Phone ph1 = new Phone("+38-066-567-90-88","Xiaomi Redmi 7A");
		Phone ph2 = new Phone("+38-063-789-09-09","Iphone 6");
		Phone ph3 = new Phone("+38-667-563-91-00","Xiaomi Redmi 9");
		Phone ph4 = new Phone("+38-099-782-45-12","Iphone 11");
		Phone ph5 = new Phone("+38-050-932-56-81","Iphone 9");
		Phone ph6 = new Phone("+38-073-876-99-00","Iphone 8");
		Network net1 = new Network("Life",3);
		ph1.regInNetwork(net1);
		ph2.regInNetwork(net1);
		ph3.regInNetwork(net1);
		ph4.regInNetwork(net1);
		ph5.regInNetwork(net1);
		String all[] = net1.getPhones();
		for (int i = 0; i < all.length; ++i) {
			System.out.println(all[i]);
		}
		ph1.Call("+38-050-932-56-81", net1);
	}
}

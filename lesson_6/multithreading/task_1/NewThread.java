public class NewThread implements Runnable{
	private int number;
	private double fact = 1;
	private String name = "";
	public NewThread(int number,String name) {
		this.number = number;
		this.name = name;
	}
	@Override
	public void run() {
		System.out.println(name);
		System.out.println(factorial());
		System.out.println();
	}
	private double factorial() {
		for (int i = 1; i <= number;++i) {
			fact = fact * i;
		}
		return fact;
	}
}

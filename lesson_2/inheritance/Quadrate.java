
public class Quadrate extends Shape{
	protected double side_a;
	public Quadrate(double a) {
		super();
		this.side_a = a;
	}
	@Override
	public double calcPerimetr() {
		double perimetr = side_a * 4.0;
		return perimetr;
	}
	@Override
	public double calculateArea() {
		double square = Math.pow(side_a,2.0);
		return square;
	}
	@Override
	public void getInfo() {
		System.out.println("Quadrate");
		System.out.printf("Perimetr = %.1f\n" + "Square = %.1f\n" + "Side = %.1f\n",calcPerimetr(),calculateArea(),side_a);
	}
	
	public double getSide_a() {
		return side_a;
	}
	public void setSide_a(double side_a) {
		this.side_a = side_a;
	}
}

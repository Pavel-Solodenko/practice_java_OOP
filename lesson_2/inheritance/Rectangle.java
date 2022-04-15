
public class Rectangle extends Quadrate{
	protected double side_b;
	public Rectangle(double side_a,double side_b) {
		super(side_a);
		this.setSide_b(side_b);
	}
	@Override
	public double calcPerimetr() {
		double perimetr = (side_a * 2.0) + (side_b * 2);
		return perimetr;
	}
	@Override
	public double calculateArea() {
		double square = side_a * side_b;
		return square;
	}
	@Override
	public void getInfo() {
		System.out.println("Rectangle");
		System.out.printf("Perimetr = %.1f\n" + "Square = %.1f\n" + "Side_a = %.1f\n" + "Side_b = %.1f\n",calcPerimetr(),calculateArea(),side_a,side_b);
	}
	public double getSide_b() {
		return side_b;
	}
	public void setSide_b(double side_b) {
		this.side_b = side_b;
	}
	
}

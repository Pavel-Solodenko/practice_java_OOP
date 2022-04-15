
public class Triangle extends Shape{
	private double side_a,side_b,side_c;
	private double perimetr;
	private double square;
	public Triangle(double a,double b,double c) {
		this.side_a = a;
		this.side_b = b;
		this.side_c = c;
	}
	@Override
	public double calcPerimetr() {
		perimetr = side_a + side_b + side_c;
		return perimetr;
	}
	@Override
	public double calculateArea() {
		double p = perimetr / 2.0;
		square = Math.sqrt(p * (p - side_a) * (p - side_b) * (p - side_c));
		return square;
	}
	@Override 
	public void getInfo() {
		System.out.println("Triangle");
		System.out.printf("Perimetr = %.1f\n" + "Square = %.3f\n", calcPerimetr(),calculateArea());
		System.out.println("Side_a = " + side_a + "   " + "Side_b = " + side_b + "   " + "Side_c = " + side_c);
	}
	public double getSide_a() {
		return side_a;
	}
	public void setSide_a(double side_a) {
		this.side_a = side_a;
	}
	public double getSide_b() {
		return side_b;
	}
	public void setSide_b(double side_b) {
		this.side_b = side_b;
	}
	public double getSide_c() {
		return side_c;
	}
	public void setSide_c(double side_c) {
		this.side_c = side_c;
	}
	public double getSquare() {
		return square;
	}
	public void setSquare(double square) {
		this.square = square;
	}
	public void setPerimetr(double perimetr) {
		this.perimetr = perimetr;
	}
	public double getPerimetr() {
		return perimetr;
	}
}

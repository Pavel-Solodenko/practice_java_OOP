
public class Parallelogram extends Rectangle{
	private double angle;
	public Parallelogram(double a,double b,double angle) {
		super(a,b);
		this.angle = angle;
	}
	@Override
	public double calculateArea() {
		double square = 0;
		if (angle < 180.0) {
			square = side_a * side_b * Math.sin((angle * Math.PI) / 180.0);
			return square;
		}
		else {
			System.out.println("Incorrect angle");
			return 0;
		}
	}
	@Override
	public void getInfo() {
		System.out.println("Parallelogram");
		System.out.printf("Perimetr = %.1f\n" + "Square = %.3f\n" + "Side_a = %.1f\n" + "Side_b = %.1f\n" + "Angle = %.1f\n", calcPerimetr(),calculateArea(),side_a,side_b,angle);
	}
}

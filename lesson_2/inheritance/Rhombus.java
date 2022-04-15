
public class Rhombus extends Quadrate{
	private double angle;
	public Rhombus(double a, double angle) {
		super(a);
		this.angle = angle;
	}
	@Override
	public double calculateArea() {
		double square = 0;
		if (angle < 180) {
			square = Math.pow(side_a, 2) * Math.sin((angle * Math.PI) / 180.0);
			return square;
		}
		else {
			System.out.println("Incorrect angle");
			return square;
		}
	}
	@Override
	public void getInfo() {
		System.out.println("Rhombus");
		System.out.printf("Perimetr = %.1f\n" + "Square = %.3f\n" + "Side_a = %.1f\n" + "Angle = %.1f\n", calcPerimetr(),calculateArea(),side_a,angle);
	}
}

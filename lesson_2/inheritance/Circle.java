
public class Circle extends Shape{
	private Point point1;
	private Point point2;
	public Circle(Point point1,Point point2) {
		this.point1 = point1;
		this.point2 = point2;
	}
	@Override
	public double calcPerimetr() {
		return 2.0 * Math.PI * point1.calcPoint(point2);
	}
	@Override
	public double calculateArea() {
		return Math.PI * Math.pow(point1.calcPoint(point2), 2);
	}
	@Override
	public void getInfo() {
		System.out.println("Circle");
		System.out.printf("Lenght = %.3f\n" + "Square = %.3f\n" + "Radius = %.3f\n",calcPerimetr(),calculateArea(),point1.calcPoint(point2));
		point1.getInfo();
		point2.getInfo();
	}
}

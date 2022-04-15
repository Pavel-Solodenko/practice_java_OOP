
public class Triangle {
	private int side_a ,side_b, side_c;
	Triangle (int side_a,int side_b, int side_c) {
		this.side_a = side_a;
		this.setSide_b(side_b);
		this.side_c = side_c;
	}
	public double SquareTriangle() {
		double square = 0;
		double partPer = (side_a + side_b + side_c) / 2.0;
		square = Math.sqrt((double) (partPer * (partPer - side_a) * (partPer - side_b) * (partPer - side_c)));
		if (Double.isNaN(square)) {
			System.out.println("Incorrect triangle");
			square = 0;
		}
		return square;
	}
	
	public int getSide_a() {
		return side_a;
	}
	public void setSide_a(int side_a) {
		this.side_a = side_a;
	}
	public int getSide_b() {
		return side_b;
	}
	public void setSide_b(int side_b) {
		this.side_b = side_b;
	}
	public int getSide_c() {
		return side_c;
	}
	public void setSide_c(int side_c) {
		this.side_c = side_c;
	}
}

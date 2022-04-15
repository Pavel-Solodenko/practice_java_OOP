
public class Desc {
	private Shape Shapes[] = new Shape[4];
	public Desc() {
	}
	public void addToDesc(Shape shape) {
		int a = 0;
		for (int i = 0; i < Shapes.length; ++i) {
			if (Shapes[i] == null) {
				Shapes[i] = shape;
				break;
			}
			++a;
		}
		if (a == Shapes.length) {
			System.out.println("Desc full!");
		}
	}
	public void deleteFromDesc(Shape shape) {
		int a = 0;
		for (int i = 0;i < Shapes.length;++i) {
			if (Shapes[i] != null && Shapes[i].equals(shape) == true) {
				Shapes[i] = null;
				break;
			}
			++a;
		}
		if (a == Shapes.length) {
			System.out.println("Not Found!");
		}
	}
	public void getShape(Shape shape) {
		int a = 0;
		for (int i = 0; i < Shapes.length; ++i) {
			if (Shapes[i] != null && Shapes[i].equals(shape) == true) {
				Shapes[i].getInfo();
				break;
			}
			++a;
		}
		if (a == Shapes.length) {
			System.out.println("Not Found");
		}
	}
	public void getInfo() {
		double sumSquare = 0;
		for (int i = 0; i < Shapes.length; ++i) {
			if (Shapes[i] != null) {
				System.out.println("-----------------------------------------------------");
				Shapes[i].getInfo();
				sumSquare = sumSquare + Shapes[i].calculateArea();
			}
		}
		System.out.println("-----------------------------------------------------");
		System.out.printf("Total square = %.3f\n\n", sumSquare);
	}
}

public class Main {
	public static void main(String[] args) {
			Triangle tr1 = new Triangle(7,6,3);
			Triangle a[] = new Triangle[4];
			a[0] = new Triangle(4,4,4);
			a[1] = new Triangle(1,3,5);
			a[2] = new Triangle(12,10,13);
			a[3] = new Triangle(7,6,4);
			for (int i = 0; i < a.length; ++i) {
				System.out.printf("Triangle square = "+ "%.3f",a[i].SquareTriangle());
				System.out.println();
			}
		}
}

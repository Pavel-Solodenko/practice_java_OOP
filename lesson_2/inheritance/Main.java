
public class Main {
	public static void main(String[] args) {
		Parallelogram pr = new Parallelogram(6,12,70);
		Desc dc = new Desc();
		Quadrate q1 = new Quadrate(4);
//		Rectangle r1 = new Rectangle(7,10);
//		Rhombus rh1 = new Rhombus(23,110);
		Point po1 = new Point(7,3);
		Point po2 = new Point(-3,1);
//		po1.getInfo();
//		po2.getInfo();
		Circle cr1 = new Circle(po1,po2);
		dc.addToDesc(cr1);
		//cr1.getInfo();
//		Triangle tg1 = new Triangle(5,3,6);
		Triangle tg2 = new Triangle(12,8,9);
		dc.addToDesc(tg2);
		dc.addToDesc(q1);
		dc.deleteFromDesc(pr);
		dc.addToDesc(pr);
		dc.getInfo();
		dc.getShape(tg2);
	}
}


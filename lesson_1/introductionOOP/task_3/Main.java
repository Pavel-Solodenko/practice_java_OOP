public class Main {
	public static void main(String[] args) {
		Vector vec1 = new Vector(5,3,1);
		Vector vec2 = new Vector(-2,10,-4);
		vec1 = vec1.addVectors(vec2);
		PrintVector(vec1);
		vec1.updateVector(7,-12,4);
		vec2.updateVector(5,-3,1);
		System.out.println(vec1.ScalarVectors(vec2));
		vec1.updateVector(1,-7,4);
		vec2.updateVector(3,8,0);
		vec1 = vec1.multiplicationVectors(vec2);
		PrintVector(vec1);
	}
	static void PrintVector(Vector vec1) {
		System.out.println("X: "+vec1.getX());
		System.out.println("Y: "+vec1.getY());
		System.out.println("X: "+vec1.getZ());
	}
}

public class Vector {
	private int x, y, z;
	Vector(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	Vector addVectors(Vector vector2) {
		Vector vector_res = new Vector(0,0,0);
		vector_res.setX(x + vector2.getX());
		vector_res.setY(y + vector2.getY());
		vector_res.setZ(z + vector2.getZ());
		return vector_res;
	}
	int ScalarVectors(Vector vector2) {
		int scalar = 0;
		scalar = x * vector2.getX() + y * vector2.getY() + z * vector2.getZ();
		return scalar;
	}
	Vector multiplicationVectors(Vector vector2) {
		Vector vector_res = new Vector(0,0,0);
		vector_res.setX((y * vector2.getZ()) - (z * vector2.getY()) );
		vector_res.setY((z * vector2.getX()) - (x * vector2.getZ()) );
		vector_res.setZ((x * vector2.getY()) - (y * vector2.getX()) );
		return vector_res;
	}
	void updateVector(int x,int y,int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
}

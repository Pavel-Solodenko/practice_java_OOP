package game_zero_x;

public class Figure {
	private int x;
	private int y;
	// if zero - true, if false - X
	private boolean type;
	public Figure(int x ,int y,boolean type) {
		this.x = x;
		this.y = y;
		this.type = type;
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
	public boolean isType() {
		return type;
	}
	public void setType(boolean type) {
		this.type = type;
	}
	public String getZeroOrX() {
		if (type == true) {
			return "O";
		}
		else {
			return "X";
		}
	}
}

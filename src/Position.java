package OOP;

public class Position {
	public int x;
	public int y;
	
    public Position(int x, int y) {
		
		this.x = x;
		this.y = y;
	}

	public static final Position DOWN = new Position(0,1);
	public static final Position UP = new Position(0,-1);
	public static final Position LEFT = new Position(-1,0);
	public static final Position RIGHT = new Position(1,0);
	public static final Position ZERO = new Position(0, 0);

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
	public Position(Position copyOther) {
		this.x = copyOther.x;
		this.y = copyOther.y;
	}
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

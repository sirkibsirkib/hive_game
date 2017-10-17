package hiveGame;

import java.awt.Point;

public class Coord {
	private int x, y;
	
	public Coord hexProject(int gridSide){
		int hx = x*37;
		int hy = y*42 + x*22;
		return new Coord(hx, hy);
	}
	
	public Coord(int x, int y){
		this.setX(x);
		this.setY(y);
	}

	public Coord(Point point) {
		this.setX(point.x);
		this.setY(point.y);
	}
	
	public Coord add(Coord o){
		return new Coord(x+o.x, y+o.y);
	}
	
	public Coord subtract(Coord o){
		return new Coord(x-o.x, y-o.y); 
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
}

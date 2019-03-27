package Shape;

import java.awt.Graphics;

public abstract class Shape {
	protected int x1, y1, x2, y2;
	// arc,평행사변형

	public void setOrign(int x, int y) {
		// 원점 셋팅
		this.x1 = x;
		this.y1 = y;
		this.x2 = x;
		this.y2 = y;

	}

	public void setPoint(int x, int y) {
		this.x2 = x;
		this.y2 = y;
	}

	abstract public void draw(Graphics graphics);

	public void addPoint(int x, int y) {

	}
}

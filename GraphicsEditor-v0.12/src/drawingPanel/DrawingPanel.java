package drawingPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import Global.Constant.EToolBar;
import Shape.Shape;

public class DrawingPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private MouseHandler mouseHandler;

	private Shape CurrentTool;

	public void setCurrentTool(EToolBar currentToole) {
		this.CurrentTool = currentToole.getShape();
	}

	public DrawingPanel() {
		this.setBackground(Color.white);
		// �̺�Ʈ�� �޴� ��ü�� ����� ���̴�.
		this.mouseHandler = new MouseHandler();
		this.addMouseListener(this.mouseHandler);
		// ��ư�̺�Ʈ
		this.addMouseMotionListener(this.mouseHandler);
		// ���콺 ���

		// new�� ���ؼ� Ellipse,Rectangle�� ������ ������ �ؾ��Ѵ�.
		CurrentTool = EToolBar.RectangleButton.getShape();
		// new�� �ؼ� Rectangle�� �ٿ�������
	}

	// ���� �𷡱��� ������ �����ؿͶ�
	private void drawShape(int x, int y) {

		Graphics graphics = this.getGraphics();
		graphics.setXORMode(getBackground());
		this.CurrentTool.setOrign(x, y);
		this.CurrentTool.draw(graphics);

	}

	private void moveShape(int x, int y) {
		Graphics graphics = this.getGraphics();
		graphics.setXORMode(getBackground());

		this.CurrentTool.draw(graphics);
		this.CurrentTool.setPoint(x, y);
		this.CurrentTool.draw(graphics);

		// ������ �ƴٰ� �Ǽ��� �ǰ� �ض�

	}

	private class MouseHandler implements MouseListener, MouseMotionListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// click move click move�ϴٰ� ������ ������ �������Ѵ�.
			// ���⼭ ����Ŭ���� Ȯ���ؾ��Ѵ�.
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// �����ð����� polygon�� �׷��Ͷ�

			drawShape(e.getX(), e.getY());

		}

		@Override
		public void mouseReleased(MouseEvent e) {

		}

		@Override
		public void mouseDragged(MouseEvent e) {// ���⼭ �����

			moveShape(e.getX(), e.getY());

		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// ����
		}

		@Override
		public void mouseEntered(MouseEvent e) {/* ���콺�� ������ �۵� */
		}

		@Override
		public void mouseExited(MouseEvent e) {/* ���콺�� ������ �� shaed */
		}
	}

	
}

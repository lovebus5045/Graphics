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
	private void drawShape() {
		// �׳� �׸���
		Graphics graphics = this.getGraphics();
		graphics.setXORMode(getBackground());
		this.CurrentTool.draw(graphics);

	}

	private void initDrawing(int x, int y) {
		this.CurrentTool.setOrign(x, y);
		this.drawShape();

	}

	private void KeepDrawing(int x, int y) {
		this.drawShape();
		this.CurrentTool.setPoint(x, y);
		this.drawShape();

	}

	private void ContinueDrawing(int x, int y) {
		// k-1���� k��°�� ���� ��� ����
		// ������ polygon�� ���� ���� ���� �Ǵµ� �׷��� �� ��� actionCommand���� if���� ���� �ȴ�.
		this.CurrentTool.addPoint(x, y);
		// setPoint�� ��������
		// init --> keepdrawing -->finish --> continue -->keep -->continue
		// -->finish(������) Polygon�� ������ ���� �����̴�.
		// �߰����� polygon Line���� �׷��� �ȴ�.
	}

	private void FinishDrawing(int x, int y) {

		this.drawShape();
		this.CurrentTool.setPoint(x, y);
		this.drawShape();
	}

	private class MouseHandler implements MouseListener, MouseMotionListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount() == 1) {
				initDrawing(e.getX(),e.getY());
				//flag���� boolean true false����ϱ�
				//userinterface�� pattern�� �������� �����
				
			}else if(e.getClickCount() == 2) {
				
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// �����ð����� polygon�� �׷��Ͷ�

			initDrawing(e.getX(), e.getY());

		}

		@Override
		public void mouseReleased(MouseEvent e) {

			FinishDrawing(e.getX(), e.getY());
		}

		@Override
		public void mouseDragged(MouseEvent e) {// ���⼭ �����

			KeepDrawing(e.getX(), e.getY());// ���콺 �����϶�

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

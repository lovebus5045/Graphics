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
		// 이벤트를 받는 객체를 등록한 것이다.
		this.mouseHandler = new MouseHandler();
		this.addMouseListener(this.mouseHandler);
		// 버튼이벤트
		this.addMouseMotionListener(this.mouseHandler);
		// 마우스 모션

		// new를 통해서 Ellipse,Rectangle을 가지고 오도록 해야한다.
		CurrentTool = EToolBar.RectangleButton.getShape();
		// new를 해서 Rectangle을 붙여버려라
	}

	// 내일 모래까지 도형을 구상해와라
	private void drawShape() {
		// 그냥 그린다
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
		// k-1에서 k번째의 점을 찍는 아이
		// 완전히 polygon을 위한 것을 만들어도 되는데 그렇게 할 경우 actionCommand에서 if문이 들어가게 된다.
		this.CurrentTool.addPoint(x, y);
		// setPoint는 마지막점
		// init --> keepdrawing -->finish --> continue -->keep -->continue
		// -->finish(마무리) Polygon은 마지막 점이 원점이다.
		// 중간점은 polygon Line으로 그려도 된다.
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
				//flag만들어서 boolean true false사용하기
				//userinterface에 pattern이 무엇인지 물어본다
				
			}else if(e.getClickCount() == 2) {
				
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// 다음시간에는 polygon을 그려와라

			initDrawing(e.getX(), e.getY());

		}

		@Override
		public void mouseReleased(MouseEvent e) {

			FinishDrawing(e.getX(), e.getY());
		}

		@Override
		public void mouseDragged(MouseEvent e) {// 여기서 지운다

			KeepDrawing(e.getX(), e.getY());// 마우스 움직일때

		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// 여기
		}

		@Override
		public void mouseEntered(MouseEvent e) {/* 마우스가 들어오면 작동 */
		}

		@Override
		public void mouseExited(MouseEvent e) {/* 마우스가 나가면 끝 shaed */
		}
	}

}

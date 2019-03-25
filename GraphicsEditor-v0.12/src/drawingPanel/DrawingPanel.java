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
		
		//점선이 됐다가 실선이 되게 해라
	    
	

	}

	private class MouseHandler implements MouseListener, MouseMotionListener {
	

		@Override
		public void mouseClicked(MouseEvent e) {
               //click move click move하다가 끝내고 싶을때 끝내야한다.
			//여기서 더블클릭을 확인해야한다.
		} 

		@Override
		public void mousePressed(MouseEvent e) {
			// 다음시간에는 polygon을 그려와라
		
			
			drawShape(e.getX(), e.getY());

		}

		@Override
		public void mouseReleased(MouseEvent e) {

		}

		@Override
		public void mouseDragged(MouseEvent e) {// 여기서 지운다

			moveShape(e.getX(), e.getY());
		



		}

		@Override
		public void mouseMoved(MouseEvent e) {
//여기
		}

		@Override
		public void mouseEntered(MouseEvent e) {/* 마우스가 들어오면 작동 */
		}

		@Override
		public void mouseExited(MouseEvent e) {/* 마우스가 나가면 끝 shaed */
		}
	}

}

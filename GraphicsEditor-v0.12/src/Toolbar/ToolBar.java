package Toolbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JToolBar;
import Global.Constant.EToolBar;
import drawingPanel.DrawingPanel;

public class ToolBar extends JToolBar {
	private static final long serialVersionUID = 1L;
	// component
	private Vector<JButton> buttons;


	// association
	private DrawingPanel drawingPanel;

	public void associate(DrawingPanel drawingPanel) {
		this.drawingPanel = drawingPanel;
	}

	public ToolBar() {
		this.buttons = new Vector<JButton>();
		ActionHandler actionHandler = new ActionHandler();
		for(EToolBar eToolBar:EToolBar.values()) {
			JButton button = new JButton(eToolBar.getText());
		     button.setActionCommand(eToolBar.name());
		     button.addActionListener(actionHandler);
		     this.buttons.add(button);
		     this.add(button);
		}
	}

	private class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {

			drawingPanel.setCurrentTool(EToolBar.valueOf(event.getActionCommand()));
		
			//Toolbar에서는 몇번째 CLASS인지 알려주고 dRAWINGpANEL에서 SHAP화 한다.

		}

	}
}

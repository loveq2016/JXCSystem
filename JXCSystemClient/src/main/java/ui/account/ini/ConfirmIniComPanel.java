package ui.account.ini;

import ui.FatherPanel;
import ui.account.AccountAllUIController;
import ui.setting.MyFrame;

public class ConfirmIniComPanel extends FatherPanel{
	AccountAllUIController uiController;
	public ConfirmIniComPanel(MyFrame frame,String url,
			AccountAllUIController uiController){
		super(frame,url,uiController);
		this.uiController = uiController;
		this.repaint();
		
		uiController.setBack_first(this);
		
		
	}
}

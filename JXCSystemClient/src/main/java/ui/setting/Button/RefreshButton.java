package ui.setting.Button;

import ui.FatherPanel;
/**
 * 刷新按钮
 * @author ZYC
 *
 */
public class RefreshButton {
	public MyButton refreshButton;
	public RefreshButton(FatherPanel panel) {
		refreshButton = new MyButton("Image/refresh.png",70,555,"Image/refresh_stop.png","Image/refresh_stop.png");
		panel.add(refreshButton);
	}
}

package ui.commodity;

import javax.swing.JFrame;

import ui.FatherPanel;
import ui.UIController;
import ui.setting.MyFrame;
import ui.setting.resultPanels.ResultPanelController;
/**
 * 库存盘点界面，功能未实现
 * @author ZYC
 *
 */
public class InventoryPanel extends FatherPanel{
	MyFrame myFrame;
	CommodityAllUIController commodityAllUIController;
	
	
	public InventoryPanel(MyFrame frame, String url, CommodityAllUIController controller) {
		super(frame, url, controller);
		this.commodityAllUIController = controller;
		commodityAllUIController.setBack_first(this);
		setTable();
	}
	private void setTable() {
		
	}

}

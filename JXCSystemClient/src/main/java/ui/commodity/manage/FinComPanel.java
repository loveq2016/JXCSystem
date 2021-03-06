package ui.commodity.manage;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import ui.CommodityPanel;
import ui.FatherPanel;
import ui.commodity.CommodityAllUIController;
import ui.setting.ColorFactory;
import ui.setting.MyFrame;
import ui.setting.MyTable;
import ui.setting.MyTextFieldBorder;
import ui.setting.SetTable;
import ui.setting.Button.ForwardButton;
import ui.setting.Button.MyButton;
import ui.setting.resultPanels.ResultPanelController;
import vo.CommodityVO;
import businesslogic.commoditybl.CommodityController;
import businesslogicservice.commodityblservice.CommodityblService;
/**
 * 确认商品界面，精确查找前往商品具体信息界面显示商品具体信息，
 * 模糊查找返回主界面列表显示信息
 * @author ZYC
 *
 */
public class FinComPanel extends FatherPanel implements ActionListener{
	
	private ColorFactory colors = new ColorFactory();;
	MyTable showTable;
	private MyFrame frame;
	private CommodityAllUIController commodityAllUIController;
	private MyButton exactForwardButton,fuzzyForwardButton;
	private MyTextFieldBorder name,typeID,info;
	private String nameString,infoString,typeIDString;
	
	private CommodityVO com;
	private ResultPanelController resController;
	private String failedAddress;
	
	private CommodityblService commodityblService;
	
	public FinComPanel(MyFrame frame, String url, CommodityAllUIController commodityAllUIController) {
		super(frame, url, commodityAllUIController);
		
		this.frame = frame;
		this.commodityAllUIController = commodityAllUIController;
		
		this.repaint();
	
		resController = new ResultPanelController(frame, this);
		this.failedAddress = "com/finCom";
		
		commodityblService = new CommodityController();
		
		commodityAllUIController.setBack_second(this,178 ,115 );
		init();
	}




	private void init() {
		setForward();
		setTextField();
	}




	private void setTextField() {
		name = new MyTextFieldBorder(254, 218);
		typeID = new MyTextFieldBorder(254, 307);
		info = new MyTextFieldBorder(254, 423);
		
		this.add(typeID);
		this.add(name);
		this.add(info);
	}



	private void setForward() {
		ForwardButton exactForward = new ForwardButton(630, 304);
		ForwardButton fuzzyForward = new ForwardButton(630, 424);
		
		exactForwardButton = exactForward.forward_white;
		fuzzyForwardButton = fuzzyForward.forward_white;
		
		this.add(exactForwardButton);
		this.add(fuzzyForwardButton);
		
		exactForwardButton.addActionListener(this);
		fuzzyForwardButton.addActionListener(this);
	}




	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exactForwardButton){
			commodityAllUIController.setTempPanel(this);
			frame.remove(this);
			exactFind();
		
			
			
		}else if(e.getSource() == fuzzyForwardButton){
			commodityAllUIController.setTempPanel(this);
			frame.remove(this);
			fuzzyFind();
			
		}
	}


	private void setTable(ArrayList<String> info){
	
		showTable = new MyTable();
		showTable.setColor(colors.comColor,colors.greyFont, colors.comColor,Color.white);
		showTable.setTable(info);
		new SetTable(showTable, frame, commodityAllUIController);
	}

	private void fuzzyFind() {
		infoString = info.getText();
		if(infoString.equals("")){
			resController.failed("存在输入为空！", failedAddress);
		}else{
			//CommodityVO(String id, String name, String type, int num, double inValue, double outValue,
			//double latestInValue, double latestOutValue,int warn) {
		// 编号、名称、型号、库存数量、进价、零售价、最近进价、最近零售价
			try{
				ArrayList<CommodityVO> comArray = commodityblService.searchFuzzyCommodity_up(infoString);
				if(comArray == null){
					resController.failed("您要查看的商品不存在！", failedAddress);
				}else{
				ArrayList<String> comArr = new ArrayList<String>();
				comArr.add("编号;名称;型号;库存数量;进价;零售价;最近进价;最近售价;警戒数量;分类");
				for(int i=0;i<comArray.size();i++){
					String item = comArray.get(i).id+";"+comArray.get(i).name+";"+comArray.get(i).type+
							";"+comArray.get(i).num+";"+comArray.get(i).inValue+";"+comArray.get(i).outValue+
							";"+comArray.get(i).latestInValue+";"+comArray.get(i).latestOutValue+";"+
							comArray.get(i).warn+";"+comArray.get(i).fatherSort;
					comArr.add(item);
				}
				setTable(comArr);
				}
			}catch(Exception e){
			resController.failed("您要查看的商品不存在！", failedAddress);
			}
		}
	}




	private void exactFind() {
		nameString = name.getText();
		typeIDString = typeID.getText();
		if(nameString.equals("")||typeIDString.equals("")){
			resController.failed("存在输入为空！", failedAddress);
		} else {
			try{
				com = commodityblService.searchAccurateCommodity_up(nameString, typeIDString);
				if(com == null){
					resController.failed("你要查看的商品不存在！", failedAddress);
				} else {
					commodityAllUIController.comDetail(com);
				}
			}catch(Exception e){
				resController.failed("你要查看的商品不存在！", failedAddress);
			}
		}
	}
	
	

	
}

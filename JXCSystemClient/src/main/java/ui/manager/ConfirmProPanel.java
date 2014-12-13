package ui.manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.setting.ForwardButton;
import ui.setting.MyButton;
import ui.setting.MyFrame;
import ui.setting.resultPanels.ResultPanelController;
import vo.promotion.DiscountVO;
import vo.promotion.ProGiftVO;
import vo.promotion.VoucherVO;
import businesslogic.promotionbl.PromotionController;
import businesslogicservice.promotionblservice.PromotionblService;

public class ConfirmProPanel extends ProDetailPanel implements ActionListener{
	
	ResultPanelController resController;
	private MyFrame frame;
	private ManagerAllUIController uiController;
	private MyButton forwardButton;
	private PromotionblService promotionblService;
	private DiscountVO discount;
	private VoucherVO voucher;
	private ProGiftVO gift;
	public ConfirmProPanel(MyFrame frame, String url,
			ManagerAllUIController controller, DiscountVO discount) {
		super(frame, url, controller, discount);
		this.frame = frame;
		this.uiController = controller;
		this.discount = discount;
		promotionblService = new PromotionController();
		addPro();
		forwardButton.setActionCommand("discount");
		
	}

	public ConfirmProPanel(MyFrame frame, String url,
			ManagerAllUIController controller, VoucherVO voucher) {
		super(frame, url, controller, voucher);
		this.voucher = voucher;
		this.frame = frame;
		this.uiController = controller;
		addPro();
		forwardButton.setActionCommand("voucher");
		
	}

	public ConfirmProPanel(MyFrame frame, String url,
			ManagerAllUIController controller, ProGiftVO gift) {
		super(frame, url, controller, gift);
		this.gift = gift;
		this.frame = frame;
		this.uiController = controller;
		addPro();
		forwardButton.setActionCommand("gift");
	}
	/**
	 * 下面三个方法用于向下层传新增的促销策略
	 */
	private int addProGift() {
		return (promotionblService.makeGift_up(gift));
	}


	private int addDiscount() {
		return(promotionblService.makeDiscount_up(discount));
	}

	private int addVoucher() {
		return(promotionblService.makeVoucher_up(voucher));
	}
	
	private void addPro() {
		ForwardButton forwardDel = new ForwardButton(700,445);
		forwardButton = forwardDel.forward_black;		
		this.add(forwardButton);
		forwardButton.addActionListener(this);
		resController = new ResultPanelController(controller, frame);
	}
	//-1 未知错误
	//1  商品不存在
	//2  库存中商品数量不足，不能完成赠品促销
	//3  客户等级不存在
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("discount")){
			frame.remove(this);
			switch(addDiscount()){
			case 0:
				resController.succeeded("成功添加一个折扣促销策略！", "manager");
				break;
			case 1:
				resController.failed("商品不存在!", "manager");
				break;
			case 2:
				resController.failed("库存中商品数量不足，不能完成赠品促销!", "manager");
				break;
			case 3:
				resController.failed("客户等级不存在!", "manager");
				break;
			case -1:
				resController.failed("未知错误!", "manager");
				break;
			}
		}else if(e.getActionCommand().equals("voucher")) {
			frame.remove(this);
			switch(addVoucher()){
			case 0:
				resController.succeeded("成功添加一个优惠券促销策略！", "manager");
				break;
			case 1:
				resController.failed("商品不存在!", "manager");
				break;
			case 2:
				resController.failed("库存中商品数量不足，不能完成赠品促销!", "manager");
				break;
			case 3:
				resController.failed("客户等级不存在!", "manager");
				break;
			case -1:
				resController.failed("未知错误!", "manager");
				break;
			}
		}else if (e.getActionCommand().equals("gift")) {
			frame.remove(this);
			switch(addProGift()){
			case 0:
				resController.succeeded("成功添加一个赠品促销策略！", "manager");
				break;
			case 1:
				resController.failed("商品不存在!", "manager");
				break;
			case 2:
				resController.failed("库存中商品数量不足，不能完成赠品促销!", "manager");
				break;
			case 3:
				resController.failed("客户等级不存在!", "manager");
				break;
			case -1:
				resController.failed("未知错误!", "manager");
				break;
			}
		}
	}

}
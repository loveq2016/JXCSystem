package ui.account.payRe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.AccountPanel;
import ui.FatherPanel;
import ui.UIController;
import ui.account.AccountAllUIController;
import ui.setting.ColorFactory;
import ui.setting.MyFrame;
import ui.setting.MyLabel;
import ui.setting.Button.ForwardButton;
import ui.setting.Button.MyButton;
import ui.setting.resultPanels.ResultPanelController;
import vo.bill.PayVO;
import businesslogic.accountbl.AccountController;
import businesslogicservice.accountblservice.AccountblService;

/**
 * 确认付款
 * 
 * @author ZYC
 * 
 */
public class ConfirmPaymentPanel extends FatherPanel implements ActionListener {
	AccountAllUIController uiController;
	MyLabel idLabel, operator, agent, item, total, ps;
	MyLabel transferList[] = new MyLabel[3];
	String person, operate;
	double totalValue, balanceValue;
	PayVO newPayment;
	MyButton forwardButton;
	ResultPanelController resControllerS,resControllerF;
	AccountblService accountblService;

	public ConfirmPaymentPanel(MyFrame frame, String url, AccountAllUIController uiController, PayVO newPayment,
			String person, String operate, double totalValue, double balanceValue) {
		super(frame, url, uiController);
		this.uiController = uiController;
		this.repaint();
		this.newPayment = newPayment;
		this.person = person;
		this.operate = operate;
		this.totalValue = totalValue;
		this.balanceValue = balanceValue;
		accountblService = new AccountController();
		
		
		resControllerS = new ResultPanelController(frame,uiController.getMainPanel());
		resControllerF = new ResultPanelController(frame,uiController.getPanel() );
		uiController.setBack_third(this);
		
		setLabel();
		setBalance();
		setForward();
	}

	public ConfirmPaymentPanel(MyFrame frame, String string,
			UIController uiController, PayVO payVO) {
		super(frame, string, uiController);
		this.newPayment = payVO;
		this.person = payVO.itemList.itemName;
		this.operate = payVO.operator;
		this.totalValue = payVO.itemList.money;
		setLabel();
		uiController.setBackBills(this);
	}

	private void setLabel() {
		idLabel = new MyLabel(106, 165, 221, 55);
		operator = new MyLabel(575, 370, 155, 55);
		agent = new MyLabel(406, 369, 155, 55);
		item = new MyLabel(104, 300, 220, 81);
		total = new MyLabel(407, 496, 318, 43);
		ps = new MyLabel(104, 453, 220, 81);
		MyLabel labels[] = new MyLabel[] { idLabel, operator, agent, item, total, ps };
		for (int i = 0; i < labels.length; i++) {
			labels[i].setForeground(new ColorFactory().accColor);
			this.add(labels[i]);
		}

		idLabel.setText(newPayment.note);
		operator.setText(operate);
		agent.setText(person);
		item.setText(newPayment.itemList.itemName);
		total.setText(totalValue + "");
		ps.setText(newPayment.itemList.remark);

		for (int i = 0; i < transferList.length; i++) {
			transferList[i] = new MyLabel(491, 162 + i * 43, 205, 43);
			if (i % 2 == 1) {
				transferList[i].setForeground(new ColorFactory().greyFont);
			} else if (i % 2 == 0) {
				transferList[i].setForeground(new ColorFactory().accColor);
			}
			this.add(transferList[i]);
		}
		transferList[0].setText(newPayment.bankAccount);
		
		transferList[2].setText(newPayment.itemList.money + "");

	}

	/**
	 * 确认 将新生成的VO传向下层
	 */
	private void setForward() {
		ForwardButton forward = new ForwardButton(737, 540);
		forwardButton = forward.forward_black;
		this.add(forwardButton);
		forwardButton.addActionListener(this);
	}

	private void setBalance(){
		transferList[1].setText(balanceValue + "");
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == forwardButton) {
			frame.remove(this);
			switch (accountblService.addPayment_up(newPayment)) {
			case 0:
				AccountPanel temp = (AccountPanel)(uiController.getMainPanel());
				temp.getFinanceInfo();
				uiController.setMainPanel(temp);
				resControllerS.succeeded("成功添加付款单！", "account");
				break;
			case 4:
				resControllerF.failed("客户不存在！", "account");
				break;
			}
		}
	}
}

package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import businesslogic.userbl.UserController;
import businesslogicservice.userblservice.UserblService;

public class LoginPanel extends FatherPanel {

	private static final long serialVersionUID = 3788130429021132822L;
	private JTextField user;
	private JPasswordField password;
	private int inputWidth = 260;
	private int inputHeight = 38;
	private int inputX = 62;
	private int inputY = 233;
	private int interval = 105;
	private JButton login;
	private String userText;
	private String passwordText;
	private JLabel failure;

	public LoginPanel(String url, UIController controller) {
		super(url,controller);
		this.addUserField();
		this.addPasswordField();
		this.addLogin();
		this.repaint();
	}
	
	
	private void addUserField() {
		user = new JTextField("请输入用户名", 20);
		user.setBounds(inputX, inputY, inputWidth, inputHeight);
		user.setBorder(BorderFactory.createEmptyBorder());
		user.addFocusListener(new UserListener());
		this.add(user);
	}

	private void addPasswordField(){
		password = new JPasswordField("请输入密码", 20);
		password.setBounds(inputX, inputY + interval, inputWidth, inputHeight);
		password.setBorder(BorderFactory.createEmptyBorder());
		password.addFocusListener(new PasswordListener());
		this.add(password);
	}
	
	private void addLogin(){
		login = new JButton();
		login.setBounds(228, 126, 43, 44);
		login.setOpaque(false);
		login.setBorder(BorderFactory.createEmptyBorder());
		login.addActionListener(new LoginListener());
		this.add(login);
	}
	
	private void addFailure(){
		failure=new JLabel("您输入的帐户名或密码有误，请重新输入！");
		failure.setBounds(inputX, inputY+2*interval, inputWidth, inputHeight);
		failure.setFont(new Font("宋体",0,15));
		failure.setForeground(Color.red);
		this.add(failure);
	}
	
	class UserListener implements FocusListener {

		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			user.setText("");
		}

		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub

		}

	}

	class PasswordListener implements FocusListener {

		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			password.setText("");
		}

		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub

		}

	}

	class LoginListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			UserblService userbl = new UserController();
			int identity = userbl.login(userText, passwordText);
			userText = user.getText();
			passwordText = new String(password.getPassword());
			switch (identity) {
			case 0: 
				controller.AdminPanel();
				break;
			case 1:
				controller.StockPersonPanel();
				break;
			case 2:
				controller.SalesPersonPanel();
				break;
			case 3:
				controller.SalesManagerPanel();
				break;
			case 4:
				controller.FinPersonPanel();
				break;
			case 5:
				controller.FinManagerPanel();
				break;
			case 6:
				controller.ManagerPanel();
				break;
			default:
				//登陆失败
				addFailure();	
				
			}
           
            	
		}

	}

}

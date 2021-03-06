package ui.setting;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
/*
 * 实现table初始化，内容添加，删除，显示，查找等操作
 */

public class MyTable extends JTable{
//	JPanel backPanel;
	private SaveTempBills infos;
	
	public static JPanel tablePanel;
	static JScrollPane tableSp ;
	public static JTable table;
	DefaultTableModel tableModel;
	Vector columnNames, rowData;
	static DefaultTableCellRenderer render;
	private Color evenColor,oddColor,fontColorEven,fontColorOdd;
	Color headerColor = new Color(239,140,142);

	//	Color evenColor = new Color(237,237,237);
//	Color oddColor = new Color(245,190,185);
//	Color fontColorEven = new Color(159,122,116);
//	Color fontColorOdd = new ColorFactory().accColor
	private ArrayList<Object> vo = new ArrayList<Object>();
	
	public MyTable(){
		
	//	this.backPanel = backPanel;
		setPanel();
	}
	
	
	public void setColor(Color evenColor,Color oddColor,Color fontColorOdd,Color fontColorEven) {
		this.evenColor = evenColor;
		this.oddColor = oddColor;
		this.fontColorEven = fontColorEven;
		this.fontColorOdd = fontColorOdd;
		
	}

	/*
	 * 初始化panel
	 */
	private  void setPanel() {
		
//		tablePanel = new ShowPanel();
		tablePanel = new JPanel();
		
		tablePanel.setLayout(null);
		tablePanel.setBounds(0,0,437 ,428);
		tablePanel.removeAll();
		tablePanel.setOpaque(false);
		tablePanel.setVisible(true);
	//	backPanel.add(tablePanel);
	}
	
	/*
	 * 初始化table
	 */
	public void setTable (ArrayList<String> info) {
		render = new DefaultTableCellRenderer();
		transInformation(info);
		
		tableModel = new DefaultTableModel(rowData,columnNames);
		table = new JTable(tableModel);
		setHeader();
		//setHeader();
	//	table.setBounds(43, 44, 360, 380);
		table.setShowGrid(false);//不显示边框
		table.setEnabled(false);
		
		makeFace(table);
		table.setOpaque(false);// 现将table设置为透明
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
//		table.setRowHeight(25);//第一行行高
//		table.setRowHeight(0,30);//其余行高
	
		table.setRowSelectionAllowed(true);
		
		render.setOpaque(false);// 将渲染器设置为透明
		table.setDefaultRenderer(Object.class, render);
		
		try {
			table.addMouseListener(new UserMouseAdapter() {
				/** *//**
				 * 鼠标单击事件
				 * @param e 事件源参数
				 */
				public void mouseSingleClicked(MouseEvent e){
					//System.out.println("Single Clicked!");
					int rowI  = table.rowAtPoint(e.getPoint());// 得到table的行号
					if (rowI > -1){
						find(rowI,rowI);
						infos.setInfo(rowI);
					}
//						System.out.println("单击鼠标 "+(tableModel.getValueAt(rowI, 0)));
				}

				/** *//**
				 * 鼠标双击事件
				 * @param e 事件源参数
				 */
				public void mouseDoubleClicked(MouseEvent e){
					//System.out.println("Doublc Clicked!");
					int rowI  = table.rowAtPoint(e.getPoint());// 得到table的行号
					if ( rowI > -1){
						infos.getInvoiceInfo(rowI);
						table.setRowSelectionInterval(rowI, rowI);
						System.out.println(rowI);
//						System.out.println("双击鼠标 "+(tableModel.getValueAt(rowI, 0)));
					}

				}
			}  );
		} catch (Exception e) {
//			e.printStackTrace();
		}
	

		tableSp = new JScrollPane(table);
		tableSp.setBounds(43,44,360,380);

		//	tableSp.setBorder(new LineBorder(Color.gray));
		tableSp.getViewport().setOpaque(false);
		tableSp.setOpaque(false);
		tableSp.setViewportView(table);
		//tableSp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	//	tableSp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		table.setFillsViewportHeight(true);
		tablePanel.add(tableSp);
		
		tablePanel.repaint();
//		tablePanel.add(table);
		
//		tablePanel.updateUI();
	}
	
	/*
	 * 设置表头
	 */
	private void setHeader() {
		tableHeader = table.getTableHeader();
		tableHeader.setResizingAllowed(true);
		tableHeader.setOpaque(false);
		tableHeader.setBackground(fontColorOdd);
		tableHeader.setForeground(fontColorEven);
	}
	/*
	 * 解析初始传进的数据
	 */
	private void transInformation(ArrayList<String> info) {
	
		columnNames = new Vector();
		String[] columnNameString = info.get(0).split(";");//表头

		for (int i = 0; i < columnNameString.length; i++) {
			columnNames.add(columnNameString[i]);
		}
		rowData = new Vector();
		for (int i = 1; i < info.size(); i++) {
			Vector dVector = new Vector();
			dVector.clear();
			String[] rowStrings = info.get(i).split(";");
			for (int j = 0; j < rowStrings.length; j++) {
				dVector.add(rowStrings[j]);
			}
			rowData.add(dVector);
		}
	}
	/*
	 * 渲染器
	 */
	private void makeFace(JTable table) {

	    try {
	      DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {
	        public Component getTableCellRendererComponent(JTable table,
	            Object value, boolean isSelected, boolean hasFocus,
	            int row, int column) {
	        	setHorizontalAlignment(SwingConstants.CENTER);//设置居中
//	        	if(row == 0){
//	        		setBackground(headerColor);
//	        		setForeground(Color.white);
//	        	}
	        	if(isSelected){
	        		setSelectionBackground(Color.white);
	        		setForeground(Color.red);
//	        		System.out.println("kkk");
	        	}
	        	else{
	        		if (row% 2 == 0){
	        			
	        			setBackground(oddColor); //设置奇数行底色
	        			setForeground(fontColorOdd);
	        			setSelectionBackground(oddColor);
	        		}
	        		else if (row % 2 == 1){
	        			
	        			setBackground(evenColor); 
	        			setForeground(fontColorEven);//设置偶数行底色
	        			setSelectionBackground(evenColor);
	        		}
	        	}

	          return super.getTableCellRendererComponent(table, value,
	              isSelected, hasFocus, row, column);
	        }
	      };
	      for (int i = 0; i < table.getColumnCount(); i++) {
	        table.getColumn(table.getColumnName(i)).setCellRenderer(tcr);
	      }
	    }
	    catch (Exception ex) {
	      ex.printStackTrace();
	    }

	  }

	/*
	 * 添加一行，自动添至末尾
	 */
	public void add(String info){
		Vector addInfo = new Vector();
		addInfo.clear();
		String[] addRow = info.split(";");
		for(int i = 0;i < addRow.length;i++){
//			System.out.println(addRow[i]);
			addInfo.add(addRow[i]);
//			System.out.println(addInfo.get(i));
		}
//		System.out.println(addInfo.get(0));
		tableModel.addRow(addInfo);
	}
	/*
	 * 删除行，参数为行数
	 */
	public void del(int loc){
		tableModel.removeRow(loc);
	}
	/*
	 * 查找行，参数为开始行数，结束行数
	 */
	public void find(int loc1,int loc2){

		Color selectColor = new Color(1,1,1,50);
		
		table.setRowSelectionInterval(loc1,loc2);
		table.setSelectionBackground(selectColor);
		table.setSelectionForeground(new Color(30,30,30));
	}
	
	
	
	public void setInfo(SaveTempBills infos){
		this.infos = infos;
	}

	public SaveTempBills getInfo(){
		return infos;
	}
	
}

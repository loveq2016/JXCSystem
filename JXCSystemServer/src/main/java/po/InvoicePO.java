package po;

import java.io.Serializable;

public class InvoicePO implements Serializable{
//	String draft_condition;//�ݸ�
//	String submit_condition;//�ύ״̬
//	String approve_condition;//�����
	
	int condition;   //0 代表草稿，1代表待审批。2代表通过。3代表失败
	int type;        //1代表CommodityPO， 2代表ImportPO， 3代表Import_Return， 4代表ExportPO，
					 //5代表Export_Return， 6代表PatchPO， 7代表ReceiptPO， 8代表PaymentPO
	String note;
	

	public InvoicePO() {
		condition=0;
	}
	
	public InvoicePO copy(){
		
		switch(type){
		
		case 1: CommodityPO po1=(CommodityPO) this;
		CommodityPO po1_tem=po1.copy();
		return invoice_copy((InvoicePO) po1_tem,(InvoicePO) po1);
			
		case 2: ImportPO po2=(ImportPO) this;
		ImportPO po2_tem=po2.copy();
		return invoice_copy((InvoicePO) po2_tem,(InvoicePO) po2);
		
		case 3: Import_ReturnPO po3=(Import_ReturnPO) this;
		Import_ReturnPO po3_tem=po3.copy();
		return invoice_copy((InvoicePO) po3_tem,(InvoicePO) po3);
		
		case 4:ExportPO po4=(ExportPO) this;
		ExportPO po4_tem=po4.copy();
		return invoice_copy((InvoicePO) po4_tem,(InvoicePO) po4);
		
		case 5:Export_ReturnPO po5=(Export_ReturnPO) this;
		Export_ReturnPO po5_tem=po5.copy();
		return invoice_copy((InvoicePO) po5_tem,(InvoicePO) po5);
		
		case 6:PatchPO po6=(PatchPO) this;
		PatchPO po6_tem=po6.copy();
		return invoice_copy((InvoicePO) po6_tem,(InvoicePO) po6);
		
		case 7:ReceiptPO po7=(ReceiptPO) this;
		ReceiptPO po7_tem=po7.copy();
		return invoice_copy((InvoicePO) po7_tem,(InvoicePO) po7);
		
		case 8:PaymentPO po8=(PaymentPO) this;
		PaymentPO po8_tem=po8.copy();
		return invoice_copy((InvoicePO) po8_tem,(InvoicePO) po8);
		}
		
		return null;
		
	}
	
	public InvoicePO invoice_copy(InvoicePO po1,InvoicePO po2){
		po1.condition=po2.condition;
		po1.type=po2.type;
		po1.note=po2.note;
		return po1;
	}

	public String getNote_Invoice() {
		// TODO Auto-generated method stub
		return note;
	}

	
	

}

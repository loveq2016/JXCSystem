package po;

import java.io.Serializable;

public class ProGiftPO extends PromotionPO implements Serializable{
	CommodityPO gift;//Ҫ�������Ʒ
	int number;
	
	public ProGiftPO(CommodityPO gift, String start_time, String end_time,int number,
			double start_money,double end_money,int level) {
		super(start_time,end_time,level,start_money,end_money);
		this.gift = gift;
		this.number=number;
	}	
	
	public ProGiftPO copy(){
		return new ProGiftPO(gift, start_time, end_time,number,start_money,end_money,level);
	}

	public CommodityPO getGift() {
		return gift;
	}
	public int getNumber(){
		return number;
	}
}

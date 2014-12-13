package vo;

import java.util.ArrayList;

public class SortVO {
	
	public String name;
	
	SortVO fatherSort;
	ArrayList<CommodityVO> commodity=new ArrayList<CommodityVO>();
	ArrayList<SortVO> sortList=new ArrayList<SortVO>();
	
	public SortVO(String name){
		this.name=name;
	}
	
	public String getName(){
		return name;
	}
	
	public boolean addSort(SortVO sonSort){
		sonSort.fatherSort=this;
		sortList.add(sonSort);
		return true;
	}
	
	public boolean addCommodity(CommodityVO sonCommodity){
		sonCommodity.fatherSort=this;
		commodity.add(sonCommodity);
		return true;
	}

}

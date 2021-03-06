package data.promotiondata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import po.CommodityPO;
import po.DiscountPO;
import po.ProGiftPO;
import po.VoucherPO;
import data.accountdata.AccountDataService_Stub;
import dataservice.promotiondataservice.PromotionDataService;

public class PromotionDataService_Stub extends UnicastRemoteObject implements PromotionDataService{

	ProGiftPO nowProGift;
	DiscountPO nowDiscount;
	VoucherPO nowVoucher;
	
	ArrayList<ProGiftPO> proGiftList=new ArrayList<ProGiftPO>();
	ArrayList<DiscountPO> discountList=new ArrayList<DiscountPO>();
	ArrayList<VoucherPO> voucherList=new ArrayList<VoucherPO>();
	
	public void writeNowDiscount(){
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("out//nowDiscount.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(nowDiscount);	
			oos.close();
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	public void readNowDiscount(){
		
		FileInputStream fis;
		ObjectInputStream ois;
		
		try{
			
			fis=new FileInputStream("out//nowDiscount.out");
			ois=new ObjectInputStream(fis);
			nowDiscount=(DiscountPO) ois.readObject();
			ois.close();
			
		} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	public void writeNowProGift(){
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("out//nowProGift.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(nowProGift);	
			oos.close();
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	public void readNowProGift(){
		
		FileInputStream fis;
		ObjectInputStream ois;
		
		try{
			
			fis=new FileInputStream("out//nowProGift.out");
			ois=new ObjectInputStream(fis);
			nowProGift=(ProGiftPO) ois.readObject();
			ois.close();
			
		} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	public void writeNowVoucher(){
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("out//nowVoucher.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(nowVoucher);	
			oos.close();
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	public void readNowVoucher(){
		
		FileInputStream fis;
		ObjectInputStream ois;
		
		try{
			
			fis=new FileInputStream("out//nowVoucher.out");
			ois=new ObjectInputStream(fis);
			nowVoucher=(VoucherPO) ois.readObject();
			ois.close();
			
		} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	public void writeProGiftList(){
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("out//proGiftList.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(proGiftList);	
			oos.close();
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	@SuppressWarnings("unchecked")
	public void readProGiftList(){
		
		FileInputStream fis;
		ObjectInputStream ois;
		
		try{
			
			fis=new FileInputStream("out//proGiftList.out");
			ois=new ObjectInputStream(fis);
			proGiftList=(ArrayList<ProGiftPO>) ois.readObject();
			ois.close();
			
		} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	
	public void writeDiscountList(){
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("out//discountList.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(discountList);	
			oos.close();
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	@SuppressWarnings("unchecked")
	public void readDiscountList(){
		
		FileInputStream fis;
		ObjectInputStream ois;
		
		try{
			
			fis=new FileInputStream("out//discountList.out");
			ois=new ObjectInputStream(fis);
			discountList=(ArrayList<DiscountPO>) ois.readObject();
			ois.close();
			
		} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	public void writeVoucherList(){
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("out//voucherList.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(voucherList);	
			oos.close();
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	@SuppressWarnings("unchecked")
	public void readVoucherList(){
		
		FileInputStream fis;
		ObjectInputStream ois;
		
		try{
			
			fis=new FileInputStream("out//voucherList.out");
			ois=new ObjectInputStream(fis);
			voucherList=(ArrayList<VoucherPO>) ois.readObject();
			ois.close();
			
		} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

	public PromotionDataService_Stub() throws RemoteException {
		super();
		
//		this.writeNowDiscount();
//		this.writeNowProGift();
//		this.writeNowVoucher();
//		this.writeProGiftList();
//		this.writeVoucherList();
//		this.writeDiscountList();
		
		this.readNowDiscount();
		this.readNowProGift();
		this.readNowVoucher();
		this.readProGiftList();
		this.readVoucherList();
		this.readDiscountList();
		// TODO Auto-generated constructor stub
	}

	public boolean addDiscount(DiscountPO po) {
		
		for(int i=0;i<discountList.size();i++){
			if(po.getEndTime().compareTo(AccountDataService_Stub.getNowTime())>=0&&(po.getLevel()==discountList.get(i).getLevel())){
				return false;
			}
		}
		if(discountList.add(po.copy())){
			this.writeDiscountList();
			return true;
		}
		return false;
	}

	public boolean addGift(ProGiftPO po) {
		
		for(int i=0;i<proGiftList.size();i++){
			if(po.getEndTime().compareTo(AccountDataService_Stub.getNowTime())>=0&&(po.getLevel()==proGiftList.get(i).getLevel())){
				return false;
			}
		}
		
		if(proGiftList.add(po.copy())){
			this.writeProGiftList();
			return true;
		}
		
		return false;
	}
	
	public boolean addVoucher(VoucherPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
		for(int i=0;i<voucherList.size();i++){
			if(po.getEndTime().compareTo(AccountDataService_Stub.getNowTime())>=0&&(po.getLevel()==voucherList.get(i).getLevel())){
				return false;
			}
		}
		
		if(voucherList.add(po.copy())){
			this.writeVoucherList();
			return true;
		}
		
		return false;
	}
	
	public boolean delDiscount(int level) {
		for(int i=0;i<discountList.size();i++){
			if(level==discountList.get(i).getLevel()){
				discountList.remove(i);
				this.writeDiscountList();
				return true;
			}
		}

		return false;
	}

	public boolean delGift(int level) {
		for(int i=0;i<proGiftList.size();i++){
			if(level==proGiftList.get(i).getLevel()){
				proGiftList.remove(i);
				this.writeProGiftList();
				return true;
			}
		}
		return false;
	}
	
	public boolean delVoucher(int level) throws RemoteException {
		// TODO Auto-generated method stub
		int note=0;
		for(int i=0;i<voucherList.size();i++){
			if(level==voucherList.get(i).getLevel()){
				voucherList.remove(note);
				this.writeVoucherList();
				return true;
			}
		}
		return false;
	}

	public DiscountPO getDiscount(int level) throws RemoteException {
		for(int i=0;i<discountList.size();i++){
			if(level==discountList.get(i).getLevel()&&discountList.get(i).getEndTime().compareTo(AccountDataService_Stub.getNowTime())>=0){
				return discountList.get(i).copy();
			}
		}
		return null;
	}

	public ProGiftPO getGift(int level) throws RemoteException {
		for(int i=0;i<proGiftList.size();i++){
			if(level==proGiftList.get(i).getLevel()&&proGiftList.get(i).getEndTime().compareTo(AccountDataService_Stub.getNowTime())>=0){
				return proGiftList.get(i).copy();
			}
		}
		return null;
	}
	
	public VoucherPO getVoucher(int level) throws RemoteException {
		// TODO Auto-generated method stub
		for(int i=0;i<voucherList.size();i++){
			if(level==voucherList.get(i).getLevel()&&voucherList.get(i).getEndTime().compareTo(AccountDataService_Stub.getNowTime())>=0){
				return voucherList.get(i).copy();
			}
		}
		return null;
	}
	
	public ArrayList<DiscountPO> showDiscount() {
		ArrayList<DiscountPO> array=new ArrayList<DiscountPO>();
		for(int i=0;i<discountList.size();i++){
			if(discountList.get(i).getStartTime().compareTo(AccountDataService_Stub.getNowTime())<=0&&discountList.get(i).getEndTime().compareTo(AccountDataService_Stub.getNowTime())>=0){
				array.add(discountList.get(i).copy());
			}
		}
		return array;
	}

	public ArrayList<ProGiftPO> showProGift() {
		ArrayList<ProGiftPO> array=new ArrayList<ProGiftPO>();
		for(int i=0;i<proGiftList.size();i++){
			if(proGiftList.get(i).getStartTime().compareTo(AccountDataService_Stub.getNowTime())<=0&&proGiftList.get(i).getEndTime().compareTo(AccountDataService_Stub.getNowTime())>=0){
				array.add(proGiftList.get(i).copy());
			}

		}
		return array;
	}

	public ArrayList<VoucherPO> showVoucher() throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<VoucherPO> array=new ArrayList<VoucherPO>();
		for(int i=0;i<voucherList.size();i++){
			if(voucherList.get(i).getStartTime().compareTo(AccountDataService_Stub.getNowTime())<=0&&voucherList.get(i).getEndTime().compareTo(AccountDataService_Stub.getNowTime())>=0){
				array.add(voucherList.get(i).copy());
			}
		}
		return array;
	}

	public boolean clear() throws RemoteException {
		// TODO Auto-generated method stub
		discountList=new ArrayList<DiscountPO>();
		proGiftList=new ArrayList<ProGiftPO>();
		voucherList=new ArrayList<VoucherPO>();
		return true;
	}

}

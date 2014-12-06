package data.salesdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import po.CustomerPO;
import po.ExportPO;
import po.Export_ReturnPO;
import po.ImportPO;
import po.Import_ReturnPO;
import po.PaymentPO;
import dataservice.salesdataservice.SalesDataService;

public class SalesDataService_Stub extends UnicastRemoteObject implements SalesDataService{
	
	
	ArrayList<CustomerPO> customerList=new ArrayList<CustomerPO>();
	ArrayList<ImportPO> importList=new ArrayList<ImportPO>();
	ArrayList<ExportPO> exportList=new ArrayList<ExportPO>();
	ArrayList<Import_ReturnPO> import_returnList=new ArrayList<Import_ReturnPO>();
	ArrayList<Export_ReturnPO> export_returnList=new ArrayList<Export_ReturnPO>();
	ArrayList<ImportPO> draftImportList=new ArrayList<ImportPO>();
	ArrayList<ExportPO> draftExportList=new ArrayList<ExportPO>();
	ArrayList<Import_ReturnPO> draftImport_returnList=new ArrayList<Import_ReturnPO>();
	ArrayList<Export_ReturnPO> draftExport_returnList=new ArrayList<Export_ReturnPO>();
	
	public void writeCustomerList(){
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("customerList.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(customerList);	
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
	public void readCustomerList(){
		
		FileInputStream fis;
		ObjectInputStream ois;
		
		try{
			
			fis=new FileInputStream("customerList.out");
			ois=new ObjectInputStream(fis);
			customerList=(ArrayList<CustomerPO>) ois.readObject();
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
	
	
	public void writeImportList(){
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("importList.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(importList);	
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
	public void readImportList(){
		
		FileInputStream fis;
		ObjectInputStream ois;
		
		try{
			
			fis=new FileInputStream("importList.out");
			ois=new ObjectInputStream(fis);
			importList=(ArrayList<ImportPO>) ois.readObject();
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
	
	
	public void writeImport_ReturnList(){
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("import_returnList.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(import_returnList);	
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
	public void readImport_ReturnList(){
		
		FileInputStream fis;
		ObjectInputStream ois;
		
		try{
			
			fis=new FileInputStream("import_returnList.out");
			ois=new ObjectInputStream(fis);
			import_returnList=(ArrayList<Import_ReturnPO>) ois.readObject();
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
	
	
	public void writeExportList(){
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("exportList.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(exportList);	
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
	public void readExportList(){
		
		FileInputStream fis;
		ObjectInputStream ois;
		
		try{
			
			fis=new FileInputStream("exportList.out");
			ois=new ObjectInputStream(fis);
			exportList=(ArrayList<ExportPO>) ois.readObject();
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
	
	
	public void writeExport_ReturnList(){
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("export_returnList.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(export_returnList);	
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
	public void readExport_ReturnList(){
		
		FileInputStream fis;
		ObjectInputStream ois;
		
		try{
			
			fis=new FileInputStream("export_returnList.out");
			ois=new ObjectInputStream(fis);
			export_returnList=(ArrayList<Export_ReturnPO>) ois.readObject();
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
	
	public void writeDraftImportList(){
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("draftImportList.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(draftImportList);	
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
	public void readDraftImportList(){
		
		FileInputStream fis;
		ObjectInputStream ois;
		
		try{
			
			fis=new FileInputStream("draftImportList.out");
			ois=new ObjectInputStream(fis);
			draftImportList=(ArrayList<ImportPO>) ois.readObject();
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
	
	
	public void writeDraftImport_ReturnList(){
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("draftImport_returnList.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(draftImport_returnList);	
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
	public void readDraftImport_ReturnList(){
		
		FileInputStream fis;
		ObjectInputStream ois;
		
		try{
			
			fis=new FileInputStream("draftImport_returnList.out");
			ois=new ObjectInputStream(fis);
			draftImport_returnList=(ArrayList<Import_ReturnPO>) ois.readObject();
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
	
	
	public void writeDraftExportList(){
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("draftExportList.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(draftExportList);	
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
	public void readDraftExportList(){
		
		FileInputStream fis;
		ObjectInputStream ois;
		
		try{
			
			fis=new FileInputStream("draftExportList.out");
			ois=new ObjectInputStream(fis);
			draftExportList=(ArrayList<ExportPO>) ois.readObject();
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
	
	
	public void writeDraftExport_ReturnList(){
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("draftExport_returnList.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(draftExport_returnList);	
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
	public void readDraftExport_ReturnList(){
		
		FileInputStream fis;
		ObjectInputStream ois;
		
		try{
			
			fis=new FileInputStream("draftExport_returnList.out");
			ois=new ObjectInputStream(fis);
			draftExport_returnList=(ArrayList<Export_ReturnPO>) ois.readObject();
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
	
	
	
	public SalesDataService_Stub() throws RemoteException {
		super();
		this.readCustomerList();
		this.readDraftImportList();
		this.readDraftImport_ReturnList();
		this.readDraftExportList();
		this.readDraftExport_ReturnList();
		this.readImportList();
		this.readImport_ReturnList();
		this.readExportList();
		this.readExport_ReturnList();
		// TODO Auto-generated constructor stub
	}

//	public SaleDataService_Stub(String address, String clerk, int amount,
//			int money, String mail, String zip, String phone, String type,
//			int level, int id) {
//		this.address = address;
//		this.clerk = clerk;
//		this.amount = amount;
//		this.money = money;
//		this.mail = mail;
//		this.zip = zip;
//		this.phone = phone;
//		this.type = type;
//		this.level = level;
//		this.id = id;
//	}
//
//	String address;
//	String clerk;
//	int amount;
//	int money;
//	String mail;
//	String zip;
//	String phone;
//	String type;
//	int level;
//	int id;

	public boolean addCustomer(CustomerPO po) {
		return true;
	}

	public boolean delCustomer(CustomerPO po) {
		return true;
	}

	public boolean updateCustomer(CustomerPO po1, CustomerPO po2) {
		return true;
	}

	public CustomerPO findCustomer(String name) {
		return new CustomerPO("1", name,1, false, "phone", "zip", "mail", 1000, 2000, "clerk", "address");
	}

	public boolean addImport(ImportPO po) {
		return true;
	}

	public boolean addImport_Return(Import_ReturnPO po) {
		return true;
	}

	public boolean addExport(ExportPO po) {
		return true;	}

	public boolean addExport_Return(Export_ReturnPO po) {
		return true;
	}

	public ArrayList<CustomerPO> getAllCustomer() {
		return customerList;
	}

	public ArrayList<ImportPO> getAllImport() {
		return importList;
	}

	public ArrayList<Import_ReturnPO> getAllImport_Return() {
		return import_returnList;
	}

	public ArrayList<ExportPO> getAllExport() {
		return exportList;
	}

	public ArrayList<Export_ReturnPO> getAllExport_Return() {
		return export_returnList;
	}

	public boolean clear() {
		return true;
	}

	public boolean addDraftImport(ImportPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addDraftImport_Return(Import_ReturnPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addDraftExport(ExportPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addDraftExport_Return(Export_ReturnPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delDraftImport(String note) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delDraftImport_Return(String note) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delDraftExport(String note) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delDraftExport_Reutrn(String note) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<ImportPO> getAllDraftImport() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Import_ReturnPO> getAllDraftImport_Return()
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<ExportPO> getAllDraftExport() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Export_ReturnPO> getAllDraftExport_Return()
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ImportPO getImport(String note) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ImportPO getDraftImport(String note) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public Import_ReturnPO getImport_Return(String note) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public Import_ReturnPO getDraftImport_Return(String note)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ExportPO getExport(String note) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ExportPO getDraftExport(String note) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public Export_ReturnPO getExport_Return(String note) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public Export_ReturnPO getDraftExport_Return(String note)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCustomerNote() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getImportNote() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getImport_ReturnNote() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getExportNote() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getExport_ReturnNote() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}

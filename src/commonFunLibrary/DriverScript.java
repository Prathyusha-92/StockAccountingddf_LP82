package commonFunLibrary;

import java.io.IOException;

import utilities.ExcelFileUtil;

public class DriverScript {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		ERP_Functions erp=new ERP_Functions();
		ExcelFileUtil exl=new ExcelFileUtil();
		int rowcount=exl.rowCount("Supplier");
		for(int i=1;i<=rowcount;i++){
			
			String sname=exl.getData("Supplier",i, 0);
			String address=exl.getData("Supplier", i, 1);
			String city=exl.getData("Supplier", i, 2);
			String country=exl.getData("Supplier", i, 3);
			String cperson=exl.getData("Supplier", i, 4);
			String pnumber=exl.getData("Supplier", i, 5);
			String mail=exl.getData("Supplier", i, 6);
			String mnumber=exl.getData("Supplier", i, 7);
			String note=exl.getData("Supplier", i, 8);
			erp.launchAPP("http://webapp.qedge.com/login.php");
			erp.login("admin", "master");
			String Results=erp.supplier(sname, address, city, country, cperson, pnumber, mail, mnumber, note);
			System.out.println(Results);
			exl.setData("supplier", i, 9, Results);
			erp.logout();
		}
	}

}

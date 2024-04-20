package learnTestNg;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import com.tyss.easywhiz.GenericUtility.ExcelUtility;

public class DataProviderConcept {
	
	
	ExcelUtility exLib= new ExcelUtility();
	

	@DataProvider
	@Factory
	public Object[][] logindata() throws Throwable {
		
		Object[][] obj = new Object[2][2];
		
		obj[0][0]= exLib.readTheDataFromExcelSheet("dataprovider", 0, 0);
		obj[0][1]= exLib.readTheDataFromExcelSheet("dataprovider", 0, 1);
		
		obj[1][0]= exLib.readTheDataFromExcelSheet("dataprovider", 1, 0);
		obj[1][1]= exLib.readTheDataFromExcelSheet("dataprovider", 1, 1);
		
		return obj;
		

	}
}
package DataProviderTestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataprovier {

	
	@Test(dataProvider="driveTest")
	public void testcaseData(String name, int internal, int external ) {
		System.out.println(name+" "+internal+"  "+external);
	}
	
	
	
	@DataProvider(name="driveTest")
public Object[][] getData( ) {    // Object [][] array means it may be int string, or any data type
		
		Object [][] datas= {{"name",25, 100},{"Ram",20, 75},{"Om",15, 60}}; 
		return datas;
	}
}

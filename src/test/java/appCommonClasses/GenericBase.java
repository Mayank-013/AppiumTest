package appCommonClasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.logging.log4j.ThreadContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.nitara.utils.DriverManager;





public class GenericBase extends PageInitialiser{
	
	public static Properties prop;
	public GenericBase()
	{
		try 
		{
			prop=new Properties();
			FileInputStream fis=new FileInputStream("src\\main\\resources\\Config.properties");
			prop.load(fis);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	@BeforeMethod(alwaysRun=true)
	@Parameters({ "URL","Udid","DeviceName","SystemPort"})
	public static void initialize(String URL,String Udid, String DeviceName, String SystemPort) throws Exception {
	

		new DriverManager().initializeDriver(URL,Udid, DeviceName,SystemPort);
		
		PageInitialiser.initializeAllPages();
	}

	@AfterMethod(alwaysRun=true)
	public static void quit() throws InterruptedException{
		DriverManager driverManager = new DriverManager();
		if(driverManager.getDriver() != null){
			driverManager.getDriver().quit();
			driverManager.setDriver(null);
		}
		
	}

}

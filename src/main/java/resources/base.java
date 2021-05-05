package resources;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.readConfigFile;

public class base {
	
	readConfigFile rc = new readConfigFile();
	public String baseURL = rc.getURL();
	
	public static WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	
	@BeforeTest
	public void setup()
	{
		log.info("*****************************************");
		log.info("------------AUTOMATION STARTED-----------");
		log.info("*****************************************");
		
		if(rc.getBrowser().contains("chrome"))
		{
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.info("chrome driver is initialized");
			
		} else if(rc.getBrowser().contains("firefox")) 
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			log.info("Firefox driver is initialized");
			
		}else if(rc.getBrowser().contains("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			log.info("edge driver is initialized");
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	}
	
	public void getScreenshot(String testCaseName) throws IOException
	{
		log.debug("Screenshot of fail testcase is taken");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destPath = System.getProperty("user.dir")+"\\Screenshot\\"+testCaseName+".png";
		File dest = new File(destPath);
		FileUtils.copyFile(source, dest);
	}

}

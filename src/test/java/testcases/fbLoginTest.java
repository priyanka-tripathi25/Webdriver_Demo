package testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import objectRepositories.facebookLoginPage;
import resources.base;
import utilities.readConfigFile;

public class fbLoginTest extends base{
	
	
	public static Logger log = LogManager.getLogger(fbLoginTest.class.getName());
	readConfigFile rc = new readConfigFile();
	
	@Test
	public void fblogin() throws InterruptedException
	{
		facebookLoginPage fl = new facebookLoginPage(driver);
		driver.get(rc.getURL());
		log.info("Facebook login page");
		fl.setEmail(rc.getEmail());
		log.info("Valid email is entered");
		fl.setPassword(rc.getPassword());
		log.info("Valid password is entered");
		Thread.sleep(1000);
		fl.clickLogin();
		log.info("click on login button");
		
	}

}

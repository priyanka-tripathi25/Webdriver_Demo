package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class readConfigFile {
	
	static FileInputStream fis;
	static Properties pro;
	
	public readConfigFile()
	{
		
		File src = new File("./Configuration/config.properties");
		
		try {
			
			fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
			
		} catch (Exception e) {
			
			System.out.println("Exception is : "+ e.getMessage());
			System.out.println("Exception is :"+ e.getCause());
		}
		
	}
	
	public String getURL()
	{
		String getUrl = pro.getProperty("url");
		return getUrl;
	}
	
	public String getBrowser()
	{
		String getBrowser = pro.getProperty("browser");
		return getBrowser;
	}
	
	public String getEmail()
	{
		String getEmail = pro.getProperty("email");
		return getEmail;
	}
	
	public String getPassword()
	{
		String getPwd = pro.getProperty("password");
		return getPwd;
	}
	

}

package resources;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import objectRepositories.MonitoringMail;
import objectRepositories.TestConfig;

public class Listeners extends base implements ITestListener, ISuiteListener{
	
	
	ExtentReports extent = ExtentReport.extentReportGenerator();
	ExtentTest test;
	
	public String messageBody;
	
	public void onTestStart(ITestResult result) {
		
		test = extent.createTest(result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result) {
		
		test.log(Status.PASS, "Successful");
		
	}

	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());
		String testCaseName = result.getMethod().getMethodName();
		
		try {
			getScreenshot(testCaseName);
			
		} catch (Exception e) {
			
			System.out.println("Exception is :"+e.getMessage());
			System.out.println("Exception is :"+e.getCause());
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		extent.flush();
		
	}

	

	public void onFinish(ISuite suite) {
		
		MonitoringMail mail = new MonitoringMail();
		
		
		try {
			messageBody = "http://" + InetAddress.getLocalHost().getHostAddress() + ":8080/job/PracticeProject25thfeb20/Extent_20Report/";
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, messageBody);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		
	}
	

}

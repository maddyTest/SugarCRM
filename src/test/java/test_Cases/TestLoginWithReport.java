package test_Cases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.LoginPage;

public class TestLoginWithReport {

	WebDriver d;
	public static ExtentReports report;
	ExtentTest logger;
	
	@BeforeMethod
	public void setup() throws IOException
	{
		report = new ExtentReports("./Reports/LoginPageReport.html", true);
		
		logger = report.startTest("Login Test");
		report.addSystemInfo("Host Name", "Mahadev");
		d = BrowserFactory.getBrowser("firefox");
		d.get(DataProviderFactory.getConfig().getApplicationUrl());
		logger.log(LogStatus.INFO, "Application is started running");
	}
	
	@Test
	public void verifyLogin() throws IOException
	{
		LoginPage login = PageFactory.initElements(d, LoginPage.class);
		
		logger.assignAuthor("Maddy");
		logger.assignCategory("Smoke");
		String title = login.getApplicationTitle();
		Assert.assertTrue(title.contains("SugarCRM"));
		logger.log(LogStatus.PASS,"Login Page is loaded and verified successfully");
	
		
		
		/*
		for(int i=4;i<=6;i++)
		{
			for(int j=0;j<=1;j++)
			{
				login.loginApplication(DataProviderFactory.getExcel().getData(0, i, j), DataProviderFactory.getExcel().getData(0, i, j));
			}
		}
		*/
		
		
		login.loginApplication(DataProviderFactory.getExcel().getData(0, 0, 0), DataProviderFactory.getExcel().getData(0, 0, 1));
		logger.log(LogStatus.INFO, "Click on login Button");
		login.verifyLogoutLink();
		logger.addScreenCapture(utility.Helper.captureScreenshot(d, "Lobin"));
		logger.addBase64ScreenShot(utility.Helper.captureScreenshot(d, "Login"));
		logger.log(LogStatus.PASS, "Logout link is verified successfully");  
	}
	
	@AfterMethod()
	public void cleanUp()
	{
		//BrowserFactory.closeBrowser(d);
		report.endTest(logger);
		//report.flush();
	}
	
}

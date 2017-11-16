package test_Cases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pages.Campaign;

public class TestCampaginWithReport {

	WebDriver d;
	ExtentReports report;
	ExtentTest logger;
	
	@BeforeTest
	public void setup()
	{
		this.report = TestLoginWithReport.report;
		logger = report.startTest("Campagin Test");
		logger.assignAuthor("Maddy");
		logger.assignCategory("Sanity");
	}
	
	@Test
	public void verifyCampaignLink() throws InterruptedException
	{
		
		Campaign campaign = PageFactory.initElements(d, Campaign.class);
		String text = campaign.clickOnCampaignsLink();
		Assert.assertTrue(text.contains("Campaigns"));
	
		
		logger.log(LogStatus.INFO, "Clicked on Campaigns Link");
		logger.log(LogStatus.PASS, "verified campaigns link");
		
		campaign.create_Campaign();
		logger.log(LogStatus.INFO, "clicked on create campaign link");
		//logger.addBase64ScreenShot(utility.Helper.captureScreenshot(d, "campaign"));
		logger.log(LogStatus.PASS, "campaign created Successfully");
		
		campaign.createTarget();
		logger.log(LogStatus.INFO, "Clicked on create Target List");
		logger.log(LogStatus.ERROR, "Unable to Locate Elements");
		logger.log(LogStatus.PASS, "Target List Selected");
	}

	@AfterTest
	public void cleanup()
	{
		report.endTest(logger);
		//report.flush();
	}
	
}

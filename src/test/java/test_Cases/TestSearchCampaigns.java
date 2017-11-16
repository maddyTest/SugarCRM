package test_Cases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import pages.SearchCampaign;

public class TestSearchCampaigns {

	WebDriver d;
	ExtentReports report;
	ExtentTest logger;
	
	@BeforeTest
	public void setup()
	{
		this.report = TestLoginWithReport.report;
		logger = report.startTest(" Search Campagin Test");
		logger.assignAuthor("Maddy");
		logger.assignCategory("Sanity");	
	}
	
	@Test
	public void verifySearchCampaign()
	{
		SearchCampaign sc = new SearchCampaign();
		sc.searchCampaigns();
	}
	
	@AfterTest
	public void cleanUp1()
	{
		report.endTest(logger);
		report.flush();
	}
}

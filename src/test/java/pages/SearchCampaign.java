package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchCampaign {

	WebDriver driver;
	
	public SearchCampaign()
	{
		this.driver = LoginPage.d;
	}
	
	
	public void searchCampaigns()
	{
		WebElement campaign_Link = driver.findElement(By.xpath(".//*[@id='moduleTab_0_Campaigns']"));
		campaign_Link.click();
		driver.findElement(By.xpath(".//*[@id='name_advanced']")).sendKeys("Sale");
		
	}
}

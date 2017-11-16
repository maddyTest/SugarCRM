package pages;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Campaign {

	WebDriver driver;
		
	By create = By.xpath(".//*[@id='create_link']");
	
	
	public Campaign(WebDriver d)
	{
		this.driver = LoginPage.d;
	}
	
	public String clickOnCampaignsLink()
	{
		WebElement campaign_Link = driver.findElement(By.xpath(".//*[@id='moduleTab_0_Campaigns']"));
		campaign_Link.click();
		String text = driver.getCurrentUrl();
		//System.out.println(text);
		//create = By.xpath(".//*[@id='create_link']");
		return text;		
	}
	
	public void create_Campaign() throws InterruptedException
	{
		
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(create));
		element.click();
		WebElement name = driver.findElement(By.xpath(".//*[@id='name']"));
		name.sendKeys("Hero Sale");
		Select s = new Select(driver.findElement(By.id("status")));
		s.selectByValue("Active");
		driver.findElement(By.xpath(".//*[@id='start_date_trigger']")).click(); //start date trigger
		driver.findElement(By.xpath(".//*[@id='start_date_trigger_div_t_cell15']/a")).click();		
		WebElement type = driver.findElement(By.id("campaign_type")); //type 
		s = new Select(type);
		s.selectByValue("Mail");
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//img[contains(@id,'end_date_trigger')]")).click();
		WebElement dd = driver.findElement(By.xpath(".//*[@id='end_date_trigger_div_t_cell34']"));
		dd.click();
		/*java.util.List<WebElement> dates = driver.findElements(By.xpath(".//img[contains(@id,'end_date_trigger')]"));
		System.out.println(dates.get(1).isEnabled());
		System.out.println(dates.get(1).isDisplayed());
		System.out.println(dates.get(1).isSelected());
		dates.get(20).click();
		Thread.sleep(3000); */
		WebElement save = driver.findElement(By.xpath(".//*[@id='SAVE_FOOTER' and @name='button']"));
		save.click();
		
	}
	
	public void createTarget() throws InterruptedException
	{
		WebElement create = driver.findElement(By.xpath(".//*[@id='list_subpanel_prospectlists']/table/tbody/tr[1]/td/table/tbody/tr/td[1]/ul/li/span"));
		create.click();
		driver.findElement(By.xpath(".//*[@id='prospect_list_campaigns_select_button']")).click();
		Thread.sleep(5000);
		//driver.findElement(By.xpath(".//a[contains(@href,'javascript:void(0)')]")).click();
		Set<String> handles =  driver.getWindowHandles();
		String []h = new String[2];
		String w =null;
		handles.toArray(h);
		for(int i=0;i<=1;i++)
			w = h[1];	
		//System.out.println("Windows handle is:"+w);
		driver.switchTo().window(w);
		Thread.sleep(3000);
		//driver.close();
		driver.findElement(By.linkText("My Target List")).click();
		driver.switchTo().defaultContent();
		//driver.getCurrentUrl();
		//System.out.println(driver.getCurrentUrl());
		//driver.findElement(By.xpath(".//*[@id='MassUpdate']/table[2]/tbody/tr[3]/td[3]/a")).clear();
		
		//System.out.println(driver.findElement(By.xpath(".//a[contains(@href,'javascript:void(0)')")).isEnabled());
	}
	
	
	
}

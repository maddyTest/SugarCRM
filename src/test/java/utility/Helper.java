package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {

	public static String captureScreenshot(WebDriver d, String screenshotName)
	{
		TakesScreenshot ts = (TakesScreenshot) d;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String dest = "./Screenshots/"+screenshotName+System.currentTimeMillis()+".png";
		//String src = OutputType.BASE64.convertFromBase64Png(src);
		try {
			FileUtils.copyFile(src, new File(dest));
		} catch (IOException e) {
			System.out.println("failed to capture screenshot" + e.getMessage());
		}
		return dest;		
	}
}

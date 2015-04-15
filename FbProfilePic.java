import java.awt.AWTException;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;


public class FbProfilePic {
	public static void main(String[] args) throws InterruptedException, AWTException, IOException{
		WebDriver driver= new FirefoxDriver();
		WebDriverWait mywait = new WebDriverWait(driver,20);
		driver.get("http://www.facebook.com");
		driver.findElement(By.id("email")).sendKeys("#email or username");
		WebElement pass = driver.findElement(By.id("pass"));
		pass.sendKeys("#password");
		pass.submit();
		driver.findElement(By.partialLinkText("#partial profile name")).click();
		Thread.sleep(5000);
		WebElement update = driver.findElement(By.xpath("//div[1]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div/div[1]/div/div[3]/div/div[2]/div[3]/div/div/div/a/i"));
		update.click();
		Thread.sleep(5000);
		WebElement upload = driver.findElement(By.xpath("//div[3]/div[2]/div/div/div/div[2]/div[1]/div[1]/div/a/div/input"));
		Thread.sleep(5000);
		upload.sendKeys("#filepath D:\\smaug.jpg"); 
		Thread.sleep(15000);
		driver.switchTo().activeElement();
		mywait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@value='1'])[13]")));
		driver.findElement(By.xpath("(//button[@value='1'])[13]")).click();
		Thread.sleep(5000);
		File file= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("#target file path D:\\fb.jpg"));
		Thread.sleep(10000);
		
		driver.close();
		driver.quit();
		
	}

}

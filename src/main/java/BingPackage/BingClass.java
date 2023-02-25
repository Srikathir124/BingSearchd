package BingPackage;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BingClass {
	
	WebDriver driver;
	Date d = new Date();
	String str = "Srikathiravan @"+ d.toString();
	static Actions action;
	

	@BeforeSuite
	@Parameters({"url"})
	public void openUrl(String url) {
		System.setProperty("webdriver.edge.driver","C://msedgedriver.exe");
		driver = new EdgeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
	}
	
	@Test(invocationCount=30)
	public void search() {
		driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys(str);
		driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys(Keys.ENTER);
		
	}
	
	@AfterSuite
	public void closeBrowser() {
		driver.quit();
	}
	
}

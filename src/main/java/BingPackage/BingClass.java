package BingPackage;

import java.time.Duration;
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
	int i = 0;
	static Actions action;

	//Just For Fun
	@BeforeSuite
	@Parameters({"url"})
	public void openUrl(String url) {
		System.setProperty("webdriver.edge.driver","C://msedgedriver.exe");
		driver = new EdgeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	@Parameters({"username","password"})
	public void SignIn(String username, String password) throws InterruptedException {
		Search();
		
		System.out.println("Waiting for SignIn to load ...");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='id_a']")).click();

	}
	
	@Test(priority=2,invocationCount=34)
	@Parameters("url")
	public void Search() {
		Date d = new Date();	String str = d.toString();	str = str+" " +i;
		driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys(str);
		driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//textarea[@name='q']")).clear();
		i++;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}
	
	@AfterSuite
	public void closeBrowser() {
		driver.quit();
	}
	
}

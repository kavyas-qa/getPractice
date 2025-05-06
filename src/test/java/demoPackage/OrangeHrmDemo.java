package demoPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class OrangeHrmDemo 
{
	WebDriver driver;
	@BeforeSuite
	public void setup()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test(priority=1)
	public void login()
	{
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	@Test(priority=2)
	public void verifyHomePage()
	{
		String actual = driver.findElement(By.xpath("//span[@class='oxd-topbar-header-breadcrumb']/child::h6")).getText();
		String expected = "Pizarra de pendientes";
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority=3)
	public void logout()
	{
		driver.findElement(By.className("oxd-userdropdown-tab")).click();
		driver.findElement(By.xpath("//ul[@class='oxd-dropdown-menu']/child::li[4]/a")).click();
	}
	
	@AfterSuite
	public void tearDown()
	{
		driver.quit();
	}
}

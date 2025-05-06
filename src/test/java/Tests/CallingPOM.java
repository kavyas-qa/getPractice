package Tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Pages.OrangeHRM_Login_Page;
import Pages.OrangeHRM_Logout_Page;

public class CallingPOM
{
	@Test
	public void executionMethod() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		OrangeHRM_Login_Page lin = new OrangeHRM_Login_Page(driver);
		OrangeHRM_Logout_Page lout = new OrangeHRM_Logout_Page(driver);
		
		lin.url();
		lin.enterUserName("Admin");
		lin.enterPassword("admin123");
		lin.clickOnLoginBtn();
		
		lout.clickOnProfile();
		lout.clickOnLogoutLink();
	}
}

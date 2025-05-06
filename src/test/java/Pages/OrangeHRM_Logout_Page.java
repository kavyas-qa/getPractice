package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRM_Logout_Page 
{
	WebDriver driver;
	public OrangeHRM_Logout_Page(WebDriver idriver)
	{
		driver=idriver;
		PageFactory.initElements(driver, this);
	}
	@FindBy (className="oxd-userdropdown-tab") WebElement profile;
	@FindBy (xpath="//ul[@role='menu']/child::li[4]/child::a") WebElement logoutLink;
	
	public void clickOnProfile() throws InterruptedException
	{
		profile.click();
		Thread.sleep(2000);
	}
	public void clickOnLogoutLink() throws InterruptedException
	{
		logoutLink.click();
		Thread.sleep(2000);
	}
}

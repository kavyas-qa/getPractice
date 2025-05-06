package demoPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProviderDemo
{
	WebDriver driver;
	@BeforeSuite
	public void setup()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@DataProvider(name="dataset")
	public Object[][] dataMethod()
	{
		Object[][]  data = new Object[3][2];
		data[0][0] = "iPhone";
		data[0][1] = "16";
		data[1][0] = "OnePlus";
		data[1][1] = "11r";
		data[2][0] = "Samsung galaxy";
		data[2][1] = "F16";
		
		return data;
	}
	@Test(dataProvider="dataset")
	public void searchMobile(String brand, String model) throws InterruptedException
	{
		
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys(brand+" "+model);
		searchBox.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.navigate().back();
		WebElement loginModal = driver.findElement(By.xpath("//span[text()='✕']"));
		if(loginModal.isDisplayed())
		{
			loginModal.click();
		}
		else
		{
			System.out.println("No login popup displayed");
		}
	}
	@AfterSuite
	public void tearDown()
	{
		driver.quit();
	}
}

/*
WebDriver driver;
@BeforeSuite
public void setup()
{
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.aviationjobsearch.com/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}

@DataProvider(name="dataset")
public Object[] dataMethod()
{
	Object[]  data = new Object[4];
	data[0] = "Pilot";
	data[1] = "Engineer";
	data[2] = "Cabin crew";
	data[3] = "Test";
	return data;
}
@Test(dataProvider="dataset")
public void searchJobs(String keyword) throws InterruptedException
{
	
	WebElement searchBox = driver.findElement(By.id("searchKeyword"));
	searchBox.sendKeys(keyword);
	WebElement searchButton = driver.findElement(By.id("nav-search-button"));
	searchButton.click();
	Thread.sleep(2000);
	driver.navigate().back();	
}
@AfterSuite
public void tearDown()
{
	driver.quit();
}*/
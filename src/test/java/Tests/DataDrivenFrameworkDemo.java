package Tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Pages.OrangeHRM_Login_Page;
import Pages.OrangeHRM_Logout_Page;

public class DataDrivenFrameworkDemo
{
	@Test
	public void executionMethod() throws InterruptedException, IOException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		OrangeHRM_Login_Page lin = new OrangeHRM_Login_Page(driver);
		OrangeHRM_Logout_Page lout = new OrangeHRM_Logout_Page(driver);
		
		lin.url();
		
		String filePath = "C:\\Users\\kavyashree_gowda\\Desktop\\Kavya Docs\\GrowSkillIt_Testing\\TestData.xlsx";
		FileInputStream fis = new FileInputStream(filePath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Data");
		int rows = sheet.getLastRowNum();
		System.out.println("Total number of rows: "+rows);
		
		for(int i=1; i<=rows; i++)
		{
			XSSFRow row = sheet.getRow(i);
			XSSFCell usernm = row.getCell(0);
			XSSFCell pass = row.getCell(1);
			try
			{
				lin.enterUserName(usernm.toString());
				lin.enterPassword(pass.toString());
				lin.clickOnLoginBtn();
				lout.clickOnProfile();
				lout.clickOnLogoutLink();
				System.out.println(usernm+" and "+ pass+ " ----> Valid login");
			}
			catch(Exception e)
			{
				System.out.println(usernm+" and "+ pass+ " ----> Invalid login");
			}
		}
		fis.close();
	}
}

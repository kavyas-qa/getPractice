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

public class KeywordDrivenFrameworkDemo 
{
	@Test
	public void executionMethod() throws InterruptedException, IOException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		OrangeHRM_Login_Page lin = new OrangeHRM_Login_Page(driver);
		OrangeHRM_Logout_Page lout = new OrangeHRM_Logout_Page(driver);
		
		String filePath = "C:\\Users\\kavyashree_gowda\\Desktop\\Kavya Docs\\GrowSkillIt_Testing\\TestData.xlsx";
		FileInputStream fis = new FileInputStream(filePath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Keyword");
		int rows = sheet.getLastRowNum();
		System.out.println("Total number of rows: "+rows);
		for(int i=1; i<=rows; i++)
		{
			XSSFRow row = sheet.getRow(i);
			XSSFCell key = row.getCell(1);
			System.out.println("Keywords ----> "+key);
			switch(key.toString())
			{
				case "url": lin.url();
							break;
				case "enterUserName": lin.enterUserName("Admin");
										break;	
				case "enterPassword": lin.enterPassword("admin123");
										break;
				case "clickOnLoginBtn": lin.clickOnLoginBtn();
										break;	
				case "clickOnProfile": lout.clickOnProfile();
										break;	
				case "clickOnLogoutLink": lout.clickOnLogoutLink();
										break;	
				default: System.out.println("Invalid keyword");				
			}
		}
		fis.close();
	}
}

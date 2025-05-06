package Tests;

import java.io.FileInputStream;
import java.io.FileOutputStream;
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

public class HybridDrivenFrameworkDemo {
	@Test
	public void executionMethod() throws InterruptedException, IOException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		OrangeHRM_Login_Page lin = new OrangeHRM_Login_Page(driver);
		OrangeHRM_Logout_Page lout = new OrangeHRM_Logout_Page(driver);


		String filePath = "C:\\Users\\kavyashree_gowda\\Desktop\\Kavya Docs\\GrowSkillIt_Testing\\TestData.xlsx";
		FileInputStream fis = new FileInputStream(filePath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet dataSheet = workbook.getSheet("Data");
		XSSFSheet keySheet = workbook.getSheet("Keyword");

		int drows = dataSheet.getLastRowNum();
		System.out.println("Total number of Data rows: " + drows);

		int krows = keySheet.getLastRowNum();
		System.out.println("Total number of Key rows: " + krows);

		for (int dr = 1; dr <= drows; dr++) {
			XSSFRow drow = dataSheet.getRow(dr);
			XSSFCell usernm = drow.getCell(0);
			XSSFCell pass = drow.getCell(1);
			XSSFCell result = drow.createCell(2);
			System.out.println("Username--------> " + usernm + "     Password---------> " + pass);
			try {
				for (int kr = 1; kr <= krows; kr++) {
					XSSFRow krow = keySheet.getRow(kr);
					XSSFCell key = krow.getCell(1);
					XSSFCell match = krow.createCell(2);

					System.out.println("Keywords ----> " + key);
					switch (key.toString()) {
					case "url":
						lin.url();
						System.out.println("url keyword is matched");
						match.setCellValue("url keyword is matched");
						break;
					case "enterUserName":
						lin.enterUserName(usernm.toString());
						System.out.println("enterUserName keyword is matched");
						match.setCellValue("enterUserName keyword is matched");
						break;
					case "enterPassword":
						lin.enterPassword(pass.toString());
						System.out.println("enterPassword keyword is matched");
						match.setCellValue("enterPassword keyword is matched");
						break;
					case "clickOnLoginBtn":
						lin.clickOnLoginBtn();
						System.out.println("clickOnLoginBtn keyword is matched");
						match.setCellValue("clickOnLoginBtn keyword is matched");
						break;
					case "clickOnProfile":
						lout.clickOnProfile();
						System.out.println("clickOnProfile keyword is matched");
						match.setCellValue("clickOnProfile keyword is matched");
						break;
					case "clickOnLogoutLink":
						lout.clickOnLogoutLink();
						System.out.println("clickOnLogoutLink keyword is matched");
						match.setCellValue("clickOnLogoutLink keyword is matched");
						break;
					default:
						System.out.println("Invalid keyword");
					}
				}
				System.out.println("Valid data");
				result.setCellValue("Valid data");
			} catch (Exception e) {
				System.out.println("Invalid data");
				result.setCellValue("Invalid data");
			}

		}
		fis.close();
		FileOutputStream fos = new FileOutputStream(filePath);
		workbook.write(fos);
	}

}

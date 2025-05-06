package demoPackage;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

public class Utility extends ListenersDemo
{
	public static void captureSS(String name) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\kavyashree_gowda\\Pictures\\Screenshots\\"+name+".jpeg");
		FileHandler.copy(src, dest);
	}
}

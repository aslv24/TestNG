package seleniumSample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Incognito {

	@Test
	public static void main() {
		
		
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--start-maximized","--incognito");
		

		WebDriver driver=new ChromeDriver(opt);

		driver.get("https://www.facebook.com");
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
	}

}

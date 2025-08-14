package com.testng.basics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test(groups = "all")
public class Groups {
	
	WebDriver driver;

	@Test(priority = 1,description = "This test for printing webpage title",groups = "smoke")
	public void verifyTitle()
	{
		System.out.println(this.driver.getTitle());
	}
	
	@Test(priority = 2,description = "This test for printing webpage url",groups = "smoke")
	public void verifyUrl()
	{
		System.out.println(driver.getCurrentUrl());
	}
	
	@Test(priority = 3,invocationCount = 1,description = "This test for printing webpage links count",dependsOnMethods = "verifyLinks",groups = "sanity")
	public void verifyLinksCount()
	{
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
	}
	
	@Test(priority = 4,description = "This test for printing webpage links",alwaysRun = true,groups = "sanity")
	public void verifyLinks()
	{
		List<WebElement> links = driver.findElements(By.tagName("a"));
		for (WebElement webElement : links) {
			System.out.println(webElement.getText()+"===="+webElement.getAttribute("href"));
		}
		
	}
	
	@Test(priority = 5,groups = "regression")
	public void verifyLogin()
	{
		driver.findElement(By.id("email")).sendKeys("admin@mail.com");
	}
	
	@BeforeClass(alwaysRun = true)
	public void setup()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://www.facebook.com/");
	}
	
	@AfterClass(alwaysRun = true)
	public void teardown()
	{
		driver.quit();
	}
}

package com.testng.task;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TaskOrangeHRM {

	WebDriver driver;

	@BeforeTest
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@Test
	public void verifyLogin()
	{
		try {
		WebElement usernameField = driver.findElement(By.xpath("//input[@name='username']"));
		WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
		WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
		usernameField.sendKeys("Admin");
		passwordField.sendKeys("admin123");
		loginButton.click();
		}
		
		catch(NoSuchElementException e)
		{
			System.err.println("Element not found... Please Check the locator value");
		}
		try {
		WebElement homepageElement = driver.findElement(By.xpath("//h6[text()='Dashboard']"));
		Assert.assertTrue(homepageElement.isDisplayed(),"Dashboard is not displayed - Login Failed!");
		System.out.println("Login Successful....");
		}
		catch(NoSuchElementException e)
		{
			System.err.println("Invalid credentials");
			System.err.println("Login Failed...");
			Assert.fail("Login Failed...");
		}
	}
}

package com.test.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SampleWebTest {
	
	@Test
	public void googleTest() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chrome/linux/chromedriver");
		WebDriver driver = new ChromeDriver();

		LogUtil.log("Launched the browser");
		LogUtil.log("Getting the Google URL");
		driver.get("https://www.google.com/");
		LogUtil.log("Verifying the title");
        Assert.assertEquals(driver.getTitle(), "Google");
		
        LogUtil.log("Searching for Intuit");
		WebElement searchBox = driver.findElement(By.name("q"));
     	searchBox.sendKeys("intuit");
     	searchBox.sendKeys(Keys.ENTER);
     	LogUtil.log("Verifying the title");
     	Assert.assertEquals(driver.getTitle(), "intuit - Google Search");

		driver.quit();

	}

}


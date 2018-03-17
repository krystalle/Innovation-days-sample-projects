package com.test.ui;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SampleWebTest {

	//@Test
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

	@Test
	public void googleTest2() throws Exception{
		
		WebDriver driver = new RemoteWebDriver(new URL("http://selenium-hub:4444/wd/hub"), DesiredCapabilities.chrome());

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


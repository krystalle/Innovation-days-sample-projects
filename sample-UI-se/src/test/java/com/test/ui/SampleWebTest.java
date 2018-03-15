package com.test.ui;

import java.util.logging.Logger;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.intuit.tools.commontestbase.IBrowserTestNGBase;
//import com.intuit.tools.webdriverbuilder.WebDriverUtils;

public class SampleWebTest extends IBrowserTestNGBase {
	
	//private static Logger logger = Logger.getAnonymousLogger();

	@Test(dataProvider = "from-json", invocationCount = 1, threadPoolSize = 1)
        public void testGoogle(RemoteWebDriver driver) throws Exception {


                LogUtil.log(driver.getCapabilities().getPlatform() + "---"
                                + driver.getCapabilities().getBrowserName() + "---"
                                + driver.getCapabilities().getVersion() + "---"
                                );


                LogUtil.log("Live Stram Url--> "+ driver.getCapabilities().getCapability("resultsUrl"));
                LogUtil.log("[info] Launched the browser");
                driver.get("https://www.google.com");
                Thread.sleep(5000);
                LogUtil.log("[info] Getting the Google URL");
                Assert.assertEquals(driver.getTitle(), "Google");
                LogUtil.log("[info] Searching for Intuit");
                driver.findElementByName("q").sendKeys("Intuit");
                //Thread.sleep(5000);
                Thread.sleep(5000);
                LogUtil.log("[info] Verifying the title");
                Assert.assertEquals(driver.getTitle(), "Google");
                LogUtil.log("[info] Done");
                LogUtil.log("[**END**] Thread ID : " + Thread.currentThread().getId());
                driver.quit();


        }

}


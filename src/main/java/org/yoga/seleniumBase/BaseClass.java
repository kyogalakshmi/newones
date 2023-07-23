package org.yoga.seleniumBase;

import java.time.Duration;


//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseClass {
protected RemoteWebDriver driver = null;

String URL = "https://dev177742.service-now.com/";
@BeforeMethod
public void openapp() {
	
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Yoga\\Downloads\\chromedriver_win32\\chromedriver.exe");

   // WebDriver driver = new ChromeDriver();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get(URL);
}
@AfterMethod
public void tearDown() {
	
	driver.quit();
}
}

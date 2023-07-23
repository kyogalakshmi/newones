package tstcs;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.ReadExcel;
public class TC001{
	@DataProvider(name = "login",parallel =true)
//	@DataProvider(name = "login",indices = {1})
	public String[][] getData() throws IOException {

		String[][]excelData = ReadExcel.getExcelData();

//		logindata[0][0] = "sampleu650@gmail.com";
//		logindata[0][1] = "Pass@123";

//		logindata[1][0] = "Demo123@gmail.com";
//		logindata[1][1] = "Demo@123";
		return excelData;
	}
	// @Parameters({"emailId"})
	@Test(dataProvider = "login")
public void login(String username, String pass) {
	System.setProperty("webdriver.chrome.silentOutput","true");
	ChromeDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://letcode.in/");
	driver.findElement(By.linkText("Log in")).click();
	driver.findElement(By.xpath("//label[text()='Email']/following::input")).sendKeys(username);
	driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys(pass);
	driver.findElement(By.xpath("//p[@class='control']//button")).click();
	
	System.err.println(driver.getTitle());
	
	boolean button = driver.findElement(By.linkText("Sign out")).isDisplayed();
	if(button) {
		System.err.println("User SignedIn Successfully!!!!");
	}
	else {
		System.err.println("User is not SignedIn!!!!");
	}

driver.close();
	}

}




package org.yoga.loginpages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.yoga.seleniumBase.BaseClass;


public class LoginPage extends BaseClass  {

	public LoginPage(RemoteWebDriver driver) {
		this.driver = driver;
	}
	// locators
// validations whether all labels are displayed
public boolean getUsernameLabel() {
//driver.switchTo().frame(0);
return driver.findElement(By.xpath("//label[text()='User name']")).isDisplayed();
	
	}
	public boolean getPasswordLabel() {
		//driver.switchTo().frame(0);
		return driver.findElement(By.xpath("//label[text()='Password']")).isDisplayed();

	}
	//actions
	/**
	 * @param username - pass the user to be Login
	 * @return 
	 */
public LoginPage enterUserName(String username){
	
	driver.findElement(By.id("user_name")).sendKeys(username);
	return this;
		}
public LoginPage enterPassword(String password){
	driver.findElement(By.id("user_password")).sendKeys(password);
	return this;
 
}
//public void selectLanguage(String lang){
//	WebElement languageDD = driver.findElementById("language_select");
//	 new Select(languageDD).selectByVisibleText(lang);	
//}
public DashBoard clickLogin(){
	driver.findElement(By.id("sysverb_login")).click();
	return new DashBoard(driver);
}
// It will Login the appln
public void login(String username,String pass) {
	driver.switchTo().frame(0);
	enterUserName(username);
	enterPassword(pass);
	clickLogin();
}
}

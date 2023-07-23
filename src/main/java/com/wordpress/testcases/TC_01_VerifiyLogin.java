package com.wordpress.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.wordpress.Pages.Login;




//********** PageObjectSamle******************//
public class TC_01_VerifiyLogin extends Login{
	

	

	public TC_01_VerifiyLogin(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Test
	public void verifyLogin() {
		Login login=new Login(driver);
		driver.manage().window().maximize();
		driver.get(baseurl);
		
		login.typeUserName();
		login.typePassword();
		login.clickOnLoginButton();
		driver.quit();
	}
	

}

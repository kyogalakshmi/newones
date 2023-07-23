package com.wordpress.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import org.testng.annotations.BeforeTest;



public class Login {
	public WebDriver driver;
	public String baseurl = "http://demosite.center/wordpress/wp-login.php";

	
@BeforeTest
public void openBrowser() {
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	
}
	
	By username = By.id("user_login");
	By pwd = By.xpath(".//*[@id='user_pass']");
	By loginButton = By.name("wp-submit");
	
	public Login(WebDriver driver) {
		this.driver=driver;
	}
	
	public void typeUserName() {
		driver.findElement(username).sendKeys("admin");
	}
	public void typePassword() {
		driver.findElement(pwd).sendKeys("demo123");
	}
	public void clickOnLoginButton() {
		driver.findElement(loginButton).click();
	}
}

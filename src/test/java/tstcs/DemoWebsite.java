package tstcs;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DemoWebsite {

	
	String URL = "https://tutorialsninja.com/demo/index.php?route=product/category&path=18&sort=p.price&order=DESC";
	@Test
	public void openapp() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Yoga\\Downloads\\chromedriver_win32\\chromedriver.exe");

	   WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.get(URL);
	    List<WebElement> price = driver.findElements(By.cssSelector("div.caption p.price"));
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    for(WebElement  e : price){
	        System.out.println(e.getText().split("\\$")[1].split("\\.")[0].replace(",", ""));
	      }

	 // extract the prices from the price elements and store in a List
//	 List<String> prices = new ArrayList<String>();
//	 for (WebElement e : price)
//	 {
//	     prices.add(e.getText());
//	 }
//
//	 // make a copy of the list
//	 List<String> sortedPrices = new ArrayList<String>(prices);
//
//	 // sort the list
//	 Collections.sort(sortedPrices);
//
//	 // true if the prices are sorted
//	 System.out.println(sortedPrices.equals(prices));
//
//	 assertEquals(prices, sortedPrices);
	}
}

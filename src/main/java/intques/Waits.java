package intques;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Waits {
	// default time of implicit wait is 0 secs
	// java thread.sleep will wait for given time eventhough the element is loaded before the predefined timit limit
	public static String nextClassName;
	public static void main(String[] args) {


		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://mdbootstrap.com/docs/b4/jquery/tables/pagination/");
		driver.manage().window().maximize();
		List<String> namesList = new ArrayList<String>();
		List<WebElement> listOfNames ;
		WebElement NextButton;
		int pageSize = 	driver.findElements(By.xpath("//div[@id='dtBasicExample_paginate']//a")).size();

		System.out.println(pageSize);


		if(pageSize>0) {
			listOfNames = driver.findElements(By.xpath("//td[@class='sorting_1']"));
			for(WebElement name: listOfNames) {
				namesList.add(name.getText());
			}
			do {
				NextButton= driver.findElement(By.id("dtBasicExample_next"));
				nextClassName= NextButton.getAttribute("class");

				if(!nextClassName.contains("disabled"))
				{
					NextButton.click();
				}
				else {
					break;
				}
			}
			while(true);
			
			System.out.println(namesList);
		}

		else {
			System.out.println("No Pagination Available!!");
		
		}



		
	}

}

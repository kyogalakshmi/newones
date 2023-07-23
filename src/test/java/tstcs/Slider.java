package tstcs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;

public class Slider {

	public static void main(String[] args) throws InterruptedException {
	
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://letcode.in/slider");
		WebElement Slider = driver.findElement(By.id("generate"));
		Thread.sleep(3000);

		Actions moveSlider = new Actions(driver);
		
		moveSlider.clickAndHold(Slider)
         .moveByOffset(40, 0)
         .release()
         .perform();
	//	Action action = moveSlider.dragAndDropBy(Slider, 30, 0).build();
	}

}

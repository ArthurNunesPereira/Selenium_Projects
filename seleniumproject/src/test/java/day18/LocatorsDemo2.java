package day18;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsDemo2 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("http://www.automationpractice.pl/index.php");
		
		//Finding number of sliders on home page
		List<WebElement> sliders = driver.findElements(By.className("homeslider-container"));
		System.out.println("Total number of sliders: " + sliders.size());

		//Finding number of images on home page
		List<WebElement> images = driver.findElements(By.tagName("img"));
		System.out.println("Total number of images: " + images.size());

		//Finding number of links on home page
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total number of links: " + links.size());
	}

}

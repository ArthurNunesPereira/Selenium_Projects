package day19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSSelectorsDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		
		//CSS locator with TAG & ID ("tag" + "#" + "ID")
		//driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("MacBook");
		
		//CSS locator with TAG & Class ("tag" + "." + "Class")
		//driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("MacBook");
		
		//CSS locator with TAG & Attribute ("tag" + "[atribute]")
		//driver.findElement(By.cssSelector("input[placeholder='Search store']")).sendKeys("MacBook");
		
		//CSS locator with TAG, Class & Attribute ("tag" + "." + "Class" + "[atribute]")
		driver.findElement(By.cssSelector("input.search-box-text[placeholder='Search store']")).sendKeys("MacBook");
	}

}

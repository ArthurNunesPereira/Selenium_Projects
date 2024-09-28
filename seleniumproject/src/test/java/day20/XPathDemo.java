package day20;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demo.nopcommerce.com/");
		
		String productname = driver.findElement(By.xpath("//a[normalize-space()='Apple MacBook Pro 13-inch']")).getText();
		
		System.out.println(productname);

	}

}

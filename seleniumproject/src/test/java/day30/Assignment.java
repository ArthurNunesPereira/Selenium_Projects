package day30;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://ui.vision/demo/webtest/frames/");
		
		WebElement frame5 = driver.findElement(By.xpath("//frame[@src='frame_5.html']"));
		driver.switchTo().frame(frame5);
		
		driver.findElement(By.xpath("//a[normalize-space()='https://a9t9.com']")).click();
		
		driver.switchTo().frame(0); // Site of inner frame is not avaliable anymore.
		
		WebElement logo = driver.findElement(By.xpath("//img[@alt='UI Vision by a9t9 software - Image-Driven Automation']"));
		
		if (logo.isDisplayed()) {
			System.out.println("Logo is present, test passed!");
		} else {
			System.out.println("Logo is not preset, test failed!");
		}
	}

}

package day29;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleRadioButtons {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com");
		driver.manage().window().maximize();

		WebElement male_rd = driver.findElement(By.xpath("(//input[@id='male'])[1]"));
		WebElement female_rd = driver.findElement(By.xpath("(//input[@id='female'])[1]"));
		
		System.out.println("Before Selection.......");
		System.out.println("Select status of the male radio button: " + male_rd.isSelected());
		System.out.println("Select status of the female radio button: " + female_rd.isSelected());

		male_rd.click();
		
		System.out.println("After Selection.......");
		System.out.println("Select status of the male radio button: " + male_rd.isSelected());
		System.out.println("Select status of the female radio button: " + female_rd.isSelected());
	}

}

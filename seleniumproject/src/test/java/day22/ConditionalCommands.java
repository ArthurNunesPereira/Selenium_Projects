package day22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ConditionalCommands {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.nopcommerce.com/register");
		driver.manage().window().maximize();

		// isDisplayed() isEnabled()
		// WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo
		// store']"));
		// System.out.println("Status of the logo: " + logo.isDisplayed());

		boolean logostatus = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed();
		System.out.println(logostatus);

		WebElement searchbox = driver.findElement(By.xpath("//input[@id='small-searchterms']"));
		System.out.println("Dispay status: " + searchbox.isDisplayed());
		System.out.println("Enable status: " + searchbox.isEnabled());

		// isSelected()
		WebElement male_rd=driver.findElement(By.xpath("//input[@id='gender-male']"));
		WebElement female_rd=driver.findElement(By.xpath("//input[@id='gender-female']"));
		
		// Before selection
		System.out.println("Before selection...............");
		System.out.println(male_rd.isSelected()); // false
		System.out.println(female_rd.isSelected()); // false

		// After selection of male radio buttons
		System.out.println("After selection of male radiop button............");
		male_rd.click();
		System.out.println(male_rd.isSelected()); // true
		System.out.println(female_rd.isSelected()); // false

		// After selection of fe-male radio button
		System.out.println("After selection of female radiop button............");
		female_rd.click();
		System.out.println(male_rd.isSelected()); // false
		System.out.println(female_rd.isSelected()); // true
	}

}

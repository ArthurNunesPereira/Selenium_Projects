package day32;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Assignment {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("autofill.profile_enabled", false);
		options.setExperimentalOption("prefs", prefs);
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://blazedemo.com");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//select[@name='fromPort']")).click();
		driver.findElement(By.xpath("//option[@value='Boston']")).click();

		driver.findElement(By.xpath("//select[@name='toPort']")).click();
		driver.findElement(By.xpath("//option[@value='London']")).click();
		
		driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
		
		int rows = driver.findElements(By.xpath("//table[@class='table']//tbody//tr")).size(); // 5
		
		// 1 - Get all the flight prices, put them inside an Array
		String[] arrayTabela = new String[rows];
		
		for (int i = 1; i <= rows; i++) {
			String price = driver.findElement(By.xpath("//table[@class='table']//tbody//tr["+i+"]/td[6]")).getText();
			 arrayTabela[i-1] = price; //adding price into array
		}
		
		// 2 - sort() the Array
		Arrays.sort(arrayTabela);
		
		// 3 - Click on the chiepest flight (witch is index(0)), and fill the form
		String chiepest = arrayTabela[0];
		for (int i = 1; i <= rows; i++) {
			String price = driver.findElement(By.xpath("//table[@class='table']//tbody//tr["+i+"]/td[6]")).getText();
			if(chiepest.equals(price)) {
				driver.findElement(By.xpath("(//input[@value='Choose This Flight'])["+i+"]")).click();
				break;
			}
		}
		
		driver.findElement(By.xpath("//input[@id='inputName']")).sendKeys("User");
		driver.findElement(By.xpath("//input[@id='address']")).sendKeys("Rua xxx");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Cidade x");
		driver.findElement(By.xpath("//input[@id='state']")).sendKeys("SP");
		driver.findElement(By.xpath("//input[@id='zipCode']")).sendKeys("1111111111");
		
		driver.findElement(By.xpath("//select[@id='cardType']")).click();
		driver.findElement(By.xpath("//option[@value='amex']")).click();
		
		driver.findElement(By.xpath("//input[@id='creditCardNumber']")).sendKeys("999999");
		driver.findElement(By.xpath("//input[@id='creditCardMonth']")).sendKeys("9");
		driver.findElement(By.xpath("//input[@id='creditCardYear']")).sendKeys("2024");
		driver.findElement(By.xpath("//input[@id='nameOnCard']")).sendKeys("User D. John");
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();
		
		Thread.sleep(1000);
		
		// 4 - Validate the message of the booking
		String msg = driver.findElement(By.xpath("//h1[normalize-space()='Thank you for your purchase today!']")).getText();
		if (msg.contains("purchase")) {
			System.out.println("Test passed!");
		} else {
			System.out.println("Test Failed!");
		}
		
		driver.quit();
	}

}

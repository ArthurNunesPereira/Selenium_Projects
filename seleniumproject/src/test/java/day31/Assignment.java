package day31;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().deleteAllCookies(); //deletes all the cookies in your browser
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.amazon.com.br");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Moonshadow");
		Thread.sleep(5000);
		
		List<WebElement> options = driver.findElements(By.xpath("//div[@class='s-suggestion-container']"));
		
		System.out.println(options.size());
		
		for (int i = 0; i < options.size(); i++) {
			System.out.println(options.get(i).getText());
			if (options.get(i).getText().equals("moonshadow hq")) {
				options.get(i).click();
				break;
			}
		}
	}

}

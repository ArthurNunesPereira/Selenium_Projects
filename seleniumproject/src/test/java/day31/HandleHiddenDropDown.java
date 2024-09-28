package day31;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleHiddenDropDown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php");
		driver.manage().window().maximize();

		// Login steps - User = "Admin" / Password = "admin123"
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		Thread.sleep(3000);

		// clicking on PIM
		driver.findElement(By.xpath("//span[normalize-space()='PIM']")).click();
		
		// clicked on dropdown
		driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[7]/div[1]/div[2]/div[1]/div[1]/div[1]")).click();
		
		Thread.sleep(3000);
		// select single option
		//driver.findElement(By.xpath("//span[normalize-space()='Development']")).click();
		
		// count number of options
		List<WebElement> options = driver.findElements(By.xpath("//div[@role='listbox']//span"));
		System.out.println("Number of options: " + options.size());
		
		// printing options
		for (WebElement op:options) {
			System.out.println(op.getText());
		}
		
		driver.findElement(By.xpath("//span[normalize-space()='Development']")).click();
	}

}

package day30;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlerts {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
		//1) Normal alert with OK button
		/*driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click(); //opens JS Alert
		Thread.sleep(5000);

		//Alert myAlert = driver.switchTo().alert();
		//myAlert.accept();
		*/
		
		//2) confirmation Alert - OK & Cancel
		/*driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
		Thread.sleep(5000);
		
		Alert myAlert = driver.switchTo().alert();
		myAlert.dismiss();*/
		
		//3) Prompt alert- Input box 
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		Thread.sleep(5000);
		
		Alert myAlert = driver.switchTo().alert();
		myAlert.sendKeys("Welcome");
		myAlert.accept();
		
		// Checking if the text was right inputed
		String res = driver.findElement(By.xpath("//p[@id='result']")).getText();
		
		if (res.contains("Welcome")) {
			System.out.println("Test passed!");
		} else {
			System.out.println("Test failed!");
		}
	}

}

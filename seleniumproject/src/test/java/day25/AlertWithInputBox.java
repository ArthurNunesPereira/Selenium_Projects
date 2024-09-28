package day25;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertWithInputBox {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		
		Alert alertwindow = driver.switchTo().alert();
		
		System.out.println(alertwindow.getText());
		
		alertwindow.sendKeys("welcome");
		
		alertwindow.accept();
		//alertwindow.dismiss();
		
		//validation
		String act_text = driver.findElement(By.xpath("//p[@id='result']")).getText();
		String exp_text = "You entered: Welcome";
		
		if (act_text.equalsIgnoreCase(exp_text)) {
			System.out.println("Test passed!");
		}
		else
		{
			System.out.println("Test failed!");
		}
	}

}

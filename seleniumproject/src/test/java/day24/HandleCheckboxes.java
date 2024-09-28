package day24;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleCheckboxes {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.navigate().to("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//select specific one checkbox
		//driver.findElement(By.xpath("//input[@id='sunday']")).click();
		
		//total number of checkboxes
		List <WebElement> checkboxes =  driver.findElements(By.xpath("//input[@type='checkbox'][@class='form-check-input']"));
		System.out.println("Total number of checkboxes: " + checkboxes.size());
		
		//Select all the checkboxes
		/*for (int i = 0; i < checkboxes.size(); i++) {
			checkboxes.get(i).click();
		}
		
		Ou foreach
		for(WebElement chkbox:checkboxes)
		{
			chkbox.click();
		}*/
		
		//Select last 2 checkboxes
		/* total Number of checkboxes - how many checkboxes to be selected = startign index
		//7-2 = 5 ( startign index)
		for (int i = 5; i < checkboxes.size(); i++) {
			checkboxes.get(i).click();
		}*/
		
		//Select first 2 chekboxes
		/*for (int i = 0; i < 2; i++) {
			checkboxes.get(i).click();
		}*/
		
		//Select specific checkboxes, example only Sunday , Tuesday and Saturday
		/*for (int i = 0; i < checkboxes.size(); i++) {
			if (i == 0 || i == 2 || i == 6) {
				checkboxes.get(i).click();
			}
		}*/
		
		//clear/Uncheck checkboxes
		//Primeiro vamos marcar as checkboxes para poder desmarca-las
		for (int i = 0; i < checkboxes.size(); i++) {
			checkboxes.get(i).click();
		}
		
		Thread.sleep(5000);
		for (int i = 0; i < checkboxes.size(); i++) {
			if(checkboxes.get(i).isSelected()) {
				checkboxes.get(i).click();
			}
		}
		
		/*
		 for(WebElement chkbox:checkboxes) {
			if(chkbox.isSelected()) {
				chkbox.click();
			}
		}
		 */
	}
}

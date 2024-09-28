package day25;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleAlerts {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
		WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		
		//Em caso de realizar apenas uma operação, ex: clicar no botão
		//driver.switchTo().alert().accept(); // or .dismiss()
		
		//Em caso de querer realizar multitarefas, é necessário atribuir o Alert em uma variável, como no exemplo abaixo
		//Alert alertwindow=driver.switchTo().alert();
		Alert alertwindow=mywait.until(ExpectedConditions.alertIsPresent());
				
		System.out.println(alertwindow.getText());
				
		//alertwindow.accept(); // this will close alert window using ok button
		alertwindow.dismiss();  // close alert window by using cancel button
				
	}

}

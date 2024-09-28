package day25;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AuthenticatedPopUp {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		//http://the-internet.herokuapp.com/basic_auth - Normal URL
		//http://admin:admin@the-internet.herokuapp.com/basic_auth - URL with Injection (Ja estamos passando o login:password direto na URL).

		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		
		String text=driver.findElement(By.xpath("//p[contains(text(),'Congratulations!')]")).getText();
		
		if(text.contains("Congratulations"))
		{
			System.out.println("Successful login.");
		}
		else
		{
			System.out.println("Login failed.");
		}
	}

}

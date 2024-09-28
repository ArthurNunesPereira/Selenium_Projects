package day30;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticatedPopup {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		//driver.get("http://the-internet.herokuapp.com/basic_auth") // normal URL 
		
		//syntax - user:password@link
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");

	}

}

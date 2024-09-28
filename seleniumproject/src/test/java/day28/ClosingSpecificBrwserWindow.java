package day28;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClosingSpecificBrwserWindow {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		//Relative xpath: //a[normalize-space()='OrangeHRM, Inc']
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/p[2]/a[1]")).click();

		Set<String> windowsIds = driver.getWindowHandles();

		for (String winid : windowsIds) {
			String title = driver.switchTo().window(winid).getTitle();
			System.out.println(title);
			
			if(title.equals("Human Resources Management Software | OrangeHRM") || title.equals("title")){
				driver.close();
			}
		}

	}

}

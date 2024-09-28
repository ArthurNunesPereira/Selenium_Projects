package day28;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleBrowserWindows {

	public static void main(String[] args) {
	
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();

		Set<String> windowsIds = driver.getWindowHandles();

		/*
		//Aproach 1
		List<String> windowsList = new ArrayList(windowsIds);
		String parentID = windowsList.get(0);
		String childID = windowsList.get(1);

		//switch to child window
		driver.switchTo().window(childID);
		System.out.println(driver.getTitle());

		//switch to child window
		driver.switchTo().window(parentID);
		System.out.println(driver.getTitle());
		*/

		//Aproach 2

		for (String winId : windowsIds) {
			String title = driver.switchTo().window(winId).getTitle();	
				if (title.equals("OrangeHRM")){
					System.out.println(driver.getCurrentUrl());
					//some validation on the parent window
				}
		}
		
	}
}

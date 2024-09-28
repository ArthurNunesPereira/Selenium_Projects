package day28;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com");
		
		//Assignment:
		//1) provide some string search for it
		driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']")).sendKeys("Selenium");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		//2) count number of links
		List <WebElement> linksList = driver.findElements(By.xpath("//div[@id='Wikipedia1_wikipedia-search-results']//div/a"));
		System.out.println("Number of Links:" + linksList.size());
		
		//3) click on each link using for loop
		for (WebElement lkList : linksList) {
			lkList.click();
		}
		
		//4) get window ID's for every browser window
		Set <String> windowsIds = driver.getWindowHandles();
		
		for (String winId : windowsIds) {
			String title = driver.switchTo().window(winId).getTitle();
			System.out.println(title);
		}
		
		//5) close specific browser window
		for (String winId : windowsIds) {
			String title = driver.switchTo().window(winId).getTitle();
			
			if (title.equals("Selenium disulfide - Wikipedia")) {
				driver.close();
			}
		}
	}

}

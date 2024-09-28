package day18;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsDemo1 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("http://www.automationpractice.pl/index.php");
		
		driver.findElement(By.id("search_query_top")).sendKeys("T-shirt");
		driver.findElement(By.name("submit_search")).click();
		// link text
		//driver.findElement(By.partialLinkText("Printed Chiffon")).click(); pega uma parte do link text, não é muito bom usar pois pode haver multiplos items com o mesmo nome.
		driver.findElement(By.linkText("Printed Chiffon Dress")).click(); // Usamos preferencialmente o link text por que pegamos o elemento especifico que queremos tratar.
		
	}

}

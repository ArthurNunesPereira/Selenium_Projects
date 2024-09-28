package day33;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

		// Capturing all the rows
		int rows = driver.findElements(By.xpath("//table[@id='productTable']//tbody//tr")).size();

		// Capturing all the colunms
		int colunms = driver.findElements(By.xpath("//table[@id='productTable']//th")).size();

		// Capturing all the pages
		int pages = driver.findElements(By.xpath("//ul[@id='pagination']//li")).size();

		// - Read all the data / Click in every select button / Switch the pages and repeat the process
		
		for (int p = 1; p <= pages; p++) {

			if (p > 1) {
				WebElement active_page = driver.findElement(By.xpath("//ul[@id='pagination']//li[" + p + "]"));
				active_page.click();
				Thread.sleep(2000);
			}
			driver.findElement(By.xpath("(//input[@type='checkbox'])[8]")).click();
			for (int i = 1; i <= rows; i++) {
				int selectIndex = 9;
				for (int j = 1; j <= colunms; j++, selectIndex++) {
					String data = driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr[" + i + "]//td[" + j + "]")).getText(); // Lendo os dados
					System.out.println(data + "\t");
					if (!driver.findElement(By.xpath("(//input[@type='checkbox'])[" + selectIndex + "]")).isSelected()) {
						driver.findElement(By.xpath("(//input[@type='checkbox'])[" + selectIndex + "]")).click(); // Clicando nos selects
					}
				}
				System.out.println();
			}
		}

	}

}

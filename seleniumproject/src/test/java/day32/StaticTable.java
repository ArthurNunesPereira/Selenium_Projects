package day32;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticTable {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

		// 1) find total number of rows in a table
		// int rows = driver.findElements(By.tagName("tr")).size(); // Single table on
		// the web page
		int rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size(); // Multiple table on the web
																							// page
		System.out.println("Number of rows: " + rows); // 7

		// 2) find total number of columns in a table
		int columns = driver.findElements(By.xpath("//table[@name='BookTable']//th")).size(); // Multiple table on the
																								// web page
		System.out.println("Number of columns: " + columns); // 4

		// 3) Read data from specific row and column (ex: 5th row and 1st colum)
		String bookName = driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[1]")).getText();
		System.out.println(bookName);

		// 4) read data from all the rows and colums
		/*
		 * System.out.println("BookName"+"\t"+"Author"+"\t"+"Subject"+"\t"+"Price");
		 * 
		 * for (int i = 2; i <= rows; i++) { for (int j = 1; j <= columns; j++) { String
		 * value =
		 * driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td["+j+
		 * "]")).getText(); System.out.println(value + "\t"); } System.out.println(); }
		 */

		// 5) Print book names whose author is Mukesh
		for (int i = 2; i <= rows; i++) {

			String authorName = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td[2]")).getText();
			if (authorName.equals("Mukesh")) {
				String mukeshBook = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td[1]")).getText();
				System.out.println(mukeshBook +"\t"+ authorName);
			}
		}
			// 6) Find total price of all the books
			int total = 0;
			for (int i = 2; i <= rows; i++) {
				String value = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td[4]")).getText();
				total = total + Integer.parseInt(value);
			}
			System.out.println("Total price of the books: " + total); //7100
		}
}

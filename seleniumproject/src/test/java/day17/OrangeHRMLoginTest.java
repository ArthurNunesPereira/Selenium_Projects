package day17;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRMLoginTest {

	public static void main(String[] args) throws InterruptedException {
		//1) Launch Browser
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		//2) Open the URL
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		Thread.sleep(4000);
		
		//3) Provide username - Admin
		//WebElement txtUserName = driver.findElement(By.name("username")); Selecionamos o elemento HTML, e criamos uma variavel do tipo WebElement para armazenar seu valor
		//txtUserName.sendKeys("Admin"); //Passamos o valor que queremos
		driver.findElement(By.name("username")).sendKeys("Admin");
		
		//4) Provide password - admin123
		driver.findElement(By.name("password")).sendKeys("admin123");
		
		//5) Click in the Submit button
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		Thread.sleep(3000);
		
		/*6) Verify the title of the dashboard page - Expected title: OrangeHRM
		Title validation
		String act_title = driver.getTitle();
		String exp_title = "OrangeHRM";
		
		if (act_title.equals(exp_title)) {
			System.out.println("Test passed!");
		} else {
			System.out.println("Test failed!");
		}*/
		
		// Label validation after successful login
		String act_label = "";
		try {
		act_label = driver.findElement(By.xpath("//*[@id='app']/div[1]/div[1]/header/div[1]/div[1]/span/h6")).getText();
		} catch(NoSuchElementException e) {}
		
		String exp_label = "Dashboard";
		
		if (act_label.equals(exp_label)) {
			System.out.println("Test passed!");
		} else {
			System.out.println("Test failed!");
		}
		
		//7) Close the Browser
		driver.close(); // or driver.quit();
	}

}

package day17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdminDemoLoginTest {
/*
6) Verify the title of dashboard page   
	Exp title : Dashboard / nopCommerce administration
7) Verify Dashboard
 */
	public static void main(String[] args) throws InterruptedException {
		//1) Launch browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//2) open url
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		
		//3)Provide username  - admin@yourstore.com
		WebElement txtemailbox = driver.findElement(By.id("Email"));
		txtemailbox.clear();
		txtemailbox.sendKeys("admin@yourstore.com");
		
		//4) Provide password  - admin
		WebElement txtpasswordbox = driver.findElement(By.id("Password"));
		txtpasswordbox.clear();
		txtpasswordbox.sendKeys("admin");
		
		//5) Click on Login button 
		driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button")).click();
		Thread.sleep(5000);
		
		//6) Verify the title of dashboard page - Dashboard / nopCommerce administration
		String act_title = driver.getTitle();
		String exp_title = "Dashboard / nopCommerce administration";
		
		if(act_title.equals(exp_title)) {
			System.out.println("Test passed!");
		} else {
			System.out.println("Test failed!");
		}
		
		//7) Verify Dashboard
		String act_label = "";
		try {
		act_label = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/h1")).getText(); // Dashboard
		} catch(Exception e) { System.out.println(e.getMessage()); }
		String exp_label = "Dashboard";
		
		if(act_label.equals(exp_label)) {
			System.out.println("Test passed!");
		} else {
			System.out.println("Test failed!");
		}
		
		//8) Close Browser
		driver.quit();
	}

}

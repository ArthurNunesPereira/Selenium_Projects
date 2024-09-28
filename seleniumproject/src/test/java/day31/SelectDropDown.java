package day31;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDown {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//Get drop down in to a Select class object
		WebElement dropDownEle = driver.findElement(By.xpath("//select[@id='country']"));
		Select dropDown = new Select(dropDownEle);
		
		//select option from the drop down (Visible text / Value / Index)
		//dropDown.selectByVisibleText("Brazil");
		//dropDown.selectByValue("uk");
		//dropDown.selectByIndex(1);
		
		//capture the options from the dropdown
		List <WebElement> options = dropDown.getOptions();
		System.out.println("Number of options in the Select tag: " + options.size()); //10
		
		//printing the options
		/*for (int i = 0; i < options.size(); i++) {
			System.out.println(options.get(i).getText());
		}*/
		//enhanced for loop
		for (WebElement op: options) {
			System.out.println(op.getText());
		}
	}

}

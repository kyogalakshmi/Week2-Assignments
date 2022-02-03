package week2.day2.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Edit {
	// http://leafground.com/pages/Edit.html

	public static void main(String[] args) {
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			driver.get("http://leafground.com/pages/Edit.html");
			driver.manage().window().maximize();
			
			// Enter Your email address
			driver.findElement(By.id("email")).sendKeys("yoga@gmail.com");
			WebElement element = driver.findElement(By.xpath("//input[contains(@value,'Append')]"));
			
			element.sendKeys("test");
			
			 System.out.println("Element is appended - " +element.getAttribute("value"));
			
			 WebElement def = driver.findElement(By.xpath("//label[text()='Get default text entered']/following::input"));
			 System.out.println("Default Text is "+def.getAttribute("value"));
			 driver.findElement(By.xpath("//input[@value='Clear me!!']")).clear();		
			WebElement Edit = driver.findElement(By.xpath("//input[@disabled='true']"));
			 
			 if(Edit.isEnabled()) {
				 System.out.println("Edit Field is Enabled");
			 }
			 else {
				 System.out.println("Edit Field is Disabled");
			 }
			
		driver.close();	

	}

}

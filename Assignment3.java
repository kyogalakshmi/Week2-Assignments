package week2.day2.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3 {
/*
 * Assignment:3
===================
1. Load url "https://acme-test.uipath.com/login"
2. Enter email as "kumar.testleaf@gmail.com"
3. Enter Password as "leaf@12"
4. Click login button
5. Get the title of the page and print
6. Click on Log Out
7. Close the browser (use -driver.close())
 * 
 * 
 */
	
		public static void main(String[] args) throws InterruptedException  {
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			driver.get("https://acme-test.uipath.com/login");
			driver.manage().window().maximize();
			driver.findElement(By.id("email")).sendKeys("kumar.testleaf@gmail.com");

			driver.findElement(By.id("password")).sendKeys("leaf@12");
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
		WebElement title =	driver.findElement(By.xpath("//h1[text()[normalize-space()='Dashboard']]"));
		System.out.println("Title of the Page - " +title.getText());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'Log')]")).click();
	    driver.close();

			
			
			
	}

}

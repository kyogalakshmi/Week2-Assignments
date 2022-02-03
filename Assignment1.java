package week2.day2.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1 {
/*
 * FaceBook:
================================
// Step 1: Download and set the path 
// Step 2: Launch the chromebrowser
// Step 3: Load the URL https://en-gb.facebook.com/
// Step 4: Maximise the window
// Step 5: Add implicit wait
// Step 6: Click on Create New Account button
// Step 7: Enter the first name
// Step 8: Enter the last name
// Step 9: Enter the mobile number
// Step 10: Enterthe password
// Step 11: Handle all the three drop downs
// Step 12: Select the radio button "Female" 
            ( A normal click will do for this step) 

 * 
 * 
 */
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();	
    	driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//input[@placeholder='First name']")).sendKeys("Yogalakshmi");
    	driver.findElement(By.xpath("//div[text()='Surname']/following::input")).sendKeys("TestLeaf");
    	driver.findElement(By.xpath("//input[contains(@name,'reg_email__')]")).sendKeys("9876543210");
    	driver.findElement(By.xpath("//input[contains(@id,'password')]")).sendKeys("Global@123");
    	
    	Select day = new Select(driver.findElement(By.id("day")));  
        day.selectByVisibleText("3");
        
        Select Month = new Select(driver.findElement(By.id("month")));  
        Month.selectByVisibleText("Dec");
        
        Select year = new Select(driver.findElement(By.id("year")));  
        year.selectByVisibleText("1957");
      
        driver.findElement(By.xpath("//label[text()='Female']")).click();
        
    	
    	
		
    	
		
	}
	
	

}

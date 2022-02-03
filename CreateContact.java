package week2.day2.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args)  {
		/*
		 * //Pseudo Code
		 * 
		 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		 * 
		 * 2. Enter UserName and Password Using Id Locator
		 * 
		 * 3. Click on Login Button using Class Locator
		 * 
		 * 4. Click on CRM/SFA Link
		 * 
		 * 5. Click on contacts Button
		 * 
		 * 6. Click on Create Contact
		 *  
		 * 7. Enter FirstName Field Using id Locator
		 * 
		 * 8. Enter LastName Field Using id Locator
		 * 
		 * 9. Enter FirstName(Local) Field Using id Locator
		 * 
		 * 10. Enter LastName(Local) Field Using id Locator
		 * 
		 * 11. Enter Department Field Using any Locator of Your Choice
		 * 
		 * 12. Enter Description Field Using any Locator of your choice 
		 * 
		 * 13. Enter your email in the E-mail address Field using the locator of your choice
		 * 
		 * 14. Select State/Province as NewYork Using Visible Text
		 * 
		 * 15. Click on Create Contact
		 * 
		 * 16. Click on edit button 
		 * 
		 * 17. Clear the Description Field using .clear
		 * 
		 * 18. Fill ImportantNote Field with Any text
		 * 
		 * 19. Click on update button using Xpath locator
		 * 
		 * 20. Get the Title of Resulting Page.
         */
		WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			driver.get("http://leaftaps.com/opentaps/control/login");
			driver.manage().window().maximize();	
			driver.findElement(By.id("username")).sendKeys("Demosalesmanager");

			driver.findElement(By.id("password")).sendKeys("crmsfa");
			driver.findElement(By.className("decorativeSubmit")).click();

			driver.findElement(By.partialLinkText("CRM/SFA")).click();
			
			driver.findElement(By.xpath("//a[text()='Contacts']")).click();
			
			driver.findElement(By.xpath("//a[contains(text(),'Create')]")).click();
			
			driver.findElement(By.id("firstNameField")).sendKeys("Yoga");
			driver.findElement(By.id("lastNameField")).sendKeys("Lakshmi");
			driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("YK");
			driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("YogaLK");
			driver.findElement(By.xpath("//input[contains(@id,'department')]")).sendKeys("QA");
		    driver.findElement(By.xpath("//*[contains(@id,'description')]")).sendKeys("This is a New Description!!");
		    driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("AYZ@testleaf.com");
		    
		    Select contact = new Select(driver.findElement(By.id("createContactForm_generalStateProvinceGeoId")));  
		    contact.selectByVisibleText("New York");	
			driver.findElement(By.xpath("//input[@value='Create Contact']")).click();
			driver.findElement(By.xpath("//a[text()='Edit']")).click();
			 driver.findElement(By.xpath("//*[contains(@id,'description')]")).clear();
			 
			 driver.findElement(By.xpath("//*[contains(@id,'importantNote')]")).sendKeys("This is a Important Note");
			 driver.findElement(By.xpath("//input[@value='Update']")).click();
			 String title = driver.getTitle();
			System.out.println("Title of Resulting Page is: " + title);
		
			
	}

}

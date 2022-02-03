package week2.day2.Assignments;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.utility.RandomString;

public class EditLead {

	/*http://leaftaps.com/opentaps/control/main
			
			* 1	Launch the browser
			* 2	Enter the username
			* 3	Enter the password
			* 4	Click Login
			* 5	Click crm/sfa link
			* 6	Click Leads link
			* 7	Click Find leads
			* 8	Enter first name
			* 9	Click Find leads button
			* 10 Click on first resulting lead
			* 11 Verify title of the page
			* 12 Click Edit
			* 13 Change the company name
			* 14 Click Update
			* 15 Confirm the changed name appears
			* 16 Close the browser (Do not log out)
*/
 
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");

		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();

		driver.findElement(By.partialLinkText("CRM/SFA")).click();

		driver.findElement(By.xpath("//a[contains(text(),'Leads')]")).click();

		driver.findElement(By.linkText("Find Leads")).click();
		
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("babu");
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//table[@class='x-grid3-row-table']/tbody[1]/tr[1]/td[1]/div[1]/a[1]")).click();
		
		WebElement SecTitle = driver.findElement(By.id("sectionHeaderTitle_leads"));
		SecTitle.click();
				
		String title = SecTitle.getText();
		System.out.println("Resultant Title is - "+title);
		String actual ="View Lead";
		if(actual.equalsIgnoreCase(title)) {
			System.out.println("Exepected Title is matched with Actual Title!!");
		}
		else {
			System.out.println("Exepected Title is not matched with Actual Title!!");

		}
		driver.findElement(By.linkText("Edit")).click();
		
		String value = RandomString.make();
		Thread.sleep(3000);
		
		
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(value);
		driver.findElement(By.xpath("//input[@value='Update']")).click();
	 	WebElement updatedcname = driver.findElement(By.id("viewLead_companyName_sp"));
		System.out.println("CompanyName after Update is - " +updatedcname.getText());
		if(updatedcname.isDisplayed()) {  
			System.out.println("Updated CompanyName is updated successfully !!!");

		}
		else {
			System.out.println("Updated CompanyName is not updated Correctly !!!");
		}
		
	driver.close();
	}
}
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	

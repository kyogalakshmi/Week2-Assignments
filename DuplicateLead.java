package week2.day2.Assignments;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {
	/*/*http://leaftaps.com/opentaps/control/main

		1	Launch the browser
		2	Enter the username
		3	Enter the password
		4	Click Login
		5	Click crm/sfa link
		6	Click Leads link
		7	Click Find leads
		8	Click on Email
		9	Enter Email
		10	Click find leads button
		11	Capture name of First Resulting lead
		12	Click First Resulting lead
		13	Click Duplicate Lead
		14	Verify the title as 'Duplicate Lead'
		15	Click Create Lead
		16	Confirm the duplicated lead name is same as captured name
		17	Close the browser (Do not log out)

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
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		driver.findElement(By.name("emailAddress")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);

		WebElement leadID = driver
				.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a"));
		String leadIDText = leadID.getText();
		System.out.println("First LeadId is - " + leadIDText);
		leadID.click();
		WebElement CapturedName = driver.findElement(By.id("viewLead_firstName_sp"));
		String Capturename = CapturedName.getText();

		driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
		String ActualTitle = "Duplicate Lead";
		WebElement SecTitle = driver.findElement(By.xpath("//div[@id='sectionHeaderTitle_leads']"));
		String ExpectedTitle = SecTitle.getText();
		System.out.println("The ExpectedTitle is - "+ExpectedTitle);
		if(ActualTitle.equalsIgnoreCase(ExpectedTitle)) {
			System.out.println("Actual and Expected Title are Same");
		}
		else {
			System.out.println("Actual and Expected Title are not Same");
		}

		driver.findElement(By.className("smallSubmit")).click();

		WebElement Duplicatename =driver.findElement(By.xpath("//span[@id='viewLead_firstName_sp']"));
		String ExpectedDNAME=Duplicatename.getText();

		System.out.println("The Captured Lead Name is - "+Capturename);
		System.out.println("The Duplicated Lead Name  is - "+ExpectedDNAME);

		if(Capturename.equalsIgnoreCase(ExpectedDNAME)) {
			System.out.println("Duplicated lead name is same as Captured name!!");
		}
		else {
			System.out.println("Duplicated lead name is not same as Captured name!!");
		}

		driver.close();
	}

}

package week2.day2.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {
	/*
	 * http://leaftaps.com/opentaps/control/main
	 * 
	 * Delete Lead: 
	 *  1 Launch the browser
	 *  2 Enter the username 
	 *  3  Enter the password
	 *  4 Click Login 
	 *  5 Click crm/sfa link 
	 *  6 Click Leads link 
	 *  7 Click Find leads 
	 *  8 Click on Phone 
	 *  9 Enter phone number 
	 *  10 Click find leads button 
	 *  11 Capture lead ID of First Resulting lead 
	 *  12 Click First Resulting lead 
	 *  13 Click Delete
	 *  14 Click Find leads 
	 *  15 Enter captured lead ID 
	 *  16 Click find leads button 
	 *  17 Verify message "No records to display" in the Lead List. This message
	 * confirms the successful deletion 
	 *  18 Close the browser (Do not log out) 
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

		driver.findElement(By.xpath("//span[contains(text(),'Phone')]")).click();

		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("123456");
		Thread.sleep(2000);
		WebElement Lead = driver.findElement(By.xpath("//button[text()='Find Leads']"));
		Lead.click();

		Thread.sleep(2000);

		WebElement leadID = driver
				.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a"));
		String leadIDText = leadID.getText();
		System.out.println("First LeadId is - " + leadIDText);
		leadID.click();
		Thread.sleep(5000);

		driver.findElement(By.className("subMenuButtonDangerous")).click();

		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();

		driver.findElement(By.xpath("//label[text()='Lead ID:']/following::input")).sendKeys(leadIDText);

		WebElement Expected = driver.findElement(By.xpath("//button[text()='Find Leads']"));

		Expected.click();
		Expected.getText();
		Thread.sleep(2000);

		WebElement ExpectedVal = driver.findElement(By.xpath("//div[text()='No records to display']"));
		String val = ExpectedVal.getText();
		String actual = "No records to display";
		if (val.equalsIgnoreCase(actual)) {
			System.out.println("Lead ID - " + leadIDText + "is Deleted Successfully !!!");
		} else {
			System.out.println("Lead ID - " + leadIDText + "is not Deleted Successfully !!!");
		}
		driver.close();
	}

}

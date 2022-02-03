package week2.day2.Assignments;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Link {

	public static void main(String[] args) {

		
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			
driver.get("http://leafground.com/pages/Link.html");
	driver.findElement(By.xpath("(//a[@href='../home.html'])[2]")).click();
	driver.navigate().back();
	WebElement redirectLink = driver.findElement(By.linkText("Find where am supposed to go without clicking me?"));
	System.out.println(redirectLink.getAttribute("href"));
	driver.findElement(By.linkText("Verify am I broken?")).click();
	WebElement isbroken = driver.findElement(By.xpath("//p[text()=' /pages/error.html']"));
	String httpstatus = driver.findElement(By.tagName("h1")).getText();
	if(isbroken.getText().contains("error"))
	{
		System.out.println("Page is Broken with HTTP Status as - " + httpstatus);
	}
	
	driver.navigate().back();
	

	
	 List<WebElement> links = driver.findElements(By.tagName("a"));
     System.out.println("The number of links is -  " + links.size());
     driver.close();
	
	WebElement gohome = driver.findElement(By.xpath("//a[contains(text(),'Go to Home Page')]"));
	gohome.click();
	
   driver.close();
	
	}

}

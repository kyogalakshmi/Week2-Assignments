package week2.day2.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Button {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Button.html");
		driver.manage().window().maximize();
	driver.findElement(By.id("home")).click();		
	driver.findElement(By.xpath("//img[@alt='Buttons']")).click();
	Thread.sleep(1000);
		WebElement position = driver.findElement(By.xpath("//button[text()='Get Position']"));
		System.out.println("Position of Button is "+position.getLocation());
	WebElement color =	driver.findElement(By.id("color"));
		color.getCssValue("background-color");
		System.out.println("The Button Color is "+color.getCssValue("background-color"));
		
	
		
	WebElement HgtWdt =	driver.findElement(By.id("size"));
	
	System.out.println("The Height of the Button is - "+HgtWdt.getSize().getHeight());
	System.out.println("The Width of the Button is - "+HgtWdt.getSize().getWidth());
	
	
	
driver.close();		
		
	}

}

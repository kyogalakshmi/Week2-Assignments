package week2.day2.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Image {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
driver.get("http://leafground.com/pages/Image.html");
driver.findElement(By.xpath("//img[@src='../images/home.png']")).click();
driver.navigate().back();



WebElement image=driver.findElement(By.xpath("//img[@src='../images/abcd.jpg']"));

if(image.getAttribute("naturalWidth").equals("0"))
{
System.out.println("Image is broken");
}
else
{
System.out.println("It ia a Valid Image Link");
}

WebElement contextclick = driver.findElement(By.xpath("//img[@src='../images/keyboard.png']"));
Actions builder = new Actions(driver);
builder.contextClick(contextclick).perform();

driver.close();

}

}

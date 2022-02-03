package week2.day2.Assignments;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;
public class Checkbox {

	public static void main(String[] args)  {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
driver.get("http://leafground.com/pages/checkbox.html");
driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();


WebElement course =driver.findElement(By.xpath("(//input[@type='checkbox'])[6]"));	
		if(course.isSelected()) {
			System.out.println("Selenium Course is Confirmed Successfully!!");
		}
		else {
			System.out.println("Selenium Course is not Checked");
		}
		

WebElement box1 = driver.findElement(By.xpath("//label[text()='DeSelect only checked']/following::input[1]"));
WebElement box2 = driver.findElement(By.xpath("//label[text()='DeSelect only checked']/following::input[2]"));
if(box1.isSelected()) {
	box1.click();
}
if(box2.isSelected()) {
	box2.click();	
}
driver.findElement(By.xpath("//label[text()='Select all below checkboxes ']/following::input[1]")).click();
driver.findElement(By.xpath("//label[text()='Select all below checkboxes ']/following::input[2]")).click();
driver.findElement(By.xpath("//label[text()='Select all below checkboxes ']/following::input[3]")).click();
driver.findElement(By.xpath("//label[text()='Select all below checkboxes ']/following::input[4]")).click();
driver.findElement(By.xpath("//label[text()='Select all below checkboxes ']/following::input[5]")).click();
driver.close();
}

}

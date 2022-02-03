package week2.day2.Assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {

	
		public static void main(String[] args) throws InterruptedException  {
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			driver.get("http://leafground.com/pages/Dropdown.html");
			driver.manage().window().maximize();
			// Select drop1 = new Select(driver.findElement(By.id("dropdown1")));  
			// drop1.selectByIndex(0);
			    Thread.sleep(1000);
			    
			    
			    WebElement selectProgram1 = driver.findElement(By.id("dropdown1")); 
			    new Select(selectProgram1).selectByIndex(2);
			    Thread.sleep(1000);
			  WebElement selectProgram2 = driver.findElement(By.xpath("//select[@name='dropdown2']")); 
			  new Select(selectProgram2).selectByVisibleText("Selenium");
			    
			  WebElement selectProgram3 = driver.findElement(By.id("dropdown3")); 
			    new Select(selectProgram3).selectByValue("3");
			  
			    WebElement selectProgram4 = driver.findElement(By.className("dropdown")); 
			    List<WebElement> op = new Select(selectProgram4).getOptions();
			  int leng =  new Select(selectProgram4).getOptions().size();
			   System.out.println("No.of options - "+leng); 
			    for(int i=0;i<leng;i++) {
			    	 String options = op.get(i).getText();
			         System.out.println(options);
			    }
			    Thread.sleep(1000);
			   
			    
			
			    WebElement sendkeys = driver.findElement(By.xpath("//div[@id='contentblock']/section[1]/div[5]/select[1]"));
			    sendkeys.sendKeys("LoadRunner");
			    
			   
			    WebElement selectvalues = driver.findElement(By.xpath("//div[@id='contentblock']/section[1]/div[6]/select[1]"));
			    Select selectvalues1 = new Select(selectvalues);
			    selectvalues1.selectByIndex(1);
			    selectvalues1.selectByIndex(2);
			    selectvalues1.selectByIndex(3);
			    selectvalues1.selectByIndex(4);
			   
	}
		}


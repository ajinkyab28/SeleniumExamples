package WebAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropDown 
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		WebElement staticDropdown=driver.findElement(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']"));
		Select dropdown=new Select(staticDropdown);
		dropdown.selectByIndex(2);
		Thread.sleep(1000);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByValue("USD");
		Thread.sleep(1000);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByVisibleText("INR");
		Thread.sleep(1000);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1000);
		int adult=3,child=2,infant=1;
		
		for(int i=1;i<adult;i++)
			driver.findElement(By.id("hrefIncAdt")).click();		
		for(int i=0; i<child;i++)
			driver.findElement(By.id("hrefIncChd")).click();
		for(int i=0;i<infant;i++)
			driver.findElement(By.id("hrefIncInf")).click();
		
		driver.findElement(By.id("btnclosepaxoption")).click();

		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
	}
}

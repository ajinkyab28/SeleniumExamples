package WebAutomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestion 
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.xpath("//input[@id='autosuggest']")).sendKeys("ind");
		Thread.sleep(1000);
		List<WebElement>options = driver.findElements(By.xpath("//ul[@id='ui-id-1']/li"));
		
		for(WebElement option:options)
		{
			if(option.getText().equalsIgnoreCase("India"))
				option.click();
		}
	}
}

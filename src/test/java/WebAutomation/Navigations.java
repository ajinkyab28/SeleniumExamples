package WebAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigations 
{
	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.navigate().to("https://rahulshettyacademy.com/");
		driver.findElement(By.xpath("//a[contains(@class,'register-btn')]")).click();
		driver.navigate().back();
		driver.navigate().forward();
		
	}
}

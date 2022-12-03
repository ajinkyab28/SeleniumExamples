package WebAutomation;

import java.time.Duration;
import org.testng.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsDemo2 
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		String name="Ajinkya";
		// wait for element to appear before failing
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		// id locator
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		// name locator
		driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
		// class name locator
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(5000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(), "Hello "+name+",");
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		
	}
}

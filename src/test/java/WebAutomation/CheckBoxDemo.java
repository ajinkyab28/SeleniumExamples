package WebAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxDemo 
{
	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		System.out.println("Count of checkbox: ");
		System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
		
		System.out.println(driver.findElement(By.xpath("//input[contains(@id,'chk_IndArm')]")).isSelected());
		driver.findElement(By.xpath("//input[contains(@id,'chk_IndArm')]")).click();
		System.out.println(driver.findElement(By.xpath("//input[contains(@id,'chk_IndArm')]")).isSelected());
	}
}

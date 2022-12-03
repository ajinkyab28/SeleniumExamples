package WebAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsDemo 
{
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		// wait for element to appear before failing
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		// id locator
		driver.findElement(By.id("inputUsername")).sendKeys("Ajinkya");
		// name locator
		driver.findElement(By.name("inputPassword")).sendKeys("1234");
		// class name locator
		driver.findElement(By.className("signInBtn")).click();
		// CSS selector locator  tagName.className
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();
		// wait for transition to complete on web page
		Thread.sleep(1000);
		// xpath //tagName[@attribute='value']
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Ajinkya");
		//CSS Selector tagName[attribute='value']
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("aj@gmail.com");
		//xPath parent to child travese using tags //parentTag/ChildTag[index]
		driver.findElement(By.xpath("//form/input[2]")).clear();
		// CSS Selector parent to child 
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("ajinkya@gmail.com");
		// xpath index for selection
		driver.findElement(By.xpath("//input[@type='text'][3]")).sendKeys("9898989898");
		// css selectoe for unique class .class name
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		System.out.println(driver.findElement(By.cssSelector("p.infoMsg")).getText());
		String pwd=driver.findElement(By.cssSelector("p.infoMsg")).getText().split("'")[1].split("'")[0];
		System.out.println("Password= "+pwd);
		// xpath parent child
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		Thread.sleep(1000);
		// css selector for unique id
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("ajinkya");
		// css selector reglar expression
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(pwd);
		driver.findElement(By.id("chkboxTwo")).click();
		// xpath regular expression
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();		
	}
}

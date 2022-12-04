package WebAutomation;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandleDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		driver.findElement(By.xpath("//a[@class='blinkingText']")).click();
		Set<String>windows=driver.getWindowHandles();
		Iterator<String>it=windows.iterator();
		String parentId = it.next();
		String childId= it.next();
		driver.switchTo().window(childId);
		String msg=driver.findElement(By.xpath("//p[text()='Please email us at ']")).getText();
		System.out.println(msg);
		String email=msg.split("at")[1].split("with")[0].trim();
		System.out.println(email);
		driver.switchTo().window(parentId);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(email);
	}

}

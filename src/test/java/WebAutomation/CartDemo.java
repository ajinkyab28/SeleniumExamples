package WebAutomation;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CartDemo 
{
	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		String []itemsNeeded= {"Cauliflower","Beetroot","Beans","Almonds"};
		List<WebElement>items=driver.findElements(By.xpath("//h4[@class='product-name']"));
		List name=Arrays.asList(itemsNeeded);
		for(int i=0;i<items.size();i++)
		{
			String item=items.get(i).getText().split("-")[0].trim();
			int j=0;
			if(name.contains(item))
			{
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if(j==itemsNeeded.length)
					break;
			}
		}
		
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
		System.out.println(driver.findElement(By.xpath("//span[@class='promoInfo']")).getText());
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		WebElement staticdropdown=driver.findElement(By.tagName("select"));
		Select dropdown=new Select(staticdropdown);
		dropdown.selectByValue("India");
		driver.findElement(By.xpath("//input[@class='chkAgree']")).click();
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		System.out.println(driver.findElement(By.xpath("//div[@class='wrapperTwo']/span")).getText());
	}
}

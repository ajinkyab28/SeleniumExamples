package WebAutomation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableDemo2
{
	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		
		List<WebElement>title=driver.findElements(By.xpath("//div[@class='tableFixHead'] //th"));
		for(int i=0; i<title.size();i++)
		{
			System.out.print(driver.findElements(By.xpath("//div[@class='tableFixHead'] //th")).get(i).getText());
			System.out.print("\t");
		}
		System.out.println();
		
		int rows = driver.findElements(By.xpath("//div[@class='tableFixHead'] //tr")).size();
		System.out.println(rows);
		for(int i=0;i<rows;i++)
		{
			int j=i+1;
			
			System.out.println(driver.findElements(By.xpath("//div[@class='tableFixHead'] //tr //td")).get(i).getText());
			System.out.print("\t");
		}
		
	}
}

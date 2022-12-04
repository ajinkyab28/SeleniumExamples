package WebAutomation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WebTableDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		
		List<WebElement> items=driver.findElements(By.xpath("//div[@class='tableFixHead'] //td[4]"));
		int sum=0;
		for(int i=0 ;i<items.size();i++)
		{
			sum=sum+Integer.parseInt(driver.findElements(By.xpath("//div[@class='tableFixHead'] //td[4]")).get(i).getText());
		}
		System.out.println(sum);
		String value=driver.findElement(By.xpath("//div[@class='totalAmount']")).getText().split(":")[1].trim();
		int total=Integer.parseInt(value);
		System.out.println(total);
		Assert.assertEquals(total, sum);
	}

}

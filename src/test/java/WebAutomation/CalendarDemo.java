package WebAutomation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CalendarDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get("https://www.path2usa.com/travel-companion/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 800)");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='form-field-travel_comp_date']")).click();
		
		String month=driver.findElement(By.xpath("//div[@class='flatpickr-month'] //span[@class='cur-month']")).getText();
		
		while(!month.equalsIgnoreCase("November"))
		{
			driver.findElement(By.xpath("//span[@class='flatpickr-next-month']")).click();
			Thread.sleep(1000);
			month=driver.findElement(By.xpath("//div[@class='flatpickr-month'] //span[@class='cur-month']")).getText();
			System.out.println(month);
		}
		
		List<WebElement>dates=driver.findElements(By.cssSelector(".flatpickr-day "));
		for(int i=0; i<driver.findElements(By.cssSelector(".flatpickr-day ")).size();i++)
		{
			String date=driver.findElements(By.cssSelector(".flatpickr-day ")).get(i).getText();
			
			if(date.equalsIgnoreCase("28"))
			{
				driver.findElements(By.cssSelector(".flatpickr-day ")).get(i).click();
			}
		}
	}

}

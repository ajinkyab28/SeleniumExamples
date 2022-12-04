package WebAutomation;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading");
		driver.findElement(By.linkText("Example 1: Element on page that is hidden")).click();
		driver.findElement(By.xpath("//button[text()='Start']")).click();
		Wait<WebDriver>wait= new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
		WebElement test = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver)
			{
				if(driver.findElement(By.xpath("//div[@id='finish']/h4")).isDisplayed())
					return driver.findElement(By.xpath("//div[@id='finish']/h4"));
				else
					return null;
			}
		});
		
		
		System.out.println(test.getText());
		

	}
}

package WebAutomation;

import java.awt.RenderingHints.Key;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksCountDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		// 1. count of all links on page
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		// 2. count of all links in footer section
		WebElement footerDriver=driver.findElement(By.xpath("//div[@id='gf-BIG']"));
		System.out.println(footerDriver.findElements(By.tagName("a")).size());
		
		// 3 count of links on first column of footer section
		WebElement firstColumn = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(firstColumn.findElements(By.tagName("a")).size());
		
		// 4 click on each link & open in new tab from first column
		for(int i=1; i<firstColumn.findElements(By.tagName("a")).size();i++)
		{
			String value = Keys.chord(Keys.CONTROL,Keys.ENTER);
			firstColumn.findElements(By.tagName("a")).get(i).sendKeys(value);
		}
		
		//5 to get tile of each opened tab
		Set<String>windows=driver.getWindowHandles();
		Iterator<String>it=windows.iterator();
		
		while(it.hasNext())
		{
			String tab=it.next();
			driver.switchTo().window(tab);
			System.out.println(driver.getTitle());
		}
		driver.switchTo().defaultContent();
		
	}

}

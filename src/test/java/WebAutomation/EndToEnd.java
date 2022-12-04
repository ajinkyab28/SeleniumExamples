package WebAutomation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class EndToEnd 
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.xpath("//input[@id='autosuggest']")).sendKeys("ind");
		List<WebElement>options=driver.findElements(By.xpath("//ul[@id='ui-id-1']/li"));
		
		for(WebElement option:options)
		{
			if(option.getText().equalsIgnoreCase("india"))
				option.click();
		}
		driver.findElement(By.xpath("//input[contains(@id,'rbtnl_Trip_1')]")).click();
		driver.findElement(By.xpath("//input[contains(@id,'rbtnl_Trip_2')]")).click();
		driver.findElement(By.xpath("//a[@id='MultiCityModelAlert']")).click();
		driver.findElement(By.xpath("//input[contains(@id,'rbtnl_Trip_0')]")).click();
		
		driver.findElement(By.xpath("//input[contains(@id,'originStation1_CTXT')]")).click();
		driver.findElement(By.xpath("//div[contains(@id,'originStation1_CTNR')] //a[@value='BLR']")).click();
		driver.findElement(By.xpath("//div[contains(@id,'ddl_destinationStation1_CTNR')] //a[@value='PNQ']")).click();
		driver.findElement(By.xpath("//a[contains(@class,'ui-state-highlight')]")).click();
		driver.findElement(By.xpath("//input[contains(@id,'chk_friendsandfamily')]")).click();
		driver.findElement(By.xpath("//input[contains(@id,'chk_IndArm')]")).click();
		driver.findElement(By.xpath("//div[@id='divpaxinfo']")).click();
		
		int adult=3,child=2,infant=1;
		for(int i=1; i<adult;i++)
			driver.findElement(By.xpath("//span[@id='hrefIncAdt']")).click();
		
		for(int i=0;i<child;i++)
			driver.findElement(By.xpath("//span[@id='hrefIncChd']")).click();
		
		for(int i=0;i<infant;i++)
			driver.findElement(By.xpath("//span[@id='hrefIncInf']")).click();
		
		driver.findElement(By.xpath("//input[@id='btnclosepaxoption']")).click();
		WebElement staticdropdown=driver.findElement(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']"));
		Select dropdown = new Select(staticdropdown);
		
		dropdown.selectByIndex(2);
		Thread.sleep(1000);
		dropdown.selectByVisibleText("INR");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[contains(@id,'btn_FindFlights')]")).click();	
	}
}

package WebAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InvokeBrowsers 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
		driver = new FirefoxDriver();
		driver.get("https://www.google.com/");
		
		driver = new EdgeDriver();
		driver.get("https://www.google.com/");
	}

}

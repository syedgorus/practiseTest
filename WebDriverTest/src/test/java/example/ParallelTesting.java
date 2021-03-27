package example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(example.ListnerTest.class)
public class ParallelTesting {
	WebDriver driver;
	
    @Test	
	public void executSessionOne() {
		
		System.setProperty("webdriver.chrome.driver", ".\\\\drivers\\\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://demo.guru99.com/V4/");
		driver.findElement(By.name("uid")).sendKeys("Driver1");
		
		
	}
@Test    
public void executSessionTwo() {
		
	/*
	 * System.setProperty("webdriver.chrome.driver",
	 * "D:\\\\Selenium jars\\\\ChromeDriver\\\\chromedriver.exe"); driver=new
	 * ChromeDriver();
	 */
		driver.get("http://demo.guru99.com/V4/");
		driver.findElement(By.name("uid")).sendKeys("Driver2");
		
		
	}
@Test
public void executSessionThree() {
	
	
	/*
	 * System.setProperty("webdriver.chrome.driver",
	 * "D:\\\\Selenium jars\\\\ChromeDriver\\\\chromedriver.exe"); driver=new
	 * ChromeDriver();
	 */
	driver.get("http://demo.guru99.com/V4/");
	driver.findElement(By.name("uid")).sendKeys("Driver3");
	
	
}
@org.testng.annotations.AfterTest
 public void AfterTest()
{
	driver.close();
}



}

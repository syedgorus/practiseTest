package example;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestingGroups {
	
	
	  WebDriver driver;
	 
	
	String launchPageHeading = "//h3[text()='Guru99 Bank']";
	String username_element="//input[@name='uid']";
	String password_element="//input[@name='password']";
			String loginbtn="//input[@name='btnLogin']";

	String	nweCustomer="//a[@href='addcustomerpage.php']";

	String	username_value="mngr308342"; 
	String	password_value="guvArUq";

	String	manager_id_display="//td[contains(text(),'Manger Id')]";

	String	fundtransfer="//a[@href='FundTransInput.php']";

	
    @Test(groups = { "Ehasan" ,"Goru"})	
	public void tc01LaunchURL() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium jars\\ChromeDriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
		driver.get("http://www.demo.guru99.com/V4/");
		
		
		}
	@Test(groups= {"Ehasan"})
	public void tc02VerifyLaunchPage() {
		String actual="Guru99 Bank Home Page";
		
		String expected=driver.getTitle();
		
	   //	Assert.assertTrue(driver.findElement(By.xpath(launchPageHeading)).isDisplayed(), "heading page is not displayed");
	   	
	   	//System.out.println("Heading is displayed");
		Assert.assertEquals(actual, expected);
	}
	@Test(groups= {"Ehasan","Goru"})
	public void tc03EnterCredentials() {
		driver.findElement(By.xpath(username_element)).sendKeys(username_value);
		driver.findElement(By.xpath(password_element)).sendKeys(password_value);
		driver.findElement(By.xpath(loginbtn)).click();
	}
	@Test(groups= {"Goru"})
	public void tc04VerifyLoggedInPage() {
		
		Assert.assertTrue(driver.findElement(By.xpath(manager_id_display)).isDisplayed(), "manager id label is not displayed");
		System.out.println("manager id label is displayed");
	}
	@Test(groups= {"Goru"})
	public void tc05VerifyHyperlinks() {
	    
		Assert.assertTrue(driver.findElement(By.xpath(nweCustomer)).isEnabled(), "New Customer link is not working");
		System.out.println("New Customer link is working");
		
		Assert.assertTrue(driver.findElement(By.xpath(fundtransfer)).isEnabled(), "Fund transfer is not working");
		System.out.println("Fund transfer link is working");
	}
	/*
	 * @Test(groups={"Ehasan"}) public void close() { driver.close(); }
	 */
}

package seleniumlab;

import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxRegister {
	
	WebDriver obj;
	
	@BeforeTest
	void configure(){
		String url="https://auth.udacity.com/sign-up";
		System.setProperty("webdriver.firefox.driver", "/root/Desktop/FirefoxDriver/geckodriver");
		obj=new FirefoxDriver();
		obj.manage().window().maximize();
		obj.get(url);
	}
	@Test (priority=1)
	void addcredentials()
	{
		WebElement element,element1,element2,element3;
		element=obj.findElement(By.cssSelector("div.form-group:nth-child(1) > input:nth-child(1)"));
		element.sendKeys("Test");
		element1=obj.findElement(By.cssSelector("div.form-group:nth-child(1) > input:nth-child(2)"));
		element1.sendKeys("User");
		element2=obj.findElement(By.cssSelector("div.form-group:nth-child(3) > input:nth-child(1)"));
		element2.sendKeys("testing15@gmail.com");
		element3=obj.findElement(By.cssSelector("div.form-group:nth-child(3) > input:nth-child(2)"));
		element3.sendKeys("password1234#");
	}
	@AfterTest
	void closebrowser()
	{
		obj.quit();
	}

}

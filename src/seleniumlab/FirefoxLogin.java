package seleniumlab;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxLogin {
	
WebDriver obj;
	
	@BeforeTest
	void configure(){
		String url="https://auth.udacity.com/sign-in";
		System.setProperty("webdriver.gecko.driver", "/root/Desktop/FirefoxDriver/geckodriver");
		obj = new FirefoxDriver();
		obj.manage().window().maximize();
		obj.get(url);
	}

	@Test (priority=1)
	void addcredentials()
	{
		WebElement element,element1,element2;
		element=obj.findElement(By.cssSelector("div.form-group:nth-child(1) > input:nth-child(1)"));
		element.sendKeys("testing12@gmail.com");
		element1=obj.findElement(By.cssSelector("div.form-group:nth-child(2) > input:nth-child(1)"));
		element1.sendKeys("password1234#");
		element2=obj.findElement(By.cssSelector(".button_primary__1qhjh"));
		element2.click();
		try {
			Thread.sleep(2000);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}


	@AfterTest
	void quitbrowser()
	{
		obj.quit();
	}
}
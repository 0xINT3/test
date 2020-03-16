package seleniumlab;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxSearch {
	
WebDriver obj;
	@BeforeTest
	void configure()
	{
		String baseurl = "https://www.udacity.com/courses/all";
		System.setProperty("webdriver.gecko.driver", "/root/Desktop/FirefoxDriver/geckodriver");
		obj = new FirefoxDriver();
		obj.navigate().to(baseurl);
	}


	
	@Test(priority=1)
	void insertkeys()
	{
		WebElement element;
		String state="Machine Learning";
		element=obj.findElement(By.cssSelector(".ng-pristine"));
		element.sendKeys(state);
		List <WebElement> li = obj.findElements(By.linkText(state));
        	li.get(0).click();
	}
	
	@Test(priority=2)
	void coursepicker()
	{
        obj.findElement(By.cssSelector("div.course-summary-card:nth-child(1) > ir-catalog-card:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > h3:nth-child(3) > a:nth-child(1)")).click();
        //obj.findElement(By.cssSelector("a.btn:nth-child(1)")).click();
	}
			
	@Test(priority=3)
	//Assertion to check course title is displayed correctly
	void assertions2()
	{
		WebElement element1;
		element1=obj.findElement(By.cssSelector("h1.ng-star-inserted"));
		Assert.assertTrue(element1.isDisplayed());
		
	}
	@Test(priority=4)
	//Assertion to check if photo is displayed correctly
	void showphotos()
	{
		WebElement element;
		element=obj.findElement(By.cssSelector(".nd-syllabus-term__header__image"));
		Assert.assertTrue(element.isDisplayed());
	}
	@Test(priority=5)
	void downloadsyllabus()  
	{
		WebElement element;
		element=obj.findElement(By.cssSelector("a.btn:nth-child(1)"));
		element.click();
		ArrayList<String> newWindow = new ArrayList <String> (obj.getWindowHandles());
		obj.switchTo().window(newWindow.get(0));
	}
						 
						       
	@AfterTest
	void quitbrowser()
	{
		obj.quit();
	}

}
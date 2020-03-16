package seleniumlab;
import org.openqa.selenium.WebDriver;
import java.util.ArrayList;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class FirefoxAssertion {
	
	WebDriver driver;
	@BeforeTest (alwaysRun=true , enabled=true)
	void configure()
	{
		String baseurl = "https://www.udacity.com/";
		System.setProperty("webdriver.gecko.driver", "/root/Desktop/FirefoxDriver/geckodriver");
		driver = new FirefoxDriver();
		driver.navigate().to(baseurl);
	}

	
	@Test (priority = 0)
	void signup_btn() throws InterruptedException
	{
		WebElement element, element1, element3;
		element = driver.findElement(By.xpath("/html/body/ir-root/ir-content/ir-autopopup-modal/ir-modal/div/div[2]/div/div[1]"));
		element.click();
		element1 = driver.findElement(By.xpath("/html/body/ir-root/ir-content/ir-header/div/header/div[4]/nav/div/a[2]"));
		String name_1 = element1.getText();
		Assert.assertTrue(name_1.contains("Sign In"));

		element1.click();
		element3 = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[1]/button[1]"));
		String name_2=element3.getText();
		Assert.assertTrue(name_2.contains("SIGN UP"));
		element3.click();
		Thread.sleep(5000);
	}
	
	@Test(priority=1)
	void signup_details() throws InterruptedException
	{
		WebElement element , element1, element2  ,element3 , element4 , element5;
		element = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div[5]/div/form/div/div[1]/input[1]"));
		element.sendKeys("Love");

		
		element1 = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div[5]/div/form/div/div[1]/input[2]"));
		element1.sendKeys("Sharma");

		
		element2 = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div[5]/div/form/div/div[2]/input"));
		element2.sendKeys("lovesharmadev1998@gmail.com");

		
		element3 = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div[5]/div/form/div/div[3]/input[1]"));
		element3.sendKeys("74YeOD@1");

		
		element4 = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div[5]/div/form/div/div[3]/input[2]"));
		element4.sendKeys("74YeOD@1");

		
		element5 = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div[5]/div/form/button"));
		element5.click();
		Thread.sleep(5000);
		
		
	}
	
	@Test(priority = 2)
	void login_btn() throws InterruptedException
	{
		driver.navigate().to("https://www.udacity.com/");
		  Thread.sleep(10000);	

		WebElement element ,element1;
		element = driver.findElement(By.xpath("/html/body/ir-root/ir-content/ir-autopopup-modal/ir-modal/div/div[2]/div/div[1]"));
		element.click();
		
		element1 = driver.findElement(By.xpath("/html/body/ir-root/ir-content/ir-header/div/header/div[4]/nav/div/a[2]"));
		String name_1=element1.getText();
		Assert.assertTrue(name_1.contains("Sign In"));
		element1.click();	
		  Thread.sleep(5000);	
		  }
	
	@Test(priority = 3)
	void login_details() throws InterruptedException
	{
		WebElement element , element1, element2;
		element = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div[3]/div[3]/div/form/div/div[1]/input"));
		element.sendKeys("lovesharmadev1998@gmail.com");
		
		element1= driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div[3]/div[3]/div/form/div/div[2]/input"));
		element1.sendKeys("Gireesh@4805");
		
		element2 = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div[3]/div[3]/div/form/button"));
		element2.click();
		
		Thread.sleep(30000);	

	
	}
	
	@Test(priority = 4)
	void catalog() throws InterruptedException
	{
		WebElement element;
		element = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/nav/div/div/div/div/div[1]/ul/li[2]/a/span[2]"));
		String name_1=element.getText();
		Assert.assertTrue(name_1.contains("Catalog"));
		element.click();		
	}
	
	@Test(priority  =5)
	void search_catalog() throws InterruptedException
	{
		WebElement element , element1;
		element1 = driver.findElement(By.xpath("/html/body/ir-root/ir-content/ir-course-catalog/section[1]/div/h1"));
		String name_1=element1.getText();
		Assert.assertTrue(name_1.contains("Program Catalog"));
		element = driver.findElement(By.xpath("/html/body/ir-root/ir-content/ir-course-catalog/section[2]/div/div/input"));
		element.sendKeys(" AI ");
		Thread.sleep(20000);	

		
	}
	
	@Test(priority = 6)
	void product() throws InterruptedException
	{
		WebElement element;
		element = driver.findElement(By.xpath("/html/body/ir-root/ir-content/ir-course-catalog/section[3]/div/div/ir-course-card-catalog/div/div/div/div[1]/ir-catalog-card/div/div[1]/div[1]/div[2]/h3/a"));
		String name_1=element.getText();
		Assert.assertTrue(name_1.contains("AI For Business Leaders"));
		element.click();
		Thread.sleep(5000);	

			
	}
	@Test(priority = 7)
	void enroll_product() throws InterruptedException
	{
		WebElement element , element1;
		element = driver.findElement(By.xpath("/html/body/ir-root/ir-content/ir-canonical-degree-overview/div[1]/ir-canonical-degree-hero/div/div[2]/div[2]/div/div/a[2]"));
		String name_1=element.getText();
		Assert.assertTrue(name_1.contains("ENROLL NOW"));
		element.click();
		element1= driver.findElement(By.xpath("/html/body/ir-root/ir-content/ir-canonical-degree-overview/div[9]/ir-canonical-degree-pricing/div[1]/div/div/ir-canonical-price-cards/div/div[2]/div/div[2]/div[3]/a"));
		String name_2=element1.getText();
		Assert.assertTrue(name_2.contains("ENROLL NOW"));
		element1.click();
		Thread.sleep(20000);	

		
	}
	
	@AfterTest
	void packup() throws InterruptedException
	{
		driver.quit();
		
	}
	
	
}

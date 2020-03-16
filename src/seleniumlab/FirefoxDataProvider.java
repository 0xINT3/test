package seleniumlab;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
public class FirefoxDataProvider {
	 WebDriver obj;
	 @BeforeTest
	 void configure() throws InterruptedException {
		  String url = "https://auth.udacity.com/sign-in";
		  System.setProperty("webdriver.gecko.driver", "/root/Desktop/FirefoxDriver/geckodriver");
		  obj=new FirefoxDriver();
		  obj.navigate().to(url);		  
	 }	 
	 @DataProvider(name = "Authentication")

	  public static Object[][] testData() 
	 {
		 	
		 return new Object[][] { { "lovesharma1998@gmail.com", "74YeOD@1" },{"Kushsharma1998@gmail.com", "Kush@123"}};

	 }
	 	 
	 @Test(dataProvider="Authentication")
	 public void testMethod(String s1Email,String s2Pass) throws InterruptedException
	 {
		 WebElement element,element1,element2;
		 element=obj.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div[3]/div[3]/div/form/div/div[1]/input"));
		 element.sendKeys(s1Email);
		 element1=obj.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div[3]/div[3]/div/form/div/div[2]/input"));
		 element1.sendKeys(s2Pass);
		 element2=obj.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div[3]/div[3]/div/form/button"));
		 String name = element2.getText();
		 Assert.assertTrue(name.contains("SIGN IN"));
		 System.out.println(name);
		 element2.click();
	 }
	 
	 @AfterTest
		void closebrowser()
		{
			obj.quit();
		}
}
	 
	 


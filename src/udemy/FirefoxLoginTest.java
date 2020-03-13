package udemy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
public class FirefoxLoginTest {
	
		 WebDriver obj;
		 @BeforeTest
		 void configure() {
			  String url = "https://www.udemy.com/";
			  System.setProperty("webdriver.gecko.driver", "/root/Desktop/FirefoxDriver/geckodriver");
			  obj=new FirefoxDriver();
			  obj.get(url);
		 }
		 
	
		 @Test (priority=0)
		 void loginClick()
		 {
			 WebElement element;
			 element=obj.findElement(By.xpath("/html/body/div[2]/div[1]/div[3]/div[5]/a/span"));
			 String name=element.getText();
			 Assert.assertTrue(name.contains("Log in"));
			 element.click();
		 }
		 @Test (priority=1)
		 void logindetails()
		 {
			 WebElement element1,element2,element3;
			 element1=obj.findElement(By.xpath("//*[@id=\"email--1\"]"));
			 element1.sendKeys("potatohead11153@gmail.com");
			 element2=obj.findElement(By.xpath("//*[@id=\"id_password\"]"));
			 element2.sendKeys("password1234");
			 element3=obj.findElement(By.xpath("//*[@id=\"submit-id-submit\"]"));
			 element3.click();
		 }		 
}
		  

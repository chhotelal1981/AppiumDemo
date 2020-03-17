package TestBase;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import junit.framework.Assert;

public class TestClass {
	AppiumDriver<MobileElement> driver;
	
	@BeforeMethod()
	public void setUpMethod(){
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "OPPO A57");
		cap.setCapability("udid", "d0f8aa3b");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "6.0.1");
		cap.setCapability("appPackage", "com.android.calculator2");
		cap.setCapability("appActivity", "com.android.calculator2.Calculator");
		
		URL url = null;
		try {
			url = new URL("http://127.0.0.1:4723/wd/hub");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver = new AppiumDriver<MobileElement>(url,cap);		
		System.out.println("Application started");
	}
	
	
	@Test(enabled = true)
	public void rotateScreen(){
		WebElement rotateScreenBtn = driver.findElement(By.id("com.android.calculator2:id/edittext"));
		rotateScreenBtn.click();
	}
	
	@Test()
	public void twoNumberAddition(){
		WebElement rotateScreenBtn = driver.findElement(By.id("com.android.calculator2:id/edittext"));
		rotateScreenBtn.click();
		WebElement seven = driver.findElement(By.id("com.android.calculator2:id/digit7"));
		WebElement plus = driver.findElement(By.id("com.android.calculator2:id/plus"));
		WebElement eight = driver.findElement(By.id("com.android.calculator2:id/digit8"));
		WebElement equals = driver.findElement(By.id("com.android.calculator2:id/equal"));
		WebElement result = driver.findElement(By.id("com.android.calculator2:id/edittext"));
		
		seven.click();
		plus.click();
		eight.click();
		equals.click();
		String str = result.getText();
		System.out.println(str);
		String[] addition = str.split("=", 2);
		System.out.println(addition[1]);
		Assert.assertEquals(addition[1], "15");
	}
	
	
	@Test()
	public void twoNumberMultiple(){
		WebElement rotateScreenBtn = driver.findElement(By.id("com.android.calculator2:id/edittext"));
		rotateScreenBtn.click();
		WebElement  one = driver.findElement(By.id("com.android.calculator2:id/digit1"));
		WebElement  zero = driver.findElement(By.id("com.android.calculator2:id/digit0"));
		WebElement  mul = driver.findElement(By.id("com.android.calculator2:id/mul"));
		WebElement  two = driver.findElement(By.id("com.android.calculator2:id/digit2"));
		WebElement  equals = driver.findElement(By.id("com.android.calculator2:id/equal"));
		WebElement  result = driver.findElement(By.id("com.android.calculator2:id/edittext"));
		one.click();
		zero.click();
		mul.click();
		two.click();
		equals.click();
		
		String string = result.getText();
		String[] mulValue = string.split("=", 2);
		Assert.assertEquals(mulValue[1], "20");
		
	}
	
	@Test()
	public void twoNumberDivision(){
		WebElement rotateScreenBtn = driver.findElement(By.id("com.android.calculator2:id/edittext"));
		rotateScreenBtn.click();
		WebElement  one = driver.findElement(By.id("com.android.calculator2:id/digit1"));
		WebElement  zero = driver.findElement(By.id("com.android.calculator2:id/digit0"));
		WebElement  div = driver.findElement(By.id("com.android.calculator2:id/div"));
		WebElement  two = driver.findElement(By.id("com.android.calculator2:id/digit2"));
		WebElement  equals = driver.findElement(By.id("com.android.calculator2:id/equal"));
		WebElement  result = driver.findElement(By.id("com.android.calculator2:id/edittext"));
		one.click();
		zero.click();
		div.click();
		two.click();
		equals.click();
		
		String string = result.getText();
		String[] mulValue = string.split("=", 2);
		Assert.assertEquals(mulValue[1], "5");
		
	}
	
	
	
	@AfterMethod()
	public void tearDownMethod(){
		driver.quit();
	}

}

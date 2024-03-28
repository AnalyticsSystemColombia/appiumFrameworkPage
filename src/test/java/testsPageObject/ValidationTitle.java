package testsPageObject;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import testsUtils.setting_Android;

public class ValidationTitle extends setting_Android  {
	@BeforeMethod
	public void preSetup()
	{
		Activity activity = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.MainActivity");
		driver.startActivity(activity);
	}
	@Test
	public void ValidationsTitles() throws InterruptedException  
	{
		String MessageTitlePage = driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")).getText();
		Assert.assertEquals(MessageTitlePage, "General Store");
		
		String MessageTitlePageGender = driver.findElement(By.xpath("(//android.widget.TextView[@text='Gender'])")).getText();
		Assert.assertEquals(MessageTitlePageGender, "Gender");
		
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Male']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		

		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		
		String MessageTitleContry = driver.findElement(By.xpath("(//android.widget.TextView[@text='Select the country where you want to shop'])")).getText();
		Assert.assertEquals(MessageTitleContry, "Select the country where you want to shop");
		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		Assert.assertEquals(toastMessage, "Please enter your name");
	}
	
}
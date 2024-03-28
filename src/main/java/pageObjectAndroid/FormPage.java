package pageObjectAndroid;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.actionsAndroid;

public class FormPage extends actionsAndroid
{
	 AndroidDriver driver;
	
	public FormPage(AndroidDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	
	@FindBy(xpath="//android.widget.RadioButton[@text='Female']")
	private WebElement FemeleOption;
	
	@FindBy(xpath="//android.widget.RadioButton[@text='Male']")
	private WebElement MaleOption;
	
	@FindBy(id="android:id/text1")
	private WebElement contrySelection;
	
	@FindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement shopButton;
	
	
	public void setNameField(String name) 
	{
		nameField.sendKeys(name);
		driver.hideKeyboard();
	}
	public void setActivity()
	{
		Activity activity = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.MainActivity");
		driver.startActivity(activity);
	}
	public void setGender(String gender) 
	{
		if(gender.contains("Female"))
			FemeleOption.click();
		else
			MaleOption.click();
	}
	public void setCountrySelection(String countryName) 
	{
		contrySelection.click();
		scrollToTest(countryName);
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+countryName+"']")).click();
	}
	public ProductCatalogue submitForm()
	{
		shopButton.click();
		return new ProductCatalogue(driver);
	}
	
}

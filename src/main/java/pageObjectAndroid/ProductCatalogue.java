package pageObjectAndroid;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utils.actionsAndroid;

public class ProductCatalogue extends actionsAndroid{
	
	AndroidDriver driver;
	
	@FindBy(xpath ="//android.widget.TextView[@text='ADD TO CART']")
	private List<WebElement> addToCart;
	
	@FindBy(id ="com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement Cart;
	
	public ProductCatalogue(AndroidDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void addItemToCartByIndex(int index)
	{
		addToCart.get(index).click();
	}
	public CartPage goToCardPege() throws InterruptedException 
	{
		Cart.click();
		Thread.sleep(2000);
		return new CartPage(driver);
	}

}

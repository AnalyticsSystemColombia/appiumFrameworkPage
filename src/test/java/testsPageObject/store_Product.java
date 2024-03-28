package testsPageObject;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.functions.ExpectedCondition;
import pageObjectAndroid.CartPage;
import pageObjectAndroid.FormPage;
import pageObjectAndroid.ProductCatalogue;
import testsUtils.setting_Android;
import pageObjectAndroid.ProductCatalogue;

public class store_Product extends setting_Android  {
	@Test(dataProvider = "getdata", groups= {"smoke"})
	
	public void testPaginaPrincipal(HashMap<String,String> input) throws InterruptedException  
	{
		formPage.setNameField(input.get("name"));
		formPage.setGender(input.get("gender"));
		formPage.setCountrySelection(input.get("country"));
		ProductCatalogue productCatalogue = formPage.submitForm();
		
		productCatalogue.addItemToCartByIndex(0);
		productCatalogue.addItemToCartByIndex(0);
		CartPage cartPage = productCatalogue.goToCardPege();
		
		double totalSum = cartPage.getProductsSum();
		double displayFormattedSum = cartPage.getTotalAmountDisplayed();
		Assert.assertEquals(totalSum, displayFormattedSum);
		//cartPage.acceptTermsConditions();
		cartPage.submitOrder();
	}	
	@BeforeMethod(alwaysRun = true)//evitar que se ejecute
	public void preSetup()
	{
		//metodo que busca una pantalla en espesifico y de hay empieza la prueba
		formPage.setActivity();
	}
	@DataProvider
	public Object[][] getdata() throws IOException
	{
		//datos manuales en el archivo
		//return new Object [][] {{"Harold Urueña", "Female","Argentina"}, {"Jenny Urueña", "Female","Brazil"}};
		List<HashMap<String, String>>	data =getJsonData(System.getProperty("user.dir")+"//src//test//java//testData//pageMain.json");
		//	return new Object[][] { {"rahul shetty","female","Argentina"},{"shetty MR","male","Argentina"}  };
		return new Object[][] { {data.get(0)},{data.get(1)},{data.get(2)} };
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    }

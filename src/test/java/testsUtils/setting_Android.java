package testsUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import pageObjectAndroid.FormPage;
import utils.appiumUtilidades;

public class setting_Android extends appiumUtilidades{
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	public FormPage formPage;
	
	@BeforeClass(alwaysRun = true)
	public void Configuracion_Appium() throws IOException
	{	
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//resources//data.properties");
		String ipAddress = System.getProperty("ipAddress")!=null ? System.getProperty("ipAddress") : prop.getProperty("ipAddress");
		System.out.println(ipAddress);
		prop.load(fis);
		//String ipAddress = prop.getProperty("ipAddress");
		String port = prop.getProperty("port");
		service = startAppiumServer(ipAddress,Integer.parseInt(port));
						
				UiAutomator2Options options = new UiAutomator2Options();
				options.setDeviceName(prop.getProperty("AndroidDeviceNames")); //Conexion a el emulador
				options.setChromedriverExecutable("C://Users//user//Desktop//Proyectos_App//driver//chromedriver_122//chromedriver.exe");
				options.setApp(System.getProperty("user.dir")+"//src//test//java//resources//General-Store.apk");
				driver = new AndroidDriver(service.getUrl(), options);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				formPage = new FormPage(driver);
	}
	@AfterClass(alwaysRun = true)
	public void teardown() 
	{
		driver.quit(); //cierra el emulador
		service.stop(); //detiene el servidor
	}
}

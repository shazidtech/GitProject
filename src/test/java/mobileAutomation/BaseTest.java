package mobileAutomation;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseTest {
	
	public AndroidDriver driver;

	
	@SuppressWarnings("deprecation")
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException
	{
		
		UiAutomator2Options option = new UiAutomator2Options();
		option.setDeviceName("Pixel"); 
		option.setChromedriverExecutable("C:\\Users\\ENT18010731\\eclipse-workspace\\Automation\\src\\test\\java\\drivers\\chromedriver.exe");
		
		//option.setApp("C:\\Users\\ENT18010731\\eclipse-workspace\\Automation\\src\\test\\java\\resources\\ApiDemos-debug.apk");	
		option.setApp("C:\\Users\\ENT18010731\\eclipse-workspace\\Automation\\src\\test\\java\\resources\\General-Store.apk");	

		URL url = new URL("http://127.0.0.1:4723");
		driver = new AndroidDriver(url, option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}
	
	public void longPressAction(WebElement ele) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
				 "elementId", ((RemoteWebElement) ele).getId(), "duration", 2000));
	}
	
	public void ScrollToEndAction() {
		boolean canScrollMore;
		do {
			
		canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
		    "left", 100, "top", 100, "width", 200, "height", 200,
		    "direction", "down",
		    "percent", 3.0
		));
		}while(canScrollMore);
	}
	public void SwipeAction(WebElement ele, String direction)
	{
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId",  ((RemoteWebElement)ele).getId(),
			    "direction", direction,
			    "percent", 0.75
			));
	}
	public Double getFormattedAmount(String amount)
	{
		Double price = Double.parseDouble(amount.substring(1));
		return price;
		
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}

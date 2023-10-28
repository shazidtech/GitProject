package mobileAutomation;
import java.net.MalformedURLException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;

public class LongPress extends BaseTest{
	
	@Test
	public void LongPressGestures() throws MalformedURLException, InterruptedException {
		
		//  Introduction to Appium-Mobile Gestures and how it works
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Expandable Lists\"]")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		
		WebElement ele = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='People Names']"));
		
		//long press method call
		longPressAction(ele);
		
		String menuText = driver.findElement(AppiumBy.id("android:id/title")).getText();
		
		Assert.assertEquals(menuText, "Sample menu");
		
		Assert.assertTrue(driver.findElement(AppiumBy.id("android:id/title")).isDisplayed());
			
	
	}
}
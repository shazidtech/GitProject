package mobileAutomation;
import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;

public class AppiumBasics extends BaseTest{
	
	@Test
	public void wifiSettingName() throws MalformedURLException {
				
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
		driver.findElement(AppiumBy.id("android:id/checkbox")).click();
		driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).click();
		
		// How to extract the text & Enter the info on Mobile Apps with Appium
		String alertTitile = driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitile, "WiFi settings");
		
		// How to handle Mobile popups & return list of matching elements on Android app
		driver.findElement(AppiumBy.id("android:id/edit")).sendKeys("QA Wifi");
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
	
	}
}
package mobileAutomation;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;

import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;

public class MiscellanceAction extends BaseTest{
	
	@Test
	public void wifiSettingName() throws MalformedURLException {
		// package and activity 		
		//Activity act = new Activity("io.appium.android.apis","io.appium.android.apis.preference.PreferenceDependencies");
		//driver.startActivity()
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
		driver.findElement(AppiumBy.id("android:id/checkbox")).click();
		
		DeviceRotation landScape =new DeviceRotation(0,0,90);
		driver.rotate(landScape);
		
		driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).click();
		
		// How to extract the text & Enter the info on Mobile apps with Appium-tool
		String alertTitile = driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitile, "WiFi settings");
		
		// Cope Paste
		//Cope to clip board - past it clip board
		driver.setClipboardText("QA Wifi");
		
		// How to handle Mobile popup & return list of matching elements on Android app
		driver.findElement(AppiumBy.id("android:id/edit")).sendKeys(driver.getClipboardText());
		
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		
		//driver.pressKey(new KeyEvent(AndroidKey.BACK));
	
	}
}
package mobileAutomation;
import java.net.MalformedURLException;

import org.testng.annotations.Test;


import io.appium.java_client.AppiumBy;

public class ScrollDemo extends BaseTest{
	
	@Test
	public void ScrollDemoTest() throws MalformedURLException, InterruptedException {
		

		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).ScrollIntoView(text(\"WebView\"));"));
		
		//Scroll to end the screen
		ScrollToEndAction();
		
		Thread.sleep(2000);

	}
}
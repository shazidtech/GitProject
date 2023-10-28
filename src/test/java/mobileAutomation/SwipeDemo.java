package mobileAutomation;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class SwipeDemo extends BaseTest{
	
	@Test
	public void SwipeDempTest() throws MalformedURLException, InterruptedException {
		

		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Gallery\"]")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"1. Photos\"]")).click();
		WebElement firstImage = driver.findElement(By.xpath("//android.widget.ImageView[1]"));
		Assert.assertEquals(driver.findElement(By.xpath("//android.widget.ImageView[1]")).getAttribute("focusable"), "true");
		
		//swipe
		
		SwipeAction(firstImage, "left");
		Assert.assertEquals(driver.findElement(By.xpath("//android.widget.ImageView[1]")).getAttribute("focusable"), "false");
	}
}
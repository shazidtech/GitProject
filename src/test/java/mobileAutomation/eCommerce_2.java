package mobileAutomation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;

public class eCommerce_2 extends BaseTest {
    @Test
    public void FillForm() throws InterruptedException {
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Rahul Shetty");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
        driver.findElement(By.id("android:id/text1")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
       
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));

        List<WebElement> products = driver.findElements(By.id("com.androidsample.generalstore:id/productName"));
        int productCount = products.size();

        for (int i = 0; i < productCount; i++) {
            String productName = products.get(i).getText();

            if (productName.equalsIgnoreCase("Jordan 6 Rings")) {
                List<WebElement> addToCartButtons = driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart"));
                // Check if index 'i' is within the bounds of addToCartButtons list
                if (i < addToCartButtons.size()) {
                    addToCartButtons.get(i).click();
                } else {
                    System.out.println("Add to cart button not found for product: " + productName);
                }
            }
        }

        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));

        String lastPageProduct = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
        Assert.assertEquals(lastPageProduct, "Jordan 6 Rings");
    }
}

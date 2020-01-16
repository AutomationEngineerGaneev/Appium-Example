import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class MobileTest {

    DesiredCapabilities capabilities = new DesiredCapabilities();

    @Test
    public void testIncorrectFBLoginIOS() throws Exception {
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.3");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 8");
        capabilities.setCapability(MobileCapabilityType.UDID, "A46D2655-0018-4644-99E5-ACF4370A11A1");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, "true");
        capabilities.setCapability("showXcodeLog", "true");
        capabilities.setCapability("autoAcceptAlerts", "true");
        WebDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        WebDriverWait wait = new WebDriverWait(driver, 15);
        driver.get("https://facebook.com");
        driver.findElement(By.name("email")).sendKeys("max@test.com");
        driver.findElement(By.name("pass")).sendKeys("123456");
    }

    @Test
    public void testIncorrectFBLoginAndroid() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 2 API 29");
        capabilities.setCapability("appPackage", "com.android.chrome");
        capabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        WebDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }


}

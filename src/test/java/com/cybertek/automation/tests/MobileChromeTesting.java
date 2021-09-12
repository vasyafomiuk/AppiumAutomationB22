package com.cybertek.automation.tests;

import com.cybertek.automation.utils.MobileUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileChromeTesting {

    @Test
    public void test() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2");
        desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

        URL url = new URL("http://localhost:4723/wd/hub");
        WebDriver driver = new RemoteWebDriver(url, desiredCapabilities);

        driver.get("http://qa1.vytrack.com");

        MobileUtils.waitFor(3000);

        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);
        MobileUtils.waitFor(3000);
        driver.findElement(By.id("main-menu-toggle")).click();
        MobileUtils.waitFor(3000);

        driver.quit();
    }
}

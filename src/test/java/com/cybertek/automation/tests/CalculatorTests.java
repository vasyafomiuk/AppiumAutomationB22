package com.cybertek.automation.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class CalculatorTests {

    @Test
    public void test1() throws MalformedURLException, InterruptedException {
        //need to setup webdriver
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        //for consts: CapabilityType, MobileCapabilityType, AndroidMobileCapabilityType
        //UiAutomator2 - used for android devices automation
        /**
         * {
         *   "platformName": "Android",
         *   "platformVersion": "7.0",
         *   "deviceName": "Pixel_2",
         *   "automationName": "UiAutomator2",
         *   "appPackage": "com.android.calculator2",
         *   "appActivity": "com.android.calculator2.Calculator"
         * }
         */
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.calculator2");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.calculator2.Calculator");
        //for non-default app we should use "app" property along with a value of application path, instead of appPackage and appActivity
        //create url of appium server:
        // localhost - server is running on the same computer
        // 4723 - default port for Appium server
        // wd/hub - path for Appium server clients same as for Selenium Grid
        URL url = new URL("http://localhost:4723/wd/hub");
        AppiumDriver<MobileElement> driver = new AndroidDriver<>(url, desiredCapabilities);
        driver.findElementById("com.android.calculator2:id/digit_7").click(); // 7
        driver.findElementByAccessibilityId("plus").click(); // +
        driver.findElementById("com.android.calculator2:id/digit_5").click(); // 5
        driver.findElementByAccessibilityId("equals").click(); // =
        MobileElement result = driver.findElementById("com.android.calculator2:id/result"); // result = 12

        Assert.assertEquals("12", result.getText());

        Thread.sleep(3000);
        driver.closeApp();
    }
}

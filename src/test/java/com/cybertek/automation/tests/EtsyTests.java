package com.cybertek.automation.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class EtsyTests {
    AppiumDriver<MobileElement> driver;

    @Before
    public void setup() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "https://cybertek-appium.s3.amazonaws.com/etsy.apk");
        URL url = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver<>(url, desiredCapabilities);
    }

    @Test
    public void test() throws InterruptedException {
        //click get started button
        Thread.sleep(3000);
        driver.findElementById("com.etsy.android:id/btn_link").click();
        Thread.sleep(3000);
        driver.findElementById("com.etsy.android:id/edit_username").sendKeys("areatha@uspeakw.com");
        Thread.sleep(3000);
        driver.findElementById("com.etsy.android:id/edit_password").sendKeys("Cybertek2020");
        Thread.sleep(3000);
        driver.findElementById("com.etsy.android:id/button_signin").click();
        Thread.sleep(3000);
        driver.findElementByAccessibilityId("Show Navigation Drawer").click();
        Thread.sleep(3000);
        Thread.sleep(3000);
        MobileElement searchInput = driver.findElementById("com.etsy.android:id/search_src_text");

        String text = "wooden spoon";

        Actions actions = new Actions(driver);

        //for some reason search by whole string doesn't work
        //so as work around, I've used a loop
        for (int i = 0; i < text.length(); i++) {
            actions.sendKeys(searchInput, text.substring(i, i + 1)).perform();
        }

    }

    @After
    public void tearDown() {
        driver.closeApp();
    }
}

package com.cybertek.automation.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Locale;

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
        WebDriverWait wait = new WebDriverWait(driver, 20);

        //click get started button
        Thread.sleep(3000);
        driver.findElementById("com.etsy.android:id/btn_link").click();
        //wait up to 20 seconds until element shows up
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.etsy.android:id/edit_username")));
        driver.findElementById("com.etsy.android:id/edit_username").sendKeys("areatha@uspeakw.com");
        driver.findElementById("com.etsy.android:id/edit_password").sendKeys("Cybertek2020");
        driver.findElementById("com.etsy.android:id/button_signin").click();

        //wait up to 20 seconds until element shows up
        By searchBy = MobileBy.AccessibilityId("Show Navigation Drawer");
        WebElement search = wait.until(ExpectedConditions.presenceOfElementLocated(searchBy));
        driver.findElement(searchBy).click();

        Thread.sleep(3000);
        MobileElement searchInput = driver.findElementById("com.etsy.android:id/search_src_text");

        String text = "wooden spoon";

        Actions actions = new Actions(driver);

        //for some reason search by whole string doesn't work
        //so as work around, I've used a loop

//        for (int i = 0; i < text.length(); i++) {
//            actions.sendKeys(searchInput, text.substring(i, i + 1)).perform();
//        }

        actions.sendKeys(searchInput, text).perform();

        Thread.sleep(3000);

        List<MobileElement> populatedResults = driver.findElementsById("com.etsy.android:id/query_text");
        populatedResults.get(0).click(); // click on 1st populated result
        Thread.sleep(3000);

        List<MobileElement> searchResults = driver.findElementsById("com.etsy.android:id/listing_title");

        //print text of every search result
        searchResults.forEach( e -> System.out.println(e.getText()+"\n"));
        //verify that every search result contains wooden spoon
        searchResults.forEach( e -> Assert.assertTrue(e.getText().toLowerCase(Locale.ROOT).contains(text)));
        Thread.sleep(3000);
    }

    @After
    public void tearDown() {
        driver.closeApp();
    }
}

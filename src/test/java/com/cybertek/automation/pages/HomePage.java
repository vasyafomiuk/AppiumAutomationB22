package com.cybertek.automation.pages;

import com.cybertek.automation.utils.Driver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    @AndroidFindBy(id = "com.etsy.android:id/search_src_text")
    private MobileElement searchInput;

    @AndroidFindBy(id = "com.etsy.android:id/query_text")
    private List<MobileElement> populatedResults;
    //AndroidFindBy = FindBy
    @AndroidFindBy(id = "com.etsy.android:id/listing_title")
    private List<MobileElement> searchResultTitles;

    private By searchIconBy = MobileBy.AccessibilityId("Show Navigation Drawer");

    public HomePage(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }
}

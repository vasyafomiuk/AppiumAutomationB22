package com.cybertek.automation.pages;

import com.cybertek.automation.utils.Driver;
import com.cybertek.automation.utils.MobileUtils;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

public class HomePage {
    @AndroidFindBy(id = "com.etsy.android:id/search_src_text")
    private MobileElement searchInput;

    @AndroidFindBy(id = "com.etsy.android:id/query_text")
    private List<MobileElement> populatedResults;
    //AndroidFindBy = FindBy
    @AndroidFindBy(id = "com.etsy.android:id/listing_title")
    private List<MobileElement> searchResultTitles;

    private By searchIconBy = MobileBy.AccessibilityId("Show Navigation Drawer");

    public HomePage() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }

    public void clickOnSearchIcon() {
        MobileUtils.waitForElement(searchIconBy);
        Driver.getDriver().findElement(searchIconBy).click();
    }

    public List<MobileElement> getPopulatedResults() {
        return populatedResults;
    }

    public List<String> getSearchResultTitleTexts(){
        MobileUtils.waitFor(3000);
        return searchResultTitles.stream().map(MobileElement::getText).collect(Collectors.toList());
    }
}

package com.cybertek.automation.pages;

import com.cybertek.automation.utils.ConfigurationReader;
import com.cybertek.automation.utils.Driver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    //ios - iOSXCUITFindBy
    @AndroidFindBy(id = "com.etsy.android:id/btn_link")
    private MobileElement getStartedBtn;

    @AndroidFindBy(id = "com.etsy.android:id/edit_username")
    private MobileElement userNameInput;

    @AndroidFindBy(id = "com.etsy.android:id/edit_password")
    private MobileElement passwordInput;

    @AndroidFindBy(id = "com.etsy.android:id/button_signin")
    private MobileElement signInBtn;


    public LoginPage(){
        // in Appium, we need to use AppiumFieldDecorator to enable @FindBY annotations
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }

    public void login(){
        String email = ConfigurationReader.getProperty("user.email");
        String password = ConfigurationReader.getProperty("user.password");
    }
}

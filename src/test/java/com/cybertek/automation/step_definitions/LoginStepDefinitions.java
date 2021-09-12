package com.cybertek.automation.step_definitions;

import com.cybertek.automation.pages.LoginPage;
import io.cucumber.java.en.Given;

public class LoginStepDefinitions {
    public LoginPage loginPage = new LoginPage();

    @Given("user clicks on get started button")
    public void user_clicks_on_get_started_button() {
        loginPage.clickGetStarted();
    }

    @Given("user logs in")
    public void user_logs_in() {
        loginPage.login();
    }
}

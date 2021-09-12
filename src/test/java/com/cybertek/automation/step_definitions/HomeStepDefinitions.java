package com.cybertek.automation.step_definitions;

import com.cybertek.automation.pages.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomeStepDefinitions {
    public HomePage homePage = new HomePage();

    @When("user searches for {string}")
    public void user_searches_for(String itemToSearchFor) {
        homePage.searchFor(itemToSearchFor);
    }

    @Then("user verifies that every search result contains {string}")
    public void user_verifies_that_every_search_result_contains(String expectedText) {
        homePage.getSearchResultTitleTexts().
                forEach( r -> Assert.assertTrue(
                        r.toLowerCase().
                        contains(expectedText.toLowerCase())));
    }
}

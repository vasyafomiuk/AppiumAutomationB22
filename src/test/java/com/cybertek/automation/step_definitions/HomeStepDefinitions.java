package com.cybertek.automation.step_definitions;

import com.cybertek.automation.pages.HomePage;
import com.cybertek.automation.utils.MobileUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class HomeStepDefinitions {
    public HomePage homePage = new HomePage();

    @When("user searches for {string}")
    public void user_searches_for(String itemToSearchFor) {
        homePage.searchFor(itemToSearchFor);
    }

    @Then("user verifies that every search result contains {string}")
    public void user_verifies_that_every_search_result_contains(String expectedText) {
        MobileUtils.swipeScreenSmall(MobileUtils.Direction.UP);
        MobileUtils.swipeScreenSmall(MobileUtils.Direction.UP);
        MobileUtils.swipeScreenSmall(MobileUtils.Direction.UP);
        homePage.getSearchResultTitleTexts().
                forEach( r -> Assertions.assertTrue(
                        r.toLowerCase().
                        contains(expectedText.toLowerCase()), r));
    }
}

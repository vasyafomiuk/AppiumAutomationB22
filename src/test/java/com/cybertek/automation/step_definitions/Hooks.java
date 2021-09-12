package com.cybertek.automation.step_definitions;

import com.cybertek.automation.utils.Driver;
import io.cucumber.java.After;

public class Hooks {

    @After
    public void tearDown() {
        Driver.closeDriver();
    }
}

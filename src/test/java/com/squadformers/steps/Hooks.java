package com.squadformers.steps;

import com.squadformers.utilities.Driver;
import io.cucumber.java.After;

public class Hooks {

    @After
    public void tearDown() {
        Driver.closeDriver();
    }


}

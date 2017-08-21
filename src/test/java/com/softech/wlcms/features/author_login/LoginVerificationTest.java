package com.softech.wlcms.features.author_login;


import com.softech.wlcms.steps.common.WlcmsHomePageSteps;
import com.softech.wlcms.steps.common.WlcmsLoginSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by umair.javaid on 2/22/2016.
 */

@RunWith(SerenityRunner.class)
public class LoginVerificationTest {
    private static final Logger logger = LoggerFactory.getLogger(LoginVerificationTest.class);

    @Managed
    WebDriver driver;

    @Steps
    WlcmsLoginSteps wlcmsLoginSteps;

    @Steps
    WlcmsHomePageSteps wlcmsHomePageSteps;


    @WithTag(type = "release", name = "smoke-test")
    @Test
    public void verifySuccessfulUserLogin() {
        logger.info("<---------------------------------------------------->");
        logger.info("<-----      Starting WLCMS Login Test           ----->");
        logger.info("<---------------------------------------------------->");

        wlcmsLoginSteps.LogIntoWlcms();

        wlcmsHomePageSteps.verifyAndCloseTutorialBox();
        wlcmsHomePageSteps.logOut();

        logger.info("<---------------------------------------------------->");
        logger.info("<-----      WLCMS Login Test is completed        ----->");
        logger.info("<---------------------------------------------------->");

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
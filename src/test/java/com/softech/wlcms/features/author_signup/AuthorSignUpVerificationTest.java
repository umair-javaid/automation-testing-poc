package com.softech.wlcms.features.author_signup;

import com.softech.wlcms.steps.author_steps.AuthorVerificationSteps;
import com.softech.wlcms.steps.common.WlcmsHomePageSteps;
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
 * Created by umair.javaid on 2/24/2016.
 */

@RunWith(SerenityRunner.class)
public class AuthorSignUpVerificationTest {
    private static final Logger logger = LoggerFactory.getLogger(AuthorSignUpVerificationTest.class);


    @Managed
    WebDriver driver;

    @Steps
    AuthorVerificationSteps authorVerificationSteps;

    @Steps
    WlcmsHomePageSteps wlcmsHomePageSteps;


    @WithTag(type = "release", name = "smoke-test")
    @Test
    public void verifySignUpUser() {

        logger.info("<---------------------------------------------------->");
        logger.info("<----     Starting WLCMS Signup Author Test     ----->");
        logger.info("<---------------------------------------------------->");

        authorVerificationSteps.navigateToWlcmsAuthorSignUpPage();
        authorVerificationSteps.fillAuthorInformation();
        authorVerificationSteps.submittingAuthorInformation();
        wlcmsHomePageSteps.verifyAndCloseTutorialBox();
        wlcmsHomePageSteps.logOut();


        logger.info("<----------------------------------------------------->");
        logger.info("<-----  WLCMS Signup New Author Test Completed   ----->");
        logger.info("<----------------------------------------------------->");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

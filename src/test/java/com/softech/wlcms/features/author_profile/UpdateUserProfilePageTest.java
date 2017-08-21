package com.softech.wlcms.features.author_profile;

import com.softech.wlcms.steps.author_steps.AuthorVerificationSteps;
import com.softech.wlcms.steps.common.WlcmsHomePageSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by umair.javaid on 4/19/2016.
 */

@RunWith(SerenityRunner.class)
public class UpdateUserProfilePageTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(UpdateUserProfilePageTest.class);

    @Managed
    WebDriver driver;

    @Steps
    AuthorVerificationSteps authorVerificationSteps;

    @Steps
    WlcmsHomePageSteps wlcmsHomePageSteps;

    @Title("Update Author First Name and Verify")
    @WithTag(type = "release", name = "regression-2-test")
    @Test
    public void updateAuthorFirstName()
    {
        authorVerificationSteps.navigateToWlcmsAuthorSignUpPage();
        authorVerificationSteps.fillAuthorInformation();
        authorVerificationSteps.submittingAuthorInformation();
        wlcmsHomePageSteps.verifyAndCloseTutorialBox();
        wlcmsHomePageSteps.navigateToUserProfile();

        authorVerificationSteps.updateUserFirstName();
        wlcmsHomePageSteps.logOut();


    }
    @After
    public void tearDown()
    {
        driver.quit();
    }
}


package com.softech.wlcms.features.author_profile;

import com.softech.wlcms.steps.author_steps.AuthorPermissionSteps;
import com.softech.wlcms.steps.author_steps.AuthorVerificationSteps;
import com.softech.wlcms.steps.common.WlcmsHomePageSteps;
import com.softech.wlcms.steps.common.WlcmsLoginSteps;
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
 * Created by umair.javaid on 5/4/2016.
 */
@RunWith(SerenityRunner.class)
public class AuthorPermissionsTest {
    private final static Logger logger = LoggerFactory.getLogger(AuthorPermissionsTest.class);

    @Managed
    WebDriver driver;

    @Steps
    AuthorVerificationSteps authorVerificationSteps;

    @Steps
    WlcmsHomePageSteps wlcmsHomePageSteps;

    @Steps
    WlcmsLoginSteps wlcmsLoginSteps;

    @Steps
    AuthorPermissionSteps authorPermissionSteps;

    @Title("Verify Author is searachable via First Name on Royalty Settings page")
    @WithTag(type = "release", name = "regression-2-test")
    @Test
    public void VerifyAuthorIsSearachableFirstNameonRoyaltySettingsPage() {
        String currentUrl =
                wlcmsLoginSteps.LogIntoWlcms();
        wlcmsHomePageSteps.verifyAndCloseTutorialBox();
        wlcmsHomePageSteps.navigateToRoyaltySettings();

        authorPermissionSteps.searchAuthorViaFirstName(currentUrl);
    }

    @Title("Verify Author is searachable via First Name on Royalty Settings page")
    @WithTag(type = "release", name = "regression-2-test")
    @Test
    public void VerifyEnableRatingReviewPermissionForAuthor() {
        String currentUrl =
                wlcmsLoginSteps.LogIntoWlcms();
        wlcmsHomePageSteps.verifyAndCloseTutorialBox();
        wlcmsHomePageSteps.navigateToAuthorPermission();

        authorPermissionSteps.searchAuthorViaFirstName(currentUrl);
        authorPermissionSteps.verifyRatingReviewPermissions();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

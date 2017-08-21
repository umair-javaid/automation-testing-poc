package com.softech.wlcms.features.author_profile;


import com.softech.wlcms.steps.author_steps.AuthorVerificationSteps;
import com.softech.wlcms.steps.common.WlcmsHomePageSteps;
import com.softech.wlcms.steps.upload_assets_steps.UploadAssetsSteps;
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
public class UploadAssetsAuthorProfileTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(UploadAssetsAuthorProfileTest.class);

    @Managed
    WebDriver driver;

    @Steps
    AuthorVerificationSteps authorVerificationSteps;

    @Steps
    WlcmsHomePageSteps wlcmsHomePageSteps;

    @Steps
    UploadAssetsSteps uploadAssetsSteps;


    @WithTag(type = "release", name = "regression-2-test")
    @Title("Upload Image In User Profile")
    @Test
    public void uploadImageInUserProfile() {
        authorVerificationSteps.navigateToWlcmsAuthorSignUpPage();
        authorVerificationSteps.fillAuthorInformation();
        authorVerificationSteps.submittingAuthorInformation();
        wlcmsHomePageSteps.verifyAndCloseTutorialBox();
        wlcmsHomePageSteps.navigateToUserProfile();
        uploadAssetsSteps.uploadImageInUserProfile();
        wlcmsHomePageSteps.logOut();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}



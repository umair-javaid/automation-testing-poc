package com.softech.wlcms.features.make_offer;

import com.softech.wlcms.steps.common.WlcmsHomePageSteps;
import com.softech.wlcms.steps.common.WlcmsLoginSteps;
import com.softech.wlcms.steps.course_creation_steps.CourseCreationSteps;
import com.softech.wlcms.steps.make_offer_steps.MakeOfferSteps;
import com.softech.wlcms.steps.publishing_steps.PublishingSteps;
import com.softech.wlcms.steps.upload_assets_steps.UploadAssetsSteps;
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
 * Created by umair.javaid on 3/29/2016.
 */
@RunWith(SerenityRunner.class)
public class MakeOfferWebinarCourseDistributorTest {
    private static final Logger logger = LoggerFactory.getLogger(MakeOfferWebinarCourseDistributorTest.class);

    @Managed
    WebDriver driver;

    @Steps
    WlcmsLoginSteps wlcmsLoginSteps;

    @Steps
    WlcmsHomePageSteps wlcmsHomePageSteps;

    @Steps
    CourseCreationSteps courseCreationSteps;

    @Steps
    PublishingSteps publishingSteps;

    @Steps
    UploadAssetsSteps uploadAssetsSteps;

    @Steps
    MakeOfferSteps makeOfferSteps;

    @WithTag(type = "release", name = "regression-1-test")
    @Test
    public void makeOfferWebinarCourseDistributor() {

        logger.info("<---------------------------------------------------------------------->");
        logger.info("<----   Make offer for the Webinar course to 360 Distributor   ------>");
        logger.info("<---------------------------------------------------------------------->");
        wlcmsLoginSteps.LogIntoWlcms();

        wlcmsHomePageSteps.verifyAndCloseTutorialBox();
        wlcmsHomePageSteps.navigatingToWebinarCourseCreation();

        courseCreationSteps.createWebinarCourse();
        courseCreationSteps.navigateToWebinar();
        courseCreationSteps.addSchduleInWebinar();

        courseCreationSteps.navigateToInstructor();
        courseCreationSteps.addInstructorInformation();
        courseCreationSteps.navigateToWebinarSetupPage();
        courseCreationSteps.addWebinarSetupAs360TrainingProvider();

        publishingSteps.navigateToMarketing();
        uploadAssetsSteps.uploadInstructorImage();
        uploadAssetsSteps.addAuthorInformationForWebinar();

        publishingSteps.openPublishingPanel();
        publishingSteps.navigateToPublishCourse();
        publishingSteps.performLmsPublishing();

        makeOfferSteps.navigateToMakeOffer();
        makeOfferSteps.performMakeOffer();

        //wlcmsHomePageSteps.logOut();

        logger.info("<----------------------------------------------------->");
        logger.info("<----- Make offer for the Webinar course to 360 Distributor test is completed----->");
        logger.info("<----------------------------------------------------->");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}



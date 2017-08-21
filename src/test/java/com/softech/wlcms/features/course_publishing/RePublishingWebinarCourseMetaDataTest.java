package com.softech.wlcms.features.course_publishing;

import com.softech.wlcms.steps.common.WlcmsHomePageSteps;
import com.softech.wlcms.steps.common.WlcmsLoginSteps;
import com.softech.wlcms.steps.course_creation_steps.CourseCreationSteps;
import com.softech.wlcms.steps.course_updation_steps.WebinarCourseUpdationSteps;
import com.softech.wlcms.steps.publishing_steps.PublishingSteps;
import com.softech.wlcms.steps.upload_assets_steps.UploadAssetsSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.*;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by umair.javaid on 4/22/2016.
 * This CLass Contains all the test cases relates to Webinar Course Re-Publishing
 */

@RunWith(SerenityRunner.class)
public class RePublishingWebinarCourseMetaDataTest {
    private static final Logger logger = LoggerFactory.getLogger(RePublishingWebinarCourseMetaDataTest.class);

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
    WebinarCourseUpdationSteps webinarCourseUpdationSteps;

    @WithTag(type = "release", name = "regression-2-test")
    @Title("Verify Meta Data after Re-Publishing of Webinar Course to LMS")
    @Test
    public void verifyLmsMetaDataOfWebinarCourseRePublishing() {
        logger.info("<---------------------------------------------------------------------->");
        logger.info("<----  Starting Webinar Course Meta Data Re-Publish to LMS Test  ------>");
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

        webinarCourseUpdationSteps.updateWebinarCourseName();

        publishingSteps.navigateToPublishCourse();
        publishingSteps.selectMetaDataOptionForLms();
        publishingSteps.performLmsPublishing();

        logger.info("<---------------------------------------------------------------------->");
        logger.info("<---- Webinar Course Meta Data Re-Publish Test is Completed ------>");
        logger.info("<---------------------------------------------------------------------->");
    }

    @WithTag(type = "release", name = "regression-2-test")
    @Title("Verify Meta Data after Re-Publishing of Webinar Course to SF")
    @Test
    public void verifySFMetaDataOfWebinarCourseRePublishing() {
        logger.info("<---------------------------------------------------------------------->");
        logger.info("<----  Starting Webinar Course Meta Data Re-Publish to SF Test  ------>");
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
        publishingSteps.performSfPublishing();

        webinarCourseUpdationSteps.updateWebinarCourseName();

        publishingSteps.navigateToPublishCourse();
        publishingSteps.selectMetaDataOptionForLms();
        publishingSteps.performSfRePublishing();

        logger.info("<---------------------------------------------------------------------->");
        logger.info("<---- Webinar Course Meta Data Re-Publish Test is Completed ------>");
        logger.info("<---------------------------------------------------------------------->");
    }

    @WithTag(type = "release", name = "regression-2-test")
    @Title("Verify Course Content after Re-Publishing of Webinar Course to LMS")
    @Test
    public void verifyLmsContentOfWebinarCourseRePublishing() {
        logger.info("<---------------------------------------------------------------------->");
        logger.info("<----  Starting Webinar Course Content Re-Publish to LMS Test  ------>");
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

//        webinarCourseUpdationSteps.updateWebinarCourseName();
        courseCreationSteps.navigateToInstructor();
        courseCreationSteps.addInstructorInformation();

        publishingSteps.navigateToPublishCourse();
        publishingSteps.selectMetaDataOptionForLms();
        publishingSteps.performLmsPublishing();

        logger.info("<---------------------------------------------------------------------->");
        logger.info("<---- Webinar Course Content Re-Publish to LMS Test is Completed ------>");
        logger.info("<---------------------------------------------------------------------->");
    }

    @WithTag(type = "release", name = "regression-2-test")
    @Title("Verify Course Content after Re-Publishing of Webinar Course to SF")
    @Test
    public void verifySFContentOfWebinarCourseRePublishing() {
        logger.info("<---------------------------------------------------------------------->");
        logger.info("<----  Starting Webinar Course Content Re-Publish to SF Test  ------>");
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
        publishingSteps.performSfPublishing();

//        webinarCourseUpdationSteps.updateWebinarCourseName();
        courseCreationSteps.navigateToInstructor();
        courseCreationSteps.addInstructorInformation();

        publishingSteps.navigateToPublishCourse();
        publishingSteps.selectMetaDataOptionForLms();
        publishingSteps.performSfRePublishing();

        logger.info("<---------------------------------------------------------------------->");
        logger.info("<---- Webinar Course Content Re-Publish to SF Test is Completed ------>");
        logger.info("<---------------------------------------------------------------------->");
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}

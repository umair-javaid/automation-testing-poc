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

import java.awt.*;

/**
 * Created by umair.javaid on 3/28/2016.
 */
@RunWith(SerenityRunner.class)
public class MakeOfferClassroomCourseDistributorTest {
    private static final Logger logger = LoggerFactory.getLogger(MakeOfferClassroomCourseDistributorTest.class);

    @Managed
    WebDriver driver;

    @Steps
    WlcmsLoginSteps wlcmsLoginSteps;

    @Steps
    CourseCreationSteps courseCreationSteps;

    @Steps
    WlcmsHomePageSteps wlcmsHomePageSteps;

    @Steps
    PublishingSteps publishingSteps;

    @Steps
    MakeOfferSteps makeOfferSteps;

    @Steps
    UploadAssetsSteps uploadAssetsSteps;

    @WithTag(type = "release", name = "regression-1-test")
    @Test
    public void makeOfferClassroomCourseDistributor() throws AWTException {
        logger.info("<---------------------------------------------------->");
        logger.info("<---Make offer for the Classroom course to 360 Distributor---->");
        logger.info("<---------------------------------------------------->");
        wlcmsLoginSteps.LogIntoWlcms();

        wlcmsHomePageSteps.verifyAndCloseTutorialBox();
        wlcmsHomePageSteps.navigatingToClassroomCourseCreation();
        courseCreationSteps.createClassroomCourse();
        courseCreationSteps.addClassInClassroom();
        courseCreationSteps.addManualSessionInClassroom();
        courseCreationSteps.addNewLocation();



        publishingSteps.navigateToMarketing();

        uploadAssetsSteps.uploadInstructorImage();
        uploadAssetsSteps.addAuthorInformationForClassroom();

        courseCreationSteps.addNewProvider();

        publishingSteps.navigateToPublishCourse();
        publishingSteps.performLmsPublishing();

        makeOfferSteps.navigateToMakeOffer();
        makeOfferSteps.performMakeOffer();



        logger.info("<---------------------------------------------------->");
        logger.info("<---Test is Completed for Make offer for the Classroom course to 360 Distributor---->");
        logger.info("<---------------------------------------------------->");

    }
    @After
    public void tearDown() {
        driver.quit();
    }
}



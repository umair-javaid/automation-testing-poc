package com.softech.wlcms.features.make_offer;

import com.softech.wlcms.steps.common.WlcmsHomePageSteps;
import com.softech.wlcms.steps.common.WlcmsLoginSteps;
import com.softech.wlcms.steps.course_creation_steps.CourseCreationSteps;
import com.softech.wlcms.steps.make_offer_steps.MakeOfferSteps;
import com.softech.wlcms.steps.publishing_steps.PublishingSteps;
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

import static junit.framework.TestCase.assertTrue;

/**
 * Created by umair.javaid on 3/3/2016.
 */


@RunWith(SerenityRunner.class)
public class MakeOfferOnlineCourseDistributorTest {
    private static final Logger logger = LoggerFactory.getLogger(MakeOfferOnlineCourseDistributorTest.class);

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

    @WithTag(type = "release", name = "smoke-test")
    @Test
    public void makeOfferOnlineCourseDistributor() {
        logger.info("<---------------------------------------------------->");
        logger.info("<---Make offer for the Online course to 360 Distributor---->");
        logger.info("<---------------------------------------------------->");
        wlcmsLoginSteps.LogIntoWlcms();

        wlcmsHomePageSteps.verifyAndCloseTutorialBox();
        wlcmsHomePageSteps.navigatingToOnlineCourseCreation();

        courseCreationSteps.createOnlineCourse();

        publishingSteps.navigateToOnlinePublishCourse();
        publishingSteps.performOnlineLmsPublishing();

        makeOfferSteps.navigateToMakeOffer();
        makeOfferSteps.performMakeOffer();


        logger.info("<---------------------------------------------------->");
        logger.info("<---Test is Completed for Make offer for the Online course to 360 Distributor---->");
        logger.info("<---------------------------------------------------->");
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}

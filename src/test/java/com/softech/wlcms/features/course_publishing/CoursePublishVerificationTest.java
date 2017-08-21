package com.softech.wlcms.features.course_publishing;

import com.softech.wlcms.steps.common.WlcmsHomePageSteps;
import com.softech.wlcms.steps.common.WlcmsLoginSteps;
import com.softech.wlcms.steps.course_creation_steps.CourseCreationSteps;
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
 * Created by umair.javaid on 3/2/2016.
 */

@RunWith(SerenityRunner.class)
public class CoursePublishVerificationTest {
    private static final Logger logger = LoggerFactory.getLogger(CoursePublishVerificationTest.class);

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

    @WithTag(type = "release", name = "smoke-test")
    @Test
    public void verifyLmsPublishingOnline() {
        logger.info("<---------------------------------------------------->");
        logger.info("<----     Starting Online Publish to LMS Test     ----->");
        logger.info("<---------------------------------------------------->");
        wlcmsLoginSteps.LogIntoWlcms();

        wlcmsHomePageSteps.verifyAndCloseTutorialBox();
        wlcmsHomePageSteps.navigatingToOnlineCourseCreation();

        courseCreationSteps.createOnlineCourse();

        publishingSteps.navigateToOnlinePublishCourse();
        publishingSteps.performOnlineLmsPublishing();

        logger.info("<----------------------------------------------------->");
        logger.info("<-----  Online Publish to LMS Test Completed   ----->");
        logger.info("<----------------------------------------------------->");
    }

    @WithTag(type = "release", name = "smoke-test")
    @Test
    public void verifySFPublishingOnline() {
        logger.info("<---------------------------------------------------->");
        logger.info("<----     Starting Online Publish to SF Test     ----->");
        logger.info("<---------------------------------------------------->");
        wlcmsLoginSteps.LogIntoWlcms();

        wlcmsHomePageSteps.verifyAndCloseTutorialBox();
        wlcmsHomePageSteps.navigatingToOnlineCourseCreation();

        courseCreationSteps.createOnlineCourse();

        publishingSteps.navigateToOnlinePublishCourse();
        publishingSteps.performOnlineSFPublishing();
        logger.info("<----------------------------------------------------->");
        logger.info("<-----  Online Publish to SF Test Completed   ----->");
        logger.info("<----------------------------------------------------->");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

package com.softech.wlcms.features.course_publishing;

import com.softech.wlcms.steps.common.WlcmsHomePageSteps;
import com.softech.wlcms.steps.common.WlcmsLoginSteps;
import com.softech.wlcms.steps.course_creation_steps.CourseCreationSteps;
import com.softech.wlcms.steps.course_updation_steps.OnlineCourseUpdationSteps;
import com.softech.wlcms.steps.publishing_steps.PublishingSteps;
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
 * Created by umair.javaid on 3/25/2016.
 */

@RunWith(SerenityRunner.class)
public class RePublishingOnlineCourseMetaDataTest {
    private static final Logger logger = LoggerFactory.getLogger(RePublishingOnlineCourseMetaDataTest.class);

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
    OnlineCourseUpdationSteps onlineCourseUpdationSteps;

    @WithTag(type = "release", name = "regression-1-test")
    @Title("Verify Meta Data after Re-Publishing of Online Course to LMS")
    @Test
    public void verifyLmsMetaDataOfOnlineCourseRePublishing()
    {
        logger.info("<---------------------------------------------------->");
        logger.info("<----  Starting Online Meta Data Re-Publish to LMS Test  ---->");
        logger.info("<---------------------------------------------------->");
        wlcmsLoginSteps.LogIntoWlcms();

        wlcmsHomePageSteps.verifyAndCloseTutorialBox();
        wlcmsHomePageSteps.navigatingToOnlineCourseCreation();

        courseCreationSteps.createOnlineCourse();

        publishingSteps.navigateToOnlinePublishCourse();
        publishingSteps.performOnlineLmsPublishing();

        onlineCourseUpdationSteps.updateCourseMetaData();

        publishingSteps.navigateToOnlinePublishCourse();
        publishingSteps.selectMetaDataOptionForLms();
        publishingSteps.performOnlineLmsPublishing();

        logger.info("<----------------------------------------------------->");
        logger.info("<-----  Online Re-Publish to LMS Test Completed   ----->");
        logger.info("<----------------------------------------------------->");

    }

    @WithTag(type = "release", name = "regression-1-test")
    @Title("Verify Meta Data after Re-Publishing of Content in Online Course to LMS")
    @Test
    public void verifyLmsContentOfOnlineCourseRePublishing()
    {
        logger.info("<---------------------------------------------------->");
        logger.info("<----  Starting Online Meta Data Re-Publish to LMS Test  ---->");
        logger.info("<---------------------------------------------------->");
        wlcmsLoginSteps.LogIntoWlcms();

        wlcmsHomePageSteps.verifyAndCloseTutorialBox();
        wlcmsHomePageSteps.navigatingToOnlineCourseCreation();

        courseCreationSteps.createOnlineCourse();
        courseCreationSteps.addLessonIntoOnlineCourse();

        publishingSteps.navigateToOnlinePublishCourse();
        publishingSteps.performOnlineLmsPublishing();

        onlineCourseUpdationSteps.updateCourseContent();

        publishingSteps.navigateToOnlinePublishCourse();
        publishingSteps.selectMetaDataOptionForLms();
        publishingSteps.performOnlineLmsPublishing();

        logger.info("<----------------------------------------------------->");
        logger.info("<-----  Online Re-Publish to LMS Test Completed   ----->");
        logger.info("<----------------------------------------------------->");

    }
    @After
    public void tearDown() {
        driver.quit();
    }
}

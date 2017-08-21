package com.softech.wlcms.features.course_verification;


import com.softech.wlcms.steps.common.WlcmsHomePageSteps;
import com.softech.wlcms.steps.common.WlcmsLoginSteps;
import com.softech.wlcms.steps.course_creation_steps.CourseCreationSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import org.junit.After;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static junit.framework.TestCase.assertTrue;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WebinarCourseTest {
    private static final Logger logger = LoggerFactory.getLogger(WebinarCourseTest.class);

    @Managed
    WebDriver driver;

    @Steps
    WlcmsLoginSteps wlcmsLoginSteps;

    @Steps
    WlcmsHomePageSteps wlcmsHomePageSteps;

    @Steps
    CourseCreationSteps courseCreationSteps;


    @WithTag(type = "release", name = "smoke-test")
    @Title("Verify Creation of New Webinar Course")
    @Test
    public void NewWebinar() {
        logger.info("<---------------------------------------------------->");
        logger.info("<-- Starting WLCMS Create New Webinar Course Test -->");
        logger.info("<---------------------------------------------------->");

        wlcmsLoginSteps.LogIntoWlcms();

        wlcmsHomePageSteps.verifyAndCloseTutorialBox();
        wlcmsHomePageSteps.navigatingToWebinarCourseCreation();

        courseCreationSteps.createWebinarCourse();

        logger.info("<----------------------------------------------------->");
        logger.info("<---- WLCMS New Webinar Course Test is Completed ---->");
        logger.info("<----------------------------------------------------->");
    }

    @WithTag(type = "release", name = "regression-1-test")
    @Title("Verify Creation of Schedule in Webinar Course")
    @Test
    public void newScheduleInWebinarCourse() {

        logger.info("<---------------------------------------------------------------------->");
        logger.info("<----   Starting WLCMS Creation of Schedule in Webinar Course   ------>");
        logger.info("<---------------------------------------------------------------------->");
        wlcmsLoginSteps.LogIntoWlcms();

        wlcmsHomePageSteps.verifyAndCloseTutorialBox();
        wlcmsHomePageSteps.navigatingToWebinarCourseCreation();

        courseCreationSteps.createWebinarCourse();
        courseCreationSteps.navigateToWebinar();
        courseCreationSteps.addSchduleInWebinar();

        logger.info("<---------------------------------------------------------------------->");
        logger.info("<----WLCMS Creation of Schedule in Webinar Course test is completed---->");
        logger.info("<---------------------------------------------------------------------->");
    }

    @WithTag(type = "release", name = "regression-2-test")
    @Title("Verify Creation of Other Service Provider in Webinar Course")
    @Test
    public void addWebinarSetupAsOtherServiceProvider() {

        logger.info("<---------------------------------------------------------------------->");
        logger.info("<---Starting WLCMS Creation of Other Service Provider in Webinar Course--->");
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
        courseCreationSteps.addServiceProviderAsOtherProvider();

        logger.info("<---------------------------------------------------------------------->");
        logger.info("<--WLCMS Creation of Other Service Provider in Webinar Course test is completed-->");
        logger.info("<---------------------------------------------------------------------->");
    }



    @After
    public void tearDown() {
        driver.quit();
    }
}


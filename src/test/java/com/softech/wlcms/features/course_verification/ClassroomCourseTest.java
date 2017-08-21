package com.softech.wlcms.features.course_verification;

/**
 * Created by umair.javaid on 3/9/2016.
 */
import com.softech.wlcms.steps.common.WlcmsHomePageSteps;
import com.softech.wlcms.steps.common.WlcmsLoginSteps;
import com.softech.wlcms.steps.course_creation_steps.CourseCreationSteps;
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

import static junit.framework.TestCase.assertTrue;

@RunWith(SerenityRunner.class)
public class ClassroomCourseTest {
    private static final Logger logger = LoggerFactory.getLogger(ClassroomCourseTest.class);

    @Managed
    WebDriver driver;

    @Steps
    WlcmsLoginSteps wlcmsLoginSteps;

    @Steps
    WlcmsHomePageSteps wlcmsHomePageSteps;

    @Steps
    CourseCreationSteps courseCreationSteps;



    @WithTag(type = "release", name = "smoke-test")
    @Title("Verify Creation of New Classroom Course")
    @Test
    public void newClassroom() {

        logger.info("<---------------------------------------------------->");
        logger.info("<-- Starting WLCMS Create New Classroom Course Test -->");
        logger.info("<---------------------------------------------------->");

        wlcmsLoginSteps.LogIntoWlcms();

        wlcmsHomePageSteps.verifyAndCloseTutorialBox();
        wlcmsHomePageSteps.navigatingToClassroomCourseCreation();

        courseCreationSteps.createClassroomCourse();


        logger.info("<----------------------------------------------------->");
        logger.info("<---- WLCMS New Classroom Course Test is Completed ---->");
        logger.info("<----------------------------------------------------->");
    }


    @WithTag(type = "release", name = "regression-1-test")
    @Title("Verify Creation of New Class in Classroom Course")
    @Test
    public void newClassInClassroomCourse() {

        logger.info("<---------------------------------------------------->");
        logger.info("<-- Starting WLCMS Add New Class in Classroom Course Test -->");
        logger.info("<---------------------------------------------------->");

        wlcmsLoginSteps.LogIntoWlcms();

        wlcmsHomePageSteps.verifyAndCloseTutorialBox();
        wlcmsHomePageSteps.navigatingToClassroomCourseCreation();

        courseCreationSteps.createClassroomCourse();
        courseCreationSteps.addClassInClassroom();

        logger.info("<----------------------------------------------------->");
        logger.info("<---- WLCMS Add New Class Test is Completed ---->");
        logger.info("<----------------------------------------------------->");
    }

    @WithTag(type = "release", name = "regression-1-test")
    @Title("Verify Creation of New Session in Classroom Course")
    @Test
    public void newSessionInClassroomCourse() {

        logger.info("<---------------------------------------------------->");
        logger.info("<-- Starting WLCMS Add New Session in Classroom Course Test -->");
        logger.info("<---------------------------------------------------->");

        wlcmsLoginSteps.LogIntoWlcms();

        wlcmsHomePageSteps.verifyAndCloseTutorialBox();
        wlcmsHomePageSteps.navigatingToClassroomCourseCreation();

        courseCreationSteps.createClassroomCourse();
        courseCreationSteps.addClassInClassroom();
        courseCreationSteps.addManualSessionInClassroom();

        logger.info("<----------------------------------------------------->");
        logger.info("<---- WLCMS Add New Session Test is Completed ---->");
        logger.info("<----------------------------------------------------->");
    }

    @WithTag(type = "release", name = "regression-1-test")
    @Title("Verify Creation of New Location in Classroom Course")
    @Test
    public void newLocationInClassroomCourse() {

        logger.info("<---------------------------------------------------->");
        logger.info("<-- Starting WLCMS Add New Location in Classroom Course -->");
        logger.info("<---------------------------------------------------->");

        wlcmsLoginSteps.LogIntoWlcms();

        wlcmsHomePageSteps.verifyAndCloseTutorialBox();
        wlcmsHomePageSteps.navigatingToClassroomCourseCreation();

        courseCreationSteps.createClassroomCourse();
        courseCreationSteps.addNewLocation();



        logger.info("<----------------------------------------------------->");
        logger.info("<---- WLCMS Add New Location Test is Completed ---->");
        logger.info("<----------------------------------------------------->");
    }

    @WithTag(type = "release", name = "regression-1-test")
    @Title("Verify Creation of New Provider in Classroom Course")
    @Test
    public void newProviderInClassroomCourse() {

        logger.info("<---------------------------------------------------->");
        logger.info("<-- Starting WLCMS Add New Session in Classroom Course Test -->");
        logger.info("<---------------------------------------------------->");

        wlcmsLoginSteps.LogIntoWlcms();

        wlcmsHomePageSteps.verifyAndCloseTutorialBox();
        wlcmsHomePageSteps.navigatingToClassroomCourseCreation();

        courseCreationSteps.createClassroomCourse();
        courseCreationSteps.addClassInClassroom();
        courseCreationSteps.addManualSessionInClassroom();
        courseCreationSteps.addNewProvider();


        logger.info("<----------------------------------------------------->");
        logger.info("<---- WLCMS Add New Provider Test is Completed ---->");
        logger.info("<----------------------------------------------------->");
    }

    @WithTag(type = "release", name = "regression-2-test")
    @Title("Verify Creation of New Daily Session in Classroom Course")
    @Test
    public void newDailySessionInClassroomCourse() {

        logger.info("<---------------------------------------------------->");
        logger.info("<-- Starting WLCMS Add New Daily Session in Classroom Course Test -->");
        logger.info("<---------------------------------------------------->");

        wlcmsLoginSteps.LogIntoWlcms();

        wlcmsHomePageSteps.verifyAndCloseTutorialBox();
        wlcmsHomePageSteps.navigatingToClassroomCourseCreation();

        courseCreationSteps.createClassroomCourse();
        courseCreationSteps.addClassInClassroom();
        courseCreationSteps.addDailySessionInClassroom();

        logger.info("<----------------------------------------------------->");
        logger.info("<---- WLCMS Add New Daily Session Test is Completed ---->");
        logger.info("<----------------------------------------------------->");
    }

    @WithTag(type = "release", name = "regression-2-test")
    @Title("Verify Creation of New Weekly Session in Classroom Course")
    @Test
    public void newWeeklySessionInClassroomCourse() {

        logger.info("<---------------------------------------------------->");
        logger.info("<-- Starting WLCMS Add New Weekly Session in Classroom Course Test -->");
        logger.info("<---------------------------------------------------->");

        wlcmsLoginSteps.LogIntoWlcms();

        wlcmsHomePageSteps.verifyAndCloseTutorialBox();
        wlcmsHomePageSteps.navigatingToClassroomCourseCreation();

        courseCreationSteps.createClassroomCourse();
        courseCreationSteps.addClassInClassroom();
        courseCreationSteps.addWeeklySessionInClassroom();

        logger.info("<----------------------------------------------------->");
        logger.info("<---- WLCMS Add New Weekly Session Test is Completed ---->");
        logger.info("<----------------------------------------------------->");
    }



    @After
    public void tearDown() {
        driver.quit();
    }
}

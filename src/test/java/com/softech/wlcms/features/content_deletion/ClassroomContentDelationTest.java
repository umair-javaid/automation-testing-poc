package com.softech.wlcms.features.content_deletion;

import com.softech.wlcms.steps.common.WlcmsHomePageSteps;
import com.softech.wlcms.steps.common.WlcmsLoginSteps;
import com.softech.wlcms.steps.content_deletion_steps.ClassroomContentDeletionSteps;
import com.softech.wlcms.steps.course_creation_steps.CourseCreationSteps;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by umair.javaid on 4/29/2016.
 */
@RunWith(SerenityRunner.class)
public class ClassroomContentDelationTest {
    private static final Logger logger = LoggerFactory.getLogger(ClassroomContentDelationTest.class);

    @Managed
    WebDriver driver;

    @Steps
    WlcmsLoginSteps wlcmsLoginSteps;

    @Steps
    WlcmsHomePageSteps wlcmsHomePageSteps;

    @Steps
    CourseCreationSteps courseCreationSteps;

    @Steps
    ClassroomContentDeletionSteps classroomContentDeletionSteps;

    @WithTag(type = "release", name = "regression-2-test")
    @Title("Verify Deletion of Class in Classroom Course")
    @Test
    public void deleteClassFromClassroomCourse() {

        logger.info("<---------------------------------------------------->");
        logger.info("<-- Starting WLCMS Deletion of Class in Classroom Course Test -->");
        logger.info("<---------------------------------------------------->");

        wlcmsLoginSteps.LogIntoWlcms();

        wlcmsHomePageSteps.verifyAndCloseTutorialBox();
        wlcmsHomePageSteps.navigatingToClassroomCourseCreation();

        courseCreationSteps.createClassroomCourse();
        courseCreationSteps.addClassInClassroom();

        classroomContentDeletionSteps.deleteClassFromClassroomCourse();

        logger.info("<----------------------------------------------------->");
        logger.info("<---- WLCMS Deletion of Class Test is Completed ---->");
        logger.info("<----------------------------------------------------->");
    }

    @WithTag(type = "release", name = "regression-2-test")
    @Title("Verify Deletion of Manual Session From Class in Classroom Course")
    @Test
    public void deleteSessionFromClassroomCourse() {

        logger.info("<---------------------------------------------------->");
        logger.info("<-- Starting WLCMS Deletion of Manual Session from Class in Classroom Course Test -->");
        logger.info("<---------------------------------------------------->");

        wlcmsLoginSteps.LogIntoWlcms();

        wlcmsHomePageSteps.verifyAndCloseTutorialBox();
        wlcmsHomePageSteps.navigatingToClassroomCourseCreation();

        courseCreationSteps.createClassroomCourse();
        courseCreationSteps.addClassInClassroom();
        courseCreationSteps.addManualSessionInClassroom();

        classroomContentDeletionSteps.deleteManualSessionFromClass();

        logger.info("<----------------------------------------------------->");
        logger.info("<---- WLCMS Deletion of Manual Session From Class Test is Completed ---->");
        logger.info("<----------------------------------------------------->");
    }

    @WithTag(type = "release", name = "regression-3-test")
    @Title("Verify Deletion of Location From Class in Classroom Course")
    @Test
    public void deleteLocationFromClassroomCourse() {

        logger.info("<---------------------------------------------------->");
        logger.info("<-- Starting WLCMS Deletion of Location from Class in Classroom Course Test -->");
        logger.info("<---------------------------------------------------->");

        wlcmsLoginSteps.LogIntoWlcms();

        wlcmsHomePageSteps.verifyAndCloseTutorialBox();
        wlcmsHomePageSteps.navigatingToClassroomCourseCreation();

        courseCreationSteps.createClassroomCourse();
        courseCreationSteps.addClassInClassroom();
        courseCreationSteps.addNewLocation();



        logger.info("<----------------------------------------------------->");
        logger.info("<---- WLCMS Deletion of Location From Class Test is Completed ---->");
        logger.info("<----------------------------------------------------->");
    }

}

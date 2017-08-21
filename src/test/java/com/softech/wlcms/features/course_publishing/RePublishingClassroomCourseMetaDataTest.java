package com.softech.wlcms.features.course_publishing;

import com.softech.wlcms.steps.common.WlcmsHomePageSteps;
import com.softech.wlcms.steps.common.WlcmsLoginSteps;
import com.softech.wlcms.steps.course_creation_steps.CourseCreationSteps;
import com.softech.wlcms.steps.course_updation_steps.ClassRoomCourseUpdationSteps;
import com.softech.wlcms.steps.publishing_steps.PublishingSteps;
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
 * Created by umair.javaid on 4/20/2016.
 */
@RunWith(SerenityRunner.class)
public class RePublishingClassroomCourseMetaDataTest {
    private static final Logger logger = LoggerFactory.getLogger(RePublishingClassroomCourseMetaDataTest.class);

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
    ClassRoomCourseUpdationSteps classRoomCourseUpdationSteps;

    @WithTag(type = "release", name = "regression-2-test")
    @Title("Verify Meta Data after Re-Publishing of Classroom Course to LMS")
    @Test
    public void verifyLmsMetaDataOfClassroomCourseRePublishing() {
        logger.info("<---------------------------------------------------->");
        logger.info("<----  Starting Classroom Meta Data Re-Publish to LMS Test  ---->");
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

        classRoomCourseUpdationSteps.updateClassroomCourseName();

        publishingSteps.navigateToPublishCourse();
        publishingSteps.selectMetaDataOptionForLms();
        publishingSteps.performLmsPublishing();

        logger.info("<---------------------------------------------------->");
        logger.info("<---- Classroom Meta Data Re-Publish to LMS Test is Completed ---->");
        logger.info("<---------------------------------------------------->");
    }

    @WithTag(type = "release", name = "regression-2-test")
    @Title("Verify Meta Data after Re-Publishing of Classroom Course to SF")
    @Test
    public void verifySfMetaDataOfClassroomCourseRePublishing() {
        logger.info("<---------------------------------------------------->");
        logger.info("<----  Starting Classroom Meta Data Re-Publish to SF Test  ---->");
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
        publishingSteps.performSfPublishing();

        classRoomCourseUpdationSteps.updateClassroomCourseName();

        publishingSteps.navigateToPublishCourse();
        publishingSteps.selectMetaDataOptionForLms();
        publishingSteps.performSfRePublishing();

        logger.info("<---------------------------------------------------->");
        logger.info("<---- Classroom Meta Data Re-Publish to SF Test is Completed ---->");
        logger.info("<---------------------------------------------------->");
    }

    @WithTag(type = "release", name = "regression-2-test")
    @Title("Verify Course Content after Re-Publishing of Classroom Course to LMS")
    @Test
    public void verifyLmsContentOfClassroomCourseRePublishing() {
        logger.info("<---------------------------------------------------->");
        logger.info("<----  Starting Classroom Course Content Re-Publish to LMS Test  ---->");
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

//        classRoomCourseUpdationSteps.updateClassroomCourseName();
        courseCreationSteps.addSecondClassInClassroom();

        publishingSteps.navigateToPublishCourse();
        publishingSteps.selectMetaDataOptionForLms();
        publishingSteps.performLmsPublishing();

        logger.info("<---------------------------------------------------->");
        logger.info("<---- Classroom Course Content Re-Publish to LMS Test is Completed ---->");
        logger.info("<---------------------------------------------------->");

    }

    @WithTag(type = "release", name = "regression-2-test")
    @Title("Verify Course Content after Re-Publishing of Classroom Course to SF")
    @Test
    public void verifySFContentOfClassroomCourseRePublishing() {
        logger.info("<---------------------------------------------------->");
        logger.info("<----  Starting Classroom Course Content Re-Publish to SF Test  ---->");
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
        publishingSteps.performSfPublishing();

//        classRoomCourseUpdationSteps.updateClassroomCourseName();
        courseCreationSteps.addSecondClassInClassroom();

        publishingSteps.navigateToPublishCourse();
        publishingSteps.selectMetaDataOptionForLms();
        publishingSteps.performSfRePublishing();

        logger.info("<---------------------------------------------------->");
        logger.info("<---- Classroom Course Content Re-Publish to SF Test is Completed ---->");
        logger.info("<---------------------------------------------------->");

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

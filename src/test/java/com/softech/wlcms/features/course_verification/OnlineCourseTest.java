package com.softech.wlcms.features.course_verification;

/**
 * Created by umair.javaid on 3/9/2016.
 */

import com.softech.wlcms.steps.common.WlcmsHomePageSteps;
import com.softech.wlcms.steps.common.WlcmsLoginSteps;
import com.softech.wlcms.steps.course_creation_steps.CourseCreationSteps;
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

import static junit.framework.TestCase.assertTrue;

@RunWith(SerenityRunner.class)
public class OnlineCourseTest {
    private static final Logger logger = LoggerFactory.getLogger(OnlineCourseTest.class);

    @Managed
    WebDriver driver;

    @Steps
    WlcmsLoginSteps wlcmsLoginSteps;

    @Steps
    WlcmsHomePageSteps wlcmsHomePageSteps;

    @Steps
    CourseCreationSteps courseCreationSteps;

    @Steps
    UploadAssetsSteps uploadAssetsSteps;

    @WithTag(type = "release", name = "smoke-test")
    @Title("Verify Creation of New Online Course")
    @Test
    public void NewOnline() {

        logger.info("<---------------------------------------------------->");
        logger.info("<----   Starting WLCMS Create New Online Test   ----->");
        logger.info("<---------------------------------------------------->");
        wlcmsLoginSteps.LogIntoWlcms();

        wlcmsHomePageSteps.verifyAndCloseTutorialBox();
        wlcmsHomePageSteps.navigatingToOnlineCourseCreation();

        courseCreationSteps.createOnlineCourse();

        wlcmsHomePageSteps.logOut();

        logger.info("<----------------------------------------------------->");
        logger.info("<-----  WLCMS New Online Course Test Completed   ----->");
        logger.info("<----------------------------------------------------->");
    }

    @WithTag(type = "release", name = "smoke-test")
    @Title("Verify Creation of New Lesson Under Online Course")
    @Test
    public void AddNewLesson() {
        logger.info("<---------------------------------------------------->");
        logger.info("<-- Starting WLCMS Add New Lesson Test -->");
        logger.info("<---------------------------------------------------->");

        wlcmsLoginSteps.LogIntoWlcms();

        wlcmsHomePageSteps.verifyAndCloseTutorialBox();
        wlcmsHomePageSteps.navigatingToOnlineCourseCreation();

        courseCreationSteps.createOnlineCourse();
        courseCreationSteps.addLessonIntoOnlineCourse();

        logger.info("<----------------------------------------------------->");
        logger.info("<---- WLCMS Add New Lesson Test is Completed ---->");
        logger.info("<----------------------------------------------------->");
    }

    @WithTag(type = "release", name = "smoke-test")
    @Title("Verify Creation of New Slide Under New Lesson")
    @Test
    public void AddSlide() {
        logger.info("<---------------------------------------------------->");
        logger.info("<-- Starting WLCMS Add New Slide Test -->");
        logger.info("<---------------------------------------------------->");
        wlcmsLoginSteps.LogIntoWlcms();

        wlcmsHomePageSteps.verifyAndCloseTutorialBox();
        wlcmsHomePageSteps.navigatingToOnlineCourseCreation();

        courseCreationSteps.createOnlineCourse();
        courseCreationSteps.addLessonIntoOnlineCourse();
        courseCreationSteps.addSlideIntoOnlineCourse();

        logger.info("<----------------------------------------------------->");
        logger.info("<---- WLCMS Add New Slide Test is Completed ---->");
        logger.info("<----------------------------------------------------->");
    }

    @WithTag(type = "release", name = "smoke-test")
    @Title("Verify Creation of New Online Course Preview ")
    @Test
    public void previewCourse() {
        logger.info("<---------------------------------------------------->");
        logger.info("<----     Starting Preview Course Test     ----->");
        logger.info("<---------------------------------------------------->");
        wlcmsLoginSteps.LogIntoWlcms();

        wlcmsHomePageSteps.verifyAndCloseTutorialBox();
        wlcmsHomePageSteps.navigatingToOnlineCourseCreation();

        courseCreationSteps.createOnlineCourse();
        courseCreationSteps.addLessonIntoOnlineCourse();
        courseCreationSteps.addSlideIntoOnlineCourse();
        courseCreationSteps.previewOnlineCourse();

        logger.info("<---------------------------------------------------->");
        logger.info("<----    Preview Course Test Completed     ----->");
        logger.info("<---------------------------------------------------->");
    }

    @WithTag(type = "release", name = "regression-1-test")
    @Title("Verify Creation of New Quiz In Online Course")
    @Test
    public void newQuizInLesson() {

        logger.info("<---------------------------------------------------->");
        logger.info("<-- Starting WLCMS Add New Quiz in Lesson for Online Course -->");
        logger.info("<---------------------------------------------------->");

        wlcmsLoginSteps.LogIntoWlcms();

        wlcmsHomePageSteps.verifyAndCloseTutorialBox();
        wlcmsHomePageSteps.navigatingToOnlineCourseCreation();

        courseCreationSteps.createOnlineCourse();
        courseCreationSteps.addLessonIntoOnlineCourse();
        courseCreationSteps.addNewQuizInLesson();

        logger.info("<----------------------------------------------------->");
        logger.info("<---- WLCMS Add New Quiz Test is Completed ---->");
        logger.info("<----------------------------------------------------->");
    }

    @WithTag(type = "release", name = "regression-1-test")
    @Title("Verify Creation of New Question In Quiz For Online Course ")
    @Test
    public void newQuestionInQuiz() {

        logger.info("<---------------------------------------------------->");
        logger.info("<-- Starting WLCMS Add New Question in Quiz for Online Course -->");
        logger.info("<---------------------------------------------------->");

        wlcmsLoginSteps.LogIntoWlcms();

        wlcmsHomePageSteps.verifyAndCloseTutorialBox();
        wlcmsHomePageSteps.navigatingToOnlineCourseCreation();

        courseCreationSteps.createOnlineCourse();
        courseCreationSteps.addLessonIntoOnlineCourse();
        courseCreationSteps.addNewQuizInLesson();
        courseCreationSteps.addQuestionInQuiz();

        logger.info("<----------------------------------------------------->");
        logger.info("<---- WLCMS Add New Question Test is Completed ---->");
        logger.info("<----------------------------------------------------->");
    }

    @WithTag(type = "release", name = "regression-1-test")
    @Title("Verify Creation of Final Exam For Online Course")
    @Test
    public void addFinalExamInLesson() {

        logger.info("<---------------------------------------------------->");
        logger.info("<-- Starting WLCMS Add Final Exam in Lesson for Online Course -->");
        logger.info("<---------------------------------------------------->");

        wlcmsLoginSteps.LogIntoWlcms();

        wlcmsHomePageSteps.verifyAndCloseTutorialBox();
        wlcmsHomePageSteps.navigatingToOnlineCourseCreation();

        courseCreationSteps.createOnlineCourse();
        courseCreationSteps.addFinalExamInLesson();


        logger.info("<----------------------------------------------------->");
        logger.info("<---- WLCMS Add Final Exam Test is Completed ---->");
        logger.info("<----------------------------------------------------->");
    }

    @WithTag(type = "release", name = "regression-1-test")
    @Title("Verify Creation of Question in Final Exam")
    @Test
    public void addQuestionInFinalExam() {

        logger.info("<---------------------------------------------------->");
        logger.info("<-- Starting WLCMS Add Question in Exam for Online Course -->");
        logger.info("<---------------------------------------------------->");

        wlcmsLoginSteps.LogIntoWlcms();

        wlcmsHomePageSteps.verifyAndCloseTutorialBox();
        wlcmsHomePageSteps.navigatingToOnlineCourseCreation();

        courseCreationSteps.createOnlineCourse();
        courseCreationSteps.addLessonIntoOnlineCourse();
        courseCreationSteps.addFinalExamInLesson();
        courseCreationSteps.addQuestionInExam();

        logger.info("<----------------------------------------------------->");
        logger.info("<---- WLCMS Add Question in Exam Test is Completed ---->");
        logger.info("<----------------------------------------------------->");
    }

    @WithTag(type = "release", name = "regression-1-test")
    @Title("Verify Image Upload In Slide For Online Course")
    @Test
    public void addImageInSlide() {

        logger.info("<---------------------------------------------------->");
        logger.info("<-- Starting WLCMS Add Image in Slide for Online Course -->");
        logger.info("<---------------------------------------------------->");

        wlcmsLoginSteps.LogIntoWlcms();

        wlcmsHomePageSteps.verifyAndCloseTutorialBox();
        wlcmsHomePageSteps.navigatingToOnlineCourseCreation();

        courseCreationSteps.createOnlineCourse();
        courseCreationSteps.addLessonIntoOnlineCourse();
        courseCreationSteps.addSlideIntoOnlineCourse();

        courseCreationSteps.navigateToUploadAssetsInSlide();
        uploadAssetsSteps.uploadImageInSlide();


        logger.info("<----------------------------------------------------->");
        logger.info("<---- WLCMS Add Image in Slide Test is Completed ---->");
        logger.info("<----------------------------------------------------->");
    }

    @WithTag(type = "release", name = "regression-2-test")
    @Title("Verify Creation of Learning Objectives In Online Course")

    @Test
    public void addLessonLearningObjectives() {

        logger.info("<---------------------------------------------------->");
        logger.info("<-- Starting WLCMS Add Learning Objectives in Lesson for Online Course -->");
        logger.info("<---------------------------------------------------->");

        wlcmsLoginSteps.LogIntoWlcms();

        wlcmsHomePageSteps.verifyAndCloseTutorialBox();
        wlcmsHomePageSteps.navigatingToOnlineCourseCreation();

        courseCreationSteps.createOnlineCourse();
        courseCreationSteps.addLessonIntoOnlineCourseWithLearningObjectives();


        logger.info("<----------------------------------------------------->");
        logger.info("<---- WLCMS Add Learning Objectives Test is Completed ---->");
        logger.info("<----------------------------------------------------->");
    }

    @WithTag(type = "release", name = "regression-2-test")
    @Title("Verify Creation of New Slide with MP4 Template Under New Lesson")
    @Test
    public void addSlideMP4Template() {

        logger.info("<---------------------------------------------------->");
        logger.info("<-- Starting WLCMS Add New Slide with MP4 Template Test -->");
        logger.info("<---------------------------------------------------->");
        wlcmsLoginSteps.LogIntoWlcms();

        wlcmsHomePageSteps.verifyAndCloseTutorialBox();
        wlcmsHomePageSteps.navigatingToOnlineCourseCreation();

        courseCreationSteps.createOnlineCourse();
        courseCreationSteps.addLessonIntoOnlineCourse();
        courseCreationSteps.addSlideIntoOnlineCourseMP4Template();

        logger.info("<----------------------------------------------------->");
        logger.info("<---- WLCMS Add New Slide of MP4 Template Test is Completed ---->");
        logger.info("<----------------------------------------------------->");
    }

    @WithTag(type = "release", name = "regression-2-test")
    @Title("Verify Creation of Number of Question In Final Exam For Online Course")
    @Test
    public void addNumberOfQuestionInFinalExam() {

        logger.info("<---------------------------------------------------->");
        logger.info("<-- Starting WLCMS Add Number of Question In Final Exam for Online Course -->");
        logger.info("<---------------------------------------------------->");

        wlcmsLoginSteps.LogIntoWlcms();

        wlcmsHomePageSteps.verifyAndCloseTutorialBox();
        wlcmsHomePageSteps.navigatingToOnlineCourseCreation();

        courseCreationSteps.createOnlineCourse();
        courseCreationSteps.addFinalExamInLesson();
        courseCreationSteps.addQuestionInExam();
        courseCreationSteps.addNumberQuestionsInFinalExam();


        logger.info("<----------------------------------------------------->");
        logger.info("<---- WLCMS Add Number of Question In Final Exam Test is Completed ---->");
        logger.info("<----------------------------------------------------->");
    }

    @WithTag(type = "release", name = "regression-3-test")
    @Title("Verify Creation of New Slide with MC-Scenario Template Under New Lesson")
    @Test
    public void addSlideMCScenarioTemplate() {

        logger.info("<---------------------------------------------------->");
        logger.info("<-- Starting WLCMS Add New Slide with MC-Scenario Template Test -->");
        logger.info("<---------------------------------------------------->");
        wlcmsLoginSteps.LogIntoWlcms();

        wlcmsHomePageSteps.verifyAndCloseTutorialBox();
        wlcmsHomePageSteps.navigatingToOnlineCourseCreation();

        courseCreationSteps.createOnlineCourse();
        courseCreationSteps.addLessonIntoOnlineCourse();
        courseCreationSteps.addSlideIntoOnlineCourseMCScenarioTemplate();

        logger.info("<----------------------------------------------------->");
        logger.info("<---- WLCMS Add New Slide of MC-Scenario Template Test is Completed ---->");
        logger.info("<----------------------------------------------------->");
    }

    @WithTag(type = "release", name = "regression-3-test")
    @Title("Verify Addition of Text In Slide Component In MC-Scenario Template Under New Lesson")
    @Test
    public void addTextInSlideComponentForMCScenarioTemplate() {

        logger.info("<---------------------------------------------------->");
        logger.info("<-- Starting WLCMS Text in Slide with MC-Scenario Template Test -->");
        logger.info("<---------------------------------------------------->");
        wlcmsLoginSteps.LogIntoWlcms();

        wlcmsHomePageSteps.verifyAndCloseTutorialBox();
        wlcmsHomePageSteps.navigatingToOnlineCourseCreation();

        courseCreationSteps.createOnlineCourse();
        courseCreationSteps.addLessonIntoOnlineCourse();
        courseCreationSteps.addSlideIntoOnlineCourseMCScenarioTemplate();
        courseCreationSteps.addTextInSlideComponents();

        logger.info("<----------------------------------------------------->");
        logger.info("<---- WLCMS Text in Slide of MC-Scenario Template Test is Completed ---->");
        logger.info("<----------------------------------------------------->");
    }

    @WithTag(type = "release", name = "regression-3-test")
    @Title("Verify Addition of Audio In Slide Component In MC-Scenario Template Under New Lesson")
    @Test
    public void addAudioInSlideComponentForMCScenarioTemplate() {

        logger.info("<---------------------------------------------------->");
        logger.info("<-- Starting WLCMS Audio in Slide with MC-Scenario Template Test -->");
        logger.info("<---------------------------------------------------->");
        wlcmsLoginSteps.LogIntoWlcms();

        wlcmsHomePageSteps.verifyAndCloseTutorialBox();
        wlcmsHomePageSteps.navigatingToOnlineCourseCreation();

        courseCreationSteps.createOnlineCourse();
        courseCreationSteps.addLessonIntoOnlineCourse();
        courseCreationSteps.addSlideIntoOnlineCourseMCScenarioTemplate();

        courseCreationSteps.addAudioInSlideComponent();
        uploadAssetsSteps.uploadAudioInSlide();

        logger.info("<----------------------------------------------------->");
        logger.info("<---- WLCMS Audio in Slide of MC-Scenario Template Test is Completed ---->");
        logger.info("<----------------------------------------------------->");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

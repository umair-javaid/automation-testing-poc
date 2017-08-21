package com.softech.wlcms.steps.course_creation_steps;

import com.github.javafaker.Faker;
import com.softech.wlcms.actions.CommonButtonsActions;
import com.softech.wlcms.actions.DatePickerActions;
import com.softech.wlcms.pages.common.WlcmsHomePage;
import com.softech.wlcms.pages.courses.CourseOverviewPage;
import com.softech.wlcms.pages.courses.classroom.*;
import com.softech.wlcms.pages.courses.online.OnlineLeftNavigationPage;
import com.softech.wlcms.pages.courses.online.content.*;
import com.softech.wlcms.pages.courses.webinar.AddScehdulePage;
import com.softech.wlcms.pages.courses.webinar.InstructorPage;
import com.softech.wlcms.pages.courses.webinar.WebinarLeftNavigationPage;
import com.softech.wlcms.pages.courses.webinar.WebinarSetupPage;
import com.softech.wlcms.steps.upload_assets_steps.UploadAssetsSteps;
import com.thedeanda.lorem.LoremIpsum;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by umair.javaid on 2/25/2016.
 */
public class CourseCreationSteps extends ScenarioSteps {
    private static final Logger logger = LoggerFactory.getLogger(CourseCreationSteps.class);

    CourseOverviewPage courseOverviewPage;
    LessonPage lessonPage;
    SlidePage slidePage;
    OnlineLeftNavigationPage onlineLeftNavigationPage;
    AddClassPage addClassPage;
    ClassroomLeftNavigationPage classroomLeftNavigationPage;
    AddSessionPage addSessionPage;
    ProviderPage providerPage;
    LocationPage locationPage;
    QuizPage quizPage;
    QuestionsPage questionsPage;
    ExamPage examPage;
    WebinarLeftNavigationPage webinarLeftNavigationPage;
    AddScehdulePage addScehdulePage;
    InstructorPage instructorPage;
    WebinarSetupPage webinarSetupPage;
    UploadAssetsSteps uploadAssetsSteps;
    DatePickerActions datePickerActions;
    CommonButtonsActions commonButtonsActions;

    @Step
    public void createOnlineCourse() {
        Faker faker = new Faker();
        String title = WlcmsHomePage.CourseTypeEnum.ONLINE.getElement() + faker.name().suffix();
        courseOverviewPage.createOnlineCourses(title);
        assertTrue(courseOverviewPage.courseIsDisplayed());
        assertEquals(courseOverviewPage.getCourseName(), title);
        onlineLeftNavigationPage.clickContent();

    }

    @Step
    public void createClassroomCourse() {
        String title = WlcmsHomePage.CourseTypeEnum.ClASSROOM.getElement() + LoremIpsum.getInstance().getTitle(1, 2);
        courseOverviewPage.createCourses(title);
        assertTrue(courseOverviewPage.courseIsDisplayed());
        boolean titleDisplayed = StringUtils.contains(courseOverviewPage.getBreadcrumbTitle(), title);
        assertTrue(titleDisplayed);
    }

    @Step
    public void createWebinarCourse() {
        String title = WlcmsHomePage.CourseTypeEnum.WEBINAR.getElement() + LoremIpsum.getInstance().getTitle(1, 2);
        courseOverviewPage.createCourses(title);
        assertTrue(courseOverviewPage.courseIsDisplayed());
        boolean titleDisplayed = StringUtils.contains(courseOverviewPage.getBreadcrumbTitle(), title);
        assertTrue(titleDisplayed);
    }

    @Step
    public void navigateToWebinar() {
        webinarLeftNavigationPage.clickWebinar();
    }

    @Step
    public void addSchduleInWebinar() {
        addScehdulePage.selectTimezone();
        addScehdulePage.setEnrollmentCloseDate();
        addScehdulePage.setCourseStartDate();
        addScehdulePage.setCourseStartTime();
        addScehdulePage.setCourseEndTime();
        addScehdulePage.saveSchedule();
        logger.info("Schedule has been created successfully");

    }

    @Step
    public void addLessonIntoOnlineCourse() {
        String title = "Lesson -" + LoremIpsum.getInstance().getTitle(1, 3);
        lessonPage.createLesson(title);
        lessonPage.submitCreatedLesson();
        assertTrue(lessonPage.lessonCreated());
        assertEquals(lessonPage.lessonTitleDisplayed(), title);
    }

    @Step
    public void addLessonIntoOnlineCourseWithLearningObjectives() {
        String title = "Lesson -" + LoremIpsum.getInstance().getTitle(1, 3);
        String learningObjective = "Learning Objective -" + LoremIpsum.getInstance().getTitle(1, 3);
        lessonPage.createLesson(title);
        lessonPage.addLearningObjectivesInLesson(learningObjective);
        lessonPage.submitCreatedLesson();
        assertTrue(lessonPage.lessonCreated());
        assertEquals(lessonPage.lessonTitleDisplayed(), title);
    }

    @Step
    public void addSlideIntoOnlineCourse() {
        String title = "Slide -" + LoremIpsum.getInstance().getTitle(1, 3);
        slidePage.createSlide(SlideTemplateType.PRESENTATION, PresentationTemplateEnum.VISUAL_RIGHT, title);
        assertTrue(slidePage.slideIsDisplayed());

    }

    @Step
    public void previewOnlineCourse() {
        courseOverviewPage.clickPreviewCourseButton();
        assertTrue(courseOverviewPage.playerIsDisplayed());

    }

    @Step
    public void addClassInClassroom() {
        String title = addClassroom();
        assertEquals(addClassPage.getClassTitle(), title);
    }

    private String addClassroom() {
        String title = "Classroom -" + LoremIpsum.getInstance().getTitle(1, 3);
        classroomLeftNavigationPage.navigateToClassroom();
        addClassPage.addClass(title);
        return title;
    }


    @Step
    public void addSecondClassInClassroom() {
        String title = addClassroom();
        assertEquals(addClassPage.getSecondClassTitle(), title);
    }

    @Step
    public void addManualSessionInClassroom() {
        logger.info("Add Manual Class Session");
        addSessionPage.navigateToAddSession();
        datePickerActions.setSessionStartDate();
        datePickerActions.setSessionEndDate();
        addSessionPage.setSessionStartTime();
        addSessionPage.setSessionEndTime();
        addSessionPage.addManualClassSession();
    }

    @Step
    public void addDailySessionInClassroom() {
        logger.info("Add Daily Class Session");
        addSessionPage.navigateToAddSession();
        addSessionPage.setDailySession();
        addSessionPage.setDailySessionNumber();
        datePickerActions.setSessionStartDate();
        datePickerActions.setSessionEndDate();
        addSessionPage.setSessionStartTime();
        addSessionPage.setSessionEndTime();
        addSessionPage.addManualClassSession();
    }

    @Step
    public void addWeeklySessionInClassroom() {
        logger.info("Add Weekly Class Session");
        addSessionPage.navigateToAddSession();
        addSessionPage.setWeeklySession();
        addSessionPage.setWeekDays();

        datePickerActions.setSessionStartDate();
        datePickerActions.setSessionEndDate();

        addSessionPage.setSessionStartTime();
        addSessionPage.setSessionEndTime();
        addSessionPage.addManualClassSession();
    }

    @Step
    public void addNewProvider() {
        classroomLeftNavigationPage.navigateToProvider();
        providerPage.addProvider();
    }

    @Step
    public void addNewLocation() {
        Faker faker = new Faker();
        String locationName = "Location_" + LoremIpsum.getInstance().getTitle(1, 3);
        String locationAddress = faker.address().streetAddressNumber();
        String locationCity = faker.address().city();
        String phoneNumberdata = faker.numerify("#####");
        String descreption = faker.bothify("######");

        classroomLeftNavigationPage.navigateToLocation();
        locationPage.addLocation();
        logger.info("Adding information in Location Form");
        locationPage.setLocationName(locationName);
        locationPage.setLocationAddress(locationAddress);
        locationPage.setLocationCity(locationCity);
        locationPage.setLocationZip(phoneNumberdata);
        locationPage.setLocationCountry();
        locationPage.setLocationState();
        locationPage.setLocationPhone(phoneNumberdata);
        locationPage.setLocationDescreption(descreption);
        locationPage.clickSubmitLocation();
        assert (locationPage.locationIsAdded());
    }

    @Step
    public void addNewQuizInLesson() {
        quizPage.addQuiz();
        quizPage.clickSaveQuiz();
    }

    @Step
    public void addQuestionInQuiz() {
        quizPage.expendAdditionalQuestion();
        questionsPage.addQuizQuestion();
        questionsPage.selectComplexity();
        questionsPage.fillQuestionBox();
        questionsPage.addFirstAnswerChoice();
        questionsPage.addSecondAnswerChoice();
        questionsPage.saveQuestionAndAnswer();
        assertEquals(questionsPage.isQuizQuestionAdded(), "Question1");
    }

    @Step
    public void addFinalExamInLesson() {
        examPage.clickAddFinalExam();
        examPage.clickSaveExam();
    }


    @Step
    public void addQuestionInExam() {

        examPage.expendAdditionalQuestion();
        questionsPage.addExamQuestion();
        questionsPage.selectExamComplexity();
        questionsPage.fillExamQuestionBox();
        questionsPage.addFirstAnswerChoiceInExam();
        questionsPage.addSecondAnswerChoiceInExam();
        questionsPage.saveQuestionAndAnswerExam();
        assertEquals(questionsPage.isExamQuestionAdded(), "Question1");
    }

    @Step
    public void navigateToInstructor() {
        webinarLeftNavigationPage.clickInstructor();
    }

    @Step
    public void addInstructorInformation() {

        instructorPage.addInstructorFirstName();
        instructorPage.addInstructorLastName();
        instructorPage.addInstructorEmail();
        instructorPage.addInstructorPhoneNumber();
        instructorPage.saveInstructorInformation();
    }

    @Step
    public void navigateToWebinarSetupPage() {
        webinarLeftNavigationPage.clickWebinarSetup();
    }

    @Step
    public void addWebinarSetupAs360TrainingProvider() {
        webinarSetupPage.select360TrainingAsWebinarServiceProvider();
        webinarSetupPage.saveWebinarSetup();
        webinarSetupPage.confirmationModel();
    }

    @Step
    public void navigateToUploadAssetsInSlide() {
        slidePage.openImageSlider();
        slidePage.navigateToUploadImage();

    }

    @Step
    public void addSupportMaterial() {
        String assetName = "Support Material Asset_" + LoremIpsum.getInstance().getTitle(1, 3);
        lessonPage.navigateToAddSupportMaterial();
        lessonPage.createNewSupportMaterial();
        lessonPage.fillSupportMaterialAssetForm(assetName);
    }

    @Step
    public void navigateToUploadVideo() {
        String slideTitleName = "Video Name_ " + LoremIpsum.getInstance().getName();
        lessonPage.navigateToUploadVideo();
        lessonPage.fillSlideTitleName(slideTitleName);
    }

    @Step
    public void navigateToUploadPpt() {
        lessonPage.clickUploadPpt();
    }

    @Step
    public void addSlideIntoOnlineCourseMP4Template() {
        String title = "Slide -" + LoremIpsum.getInstance().getTitle(1, 3);
        slidePage.createSlide(SlideTemplateType.PRESENTATION, PresentationTemplateEnum.VISUAL_STREAMING, title);
        assertTrue(slidePage.slideIsDisplayed());

    }

    @Step
    public void navigateToUploadVideoInSlide() {
        slidePage.expendVideoSlider();
        slidePage.clickAddVideoInSlide();
    }

    @Step
    public void addServiceProviderAsOtherProvider() {
        Faker faker = new Faker();
        String url = "https://" + faker.internet().url();
        String accessCode = faker.code().isbn10();
        String phoneNumberdata = faker.numerify("########");
        String additionalInformation = faker.lorem().sentence();

        webinarSetupPage.selectOtherAsWebinarServiceProvider();
        webinarSetupPage.setMeetingURL(url);
        webinarSetupPage.setdialInNumber(phoneNumberdata);
        webinarSetupPage.setaccessCode(accessCode);
        webinarSetupPage.setadditionalInformation(additionalInformation);
        webinarSetupPage.saveWebinarSetup();
        assertEquals(additionalInformation, webinarSetupPage.getadditionalInformation());

    }

    @Step
    public void addNumberQuestionsInFinalExam() {
        String numberOfQuestion = "1";
        questionsPage.addNumberQuestionsInFinalExam(numberOfQuestion);
        commonButtonsActions.saveChanges();
        assertEquals(questionsPage.getTextQuestionBankBar(), numberOfQuestion);
    }

    @Step
    public void addSlideIntoOnlineCourseMCScenarioTemplate() {
        String title = "Slide -" + LoremIpsum.getInstance().getTitle(1, 3);
        slidePage.createSlide(SlideTemplateType.ACTIVITY, ActivityTemplateEnum.MC_SCENARIO, title);
        assertTrue(slidePage.slideIsDisplayed());

    }

    @Step
    public void addTextInSlideComponents() {
        Faker faker = new Faker();
        String text = faker.lorem().fixedString(10);
        slidePage.expendMcSlideTextComponent();
        slidePage.addTextInTextSlideComponent(text);
        commonButtonsActions.saveChanges();
        assertTrue(slidePage.slideComponentTextIsDisplayed());
    }

    @Step
    public void addAudioInSlideComponent() {
        slidePage.expendMcSlideAudioComponent();
        slidePage.navigateToUploadAudio();
    }
}

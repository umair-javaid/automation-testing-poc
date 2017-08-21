package com.softech.wlcms.features.search_verification;

import com.softech.wlcms.pages.search.SearchPage;
import com.softech.wlcms.steps.common.WlcmsHomePageSteps;
import com.softech.wlcms.steps.common.WlcmsLoginSteps;
import com.softech.wlcms.steps.course_creation_steps.CourseCreationSteps;
import com.softech.wlcms.steps.search.SearchCoursesSteps;
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

/**
 * Created by umair.javaid on 3/3/2016.
 */
@RunWith(SerenityRunner.class)
public class SaveExistingCourseTest {
    private static final Logger logger = LoggerFactory.getLogger(SaveExistingCourseTest.class);

    @Managed
    WebDriver driver;

    @Steps
    WlcmsLoginSteps wlcmsLoginSteps;

    @Steps
    WlcmsHomePageSteps wlcmsHomePageSteps;

    @Steps
    CourseCreationSteps courseCreationSteps;

    @Steps
    SearchCoursesSteps searchCoursesSteps;

    @WithTag(type = "release", name = "smoke-test")
    @Test
    public void saveOnlineCourseByRecentCourses() {
        logger.info("<---------------------------------------------------->");
        logger.info("<-----    Starting WLCMS Save Exisiting Online course Test  ----->");
        logger.info("<---------------------------------------------------->");
        wlcmsLoginSteps.LogIntoWlcms();

        wlcmsHomePageSteps.verifyAndCloseTutorialBox();
        wlcmsHomePageSteps.navigateToFindRecentCourses();

        searchCoursesSteps.searchAndOpenCourse(SearchPage.CourseTypeEnum.ONLINE);
        searchCoursesSteps.performSaveExistingCourse();

        logger.info("<---------------------------------------------------->");
        logger.info("<-----   WLCMS Save Exisiting Online Course Test is completed ----->");
        logger.info("<---------------------------------------------------->");
    }
    @WithTag(type = "release", name = "smoke-test")
    @Test
    public void saveClassroomCourseByRecentCourses() {
        logger.info("<---------------------------------------------------->");
        logger.info("<-----    Starting WLCMS Save Exisiting Classroom course Test  ----->");
        logger.info("<---------------------------------------------------->");
        wlcmsLoginSteps.LogIntoWlcms();

        wlcmsHomePageSteps.verifyAndCloseTutorialBox();
        wlcmsHomePageSteps.navigateToFindRecentCourses();

        searchCoursesSteps.searchAndOpenCourse(SearchPage.CourseTypeEnum.ClASSROOM);
        searchCoursesSteps.performSaveExistingCourse();
        logger.info("<---------------------------------------------------->");
        logger.info("<-----   WLCMS Save Exisiting Classroom Course Test is completed ----->");
        logger.info("<---------------------------------------------------->");
    }
    @WithTag(type = "release", name = "smoke-test")
    @Test
    public void saveWebinarCourseByRecentCourses() {
        logger.info("<---------------------------------------------------->");
        logger.info("<-----    Starting WLCMS Save Exisiting Webinar course Test  ----->");
        logger.info("<---------------------------------------------------->");
        wlcmsLoginSteps.LogIntoWlcms();

        wlcmsHomePageSteps.verifyAndCloseTutorialBox();
        wlcmsHomePageSteps.navigateToFindRecentCourses();

        searchCoursesSteps.searchAndOpenCourse(SearchPage.CourseTypeEnum.WEBINAR);
        searchCoursesSteps.performSaveExistingCourse();
        logger.info("<---------------------------------------------------->");
        logger.info("<-----   WLCMS Save Exisiting Webinar Course Test is completed ----->");
        logger.info("<---------------------------------------------------->");
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}

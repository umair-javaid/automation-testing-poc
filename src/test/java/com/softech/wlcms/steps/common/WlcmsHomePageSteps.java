package com.softech.wlcms.steps.common;

import com.softech.wlcms.pages.common.WlcmsHomePage;
import com.softech.wlcms.pages.courses.CourseOverviewPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertTrue;

/**
 * Created by umair.javaid on 2/24/2016.
 */
public class WlcmsHomePageSteps extends ScenarioSteps {
    private static final Logger logger = LoggerFactory.getLogger(WlcmsHomePageSteps.class);

    WlcmsHomePage wlcmsHomePage;

    CourseOverviewPage courseOverviewPage;

    @Step
    public void verifyAndCloseTutorialBox() {
        wlcmsHomePage.verifyAndCloseTutorialBox();
    }

    @Step
    public void logOut() {
        wlcmsHomePage.openAuthorPanel();
        wlcmsHomePage.logOut();
    }

    @Step
    public void navigatingToOnlineCourseCreation() {
        wlcmsHomePage.createCourse(WlcmsHomePage.CourseTypeEnum.ONLINE);
        assertTrue(courseOverviewPage.titleNameisDisplayed());
    }

    @Step
    public void navigatingToWebinarCourseCreation() {
        wlcmsHomePage.createCourse(WlcmsHomePage.CourseTypeEnum.WEBINAR);
        assertTrue(courseOverviewPage.titleNameisDisplayed());
    }

    @Step
    public void navigatingToClassroomCourseCreation() {
        wlcmsHomePage.createCourse(WlcmsHomePage.CourseTypeEnum.ClASSROOM);
        assertTrue(courseOverviewPage.titleNameisDisplayed());
    }

    @Step
    public void navigateToFindRecentCourses() {
        wlcmsHomePage.clickFindRecentCourses();
    }

    @Step
    public void navigateToUserProfile() {
        wlcmsHomePage.openAuthorPanel();
        wlcmsHomePage.navigateToUserProfile();
    }

    @Step
    public void navigateToRoyaltySettings() {
        wlcmsHomePage.openToolsPanel();
        wlcmsHomePage.clickOnRoylatySettings();
    }

    @Step
    public void navigateToAuthorPermission() {
        wlcmsHomePage.openToolsPanel();
        wlcmsHomePage.clickauthorPermission();
    }

 }

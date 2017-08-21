package com.softech.wlcms.pages.common;

import com.softech.wlcms.actions.WaitActions;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by umair.javaid on 2/24/2016.
 */
public class WlcmsHomePage extends WaitActions {
    private static final Logger logger = LoggerFactory.getLogger(WlcmsHomePage.class);

    public enum CourseTypeEnum {
        ONLINE("SQA_Test_Online"),
        ClASSROOM("SQA_Test_Classroom"),
        WEBINAR("SQA_Test_Webinar");
        private String statusCode;

        private CourseTypeEnum(String statusCode) {
            this.statusCode = statusCode;
        }

        public String getElement() {
            return statusCode;
        }
    }

    @FindBy(id = "orientationModal")
    private WebElementFacade tutorialModal;

    @FindBy(css = "#contentHolder i.icon.threesixty-online-course")
    private static WebElementFacade onlineCourse;

    @FindBy(css = "#contentHolder i.icon.threesixty-classroom")
    private WebElementFacade classroomCourse;

    @FindBy(css = "#contentHolder i.icon.threesixty-webinar")
    private WebElementFacade webinarCourse;

    @FindBy(css = "#contentHolder .icon.threesixty-search-courses")
    private WebElementFacade findCourse;

    @FindBy(css = "#breadcrumbsol.breadcrumb > li")
    private WebElementFacade getTitle;

    @FindBy(css = "button.close")
    private WebElementFacade tutorialModelCloseButton;

    @FindBy(css = ".btn.btn-default.dropdown-toggle")
    private WebElementFacade menuButton;

    @FindBy(id = "loader-overlay")
    private WebElementFacade loaderOverlay;

    @FindBy(css = ".top-right-nav ul[role='menu']")
    private WebElementFacade dropDownManu;

    @FindBy(id = "breadcrumbs")
    private WebElementFacade breadCrumbs;

    @FindBy(css = ".top-right-nav ul[role='menu'] li a[href='j_spring_security_logout']")
    private WebElementFacade logOutButton;

    @FindBy(css = ".top-right-nav ul[role='menu'] li a[onclick='getUserProfile()']")
    private WebElementFacade userProfilrButton;

    @FindBy(css = ".dropdown-toggle.fix-dropdown-a[ title='Store']")
    private List<WebElementFacade> headerPanleList;

    @FindBy(css = ".dropdown-menu [href='/lcms/royaltySettings']")
    private WebElementFacade royaltySettings;

    @FindBy(css = ".dropdown-menu [href='/lcms/userPermissionSettings']")
    private WebElementFacade authorPermission;

    public void verifyAndCloseTutorialBox() {
        logger.info("Waiting for Tutorial MODAL to be DISPLAYED");
        tutorialModal.waitUntilVisible();
        tutorialModelCloseButton.waitUntilClickable();
        tutorialModelCloseButton.click();
        logger.info("CLOSE BUTTON CLICKED - unloading tutorial model");
        tutorialModal.waitUntilNotVisible();

    }

    public void clickCreateOnlineCourse() {
        logger.info("Click on Create Online Course");
        onlineCourse.waitUntilVisible();
        onlineCourse.waitUntilClickable();
//        onlineCourse.sendKeys("");
        onlineCourse.click();
    }

    public void clickCreateClassroomCourse() {
        logger.info("Click on Create Class Room Course");
        classroomCourse.waitUntilClickable();
        classroomCourse.click();
    }

    public void clickCreateWebinarCourse() {
        logger.info("Click on Create Webinar Course");
        webinarCourse.waitUntilClickable();
        webinarCourse.click();
    }

    public void openAuthorPanel() {
        logger.info("Clicking Top navigation Manu");
        loaderOverlay.waitUntilNotVisible();
        menuButton.waitUntilVisible();
        menuButton.waitUntilClickable();
        menuButton.setWindowFocus();
        menuButton.click();
        dropDownManu.waitUntilVisible();
        logger.info("Waiting for Drop down manu");
    }


    public void logOut() {

        waitUntilLoaded(logOutButton);
        logOutButton.click();
        logger.info("Click on Log out");
    }

    public void clickFindRecentCourses() {
        waitUntilLoaded(findCourse);
        findCourse.waitUntilClickable();
        findCourse.click();
        logger.info("Click on Find Recent Courses");
    }

    public void createCourse(CourseTypeEnum courseType) {
        switch (courseType) {
            case ClASSROOM:
                clickCreateClassroomCourse();
                break;
            case ONLINE:
                clickCreateOnlineCourse();
                break;
            case WEBINAR:
                clickCreateWebinarCourse();
                break;
        }
    }

    public void navigateToUserProfile() {

        waitUntilLoaded(userProfilrButton);
        userProfilrButton.click();
        logger.info("Click On User Profile");
    }

    public void openToolsPanel() {
        WebElementFacade tools = headerPanleList.get(1);
        waitUntilLoaded(tools);
        tools.waitUntilClickable();
        tools.click();
        logger.info("Open Tools Panel");
    }

    public void clickOnRoylatySettings() {
        waitUntilLoaded(royaltySettings);
        royaltySettings.click();
        logger.info("Click On Royalty Settings");
    }

    public void clickauthorPermission() {
        waitUntilLoaded(authorPermission);
        authorPermission.click();
        logger.info("Click On Author Permission");

    }
}

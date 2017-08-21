package com.softech.wlcms.pages.courses;

/**
 * Created by umair.javaid on 1/29/2016.
 */



import com.softech.wlcms.actions.WaitActions;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CourseOverviewPage extends WaitActions {
    private static final Logger logger = LoggerFactory.getLogger(CourseOverviewPage.class);



    public enum CourseEnum {
        TITLE_NAME("Automation Test Course"),
        DESCRIPTION("Automation Description"),
        KEYWORD("125"),
        LESSON_TITLE_NAME("Title automation1"),
        SLIDE_TITLE("111"),
        VISIUAL_ASSET_NAME("This is Visual Asset Name Title"),
        LESSON_LEARNING_OBJECTIVE_NAME("LEARNING_OBJECTIVE_NAME"),
        LESSON_UTIL("list_"),
        QUIZ_BANK_TITLE("quizBankTitle_"),
        LESSON_QUIZ_BANK("lesson_1_quiz_1_bank_1");
        private String statusCode;

        private CourseEnum(String statusCode) {
            this.statusCode = statusCode;
        }

        public String getElement() {
            return statusCode;
        }
    }


    @FindBy(id = "name")
    private WebElementFacade title;

    @FindBy(id = "description")
    private WebElementFacade description;

    @FindBy(id = "duration")
    private WebElementFacade duration;

    @FindBy(css = "#contentHolder .bootstrap-tagsinput input[type='text']")
    private WebElementFacade keyword;

    @FindBy(id = "btnSave")
    private WebElementFacade saveButton;

    @FindBy(css = "#contentHolder .page-content [type='button']")
    private WebElementFacade cancelButton;

    @FindBy(id = "btnPreviewCourse")
    private WebElementFacade previewCourseButton;

    @FindBy(id = "player")
    private WebElementFacade player;

    @FindBy (css= "#breadcrumbs li")
    private List<WebElementFacade> courseBreadcrumbs;

    @FindBy(css = "#headingDiv h1")
    private WebElementFacade courseHeading;

    @FindBy(css = "[name='industry']")
    private WebElementFacade industry;

    @FindBy(css = "[name='businessunitName']")
    private WebElementFacade industryUpdate;

    @FindBy(id = "nav_accordion_0_cr")
    private WebElementFacade overview;

    @FindBy(id = "nav_accordion_0")
    private WebElementFacade onlineOverview;

    public boolean titleNameisDisplayed()
    {
        title.waitUntilVisible();
        return title.isDisplayed();
    }

    public void setTitle(String titleName) {
        title.clear();
        title.click();
        title.sendKeys(titleName);
    }

    public void setDescription(String description) {
        this.description.clear();
        this.description.click();
        this.description.sendKeys(description);

    }

    public void setDuration(String duration) {
        this.duration.clear();
        this.duration.click();
        this.duration.sendKeys(duration);
    }

    public void setkeyword(String keyword) {
        this.keyword.sendKeys("");
        this.keyword.click();
        this.keyword.sendKeys(keyword);
        this.keyword.sendKeys(Keys.ENTER);
    }

    public void clickSaveButton() {
        Actions builder = new Actions(getDriver());
        builder.moveToElement(saveButton).build().perform();
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", saveButton);
        this.saveButton.sendKeys("");

        saveButton.click();
        logger.info("Click Save Button");
    }

    public void clickCancelButton() {
        cancelButton.click();
    }

    public void selectCategory()
    {
        Select select = new Select(industry);
        select.selectByIndex(2);

    }

    public void createOnlineCourses(String title) {
        this.title.waitUntilClickable();
        logger.info("Creating Course");
        setTitle(title);
        logger.info("Set Title");
        setDescription(CourseEnum.DESCRIPTION.getElement());
        logger.info("Set Category Industry");
        selectCategory();
        logger.info("Set Description");
        setkeyword("RUNNING");
        logger.info("Set Keyword");
        clickSaveButton();
        logger.info("Course is Created");
        logger.info("Course Name > " + title);
    }

    public void updateCourseName(String title)
    {
        this.title.waitUntilClickable();
        logger.info("Update Course");
        setTitle(title);
        logger.info("Update Title");
        setDescription(CourseEnum.DESCRIPTION.getElement());
        clickSaveButton();
        logger.info("Course is Update");
        logger.info("Course Updated Name > " + title);
    }

    public void createCourses(String title) {
        this.title.waitUntilVisible();
        logger.info("Creating Course");
        setTitle(title);
        logger.info("Set Title");
        setDescription(CourseEnum.DESCRIPTION.getElement());
        logger.info("Set Description");
        logger.info("Set Category Industry");
        selectCategory();
        setkeyword("RUNNING");
        logger.info("Set Keyword");
        clickSaveButton();
        logger.info("Course Name is > " + title);
        logger.info("Course is Created");
    }

    public boolean courseIsDisplayed() {
        WebElementFacade breadcrumbTrail = courseBreadcrumbs.get(2);
        waitUntilLoaded(breadcrumbTrail);
        return breadcrumbTrail.isDisplayed();
    }



    public String getCourseName() {
        return courseHeading.getText();
    }

    public String getBreadcrumbTitle() {
        WebElementFacade breadcrumbTrail = courseBreadcrumbs.get(2);
        return breadcrumbTrail.getText();
    }

    public void clickPreviewCourseButton() {
        previewCourseButton.click();
        logger.info("Click on Preview Course");
    }

        public boolean playerIsDisplayed() {
        String WindowHandle = getDriver().getWindowHandle();
        Set<String> windowHandles = getDriver().getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();
        while (iterator.hasNext()) {
            String popupHandle = iterator.next().toString();
            if (!popupHandle.contains(WindowHandle)) {
                getDriver().switchTo().window(popupHandle);
                return player.isDisplayed();
            }
        }
        return false;
    }

    public void navigateToOverview() {
        waitUntilLoaded(overview);
        overview.click();
        logger.info("Click Overview");
    }

    public void navigateToOnlineOverview() {
        waitUntilLoaded(onlineOverview);
        onlineOverview.click();
        logger.info("Click Overview");
    }
}

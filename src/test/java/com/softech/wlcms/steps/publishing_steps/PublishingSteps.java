package com.softech.wlcms.steps.publishing_steps;

import com.softech.wlcms.pages.courses.CourseOverviewPage;
import com.softech.wlcms.pages.courses.online.OnlineLeftNavigationPage;
import com.softech.wlcms.pages.courses.online.content.LessonPage;
import com.softech.wlcms.pages.courses.online.content.SlidePage;
import com.softech.wlcms.pages.publish.PublishCoursePage;
import com.softech.wlcms.pages.publish.PublishingPanelPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by umair.javaid on 3/2/2016.
 */
public class PublishingSteps extends ScenarioSteps {
    private static final Logger logger = LoggerFactory.getLogger(PublishingSteps.class);

    CourseOverviewPage courseOverviewPage;
    LessonPage lessonPage;
    SlidePage slidePage;
    OnlineLeftNavigationPage onlineLeftNavigationPage;
    PublishingPanelPage publishingPanelPage;
    PublishCoursePage publishCoursePage;


    @Step
    public void navigateToOnlinePublishCourse() {
        publishingPanelPage.scrollTop();
        publishingPanelPage.openPublishingPanel();
        publishingPanelPage.clickOnlinePublishing();
    }
    @Step
    public void navigateToMarketing() {
        publishingPanelPage.scrollTop();
        publishingPanelPage.openPublishingPanel();
        publishingPanelPage.clickMarketing();
    }

    @Step
    public void performOnlineSFPublishing() {
        publishCoursePage.selectSFPublishCheckBox();
        publishCoursePage.clickOnlinePublish();
        publishCoursePage.waitPublishToComplete();
        assertTrue(publishCoursePage.isUpdate());

    }

    @Step
    public void performOnlineLmsPublishing() {
        publishCoursePage.clickOnlinePublish();
        publishCoursePage.waitPublishToComplete();
        assertTrue(publishCoursePage.isUpdate());

    }

    @Step
    public void selectMetaDataOptionForLms() {
        publishCoursePage.clickUpdateLmsOption();

    }

    @Step
    public void navigateToPublishCourse() {
        publishingPanelPage.scrollTop();
        publishingPanelPage.openPublishingPanel();
        publishingPanelPage.clickPublishing();
    }

    @Step
    public void openPublishingPanel()
    {
        publishingPanelPage.openPublishingPanel();
    }

    @Step
    public void performLmsPublishing() {
        publishCoursePage.clickPublish();
        publishCoursePage.waitPublishToComplete();
//        assertTrue(publishCoursePage.isUpdate());

    }

    @Step
    public void performSfPublishing() {
        publishCoursePage.selectSFPublishCheckBox();
        publishCoursePage.clickPublish();
        publishCoursePage.waitPublishToComplete();
//        assertTrue(publishCoursePage.isUpdate());

    }

    @Step
    public void performSfRePublishing() {
        publishCoursePage.selectSFRePublishCheckBox();
        publishCoursePage.clickPublish();
        publishCoursePage.waitPublishToComplete();
//        assertTrue(publishCoursePage.isUpdate());

    }
}

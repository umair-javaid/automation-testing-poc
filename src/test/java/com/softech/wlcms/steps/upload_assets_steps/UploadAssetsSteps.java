package com.softech.wlcms.steps.upload_assets_steps;

import com.softech.wlcms.pages.author.UserProfilePage;
import com.softech.wlcms.pages.courses.CourseOverviewPage;
import com.softech.wlcms.pages.courses.online.OnlineLeftNavigationPage;
import com.softech.wlcms.pages.courses.online.content.LessonPage;
import com.softech.wlcms.pages.courses.online.content.SlidePage;
import com.softech.wlcms.pages.publish.MarketingPage;
import com.softech.wlcms.pages.publish.PublishCoursePage;
import com.softech.wlcms.pages.publish.PublishingPanelPage;
import com.thedeanda.lorem.LoremIpsum;
import net.thucydides.core.annotations.Step;

import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertTrue;

/**
 * Created by umair.javaid on 3/28/2016.
 */
public class UploadAssetsSteps extends ScenarioSteps {
    private static final Logger logger = LoggerFactory.getLogger(UploadAssetsSteps.class);

    CourseOverviewPage courseOverviewPage;
    LessonPage lessonPage;
    SlidePage slidePage;
    OnlineLeftNavigationPage onlineLeftNavigationPage;
    PublishingPanelPage publishingPanelPage;
    PublishCoursePage publishCoursePage;
    MarketingPage marketingPage;
    UserProfilePage userProfilePage;

    @Step
    public void uploadInstructorImage() {
        assertTrue (marketingPage.isMarketingPageDisplayed());
//       marketingPage.navigateToUpload();
        marketingPage.uploadImage();
        marketingPage.fillAssetName();
        marketingPage.clickSaveButtonForImage();
    }

    @Step
    public void addAuthorInformationForClassroom() {
        marketingPage.selectInstructor();
        marketingPage.fillAuthorInfoBox();
        marketingPage.clickAuthorInforSaveButton();

    }

    @Step
    public void addAuthorInformationForWebinar() {
        marketingPage.fillAuthorInfoBox();
        marketingPage.clickAuthorInforSaveButton();

    }

    @Step
    public void uploadImageInSlide() {
        slidePage.fillVisualAssetName();
        slidePage.uploadImageInSlide();
        slidePage.clickAcceptUploadeImage();
    }

    @Step
    public void uploadPdfInLesson() {
        lessonPage.uploadPdfInLesson();
        lessonPage.supportMaterialAcceptButton();

    }

    @Step
    public void uploadVideoInLesson() {
        lessonPage.uploadVideoInLesson();
        lessonPage.saveUploadedVideo();
    }

    @Step
    public void uploadPptInLesson() {
        lessonPage.uploadPptInLesson();
        lessonPage.acceptPptUploadInLesson();
    }

    @Step
    public void uploadVideoInSlide() {
        String videoAssetName = "Video Asset _ " + LoremIpsum.getInstance().getName();
        slidePage.fillVideoAssetName(videoAssetName);
        slidePage.uploadVideoInSlide();
        slidePage.clickAcceptUploadeVideo();
        Assert.assertEquals(videoAssetName,slidePage.getVideoAssetText());
    }
@Step
    public void uploadImageInUserProfile() {
    userProfilePage.clickEditImage();
    assertTrue(userProfilePage.imageUploaderIsDisplayed());
    userProfilePage.uploadImageInAuthorProfile();
    userProfilePage.clickAcceptProfileImageUpload();

    }

    @Step
    public void uploadAudioInSlide() {
        String audioAssetName = "Audio Asset _ " + LoremIpsum.getInstance().getName();
        slidePage.fillAudioAssetName(audioAssetName );
        slidePage.fillaudioAssetKeyword(audioAssetName);
//        slidePage.uploadAudioInSlide();
        slidePage.clickAcceptAudioUploadButton();

    }
}

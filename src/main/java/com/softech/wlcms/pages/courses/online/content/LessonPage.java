package com.softech.wlcms.pages.courses.online.content;

/**
 * Created by umair.javaid on 1/29/2016.
 */


import com.softech.wlcms.actions.WaitActions;
import com.softech.wlcms.pages.courses.online.OnlineLeftNavigationPage;
import com.softech.wlcms.util.GetAssets;
import com.thedeanda.lorem.LoremIpsum;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class LessonPage extends WaitActions {
    private static final Logger logger = LoggerFactory.getLogger(LessonPage.class);

    OnlineLeftNavigationPage onlineLeftNavigationPage;
    GetAssets assets = new GetAssets();

    @FindBy(css = "#contentHolder .page-content a[data-target='#addLessonModal']")
    private WebElementFacade addLesson;

    @FindBy(id = "Name")
    private WebElementFacade titleLesson;

    @FindBy(id = "submitLesson")
    private WebElementFacade submitLesson;

    @FindBy(css = "Div#lessons_accordion_0 div")
    private WebElementFacade lessonContainer;

    @FindBy(css = ".page-content #lessons_accordion_0 [title='Lesson Components']")
    private WebElementFacade pageContentList;

    @FindBy(css = "#addLessonLLOtable .icon-plus.blue-text")
    private WebElementFacade learningObjectiveAddButton;

    @FindBy(id = "LLO_0")
    private WebElementFacade learningObjectiveTextBox;

    @FindBy(css = "#lessons_accordion_0 [data-target='#addSMModal'] i")
    private WebElementFacade addSupportMaterial;

    @FindBy(css = "#collapseTypeSM [href='#collapseAddSM']")
    private WebElementFacade createSupportMaterialIcon;

    @FindBy(css = "#frmsmUploadAsset #audioAssetName")
    private WebElementFacade materialAsset;

    @FindBy(id = "btnSubmitAudioAssetForm")
    private WebElementFacade supportMaterialAcceptButton;

    @FindBy(css = ".page-content #addVideoSlideID")
    private WebElementFacade addVideo;

    @FindBy(id = "slideTitle")
    private WebElementFacade slideTitle;

    @FindBy(css = "#addVideoSlideform #submitSlide")
    private WebElementFacade saveVideoButton;

    @FindBy(css = "#lessons_accordion_0 #importPowerPointID")
    private WebElementFacade uploadPptButton;

    @FindBy(id = "import-ppt-label")
    private WebElementFacade importPPtBox;

    @FindBy(id = "btAcceptPPTFile")
    private WebElementFacade acceptPptButton;

    public void clickAddLesson() {
        addLesson.waitUntilClickable();
        addLesson.click();
        logger.info("click Add Lesson");
    }

    public void setTitleLesson(String lessonTitleName) {
        titleLesson.waitUntilVisible();
        titleLesson.clear();
        titleLesson.click();
        titleLesson.sendKeys(lessonTitleName);
        logger.info("Set Lesson Title");
    }

    public void clickSubmitLesson() {
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", submitLesson);
        submitLesson.click();
        submitLesson.waitUntilNotVisible();
        logger.info("Click Submit Lesson");
    }

    public void waitLessonDisplay() {
//        WebElementFacade lesson = pageContentList.get(0).find(By.cssSelector("#list #label"));
//                findElement(By.cssSelector("#list #label"));
        pageContentList.waitUntilVisible();
    }

    public String lessonTitleDisplayed() {
        return pageContentList.getText();
    }


    public void expandLessonComponents() {
        logger.info("Expending Lesson Component");
//        onlineLeftNavigationPage.init();
        onlineLeftNavigationPage.clickContent();
        waitLessonDisplay();
        pageContentList.click();
        logger.info("Lesson Component is Expended");
    }

    public void createLesson(String title) {
        logger.info("Creating Lesson ");
        onlineLeftNavigationPage.clickContent();
        clickAddLesson();
        setTitleLesson(title);
        logger.info("Lesson Name > " + title);
    }

    public void addLearningObjectivesInLesson(String learningObjective) {
        learningObjectiveAddButton.waitUntilClickable();
        learningObjectiveAddButton.click();
        learningObjectiveTextBox.waitUntilVisible();
        learningObjectiveTextBox.clear();
        learningObjectiveTextBox.sendKeys(learningObjective);

        logger.info("Learning Objective > " + learningObjective);
        logger.info("Learning Objective is Added");
    }

    public void submitCreatedLesson() {
        clickSubmitLesson();
        waitLessonDisplay();
        logger.info("Lesson is Created");
    }

    public boolean lessonCreated() {
        return lessonContainer.isDisplayed();
    }


    public void navigateToAddSupportMaterial() {

        addSupportMaterial.waitUntilClickable();
        addSupportMaterial.click();
        logger.info("Click Add Support Material");
        createSupportMaterialIcon.waitUntilVisible();

    }

    public void createNewSupportMaterial() {
        createSupportMaterialIcon.click();
        logger.info("Click Add New Support Material Icon");
    }

    public void fillSupportMaterialAssetForm(String assetName) {

        materialAsset.waitUntilClickable();
        materialAsset.clear();
        materialAsset.sendKeys(assetName);
        logger.info("Fill Asset Name");
        logger.info("Asset Name > " + assetName);
    }

    public void uploadPdfInLesson() {
        WebElement uploadPdfElement = getDriver().findElement(By.cssSelector("#supportingMaterialUploader [type='file']"));
        String pathPdf = assets.getPath(GetAssets.AssetTypeEnum.PDF);
        upload(pathPdf).to(uploadPdfElement);
        logger.info("Uploaded PDF File");
    }

    public void supportMaterialAcceptButton() {
        supportMaterialAcceptButton.waitUntilClickable();
        supportMaterialAcceptButton.click();
        logger.info("Click Support Material Accept Button");
        supportMaterialAcceptButton.waitUntilNotVisible();
    }

    public void navigateToUploadVideo() {

        addVideo.waitUntilClickable();
        addVideo.click();
        logger.info("Click on Upload Video");
    }

    public void fillSlideTitleName(String slideTitleName) {

        slideTitle.waitUntilVisible();
        slideTitle.clear();
        slideTitle.sendKeys(slideTitleName);
        logger.info("Set Video Title Name");
        logger.info("Video Title Name > " + slideTitleName);

    }

    public void uploadVideoInLesson() {
        WebElement uploadVideoElement = getDriver().findElement(By.cssSelector("#addVideoSlideform [type='file']"));
        String pathVideo = assets.getPath(GetAssets.AssetTypeEnum.VIDEO);
        upload(pathVideo).to(uploadVideoElement);
        logger.info("Video File is Uploaded");
    }

    public void saveUploadedVideo() {
        waitUntilLoaded(saveVideoButton);
        saveVideoButton.waitUntilEnabled();
        saveVideoButton.click();
        logger.info("Click on Save Uploaded Video");
        saveVideoButton.waitUntilNotVisible();
    }

    public void clickUploadPpt() {

        uploadPptButton.waitUntilClickable();
        uploadPptButton.click();
        logger.info("Click On Import Power Point");
    }

    public void uploadPptInLesson() {
        waitUntilLoaded(importPPtBox);
        WebElement uploadPptElement = getDriver().findElement(By.cssSelector("#pptUploader [type='file']"));
        String pathPpt= assets.getPath(GetAssets.AssetTypeEnum.PPT);
        upload(pathPpt).to(uploadPptElement );

    }

    public void acceptPptUploadInLesson() {
        acceptPptButton.waitUntilEnabled();
        acceptPptButton.click();
        logger.info("Click On Accept PPT ");

    }
}

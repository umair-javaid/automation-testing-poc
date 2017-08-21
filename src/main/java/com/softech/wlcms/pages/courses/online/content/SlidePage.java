package com.softech.wlcms.pages.courses.online.content;


import com.github.javafaker.Faker;
import com.softech.wlcms.actions.WaitActions;
import com.softech.wlcms.util.GetAssets;
import com.thedeanda.lorem.LoremIpsum;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.ExecuteScript;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by umair.javaid on 1/29/2016.
 */

public class SlidePage extends WaitActions {
    private static final Logger logger = LoggerFactory.getLogger(SlidePage.class);

    LessonPage lessonPage;
    Faker faker = new Faker();
    String assetName = faker.name().firstName();
    GetAssets assets = new GetAssets();


    @FindBy(id = "uploadExcelCourseImportId")
    private WebElementFacade pageloadElement;

    @FindBy(css = "#contentHolder .page-content a#addSlideID")
    private WebElement addSlide;

    @FindBy(id = "templateIDForAddForm")
    private WebElementFacade addTemplateIdForm;

    @FindBy(css = "#updateTemplateType i.temp-icon-0")
    private WebElementFacade selectTemplate;

    @FindBy(id = "btnUpdateSelectedSlideTemplate")
    private WebElementFacade saveButtonTemplateForm;

    @FindBy(id = "submitSlide")
    private WebElementFacade submitSlide;

    @FindBy(css = "#contentHolder .page-content [data-target='#addQuizModal']")
    private WebElementFacade addQuizButton;

    @FindBy(id = "add-slide-label")
    private WebElementFacade addslidelabel;

    @FindBy(css = "#updateTemplateType .modal-body")
    private List<WebElementFacade> templateForm;

    @FindBy(id = "cke_name")
    private WebElementFacade cke_name;

    @FindBy(css = "#cke_name iframe")
    private WebElementFacade titleContent;

    @FindBy(id = "selectTemplateModal")
    private WebElementFacade selectTemplateModal;

    @FindBy(css = "#lessons_accordion_0 [title='Visual Asset'] .expand")
    private WebElementFacade imageButton;

    @FindBy(css = ".page-content [data-target='#addVisualAssetModal']")
    private WebElementFacade uploadeAssetButton;

    @FindBy(id = "visualAssetName")
    private WebElementFacade visualAssetName;

    @FindBy(id = "btnSubmitVisualAssetForm")
    private WebElementFacade visualAssetAcceptFormButton;

    @FindBy(css = "#lessons_accordion_0 #videoLink")
    private WebElementFacade slideVideoIcon;

    @FindBy(css = "#lessons_accordion_0 [data-target='#addVAssetModal']")
    private WebElementFacade addVideoIcon;

    @FindBy(id = "videoAssetName")
    private WebElementFacade videoAssetName;

    @FindBy(id = "btnSubmitVideoAssetForm")
    private WebElementFacade videoAssetAcceptFormButton;

    @FindBy(css = "#lessons_accordion_0 #VideoListing td")
    private WebElementFacade videoAssetText;

    @FindBy(css = "#lessons_accordion_0 [title='Text'] .tools a.expand")
    private WebElementFacade textSlideComonent;

    @FindBy(css = "#SceneText .cke_inner iframe")
    private WebElementFacade textSlideComonentTextBox;

    @FindBy(css = "#SceneText .cke_inner iframe p")
    private WebElementFacade abc;

    @FindBy(css = "#lessons_accordion_0 [title='Audio Asset'] .tools a.expand")
    private WebElementFacade audioSlideComonent;

    @FindBy(css = "#lessons_accordion_0 [data-target='#addAssetModal'] .icon-plus.blue-text")
    private WebElementFacade addAutioAssetButton;

    @FindBy(css = "#addAssetModal #audioAssetName")
    private WebElementFacade audioAsset;

    @FindBy(css = "#addAssetModal .bootstrap-tagsinput [type='text']")
    private WebElementFacade audioAssetKeyword;

    @FindBy(css = "#addAssetModal #btnSubmitAudioAssetForm")
    private WebElementFacade uploadAcceptButton;


    public boolean isLessonExpanded() {

        logger.info("Check Lesson Components");
        lessonPage.waitLessonDisplay();
        try {
            return addSlide.isDisplayed();
        } catch (ElementNotVisibleException e) {
            return false;
        }
    }


    public void clickAddTemplate() {
        addTemplateIdForm.click();
        selectTemplateModal.waitUntilVisible();
    }

    public void setSlideTitle(String slideTitle) {
        cke_name.waitUntilVisible();
        titleContent.waitUntilVisible();
        titleContent.sendKeys("");
        titleContent.click();
        titleContent.sendKeys(slideTitle);
        logger.info("Fill Slide Title");
    }

    public WebElementFacade selectPresentationSlideTemplate(WebElementFacade templateContainer, TemplateEnum templateEnum) {
        logger.info("Select the Presentation Slide Template");
        return templateContainer.thenFindAll(By.className(templateEnum.getIconClass())).get(0);
//        return templateContainer.find(By.className(templateEnum.getIconClass())).get(0);
    }

    public WebElementFacade selectActivitySlideTemplate(WebElementFacade templateContainer, TemplateEnum templateEnum) {
        logger.info("Select the Presentation Slide Template");
        return templateContainer.find(By.id(templateEnum.getInternalID()));
    }

    public void selectTemplate(SlideTemplateType templateType, TemplateEnum templateEnum) {
        logger.info("Select Template Form");

        addTemplateIdForm.click();
        selectTemplate.waitUntilVisible();
        WebElementFacade templateContainer = templateForm.get(0);
        WebElementFacade templateSelection = null;
        switch (templateType) {
            case PRESENTATION:
                templateSelection = selectPresentationSlideTemplate(templateContainer, templateEnum);
                break;
            case ACTIVITY:
                templateSelection = selectActivitySlideTemplate(templateContainer, templateEnum);
                break;
        }
        templateSelection.click();
        saveButtonTemplateForm.click();
        saveButtonTemplateForm.waitUntilNotVisible();
    }

    public void clickSubmitSlide() {
        logger.info("Click on Submit Slide");
        submitSlide.waitUntilClickable();
        submitSlide.click();
        submitSlide.waitUntilNotVisible();
    }


    public void createSlide(SlideTemplateType templateType, TemplateEnum templateEnum, String title) {
        logger.info("Creating a new Slide");
        logger.info("-->Lesson is expanded:" + isLessonExpanded());

        if (!isLessonExpanded()) {
            lessonPage.expandLessonComponents();
        }
        clickAddSlide();

        setSlideTitle(title);
        selectTemplate(templateType, templateEnum);
        clickSubmitSlide();
        logger.info("Slide is Created");
        logger.info("Slide Name > " + title);
        customWaitUntilUnLoaded(By.cssSelector(".alert.alert-success.alert-dismissible.fade.in"));
    }

    public void clickAddSlide() {
        logger.info("Click on Add Lesson Slide");

        waitUntilLoaded(addSlide);
//        waitUnt
//        addSlide.waitUntilVisible();
//        addSlide.waitUntilClickable();
        addSlide.click();
        addslidelabel.waitUntilVisible();
        logger.info("Slide Componenet is loaded");
    }

    public boolean slideIsDisplayed() {
        addQuizButton.waitUntilVisible();
        return addQuizButton.isDisplayed();
    }


    public void openImageSlider() {

        customWaitUntilUnLoaded(By.cssSelector(".alert.alert-success.alert-dismissible.fade.in"));
        waitUntilLoaded(imageButton);
        imageButton.sendKeys("");
        imageButton.click();
        logger.info("Open Image Slider");
    }

    public void navigateToUploadImage() {
        uploadeAssetButton.waitUntilClickable();
        uploadeAssetButton.click();
        logger.info("Open Upliad Asset");

    }

    public void fillVisualAssetName() {
        waitUntilLoaded(visualAssetName);
        visualAssetName.sendKeys(assetName);
    }

    public void uploadImageInSlide() {
        WebElement uploadImageElement = getDriver().findElement(By.cssSelector("#visualUploader [type='file']"));
        String pathImage = assets.getPath(GetAssets.AssetTypeEnum.IMAGE);
        upload(pathImage).to(uploadImageElement);
        logger.info("Uploaded Image File");
    }

    public void clickAcceptUploadeImage() {

        waitUntilLoaded(visualAssetAcceptFormButton);
        visualAssetAcceptFormButton.click();

    }

    public void expendVideoSlider() {
        waitUntilLoaded(slideVideoIcon);
        slideVideoIcon.click();
        logger.info("Expend Video Slider");
    }


    public void clickAddVideoInSlide() {
        waitUntilLoaded(addVideoIcon);
        addVideoIcon.waitUntilClickable();
//        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", addVideoIcon);
        addVideoIcon.sendKeys("");
        addVideoIcon.click();
        logger.info("Click on Add Video In Slide");
    }

    public void fillVideoAssetName(String videoAssetName) {
        waitUntilLoaded(this.videoAssetName);
        this.videoAssetName.clear();
        this.videoAssetName.sendKeys(videoAssetName);
    }

    public void uploadVideoInSlide() {

        WebElement videoUploader = getDriver().findElement(By.cssSelector("#videoUploader [type='file']"));
        String path = assets.getPath(GetAssets.AssetTypeEnum.VIDEO);
        upload(path).to(videoUploader);
        logger.info("Upload Video in Slide");
    }

    public void clickAcceptUploadeVideo() {
        waitUntilLoaded(videoAssetAcceptFormButton);
        videoAssetAcceptFormButton.click();
        logger.info("Click Accept Button For Upload Asset In Slide");
        videoAssetAcceptFormButton.waitUntilNotVisible();
    }

    public String getVideoAssetText() {
        waitUntilLoaded(videoAssetText);
        logger.info("Verify If Video is Uploaded > Asset Name > " + videoAssetText.getText());
        return videoAssetText.getText();

    }

    public void expendMcSlideTextComponent() {
        waitUntilLoaded(textSlideComonent);
        textSlideComonent.sendKeys("");
        textSlideComonent.click();
        logger.info("Expend Text Slide Component Area");

    }

    public void addTextInTextSlideComponent(String text) {
        waitUntilLoaded(textSlideComonentTextBox);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", textSlideComonentTextBox);
        textSlideComonentTextBox.sendKeys("");
        textSlideComonentTextBox.click();
        textSlideComonentTextBox.sendKeys(text);
        logger.info("Enter Text In Slide Component");
    }

    public boolean slideComponentTextIsDisplayed() {
        return textSlideComonentTextBox.isDisplayed();

    }

    public void expendMcSlideAudioComponent() {
        waitUntilLoaded(audioSlideComonent);
        audioSlideComonent.waitUntilClickable();
        audioSlideComonent.sendKeys("");
        audioSlideComonent.click();
        logger.info("Expend Audio Slide Component Area");
    }

    public void navigateToUploadAudio() {

        waitUntilLoaded(addAutioAssetButton);
        addAutioAssetButton.waitUntilClickable();
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", addAutioAssetButton);
        addAutioAssetButton.sendKeys("");
        addAutioAssetButton.click();
        logger.info("Click on Add Audio Asset Button");
    }

    public void fillAudioAssetName(String audioAssetName) {
        waitUntilLoaded(audioAsset);
        audioAsset.waitUntilClickable();
        audioAsset.sendKeys("");
        audioAsset.sendKeys(audioAssetName);
        logger.info("Fill Audio Asset Name >" + audioAssetName);
    }

    public void fillaudioAssetKeyword(String audioAssetName) {
        waitUntilLoaded(audioAssetKeyword);
        audioAssetKeyword.waitUntilClickable();
        audioAssetKeyword.sendKeys("");
        audioAssetKeyword.sendKeys(audioAssetName);
        logger.info("Fill Audio Asset Keyword > " + audioAssetName);
    }

//    public void uploadAudioInSlide() {
//        WebElement browsAudio = getDriver().findElement(By.cssSelector("#audioUploader [type='file']"));
//        String mp3Path = assets.getPath(GetAssets.AssetTypeEnum.MP3);
//        upload(mp3Path).to(browsAudio);
//        logger.info("Upload MP3 in Mc Slide");
//    }

    public void clickAcceptAudioUploadButton() {
        waitUntilLoaded(uploadAcceptButton);
        uploadAcceptButton.waitUntilClickable();
        uploadAcceptButton.click();
    }
}

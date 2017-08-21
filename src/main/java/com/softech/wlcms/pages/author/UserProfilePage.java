package com.softech.wlcms.pages.author;

import com.softech.wlcms.actions.WaitActions;
import com.softech.wlcms.util.GetAssets;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by umair.javaid on 4/19/2016.
 */
public class UserProfilePage extends WaitActions {
    private static final Logger logger = LoggerFactory.getLogger(UserProfilePage.class);

    GetAssets assets = new GetAssets();

    @FindBy(id = "profileImage")
    private WebElementFacade editImage;

    @FindBy(css = "#profilePicUploader [type='file']")
    private WebElement browseImage;

    @FindBy(id = "btaddProfileImageUpload")
    private WebElementFacade imageAssetUserProfileAcceptButton;

    @FindBy(id = "upload-pp-label")
    private WebElementFacade uploadBox;

    @FindBy(css = "#userProfileForm .btn.blue")
    private WebElementFacade userProfileSaveButton;

    @FindBy(id = "firstName")
    private WebElementFacade firstname;


    public void clickEditImage() {
        waitUntilLoaded(editImage);
        editImage.click();
        logger.info("Click Edit Image");
    }

    public boolean imageUploaderIsDisplayed() {
        waitUntilLoaded(uploadBox);
        logger.info("Upload Box Is Displayed");
        return uploadBox.isDisplayed();

    }

    public void uploadImageInAuthorProfile() {

        WebElement browseImage = getDriver().findElement(By.cssSelector("#profilePicUploader [type='file']"));
        String path = assets.getPath(GetAssets.AssetTypeEnum.IMAGE);
        upload(path).to(browseImage);
        logger.info("Profile Image is Uploaded");
    }

    public void clickAcceptProfileImageUpload() {
        waitUntilLoaded(imageAssetUserProfileAcceptButton);
        imageAssetUserProfileAcceptButton.waitUntilClickable();
        imageAssetUserProfileAcceptButton.click();
        imageAssetUserProfileAcceptButton.waitUntilNotVisible();
        logger.info("Click Accept on Upload Image On User Profile");
    }


    public void clickUserProfileSave() {
        waitUntilLoaded(userProfileSaveButton);
        userProfileSaveButton.click();
        logger.info("Click On User Profile Save Button");
    }

    public String getFirstName() {
        waitUntilLoaded(firstname);
        firstname.waitUntilVisible();
        logger.info(firstname.getValue());
        return firstname.getValue();
    }
}

package com.softech.wlcms.pages.publish;


import com.softech.wlcms.actions.WaitActions;
import com.softech.wlcms.util.GetAssets;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by umair.javaid on 2/10/2016.
 */
public class MarketingPage extends WaitActions {
    private static final Logger logger = LoggerFactory.getLogger(MarketingPage.class);

    GetAssets assets = new GetAssets();


    @FindBy(id = "frm_marketing")
    private WebElement pagelocater;

    @FindBy(id = "root_icc_browse_0")
    private WebElement browserButton;

    @FindBy(id = "icc_browse_0")
    private WebElement upload;

    @FindBy(id = "AuthorImageName")
    private WebElement assetName;

    @FindBy(css = "#addAssetModal .btn.blue")
    private WebElementFacade saveButton;

    @FindBy(css = "#cke_1_contents iframe")
    private WebElementFacade authorInfoBox;

    @FindBy(css = "#frm_marketing .btn.blue.input-small")
    private WebElementFacade authorInfoSaveButton;

    @FindBy(id = "classInstructor")
    private WebElementFacade classInstructor;

    public boolean isMarketingPageDisplayed() {
        try {
            waitUntilLoaded(pagelocater);
            return pagelocater.isDisplayed();
        } catch (ElementNotVisibleException e) {
            return false;
        }
    }

    public void navigateToUpload() {
        waitUntilLoaded(browserButton);
        browserButton.click();
        logger.info("Click Browse Button");
    }

    public void uploadImage() {
        WebElement imageInputElement = getDriver().findElement(By.xpath("(.//*[@class='moxie-shim moxie-shim-html5'])"));
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("arguments[0].setAttribute('style','height: 1px;')", imageInputElement);
        WebElement uploadImageElement = getDriver().findElement(By.cssSelector("#icc_container_0 [type='file']"));
        String pathImage = assets.getPath(GetAssets.AssetTypeEnum.IMAGE);
        upload(pathImage).to(uploadImageElement);
        logger.info("Uploaded File");

    }


    public void fillAssetName() {
        waitUntilLoaded(assetName);
        assetName.clear();
        assetName.sendKeys("rendom");
        logger.info("Fill Asset Name");
    }

    public void clickSaveButtonForImage() {
        saveButton.waitUntilClickable();
        saveButton.click();
        saveButton.waitUntilNotVisible();

        logger.info("Click Upload");
    }

    public void fillAuthorInfoBox()
    {
        authorInfoBox.waitUntilClickable();
        authorInfoBox.sendKeys("");
        authorInfoBox.click();
        authorInfoBox.sendKeys("Author Info");
        logger.info("Fill Author Information Box");
    }

    public void clickAuthorInforSaveButton()
    {
        authorInfoSaveButton.waitUntilClickable();
        authorInfoSaveButton.click();
        logger.info("Click Author Save Button");
        authorInfoBox.waitUntilClickable();
        authorInfoBox.sendKeys("");
        authorInfoBox.click();
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("scrollTo(0,0);");

    }

    public void selectInstructor() {
        waitUntilLoaded(classInstructor);
        Select select = new Select(classInstructor);
        select.selectByIndex(1);
        logger.info("Select First Instructor");
    }
}

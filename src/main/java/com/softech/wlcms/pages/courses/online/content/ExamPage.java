package com.softech.wlcms.pages.courses.online.content;

/**
 * Created by umair.javaid on 2/1/2016.
 */

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.interactions.Actions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExamPage extends PageObject{
    private static final Logger logger = LoggerFactory.getLogger(ExamPage.class);

    private static final By DISPLAY_SELECTOR = By.id("Name");
    
    @FindBy(css = "#AddFinalExamLink a[data-target='#addExamModal']")
    private WebElementFacade addFinalExamButton;

    @FindBy(id = "AddFinalExamLink")
    private WebElementFacade addExam;

    @FindBy(id = "btnExamAdd")
    private WebElementFacade submitExam;

    @FindBy(css = ".page-content")
    private WebElementFacade pageContent;

    @FindBy(id = "addExamModal")
    private WebElementFacade addExamModal;

    @FindBy(id = "questionBanksTitle_0")
    private WebElementFacade additionalExamQuestion;



    public void clickAddFinalExam() {
        logger.info("Click on Add Final Exam");
       pageContent.waitUntilVisible();
        Actions builder = new Actions(getDriver());
        builder.moveToElement(addFinalExamButton).build().perform();
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", addFinalExamButton);
        addFinalExamButton.sendKeys("");
        addFinalExamButton.click();
        addExamModal.waitUntilVisible();
    }

    public void clickSaveExam() {
        logger.info("Click on Submit Exam");
        submitExam.waitUntilClickable();
        submitExam.click();
        addExamModal.waitUntilNotVisible();
    }

    public void expendAdditionalQuestion()
    {
        additionalExamQuestion.waitUntilClickable();
        additionalExamQuestion.click();
        logger.info("Expend Additional Questino Panel");
    }


    
}

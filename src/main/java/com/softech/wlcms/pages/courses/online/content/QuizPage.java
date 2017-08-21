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


public class QuizPage extends PageObject {
    private static final Logger logger = LoggerFactory.getLogger(QuizPage.class);


    @FindBy(css = "#contentHolder .page-content a[data-target='#addLessonModal']")
    private WebElementFacade addLesson;

    @FindBy(css = ".page-content a[title='Add Quiz']")
    private WebElementFacade addQuiz;

    @FindBy(id = "btaddQuizModal")
    private WebElementFacade submitQuiz;

    @FindBy(id = "addQuizModal")
    private WebElementFacade addQuizModal;

    @FindBy(css = "a[data-bank-id] .icon-question-bank")
    private WebElementFacade additionalQuestion;


    public void addQuiz() {
        logger.info("Click on Add Quiz Button");
//        pageContent.waitUntilVisible();
//        WebElementFacade addQuiz = pageContent.find(By.cssSelector("a[title='Add Quiz']"));
        Actions builder = new Actions(getDriver());
        builder.moveToElement(addQuiz).build().perform();
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", addQuiz);
        addQuiz.sendKeys("");
        addQuiz.click();
        addQuizModal.waitUntilVisible();
    }

    public void clickSaveQuiz() {
        logger.info("Click on Submit Quiz");
        submitQuiz.sendKeys("");
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", submitQuiz);
        submitQuiz.click();
    }

    public void expendAdditionalQuestion()
    {
        additionalQuestion.waitUntilClickable();
        additionalQuestion.click();
        logger.info("Expend Additional Question Panel");
    }

}

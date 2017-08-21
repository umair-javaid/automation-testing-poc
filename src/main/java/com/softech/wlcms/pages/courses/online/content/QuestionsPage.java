package com.softech.wlcms.pages.courses.online.content;

import com.softech.wlcms.actions.WaitActions;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by umair.javaid on 3/16/2016.
 */
public class QuestionsPage extends WaitActions {
    private static final Logger logger = LoggerFactory.getLogger(QuestionsPage.class);

    @FindBy(css = "a[data-bank-id] .icon-plus")
    private WebElementFacade addQuizQuestion;

    @FindBy(id = "complexity")
    private WebElementFacade complexity;

    @FindBy(css = "#cke_questionTitle iframe")
    private WebElementFacade questionBox;

    @FindBy(css = "#tbQuestionAnswer2 [data-target='#addAnsChoiceModal']")
    private WebElementFacade addAnswerButton;

    @FindBy(css = "#tbQuestionAnswer2 [data-target='#addExamAnsChoiceModal']")
    private WebElementFacade addExamAnswerButton;

    @FindBy(css = "#cke_ans-ckeditor-1 iframe")
    private WebElementFacade answerChoiceBox;

    @FindBy(css = "#cke_new_ans_choice_ckeditor_Exam iframe")
    private WebElementFacade examAnswerChoiceBox;

    @FindBy(id = "isCorrect")
    private WebElementFacade isCorrectTick;

    @FindBy(id = "isCorrectExam")
    private WebElementFacade isCorrectTickExam;

    @FindBy(id = "btAcceptAnswer")
    private WebElementFacade acceptAnswer;

    @FindBy(id = "btAcceptExamAnswer")
    private WebElementFacade acceptAnswerExam;

    @FindBy(css = "a[data-bank-id] span")
    private WebElementFacade questionNameText;

    @FindBy(css = ".portlet [data-parent='#exam_0_bank_0_questions'] span")
    private WebElementFacade examQuestionNameText;

    @FindBy(id = "btaddQuestionSave")
    private WebElementFacade saveButton;

    @FindBy(id = "btaddExamQuestionSave")
    private WebElementFacade saveButtonExam;

    @FindBy(css = "#exam_accordion_0 [data-target='#addExamQuestionModal']")
    private WebElementFacade addExamQuestion;

    @FindBy(id = "examComplexity")
    private WebElementFacade examComplexity;

    @FindBy(css = "#cke_questionExamTitle iframe")
    private WebElementFacade examQuestionBox;

    @FindBy(css = "#questionBankBar_0 [name='Final_No_Questions'] ")
    private WebElementFacade questionBankBar;



    public void addQuizQuestion() {
        Actions builder = new Actions(getDriver());
        builder.moveToElement(addQuizQuestion).build().perform();
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", addQuizQuestion);
        addQuizQuestion.sendKeys("");
        addQuizQuestion.click();
        logger.info("Add Question In Quiz");
    }

    public void selectComplexity() {
        waitUntilLoaded(complexity);
        Select select = new Select(complexity);
        select.selectByIndex(1);
        logger.info("Select Complexity");
    }

    public void selectExamComplexity() {
        waitUntilLoaded(examComplexity);
        Select select = new Select(examComplexity);
        select.selectByIndex(1);
        logger.info("Select Exam Complexity");
    }

    public void fillQuestionBox() {
        questionBox.waitUntilClickable();
        questionBox.sendKeys("");
        questionBox.click();
        questionBox.sendKeys("Question1");
        logger.info("Fill Question Box");
    }

    public void fillExamQuestionBox() {
        examQuestionBox.waitUntilClickable();
        examQuestionBox.sendKeys("");
        examQuestionBox.click();
        examQuestionBox.sendKeys("Question1");
        logger.info("Fill Exam Question Box");
    }

    public void addFirstAnswerChoice() {
        addAnswerButton.click();
        waitUntilLoaded(answerChoiceBox);
        answerChoiceBox.click();
        answerChoiceBox.sendKeys("");
        answerChoiceBox.click();
        answerChoiceBox.sendKeys("Answer 1");
        isCorrectTick.click();
        isCorrectTick.isSelected();
        acceptAnswer.click();
        logger.info("Add First Answer");

    }

    public void addFirstAnswerChoiceInExam() {
        addExamAnswerButton.click();
        waitUntilLoaded(examAnswerChoiceBox);
        examAnswerChoiceBox.click();
        examAnswerChoiceBox.sendKeys("");
        examAnswerChoiceBox.click();
        examAnswerChoiceBox.sendKeys("Answer 1");
        isCorrectTickExam.click();
        isCorrectTickExam.isSelected();
        acceptAnswerExam.click();
        logger.info("Add First Answer");

    }

    public void addSecondAnswerChoice() {
        waitUntilLoaded(addAnswerButton);
        addAnswerButton.waitUntilClickable();
        addAnswerButton.click();
        waitUntilLoaded(answerChoiceBox);
        answerChoiceBox.click();
        answerChoiceBox.sendKeys("");
        answerChoiceBox.click();
        answerChoiceBox.sendKeys("Answer 2");
        acceptAnswer.waitUntilClickable();
        acceptAnswer.click();
        logger.info("Add Second Answer");
    }

    public void addSecondAnswerChoiceInExam() {
        waitUntilLoaded(addExamAnswerButton);
        addExamAnswerButton.waitUntilClickable();
        addExamAnswerButton.click();
        waitUntilLoaded(examAnswerChoiceBox);
        examAnswerChoiceBox.click();
        examAnswerChoiceBox.sendKeys("");
        examAnswerChoiceBox.click();
        examAnswerChoiceBox.sendKeys("Answer 2");
        acceptAnswerExam.click();
        logger.info("Add Second Answer");

    }

    public void saveQuestionAndAnswer() {
        waitUntilLoaded(saveButton);
        saveButton.click();
        logger.info("Click Save Button on add new Question for Quiz");

    }

    public void saveQuestionAndAnswerExam() {
        waitUntilLoaded(saveButtonExam);
        saveButtonExam.click();
        logger.info("Click Save Button on add new Question for Exam");
    }

    public String isQuizQuestionAdded() {
        logger.info("Get Quiz Question Text");
        return questionNameText.getText();
    }

    public String isExamQuestionAdded() {
        logger.info("Get Exam Question Text");
        return examQuestionNameText.getText();
    }

    public void addExamQuestion() {
        addExamQuestion.sendKeys("");
        addExamQuestion.click();
        logger.info("Click on Add Question in Exam");
    }

    public void addNumberQuestionsInFinalExam(String num) {
        waitUntilLoaded(questionBankBar);
        questionBankBar.clear();
        questionBankBar.sendKeys(num);
        logger.info("Add Numbers of Questions in Final Exam");

    }



    public String getTextQuestionBankBar()
    {
        waitUntilLoaded(questionBankBar);
        return questionBankBar.getValue();
    }
}

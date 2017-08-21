package com.softech.wlcms.pages.search;

import com.softech.wlcms.util.Course;
import com.softech.wlcms.util.CourseParser;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;


public class SearchPage extends PageObject{
    private static final Logger logger = LoggerFactory.getLogger(SearchPage.class);

    public enum CourseTypeEnum{
        ONLINE("Online"),
        ClASSROOM("Classroom"),
        WEBINAR("Webinar");
        private String statusCode;

        private CourseTypeEnum(String statusCode){
            this.statusCode = statusCode;
        }

        public String getElement(){
            return statusCode;
        }
    }

    public enum EnumCourseHeading{
        OVERVIEW("Overview");
        private String statusCode;

        private EnumCourseHeading(String statusCode){
            this.statusCode = statusCode;
        }

        public String getElement(){
            return statusCode;
        }
    }

    @FindBy(css = "#contentHolder .page-content h1")
    private WebElementFacade coursehead;

    @FindBy(id = "course_data")
    private WebElementFacade table;


    public void clickCourse(String courseType){
        logger.info("Searching");
        List<WebElement> allRows = table.findElements(By.tagName("tr"));
        for( WebElement row : allRows ){
            if( row.getText().contains(courseType) ){
                row.findElement(By.tagName("a")).click();
                logger.info("Search Complete");
                break;
            }
        }
    }

    public String searchCourseType(){
        logger.info("Search Course Type");
        return table.getText();
    }

    public Course getMostRecentCourse(){
        logger.info("Searching for Course");
        WebElement tableRow = table.findElements(By.tagName("tr")).get(1);
        CourseParser courseParser = new CourseParser();
        return courseParser.parseRow(tableRow);
    }

    public String searchCourseHeading(){
        return coursehead.getText();
    }


}

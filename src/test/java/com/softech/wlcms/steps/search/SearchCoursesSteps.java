package com.softech.wlcms.steps.search;

import com.softech.wlcms.pages.courses.CourseOverviewPage;
import com.softech.wlcms.pages.search.SearchPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by umair.javaid on 3/3/2016.
 */
public class SearchCoursesSteps extends ScenarioSteps {
    private static final Logger logger = LoggerFactory.getLogger(SearchCoursesSteps.class);

SearchPage searchPage;
    CourseOverviewPage courseOverviewPage;

@Step
    public void searchAndOpenCourse(SearchPage.CourseTypeEnum courseTypeEnum){

    searchPage.clickCourse(courseTypeEnum.getElement());
    String searchCoursreHead = searchPage.searchCourseHeading();
    assertTrue(searchCoursreHead.contains(SearchPage.EnumCourseHeading.OVERVIEW.getElement()));
}
    @Step
    public void performSaveExistingCourse()
    {
        courseOverviewPage.clickSaveButton();
        assertTrue(courseOverviewPage.courseIsDisplayed());
    }
}

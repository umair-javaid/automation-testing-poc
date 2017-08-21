package com.softech.wlcms.steps.course_updation_steps;

import com.softech.wlcms.pages.common.WlcmsHomePage;
import com.softech.wlcms.pages.courses.CourseOverviewPage;
import com.softech.wlcms.pages.courses.online.OnlineLeftNavigationPage;
import com.softech.wlcms.pages.courses.online.content.LessonPage;
import com.softech.wlcms.pages.courses.online.content.PresentationTemplateEnum;
import com.softech.wlcms.pages.courses.online.content.SlidePage;
import com.softech.wlcms.pages.courses.online.content.SlideTemplateType;
import com.softech.wlcms.steps.course_creation_steps.CourseCreationSteps;
import com.thedeanda.lorem.LoremIpsum;
import net.thucydides.core.annotations.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by umair.javaid on 3/25/2016.
 */
public class OnlineCourseUpdationSteps {
    private static final Logger logger = LoggerFactory.getLogger(OnlineCourseUpdationSteps.class);

    OnlineLeftNavigationPage onlineLeftNavigationPage;
    CourseCreationSteps courseCreationSteps;
    CourseOverviewPage courseOverviewPage;
    SlidePage slidePage;
    LessonPage lessonPage;

    @Step
    public void updateCourseMetaData() {
        courseOverviewPage.navigateToOnlineOverview();
        String title = WlcmsHomePage.CourseTypeEnum.ONLINE.getElement() + LoremIpsum.getInstance().getTitle(1, 2);
        courseOverviewPage.updateCourseName(title);
        onlineLeftNavigationPage.clickContent();
        assertTrue(courseOverviewPage.courseIsDisplayed());
        assertEquals(courseOverviewPage.getCourseName(), title);

    }

    @Step
    public void updateCourseContent() {

        onlineLeftNavigationPage.clickContent();
        String title = "Slide -" + LoremIpsum.getInstance().getTitle(1, 3);
        slidePage.createSlide(SlideTemplateType.PRESENTATION, PresentationTemplateEnum.VISUAL_RIGHT, title);

        assertTrue(slidePage.slideIsDisplayed());

    }


}

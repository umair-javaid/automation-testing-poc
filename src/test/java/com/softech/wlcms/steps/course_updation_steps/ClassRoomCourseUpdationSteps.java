package com.softech.wlcms.steps.course_updation_steps;

import com.softech.wlcms.pages.common.WlcmsHomePage;
import com.softech.wlcms.pages.courses.CourseOverviewPage;
import com.softech.wlcms.pages.courses.classroom.ClassroomLeftNavigationPage;
import com.thedeanda.lorem.LoremIpsum;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by umair.javaid on 4/20/2016.
 */
public class ClassRoomCourseUpdationSteps {
    private static final Logger logger = LoggerFactory.getLogger(ClassRoomCourseUpdationSteps.class);

    ClassroomLeftNavigationPage classroomLeftNavigationPage;
    CourseOverviewPage courseOverviewPage;

    public void updateClassroomCourseName() {
        courseOverviewPage.navigateToOverview();
        String title = WlcmsHomePage.CourseTypeEnum.ClASSROOM.getElement() + LoremIpsum.getInstance().getTitle(1, 2);
        courseOverviewPage.updateCourseName(title);
        classroomLeftNavigationPage.navigateToClassroom();
        assertTrue(courseOverviewPage.courseIsDisplayed());
        boolean titleDisplayed = StringUtils.contains(courseOverviewPage.getBreadcrumbTitle(), title);
        assertTrue(titleDisplayed);

    }
}

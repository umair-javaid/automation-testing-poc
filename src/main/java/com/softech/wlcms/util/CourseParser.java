package com.softech.wlcms.util;


import org.apache.commons.beanutils.BeanUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public final class CourseParser {
    private static final Logger logger = LoggerFactory.getLogger(CourseParser.class);

    enum CourseDataMapper{
        TITLE(0,"title"),
        TYPE(1,"type"),
        ID(2,"id"),
        MODIFIED(3,"lastModified"),
        STATUS(4,"status");

        private int index;
        private String columnName;

        CourseDataMapper(final int index,String columnName){
            this.index = index;
            this.columnName = columnName;
        }

        public int getIndex(){
            return index;
        }

        public String getColumnName(){
            return columnName;
        }
    }

    public Course parseRow(final WebElement courseRow){
        Course course = new Course();
        List<WebElement> cells = courseRow.findElements(By.tagName("td"));
        for( CourseDataMapper dataMapper : CourseDataMapper.values() ){
            String cellData = cells.get(dataMapper.getIndex()).getText();
            try{
                BeanUtils.setProperty(course,dataMapper.getColumnName(),cellData);
            }catch( IllegalAccessException | InvocationTargetException propertyMappingException ){
                logger.error("Error setting Course Property",propertyMappingException);
            }
        }
        return course;
    }
}

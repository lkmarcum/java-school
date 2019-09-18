package com.lambdaschool.school.service;

import com.lambdaschool.school.TestingSchoolApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestingSchoolApplication.class)
class CourseServiceImplTest
{
    @Autowired
    private CourseService courseService;

    @Test
    void findCourseById()
    {
        assertEquals("Test Data Science", courseService.findCourseById(1).getCoursename());
    }

    @Test
    void delete()
    {
    }
}
package com.lambdaschool.school.service;

import com.lambdaschool.school.TestingSchoolApplication;
import com.lambdaschool.school.exceptions.ResourceNotFoundException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityNotFoundException;

import static org.junit.Assert.*;


//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = TestingSchoolApplication.class)
public class CourseServiceImplTest
{
    @Autowired
    private CourseService courseService;

    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void findCourseById()
    {
        assertEquals("Test Data Science", courseService.findCourseById(1).getCoursename());
    }

    @Test
    public void delete()
    {
        courseService.delete(2);
        assertEquals(5, courseService.findAll(Pageable.unpaged()).size());
    }

//    @Test(expected = ResourceNotFoundException.class)
//    public void deleteNotFound()
//    {
//        courseService.delete(5000);
//    }

}
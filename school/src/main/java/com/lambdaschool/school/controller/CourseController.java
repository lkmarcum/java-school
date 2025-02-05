package com.lambdaschool.school.controller;

import com.lambdaschool.school.model.Course;
import com.lambdaschool.school.model.ErrorDetail;
import com.lambdaschool.school.service.CourseService;
import com.lambdaschool.school.view.CountStudentsInCourses;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@RestController
@RequestMapping(value = "/courses")
public class CourseController
{
    private static final Logger logger = LoggerFactory.getLogger(CourseController.class);

    @Autowired
    private CourseService courseService;

    @ApiOperation(value = "Returns all Courses", response = Course.class, responseContainer = "ArrayList")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query",
                    value = "Results page you want to retrieve (0..N)"),
            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
                    value = "Number of records per page."),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                    value = "Sorting criteria in the format: property(,asc|desc). " +
                            "Default sort order is ascending. " +
                            "Multiple sort criteria are supported.")})
    @GetMapping(value = "/courses", produces = {"application/json"})
    public ResponseEntity<?> listAllCourses(HttpServletRequest request, @PageableDefault(page = 0, size = 3)Pageable pageable)
    {
        logger.info(request.getMethod().toUpperCase() + " " + request.getRequestURI() + " accessed");

        ArrayList<Course> myCourses = courseService.findAll(pageable);
        return new ResponseEntity<>(myCourses, HttpStatus.OK);
    }

    @ApiOperation(value = "Returns number of Students enrolled in each Course", response = CountStudentsInCourses.class, responseContainer = "ArrayList")
    @GetMapping(value = "/studcount", produces = {"application/json"})
    public ResponseEntity<?> getCountStudentsInCourses(HttpServletRequest request)
    {
        logger.info(request.getMethod().toUpperCase() + " " + request.getRequestURI() + " accessed");

        ArrayList<CountStudentsInCourses> myList = courseService.getCountStudentsInCourse();
        return new ResponseEntity<>(myList, HttpStatus.OK);
    }

    @ApiOperation(value = "Deletes Course tied to a given ID", response = void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Course successfully deleted", response = void.class),
            @ApiResponse(code = 404, message = "No Course found with that ID", response = ErrorDetail.class)
    })
    @DeleteMapping("/courses/{courseid}")
    public ResponseEntity<?> deleteCourseById(@ApiParam(value = "Course ID", required = true, example = "1")
                                                  @PathVariable long courseid)
    {
        courseService.delete(courseid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

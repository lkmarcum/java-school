DELETE
FROM studcourses;

DELETE
FROM course;

DELETE
FROM student;

DELETE
FROM instructor;

INSERT INTO instructor (instructid, instructname)
    VALUES(1, 'Test Sally'),
          (2, 'Test Lucy'),
          (3, 'Test Charlie');

INSERT INTO course (courseid, coursename, instructid)
	VALUES (1, 'Test Data Science', 1),
           (2, 'Test JavaScript', 1),
           (3, 'Test Node.js',  1),
           (4, 'Test Java Back End', 2),
           (5, 'Test Mobile IOS', 2),
           (6, 'Test Mobile Android',  3);

INSERT INTO student (studid, studname)
    VALUES (1, 'Test John'),
           (2, 'Test Julian'),
           (3, 'Test Mary'),
           (4, 'Test Julian'),
           (5, 'Test Tyler'),
           (6, 'Test Kim'),
           (7, 'Test Juan'),
           (8, 'Test Robby'),
           (9, 'Test Roberto'),
           (10, 'Test Bob'),
           (11, 'Test Liz'),
           (12, 'Test June'),
           (13, 'Test April');

INSERT INTO studcourses (studid, courseid)
    VALUES (1, 1),
           (1, 4),
           (2, 2),
           (3, 3),
           (3, 1),
           (3, 6);

alter sequence hibernate_sequence restart with 20;
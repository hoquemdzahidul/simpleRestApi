package com.zahid.com.zahid.core;

import com.zahid.com.zahid.review.Review;
import com.zahid.course.Course;
import com.zahid.course.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by Zahid on 12/16/2017.
 */
@Component
public class DatabaseLoader implements ApplicationRunner {
    private CourseRepository courseRepository;
    @Autowired
    public DatabaseLoader(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        Course course = new Course("Java" , "https://www.udemy.com");
        course.addReview(new Review(4, " Excelant couse !!!yo"));
        courseRepository.save(course);
        String [] templates = {
                "Up and Running with %s",
                "%s Basics",
                "%s for Beginers",
                "%s for Neckbeards",
                "Under the hood : %s"
        };
        String [] buzzwords = {
                "Spring Rest Data",
                "Java 9",
                "C#",
                "Hibernet",
                "Object Oriented Programming "
        };
        List<Course> bunchOfCourses = new ArrayList<>();
        IntStream.range(0 , 100).forEach(i -> {
            String template = templates[i % templates.length];
            String buzword = buzzwords[i % buzzwords.length];
            String title = String.format(template , buzword);
            Course c = new Course(title , "www.example.com");
            c.addReview(new Review( i % 5 , String.format("More %s please" , buzword)));
            bunchOfCourses.add(c);
        });
        courseRepository.save(bunchOfCourses);

    }
}

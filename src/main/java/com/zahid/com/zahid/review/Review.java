package com.zahid.com.zahid.review;

import com.zahid.com.zahid.core.BaseEntity;
import com.zahid.course.Course;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by Zahid on 12/16/2017.
 */
@Entity
public class Review extends BaseEntity{
    private int rating;
    private String description;
    @ManyToOne
    private Course course;

    public Review() {
        super();
    }

    public Review(int rating, String description) {
        this.rating = rating;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}

package com.zahid.course;

import com.zahid.com.zahid.core.BaseEntity;
import com.zahid.com.zahid.review.Review;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zahid on 12/16/2017.
 */
@Entity
public class Course extends BaseEntity {

    private String title;
    private String url;
    @ManyToMany(mappedBy = "course" , cascade = CascadeType.ALL)
    private List<Review> reviews;

    public Course() {
    }

    public Course(String title, String url) {
        this.title = title;
        this.url = url;
        reviews = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void addReview(Review review)
    {
        review.setCourse(this);
        reviews.add(review);
    }
}

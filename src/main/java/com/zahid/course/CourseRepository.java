package com.zahid.course;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * Created by Zahid on 12/16/2017.
 */
public interface CourseRepository extends PagingAndSortingRepository<Course , Long> {
    @RestResource(rel = "title-contains" , path = "containsTitle")
    Page<Course> findByTitleContaining(@Param("title") String title , Pageable page);
}

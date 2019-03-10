package com.bootcamp.bootcamp.service;

import com.bootcamp.bootcamp.model.CourseEdition;
import com.bootcamp.bootcamp.model.repository.EditionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Service
@RequestMapping
public class EditionService {

    @Autowired
    private EditionRepository editionRepository;


    public List<CourseEdition> getAllCourses() {
        return editionRepository.findAllByOrderByPrice();
    }


    public Optional<CourseEdition> getOneCourse(long id) {

        return editionRepository.findById(id);
    }

    public CourseEdition getEdition(long id) {
        return editionRepository.getOne(id);
    }

    public void deleteEdition(long id) {

        editionRepository.deleteById(id);
    }

    public void addToDB(CourseEdition courseEdition) {
        courseEdition.setActive(true);
        editionRepository.save(courseEdition);
    }

    public void updateDB(CourseEdition courseEdition) {
        editionRepository.save(courseEdition);
    }



}

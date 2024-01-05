package com.example.demo.survey;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurveyDao extends JpaRepository<Survey, Integer> {

}

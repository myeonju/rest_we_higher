package com.example.demo.survey;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyItemDao extends JpaRepository<SurveyItem,Integer> {

}

package com.example.demo.survey;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SurveyItemService {
    private final SurveyItemDao surveyItemDao;

    public SurveyItem save(SurveyItem surveyItem){
        return surveyItemDao.save(surveyItem);
    }
}

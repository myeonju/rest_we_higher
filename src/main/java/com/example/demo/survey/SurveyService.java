package com.example.demo.survey;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SurveyService {
    private final SurveyDao surveydao;

    //추가, 수정
    public SurveyDto save(SurveyDto dto){
        Survey entity = surveydao.save(new Survey().toEntity(dto));
        return new SurveyDto().toDto(entity);
    }

    // ID로 보기
    public SurveyDto get(int id){
        Survey entity = surveydao.findById(id).orElse(null);
        return  new SurveyDto().toDto(entity);
    }

    //전체 보기
    public List<SurveyDto> getAll(){
        List<Survey> s = surveydao.findAll();
        List<SurveyDto> list = new ArrayList<>();
        for(Survey entity:s){
            list.add(new SurveyDto().toDto(entity));
        }
        return list;
    }

    //삭제
    public void del(int id){
        surveydao.deleteById(id);
    }
}

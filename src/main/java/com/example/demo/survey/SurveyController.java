package com.example.demo.survey;

import com.example.demo.member.Member;
import com.example.demo.member.MemberDto;
import com.example.demo.member.MemberService;
import lombok.RequiredArgsConstructor;
import oracle.jdbc.proxy.annotation.Post;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.Subject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins="*")
@RequiredArgsConstructor
@RequestMapping("/survey")
public class SurveyController {
    private final SurveyService surveyService;
    private final SurveyItemService surveyItemService;

    //추가
    @PostMapping(name = "")
    public Map add(@RequestBody SurveyDto s){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Member user = (Member) authentication.getPrincipal();
        MemberDto memberDto = new MemberDto().toDto(user);
        Map map = new HashMap();

//        for (SurveyItem item : s.getItems()) {
////            item.setSurvey(new Survey().toEntity(survey));
//            surveyItemService.save(item);
//        }

        s.setWriter(memberDto);
        s.setItems(new ArrayList<>());
        SurveyDto survey = surveyService.save(s);


        map.put("survey", survey);
        return map;
    }


    //수정


    //ID로 보기
    @GetMapping("/{id}")
    public Map get(@PathVariable("id") int id){
        SurveyDto survey = surveyService.get(id);
        Map map = new HashMap();

        map.put("survey",survey);
        return map;
    }

    //전체 보기
    @GetMapping("")
    public Map list(){
        Map map = new HashMap();
        List<SurveyDto> list = surveyService.getAll();

        map.put("list",list);
        return map;
    }

    //삭제
}

package com.example.demo.survey;

import com.example.demo.member.Member;
import com.example.demo.member.MemberDto;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class SurveyDto {
    private int id;
    private String title;
    private String content;
    private Date wdate;
    private MemberDto writer;
    private List<SurveyItem> items = new ArrayList<>();

    public SurveyDto toDto(Survey entity) {
        return new SurveyDto(
                entity.getId(),
                entity.getTitle(),
                entity.getContent(),
                entity.getWdate(),
                new MemberDto().toDto(entity.getWriter()),
                entity.getItems()
        );
    }
}

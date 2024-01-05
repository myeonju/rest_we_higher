package com.example.demo.survey;

import com.example.demo.member.Member;
import jakarta.persistence.*;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Setter
public class SurveyItem {
    @Id
    @SequenceGenerator(name="seq_gen", sequenceName="seq_surveyitem", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq_gen")
    private int id;
    @ManyToOne
    @JoinColumn()
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Survey survey;
    private String title;
//    @ManyToMany
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    private List<Member> voters;

}

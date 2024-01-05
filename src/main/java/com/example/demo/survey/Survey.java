package com.example.demo.survey;

import com.example.demo.member.Member;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Survey {
    @Id
    @SequenceGenerator(name="seq_gen", sequenceName="seq_survey", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq_gen")
    private int id;
    private String title;
    private String content;
    private Date wdate;
    @ManyToOne
    @JoinColumn(nullable=false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Member writer;
    @OneToMany(mappedBy = "survey", cascade = CascadeType.ALL)
    private List<SurveyItem> items;

    @PrePersist
    public void setDate() {
        wdate = new Date();
    }

    public void addItem(SurveyItem surveyItem){
        surveyItem.setSurvey(this);
        getItems().add(surveyItem);
    }

    public Survey toEntity(SurveyDto dto) {
        return new Survey(
                dto.getId(),
                dto.getTitle(),
                dto.getContent(),
                dto.getWdate(),
                new Member().toEntity(dto.getWriter()),
                dto.getItems()
        );
    }
}

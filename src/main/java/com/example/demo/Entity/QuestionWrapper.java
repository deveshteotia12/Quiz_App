package com.example.demo.Entity;

import lombok.Data;

@Data
public class QuestionWrapper
{
    Long id;

    String category;

    String difficultyLevel;

    String option1;
    String option2;
    String option3;
    String option4;

    public QuestionWrapper(Long id, String category, String difficultyLevel, String option1, String option2, String option3, String option4) {
        this.id = id;
        this.category = category;
        this.difficultyLevel = difficultyLevel;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
    }
}

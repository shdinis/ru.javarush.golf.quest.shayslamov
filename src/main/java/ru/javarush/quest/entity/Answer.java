package ru.javarush.quest.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@JsonTypeName
public class Answer {

    @JsonProperty("answerText")
    private String answerText;

    @JsonProperty("nextQuestion")
    private Long nextQuestion;

    public Answer(@JsonProperty(value = "answerText") String answerText,
                  @JsonProperty(value = "nextQuestion") Long nextQuestion) {
        this.answerText = answerText;
        this.nextQuestion = nextQuestion;
    }
}

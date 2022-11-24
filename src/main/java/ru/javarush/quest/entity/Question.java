package ru.javarush.quest.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@JsonTypeName
@EqualsAndHashCode
public class Question {

    @JsonProperty("questionText")
    private final String questionText;
    @JsonProperty("idAnswer")
    private final List<Long> idAnswer;

    @JsonProperty("backgroundPicture")
    private String backgroundPicture;


    public Question(@JsonProperty(value = "questionText") String questionText,
                    @JsonProperty(value = "idAnswer") List<Long> idAnswer,
                    @JsonProperty(value = "backgroundPicture") String backgroundPicture) {
        this.questionText = questionText;
        this.idAnswer = idAnswer;
        this.backgroundPicture = backgroundPicture;
    }
}

package ru.javarush.quest.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@JsonTypeName
public class Question {
    @JsonProperty("id")
    private final Long id;

    @JsonProperty("questionText")
    private final String questionText;
    @JsonProperty("idAnswer")
    private final List<Long> idAnswer;
    @JsonProperty("backgroundPicture")
    private final String backgroundPicture;
    public Question(@JsonProperty(value = "id") Long id,
                    @JsonProperty(value = "questionText") String questionText,
                    @JsonProperty(value = "idAnswer") List<Long> idAnswer,
                    @JsonProperty(value = "backgroundPicture") String backgroundPicture) {
        this.id = id;
        this.questionText = questionText;
        this.idAnswer = idAnswer;
        this.backgroundPicture = backgroundPicture;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<Long> getIdAnswer() {
        return idAnswer;
    }

    public String getBackgroundPicture() {
        return backgroundPicture;
    }
}

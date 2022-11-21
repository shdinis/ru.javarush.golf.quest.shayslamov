package ru.javarush.quest.entity;

import com.fasterxml.jackson.annotation.JacksonAnnotation;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;

@Getter
@JsonTypeName
public class User {
    @JsonProperty("id")
    private final Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("password")
    private String password;
    @JsonProperty("countOfPlayedGames")
    private Long countOfPlayedGames;

    public User(@JsonProperty(value = "id") Long id,
                @JsonProperty(value = "name") String name,
                @JsonProperty(value = "password") String password,
                @JsonProperty(value = "countOfPlayedGames") Long countOfPlayedGames) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.countOfPlayedGames = countOfPlayedGames;
    }

    public void upCountGames(){
        this.countOfPlayedGames++;
    }
}

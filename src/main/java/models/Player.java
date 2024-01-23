package models;

import lombok.Getter;
import lombok.Setter;
import models.enums.PlayerType;

@Getter
@Setter
public class Player {
    private String name;
    private int id;
    private char symbol;
    private PlayerType playerType;
}

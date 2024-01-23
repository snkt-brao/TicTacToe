package models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HumanPlayer extends Player {
    private int rank;
    private int age;
}

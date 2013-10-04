package model;

import java.util.List;

public abstract class Model {
    public abstract void updateTrace(String userInput);
    public abstract List<String> parseInput(String userInput);
}

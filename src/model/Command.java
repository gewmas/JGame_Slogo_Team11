package model;

import java.util.List;

public abstract class Command {
    int numberOfParameters;
    
    public abstract void execute(List<String> commandInput);
}

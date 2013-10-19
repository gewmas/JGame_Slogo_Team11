package model;

import java.util.ResourceBundle;
import java.util.Map;
import model.expression.Expression;
import model.parser.Parser;
import Exceptions.SlogoException;

public abstract class Model {

    public abstract void updateTrace (String userInput, ResourceBundle messages) throws SlogoException;
    public abstract Map<String, Expression> getGlobalVariables ();
    public abstract Map<String, Expression> getRunningFunction ();
    public abstract Parser getParser();
}

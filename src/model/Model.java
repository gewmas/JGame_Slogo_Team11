package model;

import java.util.Map;
import java.util.Stack;
import model.expression.Expression;
import model.parser.Parser;
import Exceptions.SlogoException;
import controller.ControllerToModelInterface;


public abstract class Model {

    public abstract void updateTrace (String userInput) throws SlogoException;

    public abstract Map<String, Expression> getGlobalVariables ();

    public abstract Map<String, Expression> getRunningFunction ();

    public abstract Parser getParser ();

    public abstract ControllerToModelInterface getController ();

    public abstract Stack<String> getFunctionStack ();
}

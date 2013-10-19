package model.expression;

import java.util.ArrayList;
import java.util.List;
import model.Model;
import controller.TurtleCommand;
import Exceptions.SlogoException;

public class SetPaletteExpression extends DisplayCommandExpression {

    public SetPaletteExpression (List<String> cmdList, Model model) throws SlogoException {
        super(cmdList, model);
    }
    

}

package model.expression;

import java.util.List;
import model.Model;
import Exceptions.SlogoException;

public class AskWithExpression extends AskExpression {

    public AskWithExpression (List<String> cmdList, Model model) throws SlogoException {
        super(cmdList, model);
    }

}

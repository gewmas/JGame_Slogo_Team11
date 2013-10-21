package model.expression;

import java.util.List;
import Exceptions.SlogoException;
import model.Model;

public class ZeroParameterExpression extends Expression {

    public ZeroParameterExpression (Model model) throws SlogoException {
        super(model);
    }

    @Override
    public void convert (List<String> cmdList) {

    }

    @Override
    public List<Expression> evaluate () {
        return null;
    }

  

}

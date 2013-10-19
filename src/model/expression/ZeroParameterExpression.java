package model.expression;

import java.util.List;
import model.Model;
import controller.TurtleCommand;

public class ZeroParameterExpression extends Expression {

    public ZeroParameterExpression (Model model) {
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

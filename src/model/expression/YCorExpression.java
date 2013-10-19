    package model.expression;

import model.Model;
import controller.Controller;
import controller.ControllerToModelInterface;

public class YCorExpression extends QueryExpression {

    public YCorExpression (Model model) {
        super(model);
    }

    @Override
    public void executeControllerCommand (ControllerToModelInterface controller) {
        controller.yCor();
    }

}

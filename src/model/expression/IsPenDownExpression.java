package model.expression;

import model.Model;
import controller.Controller;
import controller.ControllerToModelInterface;

public class IsPenDownExpression extends QueryExpression {

    public IsPenDownExpression (Model model) {
        super(model);
    }

    @Override
    public void executeControllerCommand (ControllerToModelInterface controller) {
        controller.isPenDown();
    }

}

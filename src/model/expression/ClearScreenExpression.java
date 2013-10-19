package model.expression;

import model.Model;
import controller.Controller;
import controller.ControllerToModelInterface;

public class ClearScreenExpression extends QueryExpression {

    public ClearScreenExpression (Model model) {
        super(model);
    }

    @Override
    public void executeControllerCommand (ControllerToModelInterface controller) {
        controller.clearScreen();
    }

}

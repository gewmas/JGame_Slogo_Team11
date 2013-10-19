package model.expression;

import controller.Controller;
import controller.ControllerToModelInterface;

public class PencolorExpression extends QueryExpression {
    
    @Override
    public void executeControllerCommand (ControllerToModelInterface controller) {
        controller.penColor();
    }

}

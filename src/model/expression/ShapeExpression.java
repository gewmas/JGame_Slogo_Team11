package model.expression;

import Exceptions.SlogoException;
import model.Model;
import controller.ControllerToModelInterface;

public class ShapeExpression extends QueryExpression {

    public ShapeExpression (Model model) throws SlogoException {
        super(model);
    }

    @Override
    public void executeControllerCommand (ControllerToModelInterface controller) {
        controller.turtleShape();
    }

}

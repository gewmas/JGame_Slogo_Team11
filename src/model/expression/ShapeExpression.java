package model.expression;

import controller.ControllerToModelInterface;

public class ShapeExpression extends QueryExpression {

    @Override
    public void executeControllerCommand (ControllerToModelInterface controller) {
        controller.turtleShape();
    }

}

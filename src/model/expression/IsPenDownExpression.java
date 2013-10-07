package model.expression;

import controller.Controller;

public class IsPenDownExpression extends QueryExpression {

    @Override
    public void executeControllerCommand (Controller controller) {
        controller.isPenDown();
    }

}

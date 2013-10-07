package model.expression;

import controller.Controller;

public class ClearScreenExpression extends QueryExpression {

    @Override
    public void executeControllerCommand (Controller controller) {
        controller.clearScreen();
    }

}

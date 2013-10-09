    package model.expression;

import controller.Controller;

public class YCorExpression extends QueryExpression {

    @Override
    public void executeControllerCommand (Controller controller) {
        controller.yCor();
    }

}

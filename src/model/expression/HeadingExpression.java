package model.expression;

import controller.Controller;

public class HeadingExpression extends QueryExpression {

    @Override
    public void executeControllerCommand (Controller controller) {
        controller.heading();
    }

}

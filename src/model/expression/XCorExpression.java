package model.expression;

import controller.Controller;

public class XCorExpression extends QueryExpression {

    @Override
    public void executeControllerCommand (Controller controller) {
        controller.xCor();
    }

}

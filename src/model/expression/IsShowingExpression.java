package model.expression;

import controller.Controller;

public class IsShowingExpression extends QueryExpression {

    @Override
    public void executeControllerCommand (Controller controller) {
        controller.isShowing();
    }

}

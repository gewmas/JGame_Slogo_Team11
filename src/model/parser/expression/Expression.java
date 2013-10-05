package model.parser.expression;

import java.util.List;

public abstract class Expression {

    public abstract void convert(List<String> cmdList);
    public abstract List<Expression> evaluate();
}

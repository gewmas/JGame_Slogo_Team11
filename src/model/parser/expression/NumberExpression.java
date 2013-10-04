package model.parser.expression;

public class NumberExpression extends Expression {
    double number;
    
    public NumberExpression(double d){
        number = d;
    }
    
    public double evaluate(){
        return number;
    }
    
}

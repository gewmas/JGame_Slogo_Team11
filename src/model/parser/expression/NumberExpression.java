package model.parser.expression;

public class NumberExpression extends Expression {
    double number;
    
    public NumberExpression(double d){
        number = d;
    }
    
    public Expression evaluate(){
        return this;
    }
    
    public Expression sum(NumberExpression rhs){
        return new NumberExpression(getNumber()+rhs.getNumber());
    }

    public double getNumber () {
        return number;
    }
}

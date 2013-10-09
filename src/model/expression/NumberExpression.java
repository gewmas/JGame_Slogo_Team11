package model.expression;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class NumberExpression extends Expression {
    double number;

//    public NumberExpression (NumberExpression rhs){
//        
//    }
    
    public NumberExpression (double d) {
        number = d;
    }

    @Override
    public void convert (List<String> cmdList) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Expression> evaluate () {
        // TODO Auto-generated method stub
        List<Expression> finalExpressionList = new ArrayList<Expression>();
        finalExpressionList.add(this);
        return finalExpressionList;
    }

    /**
     * @purpose Sum two NumberExpressions
     * @param rhs
     * @return
     */
    public Expression sum (NumberExpression rhs) {
        return new NumberExpression(getNumber() + rhs.getNumber());
    }
    
    /**
     * @purpose Subtract two NumberExpressions
     * @param rhs
     * @return
     */
    public Expression subtract (NumberExpression rhs) {
        return new NumberExpression(getNumber() - rhs.getNumber());
    }
    
    /**
     * @purpose multiply two NumberExpressions
     * @param rhs
     * @return
     */
    public Expression multiply (NumberExpression rhs) {
        return new NumberExpression(getNumber() * rhs.getNumber());
    }
    
    /**
     * @purpose divide two NumberExpressions
     * @param rhs
     * @return
     */
    public Expression divide (NumberExpression rhs) {
        return new NumberExpression(getNumber() / rhs.getNumber());
    }
    
    /**
     * @purpose find remainer of two NumberExpressions
     * @param rhs
     * @return
     */
    public Expression remainder (NumberExpression rhs) {
        return new NumberExpression(getNumber() % rhs.getNumber());
    }
    
    /**
     * @purpose negate the NumberExpression
     * @param rhs
     * @return
     */
    public Expression minus () {
        return new NumberExpression(getNumber() * -1);
    }
    
    /**
     * @purpose negate the NumberExpression
     * @param rhs
     * @return
     */
    public Expression random () {
        Random rand = new Random();
        int  n = rand.nextInt((int) getNumber());
        return new NumberExpression(n);
    }
    
    /**
     * @purpose sin of the NumberExpression
     * @param rhs
     * @return
     */
    public Expression sin () {
        return new NumberExpression(Math.round(Math.sin(Math.toRadians(getNumber()))));
    }
    
    /**
     * @purpose cos of the NumberExpression
     * @param rhs
     * @return
     */
    public Expression cos () {
        return new NumberExpression(Math.round(Math.cos(Math.toRadians(getNumber()))));
    }
    
    /**
     * @purpose tan of the NumberExpression
     * @param rhs
     * @return
     */
    public Expression tan () {
        return new NumberExpression(Math.round(Math.tan(Math.toRadians(getNumber()))));
    }
    
    /**
     * @purpose arctan of the NumberExpression
     * @param rhs
     * @return
     */
    public Expression atan () {
        return new NumberExpression(Math.round(Math.atan(Math.toRadians(getNumber()))));
    }
    
    /**
     * @purpose log of the NumberExpression
     * @param rhs
     * @return
     */
    public Expression log () {
        return new NumberExpression(Math.log(getNumber()));
    }
    
    /**
     * @purpose power of the NumberExpression (we just always raise to power 2 since not clear in docs)
     * @param rhs
     * @return
     */
    public Expression pow () {
        return new NumberExpression(Math.pow(getNumber(), 2));
    }
    
    /**
     * @purpose Check if exp1 strictly less then exp2
     * @param rhs
     * @return
     */
    public Expression less (NumberExpression rhs) {
        double num = 0;
        if(getNumber() < rhs.getNumber()) {
            num = 1;
        }
        return new NumberExpression(num);
    }
    
    /**
     * @purpose Check if exp1 strictly greater then exp2
     * @param rhs
     * @return
     */
    public Expression greater (NumberExpression rhs) {
        double num = 0;
        if(getNumber() > rhs.getNumber()) {
            num = 1;
        }
        return new NumberExpression(num);
    }
    
    /**
     * @purpose Check if exp1 equal to exp2
     * @param rhs
     * @return
     */
    public Expression equal (NumberExpression rhs) {
        double num = 0;
        if(getNumber() == rhs.getNumber()) {
            num = 1;
        }
        return new NumberExpression(num);
    }
    
    /**
     * @purpose Check if exp1 not equal to exp2
     * @param rhs
     * @return
     */
    public Expression notEqual (NumberExpression rhs) {
        double num = 0;
        if(getNumber() != rhs.getNumber()) {
            num = 1;
        }
        return new NumberExpression(num);
    }
    
    /**
     * @purpose Check if test1 and test2 are non-zero
     * @param rhs
     * @return
     */
    public Expression and (NumberExpression rhs) {
        double num = 0;
        if(getNumber() != 0 && rhs.getNumber() != 0) {
            num = 1;
        }
        return new NumberExpression(num);
    }
    
    /**
     * @purpose Check if test1 or test2 are non-zero
     * @param rhs
     * @return
     */
    public Expression or (NumberExpression rhs) {
        double num = 0;
        if(getNumber() != 0 || rhs.getNumber() != 0) {
            num = 1;
        }
        return new NumberExpression(num);
    }
    
    /**
     * @purpose Check if test1 or test2 are non-zero
     * @param rhs
     * @return
     */
    public Expression not () {
        double num = 0;
        if(getNumber() == 0) {
            num = 1;
        }
        return new NumberExpression(num);
    }

    public double getNumber () {
        return number;
    }

}

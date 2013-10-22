package model.expression;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import Exceptions.SlogoException;
import model.Model;


public class NumberExpression extends Expression {
    double number;

//    public NumberExpression (NumberExpression rhs){
//        
//    }
    
    public NumberExpression (double d, Model model) throws SlogoException {
        super(model);
        number = d;
    }

    @Override
    public void convert (List<String> cmdList) {

    }

    @Override
    public List<Expression> evaluate () {
        
        List<Expression> finalExpressionList = new ArrayList<Expression>();
        finalExpressionList.add(this);
        return finalExpressionList;
    }

    /**
     * @purpose Sum two NumberExpressions
     * @param rhs
     * @return
     * @throws SlogoException 
     */
    public Expression sum (NumberExpression rhs) throws SlogoException {
        return new NumberExpression(getNumber() + rhs.getNumber(), model);
    }
    
    /**
     * @purpose Subtract two NumberExpressions
     * @param rhs
     * @return
     */
    public Expression subtract (NumberExpression rhs) throws SlogoException{
        return new NumberExpression(getNumber() - rhs.getNumber(), model);
    }
    
    /**
     * @purpose multiply two NumberExpressions
     * @param rhs
     * @return
     */
    public Expression multiply (NumberExpression rhs) throws SlogoException{
        return new NumberExpression(getNumber() * rhs.getNumber(), model);
    }
    
    /**
     * @purpose divide two NumberExpressions
     * @param rhs
     * @return
     * @throws SlogoException 
     */
    public Expression divide (NumberExpression rhs) throws SlogoException {
        return new NumberExpression(getNumber() / rhs.getNumber(), model);
    }
    
    /**
     * @purpose find remainer of two NumberExpressions
     * @param rhs
     * @return
     */
    public Expression remainder (NumberExpression rhs) throws SlogoException{
        return new NumberExpression(getNumber() % rhs.getNumber(), model);
    }
    
    /**
     * @purpose negate the NumberExpression
     * @param rhs
     * @return
     */
    public Expression minus () throws SlogoException{
        return new NumberExpression(getNumber() * -1, model);
    }
    
    /**
     * @purpose negate the NumberExpression
     * @param rhs
     * @return
     */
    public Expression random () throws SlogoException{
        Random rand = new Random();
        int n = rand.nextInt(getNumber().intValue());
        return new NumberExpression(n, model);
    }
    
    /**
     * @purpose sin of the NumberExpression
     * @param rhs
     * @return
     */
    public Expression sin () throws SlogoException{
        return new NumberExpression(Math.round(Math.sin(Math.toRadians(getNumber()))), model);
    }
    
    /**
     * @purpose cos of the NumberExpression
     * @param rhs
     * @return
     */
    public Expression cos () throws SlogoException{
        return new NumberExpression(Math.round(Math.cos(Math.toRadians(getNumber()))), model);
    }
    
    /**
     * @purpose tan of the NumberExpression
     * @param rhs
     * @return
     */
    public Expression tan () throws SlogoException{
        return new NumberExpression(Math.round(Math.tan(Math.toRadians(getNumber()))), model);
    }
    
    /**
     * @purpose arctan of the NumberExpression
     * @param rhs
     * @return
     */
    public Expression atan () throws SlogoException{
        return new NumberExpression(Math.round(Math.atan(Math.toRadians(getNumber()))), model);
    }
    
    /**
     * @purpose log of the NumberExpression
     * @param rhs
     * @return
     */
    public Expression log () throws SlogoException{
        return new NumberExpression(Math.log(getNumber()), model);
    }
    
    /**
     * @purpose power of the NumberExpression (we just always raise to power 2 since not clear in docs)
     * @param rhs
     * @return
     */
    public Expression pow () throws SlogoException{
        return new NumberExpression(Math.pow(getNumber(), 2), model);
    }
    
    /**
     * @purpose Check if exp1 strictly less then exp2
     * @param rhs
     * @return
     */
    public Expression less (NumberExpression rhs) throws SlogoException{
        double num = 0;
        if(getNumber() < rhs.getNumber()) {
            num = 1;
        }
        return new NumberExpression(num, model);
    }
    
    /**
     * @purpose Check if exp1 strictly greater then exp2
     * @param rhs
     * @return
     */
    public Expression greater (NumberExpression rhs) throws SlogoException{
        double num = 0;
        if(getNumber() > rhs.getNumber()) {
            num = 1;
        }
        return new NumberExpression(num, model);
    }
    
    /**
     * @purpose Check if exp1 equal to exp2
     * @param rhs
     * @return
     */
    public Expression equal (NumberExpression rhs) throws SlogoException{
        double num = 0;
        if(getNumber() == rhs.getNumber()) {
            num = 1;
        }
        return new NumberExpression(num, model);
    }
    
    /**
     * @purpose Check if exp1 not equal to exp2
     * @param rhs
     * @return
     */
    public Expression notEqual (NumberExpression rhs) throws SlogoException{
        double num = 0;
        if(getNumber() != rhs.getNumber()) {
            num = 1;
        }
        return new NumberExpression(num, model);
    }
    
    /**
     * @purpose Check if test1 and test2 are non-zero
     * @param rhs
     * @return
     */
    public Expression and (NumberExpression rhs) throws SlogoException{
        double num = 0;
        if(getNumber() != 0 && rhs.getNumber() != 0) {
            num = 1;
        }
        return new NumberExpression(num, model);
    }
    
    /**
     * @purpose Check if test1 or test2 are non-zero
     * @param rhs
     * @return
     */
    public Expression or (NumberExpression rhs) throws SlogoException{
        double num = 0;
        if(getNumber() != 0 || rhs.getNumber() != 0) {
            num = 1;
        }
        return new NumberExpression(num, model);
    }
    
    /**
     * @purpose Check if test1 or test2 are non-zero
     * @param rhs
     * @return
     */
    public Expression not () throws SlogoException{
        double num = 0;
        if(getNumber() == 0) {
            num = 1;
        }
        return new NumberExpression(num, model);
    }

    public Double getNumber () {
        return number;
    }

}

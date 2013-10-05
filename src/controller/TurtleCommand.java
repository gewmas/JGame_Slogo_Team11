package controller;

public class TurtleCommand {
    double x;
    double y;
    double direction;
    //color
    //isPenDown
    
    public TurtleCommand(double x, double y, double direction){
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public double getX () {
        return x;
    }

    public double getY () {
        return y;
    }

    public double getDirection () {
        return direction;
    }

    public void setX (double x) {
        this.x = x;
    }

    public void setY (double y) {
        this.y = y;
    }

    public void setDirection (double direction) {
        this.direction = direction;
    }
    
    
}

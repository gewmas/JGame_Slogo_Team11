package controller;

public class TurtleCommand {
    private double x;
    private double y;
    private double direction;
    private boolean isPenDown;
    private boolean isVisible;
    //color
    
    public TurtleCommand(){
        this(0.0, 0.0, 90.0);
    }
    
    public TurtleCommand(double x, double y, double direction){
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.isPenDown = true;
        this.isVisible = true;
    }
    
    public TurtleCommand(TurtleCommand rhs){
        this.x = rhs.x;
        this.y = rhs.y;
        this.direction = rhs.direction;
        this.isPenDown = rhs.isPenDown;
        this.isVisible = rhs.isVisible;
    }
    
    public boolean isVisible () {
        return isVisible;
    }

    public void setVisible (boolean isVisible) {
        this.isVisible = isVisible;
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

    public boolean isPenDown () {
        return isPenDown;
    }

    public void setPenDown (boolean isPenDown) {
        this.isPenDown = isPenDown;
    }
    
    
}

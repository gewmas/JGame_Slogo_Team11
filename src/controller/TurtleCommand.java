package controller;

public class TurtleCommand {
    private double x;
    private double y;
    private double direction;
    private boolean isPenDown;
    private boolean isVisible;
    private boolean isActive;

    private double background;
    private double penColor;
    private double penSize;
    private double shape;
    private boolean stamp;
    private boolean clearStamps;

    public TurtleCommand () {
        this(0.0, 0.0, 90.0);
    }

    public TurtleCommand (double x, double y, double direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        isPenDown = true;
        isVisible = true;

    }

    public TurtleCommand (TurtleCommand rhs) {
        x = rhs.x;
        y = rhs.y;
        direction = rhs.direction;
        isPenDown = rhs.isPenDown;
        isVisible = rhs.isVisible;
    }

    public double getBackground () {
        return background;
    }

    public void setBackground (double background) {
        this.background = background;
    }

    public double getPenColor () {
        return penColor;
    }

    public void setPenColor (double penColor) {
        this.penColor = penColor;
    }

    public double getShape () {
        return shape;
    }

    public void setShape (double shape) {
        this.shape = shape;
    }

    public boolean isStamp () {
        return stamp;
    }

    public void setStamp (boolean stamp) {
        this.stamp = stamp;
    }

    public boolean isClearStamps () {
        return clearStamps;
    }

    public void setClearStamps (boolean clearStamps) {
        this.clearStamps = clearStamps;
    }

    public boolean isVisible () {
        return isVisible;
    }

    public void setVisible (boolean isVisible) {
        this.isVisible = isVisible;
    }

    public void setActive (boolean isActive) {
        this.isActive = isActive;
    }

    public boolean isActive () {
        return isActive;
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

    public double getPenSize () {
        return penSize;
    }

    public void setPenSize (double penSize) {
        this.penSize = penSize;
    }

}

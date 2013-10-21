package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TurtleCommand {
    private double x;
    private double y;
    private double direction;
    private boolean isPenDown;
    private boolean isVisible;
    private boolean isActive;

    private static final String BACKGROUND = "background";
    private static final String PEN_COLOR = "penColor";
    private static final String PEN_SIZE = "penSize";
    private static final String SHAPE = "shape";

    private double background;
    private double penColor;
    private double penSize;
    private double shape;
    private boolean stamp;
    private boolean clearStamps;
    
    private List<HashMap<String, Double>> preferencesMap;
    
    public TurtleCommand(){
        this(0.0, 0.0, 90.0);
    }
    
    public TurtleCommand(double x, double y, double direction){
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.isPenDown = true;
        this.isVisible = true;
        this.preferencesMap = new ArrayList<HashMap<String, Double>>();
    }
    
    public TurtleCommand(TurtleCommand rhs){
    	this(rhs.x, rhs.y, rhs.direction);
//        this.x = rhs.x;
//        this.y = rhs.y;
//        this.direction = rhs.direction;
//        this.isPenDown = rhs.isPenDown;
//        this.isVisible = rhs.isVisible;
    }
    
	public Map<String, Double> getCurrentPreferences() {
		Map<String, Double> preference = new HashMap<String, Double>();
		preference.put(BACKGROUND, this.getBackground());
		preference.put(PEN_COLOR, this.getPenColor());
		preference.put(SHAPE, this.getShape());
		preference.put(PEN_SIZE, this.getPenSize());
		return preference;
	}
    
    public void savePreferences (Map<String, Double> preference) {
    	this.preferencesMap.add((HashMap<String, Double>) preference);
    }
    
    public void loadPreferences (int index) {
    	Map<String, Double> map = this.preferencesMap.get(index);
    	this.setBackground(map.get(BACKGROUND));
    	this.setPenColor(map.get(PEN_COLOR));
    	this.setPenSize(map.get(PEN_SIZE));
    	this.setShape(map.get(SHAPE));
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

    public void setActive(boolean isActive){
        this.isActive=isActive;
    }
    
    public boolean isActive(){
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

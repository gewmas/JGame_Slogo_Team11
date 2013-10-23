package controller;

/**
 * ImageTurtle reprsents turtle by image
 * @author Yuhua, Fabio
 */
public class ImageTurtle extends Turtle {

    String image;
    
    public ImageTurtle(){
        super();
    }
    
    public void setTurtleImage(String image){
        this.image = image;
    }
    
    public String getTurtleImage(){
        return image;
    }
    
}

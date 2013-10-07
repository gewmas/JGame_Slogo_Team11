package controller;

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

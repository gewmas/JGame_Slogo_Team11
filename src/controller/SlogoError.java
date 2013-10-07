package controller;

public class SlogoError {
    
    String name;
    String description;
    
    public SlogoError(String myName, String myDescription) {
        name = myName;
        description = myDescription;
    }
    
    public String getName () {
        return name;
    }
    public void setName (String name) {
        this.name = name;
    }
    public String getDescription () {
        return description;
    }
    public void setDescription (String description) {
        this.description = description;
    }
    
    

}

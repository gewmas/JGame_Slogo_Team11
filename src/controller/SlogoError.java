package controller;

public class SlogoError {
    
    String name;
    String description;
    
    /**
     * Prints an error to the console without crashing the program when an error occurs in SLogo 
     */
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

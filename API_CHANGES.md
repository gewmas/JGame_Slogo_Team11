#Previous API

```java
Controller

// Take the commands typed by the user and updates the TurtleTrace accordingly.
Public void interpretCommand ( String userInput )

// Returns the active TurtleTrace object which is outlined below
Public TurtleTrace getTurtleTrace( )

// Getters and setters of turtle so turtle object never directly manipulated by view
Public void setTurtleColor( )
Public void getTurtleColor( )
Public void setTurtlePenUp( )
Public void setTurtlePenDown( )
Public void setTurtleImage( )
Public void getTurtleImage( )
Public void getTurtlePenColor( )
Public void setTurtlePenColor( )

// Additional getters/setters
Public void setBackgroundColor( )
Public AGColor getBackgroundColor( )
Public void setActiveTurtle( int turtleId )
```

#Current API

```java
Controller

public Workspace getCurrentWorkspace () { ... }
public void setCurrentWorkspace (String workspaceId) { ... }
public List<Turtle> getTurtles () {
    return currentWorkspace.getTurtles();
}

public List<Turtle> getActiveTurtles () {
    return currentWorkspace.getActiveTurtles();
}

...
```

The original API doesn't consider multiple workspaces and turtles. We change the Controller to store information by Workspace and View will now get needed information of currentWorkspace.



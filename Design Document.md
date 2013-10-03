Design Document
======

#Design Goal  – Front End

The front end object will contain a number of modules to be rendered as the UI for SLogo. The rendered modules are Display, Turtle-variable state, User-defined-variable state, and User inputs (this module is comprised of Command line and Toggle controls).  

The front end will be responsible for painting each of these modules as part of the UI windows. The display module will be responsible for rendering the actions of the turtle on the GUI. Windows will monitor user interactions and will either alter the display if it is a display toggle, or pass the results of the user action to the backend. 

The main form of sending data to the backend will be an interpretCommand method, which sends a command string to the backend to be parsed. Thus, any communication from the frontend to the backend can be represented in the form of a command string. For example, changing a variable value in the turtle data window can be treated as the user entering the command MAKE variable expr. This simplifies our communication pathway to allow for passing one data type to the backend (a string), and allows future additions to be made by adding extra textual commands.

#Primary Classes and Methods
	
The main parts of the GUI are:
•	Display - paints the current position of the turtle, as well as lines drawn by the pen
•	Command line - similar to MATLAB command window, displays past commands above which can be clicked to be executed, and allows the user to input new commands. Scrollable.
•	Turtle variables - displays turtle-variables about the current turtle, for example: x,y coordinates, current angular direction etc. This module hovers on Display window and can be toggled off if the user desires.
•	User-defined variables - shows the variables created by the user and their values, which can be edited by the user. Similar to MATLAB workspace window.
•	Toggle controls - contains toggle buttons to turn certain features on and off.
There will be a basic GUI window super class, which each specialized window can then extend in order to implement their individual features. The final display window will contain each of these GUI elements organized in a user-friendly way.

#Example Code

In order to parse the user command, the command line will have an ActionListener that processes user input. The ActionListener will then call interpretCommand whenever a string is entered.

```java
commandLine = new JTextField(N);
commandLine.addActionListener(this);

public void actionPerformed(ActionEvent e){
   String command=commandLine.getText();
   interpretCommand(command);
}
```
Once the backend processes the command, it will update the TurtleTrace commandList. The frontend then calls getCommandList() in its eval loop, and draws the lines and turtle positions in the turtleCommand list.
```java
loop{
   getCommandList();
   paintTurtleCommands();
}
```
#Alternatives

The communication pathway between the frontend and the backend can be extended, so that each window has its own method that passes commands to the backend, or even sets state in the backend directly. However, we found that this implementation would be too restrictive, as it would introduce a number of class specific communication pathways, compared to a more general method of passing everything as string commands. This also means that the backend's command parser will be able to parse everything the frontend sends without any modifications.


#Design Goals - Back End
The back end will takes the command string from front end and update the TurtleTrace of the Turtle and the front end can update the painting according to the trace.

SLogo will be implemented using the Model-View-Controller (MVC) architecture and therefore there are three main classes, Model, View and Controller. 
##Controller is responsible to store instances of Turtle and servers interface for View and Model. View will call function in Controller to pass command strings to Model, set activeTurtle and get multiple properties of the activeTurtle, background color.  Model will update the TurtleTrace of the activeTurtle.
##Model is responsible to parse the command strings, update muliple properties and TurtleTrace of Turtle.
##View is responsible to paint the trace of activeTurtle according to the TurtleTrace.

#Primary Classes and Methods

#Example code
##Draw Turtle and Trace using TurtleTrace 
For View to get TurtleTrace to draw, calling the function in Controller:
```java
public TurtleTrace getTurtleTrace( );
```
To interpret the Trace, first check the Error. If there is any, it means that Model fails to parse the previou command and store the error information in Error. Then the View can show the error information to the user.
```java
if(!getError().empty()) System.out.println(getError()); //The format of Error is not decided yet, may be String.
```
If there is no error, View can look at the List of TurtleCommand and draw.
```java
 commandList = getCommandList( )
```
The information for drawing Turtle includes x, y, direction and isPenUp. More attributes could be added to the TurtleCommand like color.

In general, the method to draw the trace and the turtle is as below:
```java
public void paintFrame(){
       TurtleTrace turtleTrace = controller.getTurtleTrace(); // Notice that the return value could extend to List of TurtleTrace, then need to draw multiple turtle and traces
       if(turtleTrace.getError()) … //Print some error info

       List<TurtleCommand> turtleCommands = turtleTrace.getCommandList( );
       for(TurtleCommand turtleCommand : turtleCommands){
              //Not sure if we can draw a temp turtle according to every x,y,direction and disappear after we draw the next position to do the animation? 
              …
              //Draw trace according to the x,y and the prevX, prevY and isPenUp
              ...
       }
       //Draw turtle according to the color or image of the turtle, and x,y,direction in turtleCommand
              ...
}
```

## … // Fabio, maybe talk about how to update the TurtleTrace when parsing the commands?

#Alternatives

#Role



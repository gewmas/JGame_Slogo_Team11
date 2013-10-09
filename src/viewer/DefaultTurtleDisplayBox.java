package viewer;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import controller.Controller;
import controller.Turtle;
import controller.TurtleCommand;
import controller.TurtleTrace;
import viewer.display_objects.DisplayPath;
import viewer.display_objects.DisplayTurtle;
import jgame.JGColor;
import jgame.JGPoint;
import jgame.platform.JGEngine;


/** Tutorial example 1: a minimal program.  A "bare skeleton" program
 * displaying a moving text "hello world".
 *
 * In order to run as both applet and application, you need to define a main()
 * method (this is the entry point for an application) and a parameterless
 * constructor (this is the entry point for an applet).  We use a second
 * constructor with a size parameter to initialise the engine as an
 * application.
 */
public class DefaultTurtleDisplayBox extends TurtleDisplay {
        public DefaultTurtleDisplayBox(Controller controller) {
                // This inits the engine as an applet.
                this(new JGPoint(500,500),controller); 
        }

        /** We use a separate constructor for starting as an application. */
        public DefaultTurtleDisplayBox(JGPoint size, Controller controller) {
            super(size,controller); 
        }
}
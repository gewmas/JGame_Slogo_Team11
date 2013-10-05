package viewer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UserVariableBox extends JPanel{
    JLabel myVariables;
    public UserVariableBox(){
        myVariables = new JLabel();
        myVariables.setFont(new Font("Georgia", Font.PLAIN, 14));
        myVariables.setForeground(new Color(50, 50, 25));
        myVariables.setText("Hi");
        add(myVariables);
        setBorder(BorderFactory.createLineBorder(Color.black));
        setPreferredSize(new Dimension(300,300));
    }
}

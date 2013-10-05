package viewer;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CommandBox extends JPanel implements ActionListener{
    JTextField myTextField;
    
    public CommandBox(){
        myTextField=new JTextField(40);
        //myTextField.setPreferredSize(new Dimension(500,100));
        add(myTextField);
        myTextField.addActionListener(this);
        //setSize(200,100);
    }

    @Override
    public void actionPerformed (ActionEvent arg0) {
        String text = myTextField.getText();
        myTextField.selectAll();
    }
}

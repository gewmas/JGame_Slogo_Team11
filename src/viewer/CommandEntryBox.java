package viewer;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JTextField;
import controller.Controller;

public class CommandEntryBox extends Panel implements ActionListener{
    JTextField myTextField;
    Controller myController;
    PastCommandBox myPastCommandBox;
    
    public CommandEntryBox(int width, int height,PastCommandBox pastcommandbox, Controller controller){
        super(width,height);
        myTextField=new JTextField();
        add(myTextField);
        myTextField.addActionListener(this);
        myController=controller;
        myPastCommandBox=pastcommandbox;
        myTextField.setPreferredSize(new Dimension(width,height-5));
        //setPreferredSize(new Dimension(200,20));
    }

    @Override
    public void actionPerformed (ActionEvent arg0) {
        String text = myTextField.getText();
        myController.addCommand(text);
        myPastCommandBox.addCommand(text);
        myTextField.setText("");
    }
}

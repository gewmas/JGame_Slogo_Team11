package viewer;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CommandEntryBox extends Panel implements ActionListener{
    JTextField myTextField;
    
    public CommandEntryBox(int width, int height){
        myTextField=new JTextField();
        myTextField.setPreferredSize(new Dimension(width,height));
        add(myTextField);
        myTextField.addActionListener(this);
        //setPreferredSize(new Dimension(200,20));
    }

    @Override
    public void actionPerformed (ActionEvent arg0) {
        String text = myTextField.getText();
        myTextField.selectAll();
    }
}

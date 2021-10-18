package swing;
import javax.swing.*;
import java.awt.event.*;

public class CheckRadio implements ItemListener{

    JCheckBox cb1,cb2;
    JLabel l;

    CheckRadio() {

        JFrame f = new JFrame("Checkbox Frame");

        l = new JLabel();
        l.setHorizontalAlignment(JLabel.CENTER);
        l.setSize(400,100);

        cb1 = new JCheckBox("Java");
        cb1.setBounds(100,100, 100,50);

        cb2 = new JCheckBox("Python", true);
        cb2.setBounds(100,150,100,50);

        f.add(cb1);
        f.add(cb2);
        f.add(l);

        cb1.addItemListener(this);
        cb2.addItemListener(this);

        f.setSize(800, 800);
        f.setLayout(null);
        f.setVisible(true);
    }

    public void itemStateChanged(ItemEvent e) {
        if(e.getSource() == cb1)
            l.setText("Java Checkbox: " +(e.getStateChange()==1?"checked":"unchecked"));

        if(e.getSource() == cb2)
            l.setText("Python Checkbox: "+(e.getStateChange()==1?"checked":"unchecked"));
    }

    public static void main(String[] args){
        new CheckRadio();
    }
}

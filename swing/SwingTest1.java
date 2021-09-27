package swing;

import javax.swing.*;
import java.awt.event.*;

public class SwingTest1 implements ActionListener{

    JTextField tf;
    JButton b;

    SwingTest1(){

        JFrame f =  new JFrame("Aman's Button");
        tf = new JTextField("Java");
        tf.setBounds(50, 100, 95, 30);

        b = new JButton("Ok");

        b.setBounds(50, 50, 95, 30);

        b.addActionListener(this);
        f.add(b);
        f.add(tf);

        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == b)
            tf.setText("Java Lab");
    }

    public static void main(String[] r) {
        new SwingTest1();
    }
}
import javax.swing.*;

public class Test {
    public static void main(String[] args) {
        JFrame f = new JFrame("Test");
        JButton b = new JButton("🚩");

        b.setBounds(130,100,100, 40);
        f.add(b);

        f.setSize(300, 400);
        f.setLayout(null);

        f.show(true);
    }
}
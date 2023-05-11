package PastryPulverizer;

import javax.jws.WebParam;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View {
    private JPanel Panel;
    private JTextPane textPane1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;


    public JPanel getPanel() {
        return Panel;
    }

    public JTextPane getTextPane1() {
        return textPane1;
    }

    public void setTextPane1(String money) {
        textPane1.setText(money);
    }

    public JButton getButton1() {
        return button1;
    }
}


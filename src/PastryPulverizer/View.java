package PastryPulverizer;

import javax.jws.WebParam;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View {
    private JPanel Panel;
    private JTextPane textPane1;
    private JButton button1;
    private JButton pulverizerButton;
    private JButton pastryBakerButton;
    private JButton button4;
    private JButton saveButton;
    private JButton loadButton;


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

    public JButton getSaveButton() {
        return saveButton;
    }

    public JButton getLoadButton() {
        return loadButton;
    }

    public JButton getPulverizerButton() {
        return pulverizerButton;
    }

    public JButton getPastryBakerButton() {
        return pastryBakerButton;
    }

    public void setPulverizer(String money) {
        pulverizerButton.setText(money);
    }
    public void setPastryBaker(String money) {
        pastryBakerButton.setText(money);
    }
}


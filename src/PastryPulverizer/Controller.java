package PastryPulverizer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Scanner;

public class Controller extends JFrame {

    Model model;
    View view;

    public Controller(Model m, View v){

        this.model = m;
        this.view = v;

        this.setContentPane(v.getPanel());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setTitle("PastryPulverizer");


        view.getButton1().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    m.addPastries();
                    v.setTextPane1(m.getMoney());
                }
            });
        view.getSaveButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    m.save();
                }
            });
        view.getLoadButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    m.load();
            }
        });
    }


    public static void main(String[] args) {
    Model m = new Model();
    View v = new View();
    Controller thisIsTheProgram = new Controller(m, v);
    thisIsTheProgram.setVisible(true);


    }
}



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
                    v.setTextPane1(m.getMoney());
            }
        });
        view.getPulverizerButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                m.buyPastryPulverizer(m.getPulverizer());
                System.out.println("You own " + m.getPulverizer().getOwned() + " Pulverizers\nThey will now cost " + m.getPulverizer().getCost() + " Pastries \n" + m.getPulverizeStrength() + " PulverizerStrength");
                v.setTextPane1(m.getMoney());
            }
        });
        view.getPastryBakerButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                m.buyPastryBuilding(m.getPastryBaker());
                System.out.println("You own " + m.getPastryBaker().getOwned() + " PastryBakers\nThey will now cost " + m.getPastryBaker().getCost() + " Pastries \nYour Pps is " + m.getPastryBaker().getPps());
                v.setTextPane1(m.getMoney());
                m.timer();
            }
        });
    }


    public static void main(String[] args) {
    Model m = new Model();
    View v = new View();
    Controller thisIsTheProgram = new Controller(m, v);
    thisIsTheProgram.setVisible(true);

        System.out.println("You own " + m.getPulverizer().getOwned() + " Pulverizers \n You own " + m.getPastryBaker().getOwned() + " PastryBakers \n Your PulverizerStrength is " + m.getPulverizeStrength() + " per click \n");
    }
}



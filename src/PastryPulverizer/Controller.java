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
    }

    public static void main(String[] args) {
    Model m = new Model();
    View v = new View();
    Controller thisIsTheProgram = new Controller(m, v);
    thisIsTheProgram.setVisible(true);

        Connection conn = null;
        String user = "te20";
        JPasswordField pf = new JPasswordField();
        JOptionPane.showConfirmDialog(null, pf, "password?", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        String password = new String(pf.getPassword());

        try {
            conn = DriverManager.getConnection("jdbc:mysql://db.umea-ntig.se:3306/te20? "+
                    "allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            Statement stmt = conn.createStatement();
            String SQLQuery = "SELECT * FROM tn03pastry";
            ResultSet result = stmt.executeQuery(SQLQuery);

            ResultSetMetaData metadata = result.getMetaData();

            int numCols = metadata.getColumnCount();
            for (int i = 1 ; i <= numCols ; i++) {
                System.out.println(metadata.getColumnClassName(i));
            }

            //insert
            SQLQuery = "INSERT INTO tn03pastry(pastries) VALUES ('"+ m.getMoney()+"')";
            stmt.executeUpdate(SQLQuery);


            stmt.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }
}



package PastryPulverizer;
import PastryPulverizer.Buildings.*;

import javax.swing.*;
import java.sql.*;

public class Model {



    Pulverizer Pulverizer = new Pulverizer();
    PastryBaker PastryBaker = new PastryBaker();

    int fps = 30;
    int pastries = 0;
    int Pps = 0;
    int PulverizeStrength = 1;

    public PastryPulverizer.Buildings.Pulverizer getPulverizer() {
        return Pulverizer;
    }

    public PastryPulverizer.Buildings.PastryBaker getPastryBaker() {
        return PastryBaker;
    }

    public void buyPastryPulverizer(Building Building) {
        if(pastries > Building.getCost()-1) {
            pastries -= Building.getCost();
            Building.setCost((int) (Building.getCost() * 1.20));
            Building.setOwned(Building.getOwned() + 1);
            PulverizeStrength = 1+(Pulverizer.getOwned() * Pulverizer.getPps());
        } else {
            System.out.println("You dont have enough pastries");
        }
    }

    public void buyPastryBuilding(Building Building) {
        if(pastries > Building.getCost()-1) {
            pastries -= Building.getCost();
            Building.setCost((int) (Building.getCost() * 1.20));
            Building.setOwned(Building.getOwned() + 1);
            PulverizeStrength = 1+(PastryBaker.getOwned() * PastryBaker.getPps());
        } else {
            System.out.println("You dont have enough pastries");
        }
    }
    public int getPulverizeStrength() {
        return PulverizeStrength;
    }

    public void setPulverizeStrength(int pulverizeStrength) {
        PulverizeStrength = pulverizeStrength;
    }

    public void addPastries() {
        PulverizeStrength = 1+(Pulverizer.getOwned() * Pulverizer.getPps());
        pastries += PulverizeStrength;
    }

    public String getMoney() {
        String money = pastries + " Pastries";
        return money;
    }

    public void save(){
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
            SQLQuery = "UPDATE tn03pastry SET pastries = " + pastries;
            stmt.executeUpdate(SQLQuery);


            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void load(){
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


            while (result.next()) {
                pastries = result.getInt("pastries");
            }


            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}

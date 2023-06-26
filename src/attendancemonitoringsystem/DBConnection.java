/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancemonitoringsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class DBConnection {
    public static Connection getConnection() {
        try {
            String dbRoot = "jdbc:mysql://";
            String hostName = "localhost:3306/";
            String dbName = "attendancemonitoring";
            String dbUrl =  dbRoot + hostName + dbName;
            
            String hostUsername = "root";
            String hostPassword = "";
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection myConn = DriverManager.getConnection(dbUrl, hostUsername, hostPassword);
      
        
        return myConn;
        } catch (Exception e) {
               //pop up message here
            JOptionPane.showMessageDialog(null, e);
            
            return null;
        }
    }
}
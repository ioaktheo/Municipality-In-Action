/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Xristos Aslamagidis
 */
public class DbLinker {
      private Connection con;
    private Statement st;
    private ResultSet rs;

    public DbLinker() {
         try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://192.168.137.1:3306/community", "monty", "some_pass");
            st = con.createStatement();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error: " + ex);
        }
         
         
    }

    public Connection getCon() {
        return con;
    }

    public Statement getSt() {
        return st;
    }

    public ResultSet getRs() {
        return rs;
    }
    
}

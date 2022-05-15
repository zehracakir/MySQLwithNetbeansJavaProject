/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.database.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zehra
 */
public class DBUtil {
    public static Connection getConnection(){
        Properties properties = new Properties();
        Connection connection = null;
        
        
        
        
        File file = new File(".");
        try {
            FileInputStream inputStream = new FileInputStream(file.getAbsolutePath()+"/src/resources/db.properties");
            properties.load(inputStream);
            String driver = properties.getProperty("driver");
            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            
            Class.forName(driver);
            
            connection = DriverManager.getConnection(url,user,password);
        
        
        
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
           System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
       return connection; 
    }
    
    public static void closeConnection(Connection connection){
        if(connection != null)
            try {
                connection.close();
        } catch (SQLException ex) {
                System.out.println(ex.getMessage());
        }
    }
}

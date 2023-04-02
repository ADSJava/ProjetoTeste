package br.com.projeto.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionFactory {
    public Connection getConnection(){
        
        try { 
           return DriverManager.getConnection("jdbc:mysql://localhost:3306/bdvendas?user=root&password=root") ;
        } catch (Exception e) { 
            
        throw new RuntimeException(e); 
        }
    }
}

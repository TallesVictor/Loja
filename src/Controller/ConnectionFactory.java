/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Bruno Andrade
 */
public class ConnectionFactory {
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver encontrado com sucesso");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver de conexão mysql não encontrado");
            System.out.println(e.getStackTrace());
        }
        
        try {
            String url = "jdbc:mysql://localhost:3306/mpsneakers";
            String usuario = "root";
            String senha = "";
            Connection c =  DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão estabelecida com sucesso");
            return c;
        } catch (SQLException e) {
            System.out.println("Erro inesperado na conexão com banco de dados.");
            System.out.println(e.getStackTrace());
            throw new RuntimeException();
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.romaneio.core.entity.dao.conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author valdemar
 */
public class ConexaoJDBC {
                                       
    private static final String URL = "jdbc:mysql://localhost:3306/romaneio";
    private static final String USER = "root";
    private static final String PASSOWORD = "admin";
    
    public static Connection conn;
    
    public static Connection getConnection(){
        
        try {
            if(conn == null){
                conn = DriverManager.getConnection(URL, USER, PASSOWORD);
                return conn;  
            }else{
                return conn;
            }
        } catch (SQLException e) {
            System.out.println("erro ao conecta no banco");
            
            return null;
        }
    }
}

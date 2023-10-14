/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.romaneio.core.entity.dao;

import br.romaneio.core.entity.dao.conexao.ConexaoJDBC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author valdemar
 */
public class CarregarTabelas {
    public  String[] carregar() {
    
       String sql = "show TABLES";  
       PreparedStatement ps = null;
       ResultSet rs = null;
       String[] vetor = new String[10];
       try {
           ps = ConexaoJDBC.getConnection().prepareStatement(sql);
           rs = ps.executeQuery();
           int i = 0;
           while(rs.next()){
               
               String tabela = rs.getString(1);
               vetor[i] = tabela;
              
               i++;
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }finally{
           try {
               ps.close();
               rs.close();;
           } catch (SQLException e) {
               e.printStackTrace();
           }
       } return vetor; 
   } 
}

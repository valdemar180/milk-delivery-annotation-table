/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.romaneio.core.entity.dao;

import br.romaneio.core.entity.dao.conexao.ConexaoJDBC;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author valdemar
 */
public class CriarMesDAO {
    
    public void criar(String mes){
        
        String ano = "_" + String.valueOf(obterAno());
        String url = "jdbc:mysql://localhost:3306/romaneio";
        String usuario = "root";
        String senha = "admin";
        String sql = "CREATE TABLE `romaneio`."+ mes + ano +" (\n" +
                     "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                     "  `litros` INT NOT NULL,\n" +
                     "  `furural` DOUBLE NOT NULL,\n" +
                     "  `valor_leite` DOUBLE NOT NULL,\n" +
                     "  `mes` INT NOT NULL,\n" +
                     "  PRIMARY KEY (`id`, `litros`, `furural`, `valor_leite`, `mes`));";
        
  

         PreparedStatement ps = null;
        
        try {
            ps = ConexaoJDBC.getConnection().prepareStatement(sql);
            
            ps.execute();

            JOptionPane.showMessageDialog(null, "Criado com sucesso");
           ps.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public int obterAno(){
        
        LocalDate ano = LocalDate.now();
        int anoAtual = ano.getYear();
        
        return anoAtual;
    
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.romaneio.core.entity.dao;
import br.romaneio.core.entity.Dia;
import br.romaneio.core.entity.dao.conexao.ConexaoJDBC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author valdemar
 */
public class HistoricoMesDAO {
  
    public Dia carregar(Long id , String nome){
    
        
        String sql = "SELECT ID, LITROS, FURURAL, VALOR_LEITE FROM "+ nome + " WHERE ID = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            ps = ConexaoJDBC.getConnection().prepareStatement(sql);
            
            ps.setLong(1, id);
            rs = ps.executeQuery();
            
            if(rs.next()){
                
                Dia dia = new Dia();
                dia.setId(rs.getLong("ID"));
                dia.setLitros(rs.getInt("LITROS"));
                dia.setFurural(rs.getDouble("FURURAL"));
                dia.setValorLeite(rs.getDouble("VALOR_LEITE"));
                return dia;        
            }
            
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            
        } finally {
            try {
                ps.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    
    }
        return null;
    
}}

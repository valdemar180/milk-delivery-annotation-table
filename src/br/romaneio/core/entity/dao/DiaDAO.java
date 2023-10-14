/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.romaneio.core.entity.dao;

import br.romaneio.core.entity.ContadorDias;
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
public class DiaDAO {
    public void inserir(Dia dia){
        TabelaInicialDAO tbdao = new TabelaInicialDAO();
        String nome = tbdao.carregarUltimaTables();
        String sql = "INSERT INTO " + nome + " (LITROS, FURURAL, VALOR_LEITE , MES) VALUES (?,?,?,?)";
        PreparedStatement ps = null;
        
        
        try {
            ps = ConexaoJDBC.getConnection().prepareStatement(sql);
            ps.setInt(1, dia.getLitros());
            ps.setDouble(2, dia.getFurural());
            ps.setDouble(3,dia.getValorLeite());
            ps.setInt(4,dia.getMes());
            ps.execute();
            JOptionPane.showMessageDialog(null,"Cadastrado com sucesso");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public Dia buscar(Long id){
    
       
        String sql = "SELECT ID, LITROS, FURURAL, VALOR_LEITE FROM JANEIRO WHERE ID = ?";
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
    
    }
    
    
    
    
    
        
}

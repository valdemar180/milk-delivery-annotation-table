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
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author valdemar
 */
public class TabelaInicialDAO {
    public  String carregarUltimaTables() {
    
       String sql = "select table_name\n" +
                    "from information_schema.tables\n" +
                    "where table_schema = 'romaneio'\n" +
                    "order by create_time desc\n" +
                    "limit 1";  
       PreparedStatement ps = null;
       ResultSet rs = null;
       String tabela = null ;
       
       try {
           ps = ConexaoJDBC.getConnection().prepareStatement(sql);
           rs = ps.executeQuery();
          
           while(rs.next()){
               
                tabela = rs.getString(1);
                
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
           
       } return tabela; 
   } 
   
   public Dia carregarTabela(Long id ){
    
        String nome = carregarUltimaTables();
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
   }
   public int somatotal(){
       
       
       int soma = 0;
       
       for(int i = 1; i <=31;i++){
           Long id = Long.valueOf(i);
           Dia dia = carregarTabela(id);
           
           if(dia != null){
               
                int litros = dia.getLitros();
                
                soma += litros;
           }
           
       }
       
       return soma;
   }
   public Double valortotalReais(){
       
       Double soma = Double.valueOf(somatotal());
       Long id = Long.valueOf(1);
       Dia dia = carregarTabela(id);
       Double valorLeite = dia.getValorLeite();
       Double valortotal = soma * valorLeite;
       
       
       return arredondar(valortotal, 2);
   }
   public double furural(){
       Long id = Long.valueOf(1);
       Dia dia = carregarTabela(id);
       Double furural = dia.getFurural();
       Double reais = valortotalReais();
       
       Double valor = reais - (reais * (furural / 100.0));
       Double reaisComDesconto = arredondar(valor, 2);
       
       return reaisComDesconto;
   }
    public static double arredondar(double numero, int casasDecimais) {
        double fatorDeMultiplicacao = Math.pow(10, casasDecimais);
        return Math.round(numero * fatorDeMultiplicacao) / fatorDeMultiplicacao;
    }
}

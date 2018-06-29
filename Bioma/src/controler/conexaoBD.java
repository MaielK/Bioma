/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

/**
 *
 * @author arthur
 */

import java.sql.*;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

public class conexaoBD {
    
     public Statement stm;
    public ResultSet rs;
    private String driver = "org.postgresql.Driver";
    private String caminho = "jdbc:postgresql://localhost:5432/sistema";
    private String usuario = "postgres";
    private String senha = "postgres";
    public Connection con;
    
    public void conexao(){
   
        try {
        System.setProperty("jdbc.Drivers", driver);
        con = DriverManager.getConnection(caminho, usuario, senha);
        //JOptionPane.showMessageDialog(null, "Conexão Efetuada com Sucesso!");
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao conectar com banco de dados:\n" +ex);
        }
    }
    
    /* consulta */
    public void executaSql (String sql){
        try{
            stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ExecutaSQL:\n" +ex.getMessage());
        }
    }
    
        public void desconecta(){
        try {
            con.close();
            JOptionPane.showMessageDialog(null, "BD Desconectado com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Fechar Conexo com BD:\n" +ex.getMessage());
        }
            
        }
    
}


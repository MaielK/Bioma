/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.login_model;
import view.tela_login;
import view.tela_principal;

/**
 *
 * @author arthur
 */
public class login_control {
    
 login_model login = new login_model();
 conexaoBD conexao = new conexaoBD();
 
    public boolean verificaLogin(String usuario, String senha) {

        try {
            conexao.conexao();
            String sql = "select * from login where usuario = '" + usuario + "'";
            conexao.executaSql(sql);
            conexao.rs.first();
            if (conexao.rs.getString("senha").equals(senha)) {
                tela_principal tela_p = new tela_principal();
                tela_p.setVisible(true);
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Usuário ou senha inconrreto");
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Usuário ou senha inconrreto");
            return false;
        }      
    }
}

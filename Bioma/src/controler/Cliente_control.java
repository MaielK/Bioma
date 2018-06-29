/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.awt.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.cliente_model;

/**
 *
 * @author arthu
 */
public class Cliente_control {

    conexaoBD conexao = new conexaoBD();
    cliente_model cliente_modelo = new cliente_model();

    public void cadastroCliente(cliente_model cliente) {

        conexao.conexao();
        try {
            String sql = "insert into cliente (cli_nome, cli_rg, cli_cpf, cli_celular, cli_telefone, cli_email, cli_endereço, cli_estado, cli_municipio) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst;
            pst = conexao.con.prepareStatement(sql);
            pst.setString(1, cliente.getCli_nome());
            pst.setString(2, cliente.getCli_rg());
            pst.setString(3, cliente.getCli_cpf());
            pst.setString(4, cliente.getCli_celular());
            pst.setString(5, cliente.getCli_telefone());
            pst.setString(6, cliente.getCli_email());
            pst.setString(7, cliente.getCli_endereço());
             pst.setInt(8, cliente.getCli_estado());
            pst.setInt(9, cliente.getCli_municipio());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Cliente inserido com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(Cliente_control.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<cliente_model> listaCliente() {
        conexao.conexao();

        PreparedStatement pst;
        ResultSet rs;
        ArrayList<cliente_model> clientes = new ArrayList<>();
        try {
            String sql = "select * from cliente";
            pst = conexao.con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {

                cliente_modelo.setCli_cod(rs.getInt("cli_cod"));
                cliente_modelo.setCli_nome(rs.getString("cli_nome"));
                cliente_modelo.setCli_rg(rs.getString("cli_rg"));
                cliente_modelo.setCli_cpf(rs.getString("cli_cpf"));
                cliente_modelo.setCli_telefone(rs.getString("cli_telefone"));
                cliente_modelo.setCli_celular(rs.getString("cli_celular"));
                cliente_modelo.setCli_email(rs.getString("cli_email"));
                cliente_modelo.setCli_endereço(rs.getString("cli_endereço"));
                cliente_modelo.setCli_estado(rs.getInt("cli_estado"));
                cliente_modelo.setCli_municipio(rs.getInt("cli_municipio"));

                clientes.add(cliente_modelo);

            }
        } catch (SQLException ex) {

            Logger.getLogger(Cliente_control.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return clientes;

    }
}



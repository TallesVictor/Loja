/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Dcxz
 */
public class FornecedorDao {
    
    private Connection connection;

    public FornecedorDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public boolean cadastrar(Fornecedor c) {
        String sql = "insert into fornecedor (nome, cep, cnpj) "
                + "values (?,?,?)";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, c.getNome());
            ps.setString(2, c.getCep());
            ps.setString(3, c.getCnpj());
            ps.execute();
            ps.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao Cadastrar: " + e.getMessage());
            throw new RuntimeException();
        }
    }
     public Fornecedor buscarporid(Integer id) {
        Fornecedor cliente = null;
        String sql = "select * from fornecedor where id = ? limit 1";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cliente = preencherFornecedor(rs);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar: " + e.getMessage());
            throw new RuntimeException();
        }
        return cliente;
    }

    public ArrayList<Fornecedor> buscarTodos() {
        ArrayList<Fornecedor> listaFornecedor = new ArrayList<>();
        String sql = "select * from fornecedor order by id";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Fornecedor c = preencherFornecedor(rs);
                listaFornecedor.add(c);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar: " + e.getMessage());
            throw new RuntimeException();
        }
        return listaFornecedor;
    }

    private Fornecedor preencherFornecedor(ResultSet rs) throws SQLException {
        int id= rs.getInt("id");
        String nome = rs.getString("nome");
        String cep = rs.getString("cep");
        String cnpj = rs.getString("cnpj");
        Fornecedor c = new Fornecedor(id, nome, cep, cnpj);
        return c;
    }

    public void atualizar(Fornecedor c) {
        String sql = "update fornecedor set nome=?, cep=?, cnpj=? where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(4, c.getId());
            ps.setString(1, c.getNome());
            ps.setString(2, c.getCep());
            ps.setString(3, c.getCnpj());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao ataualizar: " + e.getMessage());
            throw new RuntimeException();
        }
    }

   

    public void excluir(Integer id) {
        String sql1 = "SET FOREIGN_KEY_CHECKS=0";
        String sql = "delete from fornecedor where id= ?";
        String sql2 = "SET FOREIGN_KEY_CHECKS=1";
        try {
            PreparedStatement ps = connection.prepareStatement(sql1);
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
            throw new RuntimeException();
        }
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
            throw new RuntimeException();
        }
        try {
            PreparedStatement ps = connection.prepareStatement(sql2);
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
            throw new RuntimeException();
        }
    }

}

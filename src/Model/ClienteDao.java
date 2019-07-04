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
public class ClienteDao {

    private Connection connection;

    public ClienteDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public boolean cadastrar(Cliente c) {
        String sql = "insert into cliente (nome, rg, cpf) "
                + "values (?,?,?)";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, c.getNome());
            ps.setString(2, c.getRg());
            ps.setString(3, c.getCpf());
            ps.execute();
            ps.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao Cadastrar: " + e.getMessage());
            throw new RuntimeException();
        }
    }
     public Cliente buscarporid(Integer id) {
        Cliente cliente = null;
        String sql = "select * from cliente where id = ? limit 1";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cliente = preencherCliente(rs);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar: " + e.getMessage());
            throw new RuntimeException();
        }
        return cliente;
    }

    public ArrayList<Cliente> buscarTodos() {
        ArrayList<Cliente> listaCliente = new ArrayList<>();
        String sql = "select * from cliente order by id";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cliente c = preencherCliente(rs);
                listaCliente.add(c);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar: " + e.getMessage());
            throw new RuntimeException();
        }
        return listaCliente;
    }

    private Cliente preencherCliente(ResultSet rs) throws SQLException {
        int id= rs.getInt("id");
        String nome = rs.getString("nome");
        String cpf = rs.getString("cpf");
        String rg = rs.getString("rg");
        Cliente c = new Cliente(id,nome, rg, cpf);
        return c;
    }

    public void atualizar(Cliente c) {
        String sql = "update cliente set nome=?, rg=?, cpf=? where id=?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(4, c.getId());
            ps.setString(1, c.getNome());
            ps.setString(2, c.getRg());
            ps.setString(3, c.getCpf());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao ataualizar: " + e.getMessage());
            throw new RuntimeException();
        }
    }

    public void excluir(Integer id) {
        String sql1 = "SET FOREIGN_KEY_CHECKS=0";
        String sql = "delete from cliente where id= ?";
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

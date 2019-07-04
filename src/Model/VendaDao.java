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
public class VendaDao {

    private Connection connection;

    public VendaDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public boolean cadastrar(Venda v) {
        String sql = "insert into vendas (id_produto, id_funcionario, quantidade,preco,data) "
                + "values (?,?,?,?,?)";
        String sql1 = "UPDATE produto SET quantidade= quantidade-? WHERE id=?;";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            PreparedStatement ps1 = connection.prepareStatement(sql1);
            ps.setInt(1, v.getIdProduto());
            ps.setInt(2, v.getIdFuncionario());
            ps.setInt(3, v.getQuantidade());
            ps.setDouble(4, v.getPreco());
            ps.setString(5, v.getData());
            ps1.setInt(1, v.getQuantidade());
            ps1.setInt(2, v.getId());
            ps.execute();
            ps.close();
            ps1.execute();
            ps1.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao Cadastrar: " + e.getMessage());
            throw new RuntimeException();
        }

    }

    public Venda buscarporid(Integer id) {
        Venda venda = null;
        String sql = "select * from vendas where id = ? limit 1";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                venda = preencherVenda(rs);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar: " + e.getMessage());
            throw new RuntimeException();
        }
        return venda;
    }

    public ArrayList<Venda> buscarTodos() {
        ArrayList<Venda> listaVenda = new ArrayList<>();
        String sql = "select * from vendas order by id";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Venda v = preencherVenda(rs);
                listaVenda.add(v);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar: " + e.getMessage());
            throw new RuntimeException();
        }
        return listaVenda;
    }

    private Venda preencherVenda(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        int idProduto = rs.getInt("id_produto");
        int idFuncionario = rs.getInt("id_funcionario");
        int quantidade = rs.getInt("quantidade");
        double preco = rs.getDouble("preco");
        String data = rs.getString("data");
        Venda v = new Venda(id, idProduto, idFuncionario, quantidade, preco, data);
        return v;
    }

    public void atualizar(Venda v) {
        String sql = "update vendas set id_produto=?, id_funcionario=?, quantidade=?,preco=?,data=? where id=?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, v.getIdProduto());
            ps.setInt(2, v.getIdFuncionario());
            ps.setInt(3, v.getQuantidade());
            ps.setDouble(4, v.getPreco());
            ps.setString(5, v.getData());
            ps.setInt(6, v.getId());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao ataualizar: " + e.getMessage());
            throw new RuntimeException();
        }
    }

    public void excluir(Integer id) {
        String sql = "delete from vendas where id= ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
            throw new RuntimeException();
        }
    }

    public ArrayList<Venda> buscarTodosIdProduto(int id) {
        ArrayList<Venda> listaVenda = new ArrayList<>();
        String sql = "select * from vendas where id_produto=" + id + ";";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Venda v = preencherVenda(rs);
                listaVenda.add(v);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar: " + e.getMessage());
            throw new RuntimeException();
        }
        return listaVenda;
    }

    public ArrayList<Venda> buscarTodosIdFun(int id) {
        ArrayList<Venda> listaVenda = new ArrayList<>();
        String sql = "select * from vendas where id_funcionario=" + id + ";";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Venda v = preencherVenda(rs);
                listaVenda.add(v);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar: " + e.getMessage());
            throw new RuntimeException();
        }
        return listaVenda;
    }

    public ArrayList<Venda> buscarTodosData(String data) {
        ArrayList<Venda> listaVenda = new ArrayList<>();
        String sql = "select * from vendas where data='" + data + "';";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Venda v = preencherVenda(rs);
                listaVenda.add(v);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar: " + e.getMessage());
            throw new RuntimeException();
        }
        return listaVenda;
    }

    public ArrayList<Venda> ordernarMaior() {
        ArrayList<Venda> listaVenda = new ArrayList<>();
        String sql = "select * from vendas order by preco ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Venda v = preencherVenda(rs);
                listaVenda.add(v);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar: " + e.getMessage());
            throw new RuntimeException();
        }
        return listaVenda;
    }

    public ArrayList<Venda> ordernarMenor() {
        ArrayList<Venda> listaVenda = new ArrayList<>();
        String sql = "select * from vendas order by preco desc";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Venda v = preencherVenda(rs);
                listaVenda.add(v);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar: " + e.getMessage());
            throw new RuntimeException();
        }
        return listaVenda;
    }

}

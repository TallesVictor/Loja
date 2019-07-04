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
public class ProdutoDao {
        private Connection connection;

    public ProdutoDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public boolean cadastrar(Produto p) {
        String sql = "insert into produto (marca, modelo, numeracao,if_fornecedor,quantidade,preco) "
                + "values (?,?,?,?,?,?)";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, p.getMarca());
            ps.setString(2, p.getModelo());
            ps.setInt(3, p.getNumeracao());
            ps.setInt(4, p.getIdFornecedor());
            ps.setInt(5, p.getQuantidade());
            ps.setDouble(6, p.getPreco());
            ps.execute();
            ps.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao Cadastrar: " + e.getMessage());
            throw new RuntimeException();
        }
    }
     public Produto buscarporid(Integer id) {
        Produto produto = null;
        String sql = "select * from produto where id = ? limit 1";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                produto = preencherProduto(rs);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar: " + e.getMessage());
            throw new RuntimeException();
        }
        return produto;
    }

    public ArrayList<Produto> buscarTodos() {
        ArrayList<Produto> listaProduto = new ArrayList<>();
        String sql = "select * from produto order by id";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Produto c = preencherProduto(rs);
                listaProduto.add(c);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar: " + e.getMessage());
            throw new RuntimeException();
        }
        return listaProduto;
    }

    private Produto preencherProduto(ResultSet rs) throws SQLException {
        int id= rs.getInt("id");
        String marca = rs.getString("marca");
        String modelo = rs.getString("modelo");
        int numeracao = rs.getInt("numeracao");
        int id_fornecedor = rs.getInt("id_fornecedor");
        int quantidade = rs.getInt("quantidade");
        double preco = rs.getDouble("preco");
        Produto p = new Produto(id, marca, modelo, numeracao, id_fornecedor, quantidade, preco);
        return p;
    }

    public void atualizar(Produto p) {
        String sql = "update produto set marca=?, modelo=?, numeracao=?,id_fornecedor=?,quantidade=?,preco=? where id=?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(7, p.getId());
           ps.setString(1, p.getMarca());
            ps.setString(2, p.getModelo());
            ps.setInt(3, p.getNumeracao());
            ps.setInt(4, p.getIdFornecedor());
            ps.setInt(5, p.getQuantidade());
            ps.setDouble(6, p.getPreco());;
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao ataualizar: " + e.getMessage());
            throw new RuntimeException();
        }
    }

    public void excluir(Integer id) {
        String sql1 = "SET FOREIGN_KEY_CHECKS=0";
        String sql = "delete from produto where id= ?";
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
    
    public ArrayList<Produto> buscarTodosID(int id) {
        ArrayList<Produto> listaProduto = new ArrayList<>();
        String sql = "select * from produto where id="+id+";";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Produto c = preencherProduto(rs);
                listaProduto.add(c);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar: " + e.getMessage());
            throw new RuntimeException();
        }
        return listaProduto;
    }

public ArrayList<Produto> ordernarPreco() {
        ArrayList<Produto> listaProduto = new ArrayList<>();
        String sql = "SELECT * FROM produto order by preco";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Produto c = preencherProduto(rs);
                listaProduto.add(c);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar: " + e.getMessage());
            throw new RuntimeException();
        }
        return listaProduto;
    }
public ArrayList<Produto> ordernarPrecoDesc() {
        ArrayList<Produto> listaProduto = new ArrayList<>();
        String sql = "SELECT * FROM produto order by preco desc";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Produto c = preencherProduto(rs);
                listaProduto.add(c);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar: " + e.getMessage());
            throw new RuntimeException();
        }
        return listaProduto;
    }
public ArrayList<Produto> buscarTodosMarca(String marca) {
        ArrayList<Produto> listaProduto = new ArrayList<>();
        String sql = "SELECT * FROM produto WHERE marca LIKE '%"+marca+"%';";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Produto c = preencherProduto(rs);
                listaProduto.add(c);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar: " + e.getMessage());
            throw new RuntimeException();
        }
        return listaProduto;
    }
public ArrayList<Produto> buscarTodosModelo(String modelo) {
        ArrayList<Produto> listaProduto = new ArrayList<>();
        String sql ="SELECT * FROM produto WHERE modelo LIKE '%"+modelo+"%';";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Produto c = preencherProduto(rs);
                listaProduto.add(c);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar: " + e.getMessage());
            throw new RuntimeException();
        }
        return listaProduto;
    }

}

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
public class FuncionarioDao {
    
    private Connection connection;

    public FuncionarioDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public boolean cadastrar(Funcionario f) {
        String sql = "insert into funcionario (nome, cpf, senha) "
                + "values (?,?,?)";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, f.getNome());
            ps.setString(2, f.getCpf());
            ps.setString(3, f.getSenha());
            ps.execute();
            ps.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao Cadastrar: " + e.getMessage());
            throw new RuntimeException();
        }
    }
     public Funcionario buscarporid(Integer id) {
        Funcionario cliente = null;
        String sql = "select * from funcionario where id = ? limit 1";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cliente = preencherFuncionario(rs);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar: " + e.getMessage());
            throw new RuntimeException();
        }
        return cliente;
    }

    public ArrayList<Funcionario> buscarTodos() {
        ArrayList<Funcionario> listaFuncionario = new ArrayList<>();
        String sql = "select * from funcionario order by id";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Funcionario c = preencherFuncionario(rs);
                listaFuncionario.add(c);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar: " + e.getMessage());
            throw new RuntimeException();
        }
        return listaFuncionario;
    }
public ArrayList<Funcionario> buscarTodosCPF(String cpf) {
        ArrayList<Funcionario> listaFuncionario = new ArrayList<>();
        String sql = "select * from funcionario where nome='"+cpf+"';";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Funcionario c = preencherFuncionario(rs);
                listaFuncionario.add(c);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar: " + e.getMessage());
            throw new RuntimeException();
        }
        return listaFuncionario;
    }
public ArrayList<Funcionario> buscarTodosId(int id) {
        ArrayList<Funcionario> listaFuncionario = new ArrayList<>();
        String sql = "select * from funcionario where id="+id+";";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Funcionario c = preencherFuncionario(rs);
                listaFuncionario.add(c);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar: " + e.getMessage());
            throw new RuntimeException();
        }
        return listaFuncionario;
    }
    private Funcionario preencherFuncionario(ResultSet rs) throws SQLException {
        int id= rs.getInt("id");
        String nome = rs.getString("nome");
        String cpf = rs.getString("cpf");
        String senha = rs.getString("senha");
        Funcionario c = new Funcionario(id, nome, cpf, senha);
        return c;
    }

    public void atualizar(Funcionario c) {
        String sql = "update funcionario set nome=?, cpf=?, senha=? where id=?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(4, c.getId());
            ps.setString(1, c.getNome());
            ps.setString(2, c.getCpf());
            ps.setString(3, c.getSenha());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao ataualizar: " + e.getMessage());
            throw new RuntimeException();
        }
    }

    public Funcionario login(String cpf, String senha) {
        Funcionario funcionario = null;
        String sql = "select * from funcionario where cpf='" + cpf + "' and senha='" + senha + "' limit 1";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                funcionario = preencherFuncionario(rs);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar: " + e.getMessage());
            throw new RuntimeException();
        }
        return funcionario;
    }

    public void excluir(Integer id) {
        String sql1 = "SET FOREIGN_KEY_CHECKS=0";
        String sql = "delete from funcionario where id= ?";
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

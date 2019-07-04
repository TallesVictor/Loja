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
public class AvaliacaoDao {

    private Connection connection;

    public AvaliacaoDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public boolean cadastrar(Avaliacao a) {
        String sql = "insert into avaliacao(nota, id_produto, opniao, tipo, id_cliente) "
                + "values (?,?,?,?,?)";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, a.getNota());
            ps.setInt(2, a.getIdProduto());
            ps.setString(3, a.getOpniao());
            ps.setString(4, a.getTipo());
            ps.setString(5, a.getIdCliente());
            ps.execute();
            ps.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao Cadastrar: " + e.getMessage());
            throw new RuntimeException();
        }
    }

    public ArrayList<Avaliacao> buscarNota1() {
        ArrayList<Avaliacao> listaAvaliacao = new ArrayList<>();
        String sql = "select * from avaliacao order by nota";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Avaliacao p = preencherAvaliacao(rs);
                listaAvaliacao.add(p);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar: " + e.getMessage());
            throw new RuntimeException();
        }
        return listaAvaliacao;
    }

    public ArrayList<Avaliacao> buscarNota2() {
        ArrayList<Avaliacao> listaAvaliacao = new ArrayList<>();
        String sql = "select * from avaliacao order by nota desc";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Avaliacao p = preencherAvaliacao(rs);
                listaAvaliacao.add(p);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar: " + e.getMessage());
            throw new RuntimeException();
        }
        return listaAvaliacao;
    }

    public ArrayList<Avaliacao> buscarTipo1() {
        ArrayList<Avaliacao> listaAvaliacao = new ArrayList<>();
        String sql = "select * from avaliacao where tipo= 'Atendimento'";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Avaliacao p = preencherAvaliacao(rs);
                listaAvaliacao.add(p);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar: " + e.getMessage());
            throw new RuntimeException();
        }
        return listaAvaliacao;
    }

    public ArrayList<Avaliacao> buscarTipo2() {
        ArrayList<Avaliacao> listaAvaliacao = new ArrayList<>();
        String sql = "select * from avaliacao where tipo= 'Entrega'";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Avaliacao p = preencherAvaliacao(rs);
                listaAvaliacao.add(p);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar: " + e.getMessage());
            throw new RuntimeException();
        }
        return listaAvaliacao;
    }

    private Avaliacao preencherAvaliacao(ResultSet rs) throws SQLException {
        Integer id = rs.getInt("id");
        int nota = rs.getInt("nota");
        int id_produto = rs.getInt("id_produto");
        String opniao = rs.getString("opniao");
        String tipo = rs.getString("tipo");
        String id_cliente = rs.getString("id_cliente");
        Avaliacao a = new Avaliacao(id, nota, id_produto, opniao, tipo, id_cliente);
        return a;
    }

}

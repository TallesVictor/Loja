/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Venda;
import Model.VendaDao;
import java.util.ArrayList;

/**
 *
 * @author Dcxz
 */
public class VendaController {
    VendaDao dao;
      
    public ArrayList<Venda> buscarTodos() {
        dao = new VendaDao();
        return dao.buscarTodos();
    }
    public boolean Cadastrar(Venda f) {
        dao = new VendaDao();
        return dao.cadastrar(f);
    }
    public Venda buscaID(int id) {
        dao = new VendaDao();
        return dao.buscarporid(id);
    }

    public void atualizarVenda(Venda f) {
        dao = new VendaDao();
        dao.atualizar(f);
    }

    public void excluirVenda(Integer id) {
        dao = new VendaDao();
        dao.excluir(id);
    }
    
    public ArrayList<Venda> buscarTodosIDP(int id) {
        dao = new VendaDao();
        return dao.buscarTodosIdProduto(id);
    }
    public ArrayList<Venda> buscarTodosIDF(int id) {
        dao = new VendaDao();
        return dao.buscarTodosIdFun(id);
    }
    public ArrayList<Venda> buscarTodosDT(String data) {
        dao = new VendaDao();
        return dao.buscarTodosData(data);
    }
    public ArrayList<Venda> maior() {
        dao = new VendaDao();
        return dao.ordernarMaior();
    }
    public ArrayList<Venda> menor() {
        dao = new VendaDao();
        return dao.ordernarMenor();
    }
}

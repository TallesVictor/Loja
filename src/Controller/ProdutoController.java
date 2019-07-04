/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Model.Produto;
import Model.ProdutoDao;
import java.util.ArrayList;

/**
 *
 * @author Dcxz
 */
public class ProdutoController {
    ProdutoDao dao;
    public ArrayList<Produto> buscarTodos() {
        dao = new ProdutoDao();
        return dao.buscarTodos();
    }
    public boolean Cadastrar(Produto p) {
        dao = new ProdutoDao();
        return dao.cadastrar(p);
    }
    public Produto buscaID(int id) {
        dao = new ProdutoDao();
        return dao.buscarporid(id);
    }

    public void atualizarProduto(Produto p) {
        dao = new ProdutoDao();
        dao.atualizar(p);
    }

    public void excluirProduto(Integer id) {
        dao = new ProdutoDao();
        dao.excluir(id);
    }
    public ArrayList<Produto> buscarTodosID(int id) {
        dao = new ProdutoDao();
        return dao.buscarTodosID(id);
    
    }public ArrayList<Produto> buscarTodosModelo(String x) {
        dao = new ProdutoDao();
        return dao.buscarTodosModelo(x);
    }public ArrayList<Produto> buscarTodosMarca(String x) {
        dao = new ProdutoDao();
        return dao.buscarTodosMarca(x);
    }
    
    public ArrayList<Produto> ordenarPrecoAsc() {
        dao = new ProdutoDao();
        return dao.ordernarPreco();
    }
    public ArrayList<Produto> ordernarPrecoDesc() {
        dao = new ProdutoDao();
        return dao.ordernarPrecoDesc();
    }
}

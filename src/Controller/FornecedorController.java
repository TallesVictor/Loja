/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Fornecedor;
import Model.FornecedorDao;
import java.util.ArrayList;

/**
 *
 * @author Dcxz
 */
public class FornecedorController {
     FornecedorDao dao;
    
    public ArrayList<Fornecedor> buscarTodos() {
        dao = new FornecedorDao();
        return dao.buscarTodos();
    }
    public boolean Cadastrar(Fornecedor f) {
        dao = new FornecedorDao();
        return dao.cadastrar(f);
    }
    public Fornecedor buscaID(int id) {
        dao = new FornecedorDao();
        return dao.buscarporid(id);
    }

    public void atualizarFornecedor(Fornecedor f) {
        dao = new FornecedorDao();
        dao.atualizar(f);
    }

    public void excluirFornecedor(Integer id) {
        dao = new FornecedorDao();
        dao.excluir(id);
    }
}

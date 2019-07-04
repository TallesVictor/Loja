/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Cliente;
import Model.ClienteDao;
import java.util.ArrayList;

/**
 *
 * @author Dcxz
 */
public class ClienteController {
    ClienteDao dao;
    
    public ArrayList<Cliente> buscarTodos() {
        dao = new ClienteDao();
        return dao.buscarTodos();
    }
    public boolean Cadastrar(Cliente f) {
        dao = new ClienteDao();
        return dao.cadastrar(f);
    }
    public Cliente buscaID(int id) {
        dao = new ClienteDao();
        return dao.buscarporid(id);
    }

    public void atualizarCliente(Cliente f) {
        dao = new ClienteDao();
        dao.atualizar(f);
    }

    public void excluirCliente(Integer id) {
        dao = new ClienteDao();
        dao.excluir(id);
    }
    
}

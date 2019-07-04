/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Funcionario;
import Model.FuncionarioDao;
import java.util.ArrayList;

/**
 *
 * @author Dcxz
 */
public class FuncionarioController {
    FuncionarioDao dao;
      public ArrayList<Funcionario> buscarTodos() {
        dao = new FuncionarioDao();
        return dao.buscarTodos();
    }
    public boolean Cadastrar(Funcionario f) {
        dao = new FuncionarioDao();
        return dao.cadastrar(f);
    }
     public Funcionario loginCpf(String cpf, String senha) {
        dao = new FuncionarioDao();
        return dao.login(cpf,senha);
    }
    public ArrayList<Funcionario> buscaTodosID(int id) {
        dao = new FuncionarioDao();
        return dao.buscarTodosId(id);
    }
     public Funcionario buscaID(int id) {
        dao = new FuncionarioDao();
        return dao.buscarporid(id);
    }
     public ArrayList<Funcionario> buscarNome(String cpf) {
        dao = new FuncionarioDao();
        return dao.buscarTodosCPF(cpf);
    }

    public void atualizarFuncionario(Funcionario f) {
        dao = new FuncionarioDao();
        dao.atualizar(f);
    }

    public void excluirFuncionario(Integer id) {
        dao = new FuncionarioDao();
        dao.excluir(id);
    }
}

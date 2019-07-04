/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Avaliacao;
import Model.AvaliacaoDao;
import java.util.ArrayList;

/**
 *
 * @author Dcxz
 */
public class AvaliacaoController {
    AvaliacaoDao dao;
    public ArrayList<Avaliacao> buscarNota1() {
        dao = new AvaliacaoDao();
        return dao.buscarNota1();
    }
     public ArrayList<Avaliacao> buscarNota2() {
        dao = new AvaliacaoDao();
        return dao.buscarNota2();
    }
      public ArrayList<Avaliacao> buscarTipo1() {
        dao = new AvaliacaoDao();
        return dao.buscarTipo1();
    }
       public ArrayList<Avaliacao> buscarTipo2() {
        dao = new AvaliacaoDao();
        return dao.buscarTipo2();
    }
    public boolean Cadastrar(Avaliacao a) {
        dao = new AvaliacaoDao();
        return dao.cadastrar(a);
    }
}

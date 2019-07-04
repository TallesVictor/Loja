/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Dcxz
 */
public class Avaliacao {
    private int id;
    private int nota;
    private int idProduto;
    private String opniao;
    private String tipo;
    private String idCliente;

    public Avaliacao(int nota, int idProduto, String opniao, String tipo, String idCliente) {
        this.nota = nota;
        this.idProduto = idProduto;
        this.opniao = opniao;
        this.tipo = tipo;
        this.idCliente = idCliente;
    }

    public Avaliacao(int id, int nota, int idProduto, String opniao, String tipo, String idCliente) {
        this.id = id;
        this.nota = nota;
        this.idProduto = idProduto;
        this.opniao = opniao;
        this.tipo = tipo;
        this.idCliente = idCliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getOpniao() {
        return opniao;
    }

    public void setOpniao(String opniao) {
        this.opniao = opniao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }
    
}

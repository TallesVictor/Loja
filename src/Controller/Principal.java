/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.TelaInicio;
import View.TelaLogin;

/**
 *
 -Esquecer senha
 * @author Edu
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        mostrarLogin();
    }
    public static void mostrarLogin(){
         TelaInicio tl = new TelaInicio();
        tl.setResizable(false);
        tl.setTitle("Inicio");
        tl.setLocationRelativeTo(null);
        tl.setVisible(true);
        tl.setVisible(true);
    }
}

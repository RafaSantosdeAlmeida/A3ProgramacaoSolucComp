/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prototipojogo2048;

import java.util.Arrays;

/**
 *
 * @author marco
 */
public class Jogo2048 {
    public static void main(String[] args) {
        Tabuleiro tab = new Tabuleiro(4,4);
        TelaPrincipalDoJogo telaPrincipal = new TelaPrincipalDoJogo();

        while (true) {
            telaPrincipal.alterarMatriz(tab.matrizTabuleiro);
            telaPrincipal.setVisible(true);
            tab.novaJogada();
            tab.gerarNovo2();
        }
    }
}


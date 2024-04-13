/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prototipojogo2048;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author marco
 */
public class Tabuleiro {
    int[][] matrizTabuleiro;
    int nLinhas, nColunas;
    
    public Tabuleiro(int nLinhas, int nColunas){    //CONSTRUTOR
        this.matrizTabuleiro = new int[nLinhas][nColunas];
        this.nLinhas = nLinhas;
        this.nColunas = nColunas;
        
        System.out.println("Botoes do jogo: \nCIMA\tESQUERDA\tBAIXO\tDIREITA\nW\tA\tS\tD\n");
        
        //GERA dois novos elementos no inicio
        for (int i = 0; i < 2; i++) {
            gerarNovo2();
        }
    }
    
    
    public void novaJogada(){   //REALIZA O CALCULO DAS JOGADAS
        
        Scanner teclado = new Scanner(System.in);
        
        char movimento;
        boolean flagBloqueado=false;    //DIZ se existe um elemento entre dois que bloqueia a soma deles
        
        System.out.print("Digite o seu movimento(w a s d): ");
        movimento = teclado.nextLine().charAt(0);
        
        //ATENÇÃO NÃO MEXA AQUI
        switch(movimento){      //ITERA de cima para baixo
            case 'w':
                
                for (int linhaMatriz = 0; linhaMatriz < matrizTabuleiro.length; linhaMatriz++) {
                    for (int colunaMatriz = 0; colunaMatriz < matrizTabuleiro[linhaMatriz].length; colunaMatriz++) {
                        for (int elementosBaixo = linhaMatriz+1; elementosBaixo < matrizTabuleiro.length; elementosBaixo++) {
                            if((matrizTabuleiro[linhaMatriz][colunaMatriz]==matrizTabuleiro[elementosBaixo][colunaMatriz]) & (flagBloqueado==false)){
                                matrizTabuleiro[linhaMatriz][colunaMatriz]+=matrizTabuleiro[elementosBaixo][colunaMatriz];
                                matrizTabuleiro[elementosBaixo][colunaMatriz]=0;
                            }
                            else if ((matrizTabuleiro[linhaMatriz][colunaMatriz]==0) & (flagBloqueado==false)) {
                                matrizTabuleiro[linhaMatriz][colunaMatriz]+=matrizTabuleiro[elementosBaixo][colunaMatriz];
                                matrizTabuleiro[elementosBaixo][colunaMatriz]=0;
                            }
                            else if((matrizTabuleiro[elementosBaixo][colunaMatriz]==0) & (flagBloqueado==false)){
                                //flagBloqueado = flagBloqueado;
                            }
                            else{
                                flagBloqueado = true;
                            }
                        }
                        flagBloqueado = false;
                    }
                }
                break;
                
            case 'a':       //ITERA da esquerda para direita
                
                for (int linhaMatriz = 0; linhaMatriz < matrizTabuleiro.length; linhaMatriz++) {
                    for (int colunaMatriz = 0; colunaMatriz < matrizTabuleiro[linhaMatriz].length; colunaMatriz++) {
                        for (int elementoDireita = colunaMatriz+1; elementoDireita < matrizTabuleiro[linhaMatriz].length; elementoDireita++) {
                            if((matrizTabuleiro[linhaMatriz][colunaMatriz]==matrizTabuleiro[linhaMatriz][elementoDireita]) & (flagBloqueado==false)){
                                matrizTabuleiro[linhaMatriz][colunaMatriz]+=matrizTabuleiro[linhaMatriz][elementoDireita];
                                matrizTabuleiro[linhaMatriz][elementoDireita]=0;
                            }
                            else if((matrizTabuleiro[linhaMatriz][colunaMatriz]==0) & (flagBloqueado==false)){
                                matrizTabuleiro[linhaMatriz][colunaMatriz]+=matrizTabuleiro[linhaMatriz][elementoDireita];
                                matrizTabuleiro[linhaMatriz][elementoDireita]=0;
                            }
                            else if((matrizTabuleiro[linhaMatriz][elementoDireita]==0) & (flagBloqueado==false)){
                                //flagBloqueado=flagBloqueado;
                            }
                            else {
                                flagBloqueado = true;
                            }
                        }
                        flagBloqueado = false;
                    }
                }
                break;
                
            case 's':       //ITERA de baixo para cima
                
                for (int linhaMatriz =  matrizTabuleiro.length-1; linhaMatriz >= 0; linhaMatriz-=1) {
                    for (int colunaMatriz = 0; colunaMatriz < matrizTabuleiro[linhaMatriz].length; colunaMatriz++) {
                        for (int elementoCima = linhaMatriz-1; elementoCima >= 0; elementoCima-=1) {
                            if((matrizTabuleiro[linhaMatriz][colunaMatriz]==matrizTabuleiro[elementoCima][colunaMatriz]) & (flagBloqueado==false)){
                                matrizTabuleiro[linhaMatriz][colunaMatriz]+=matrizTabuleiro[elementoCima][colunaMatriz];
                                matrizTabuleiro[elementoCima][colunaMatriz]=0;
                            }
                            else if ((matrizTabuleiro[linhaMatriz][colunaMatriz]==0) & (flagBloqueado==false)) {
                                matrizTabuleiro[linhaMatriz][colunaMatriz]+=matrizTabuleiro[elementoCima][colunaMatriz];
                                matrizTabuleiro[elementoCima][colunaMatriz]=0;
                            }
                            else if((matrizTabuleiro[elementoCima][colunaMatriz]==0) & (flagBloqueado==false)){
                                //flagBloqueado = flagBloqueado;
                            }
                            else{
                                flagBloqueado = true;
                            }
                        }
                        flagBloqueado = false;
                    }
                }
                break;
                
            case 'd':       //ITERA da direita para esquerda
                
                for (int linhaMatriz = 0; linhaMatriz < matrizTabuleiro.length; linhaMatriz++) {
                    for (int colunaMatriz = matrizTabuleiro[linhaMatriz].length-1; colunaMatriz >= 0; colunaMatriz--) {
                        for (int elementoEsquerda = colunaMatriz-1; elementoEsquerda >= 0; elementoEsquerda--) {
                            if((matrizTabuleiro[linhaMatriz][colunaMatriz]==matrizTabuleiro[linhaMatriz][elementoEsquerda])&(flagBloqueado==false)){
                                matrizTabuleiro[linhaMatriz][colunaMatriz]+=matrizTabuleiro[linhaMatriz][elementoEsquerda];
                                matrizTabuleiro[linhaMatriz][elementoEsquerda]=0;
                            }
                            else if((matrizTabuleiro[linhaMatriz][colunaMatriz]==0) & (flagBloqueado==false)){
                                matrizTabuleiro[linhaMatriz][colunaMatriz]+=matrizTabuleiro[linhaMatriz][elementoEsquerda];
                                matrizTabuleiro[linhaMatriz][elementoEsquerda]=0;
                            }
                            else if((matrizTabuleiro[linhaMatriz][elementoEsquerda]==0) & (flagBloqueado==false)){
                                //flagBloqueado = flagBloqueado;
                            }
                            else{
                                flagBloqueado = true;
                            }
                        }
                        flagBloqueado = false;
                    }
                }
        }
    }
    
    public void gerarNovo2(){
        
        Random gerador = new Random();
        
        int linhaDo2;
        int colunaDo2;
        
        do
        {
        linhaDo2 = gerador.nextInt(nLinhas);
        colunaDo2 = gerador.nextInt(nColunas);
        }
        while(matrizTabuleiro[linhaDo2][colunaDo2]!=0);
        
        matrizTabuleiro[linhaDo2][colunaDo2] = 2;
        
    }
    
    public void tabToString(){
        for (int linha = 0; linha < matrizTabuleiro.length; linha++) {
            System.out.println(Arrays.toString(matrizTabuleiro[linha]));
        }
    }
    
}

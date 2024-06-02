/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogo2048;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author marco
 */
public class Tabuleiro {
    private int[][] matrizTabuleiro;
    private Elemento[][] matrizElemento;
    private int nLinhas, nColunas, score;
    
    public void somaScore(int valorSoma){
        score += valorSoma;
    }
    
    public int getScore() {
        return score;
    }


    public Tabuleiro(int nLinhas, int nColunas, int nBloqueios){    //CONSTRUTOR
        this.matrizTabuleiro = new int[nLinhas][nColunas];
        this.matrizElemento = new Elemento[nLinhas][nColunas];
        this.nLinhas = nLinhas;
        this.nColunas = nColunas;
        this.score = 0;
        
        
        for (int linha = 0; linha < this.matrizElemento.length; linha++) {
            for (int coluna = 0; coluna < this.matrizElemento[linha].length; coluna++) {
                this.matrizElemento[linha][coluna] = new Elemento();
            }
        }
        
        //Gera dois novo bloqueio
        for (int i = 0; i < nBloqueios; i++) {
            gerarBloqueio();
        }
        
        //CRIAR objetos Elemento na matriz
        
        System.out.println("Botoes do jogo: \nCIMA\tESQUERDA\tBAIXO\tDIREITA\nW\tA\tS\tD\n");
        
        //GERA dois novos elementos no inicio
        for (int i = 0; i < 2; i++) {
            gerarNovo2();
        }
    }
    
    
    
    
    public void moverCima(){
        boolean flagBloqueado=false;    //DIZ se existe um elemento entre dois que bloqueia a soma deles
    
        for (int linhaMatriz = 0; linhaMatriz < matrizTabuleiro.length; linhaMatriz++) {
                    for (int colunaMatriz = 0; colunaMatriz < matrizTabuleiro[linhaMatriz].length; colunaMatriz++) {
                        for (int elementosBaixo = linhaMatriz+1; elementosBaixo < matrizTabuleiro.length; elementosBaixo++) {
                            //Bloco de Bloqueio
                            if(this.matrizElemento[linhaMatriz][colunaMatriz].isBloqueado()||
                               this.matrizElemento[elementosBaixo][colunaMatriz].isBloqueado()){
                                flagBloqueado = true;
                            }
                            
                            
                            if((matrizTabuleiro[linhaMatriz][colunaMatriz]==matrizTabuleiro[elementosBaixo][colunaMatriz]) & (flagBloqueado==false)){
                                matrizTabuleiro[linhaMatriz][colunaMatriz]+=matrizTabuleiro[elementosBaixo][colunaMatriz];
                                somaScore(matrizTabuleiro[linhaMatriz][colunaMatriz]); // Atualiza o score
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
    
    }
    

    public void moverEsquerda(){
        boolean flagBloqueado=false;    //DIZ se existe um elemento entre dois que bloqueia a soma deles
        
        for (int linhaMatriz = 0; linhaMatriz < matrizTabuleiro.length; linhaMatriz++) {
                    for (int colunaMatriz = 0; colunaMatriz < matrizTabuleiro[linhaMatriz].length; colunaMatriz++) {
                        for (int elementoDireita = colunaMatriz+1; elementoDireita < matrizTabuleiro[linhaMatriz].length; elementoDireita++) {
                            //Bloco de Bloqueio
                            if(this.matrizElemento[linhaMatriz][colunaMatriz].isBloqueado()||
                               this.matrizElemento[linhaMatriz][elementoDireita].isBloqueado()){
                                flagBloqueado = true;
                            }
                            
                            if((matrizTabuleiro[linhaMatriz][colunaMatriz]==matrizTabuleiro[linhaMatriz][elementoDireita]) & (flagBloqueado==false)){
                                matrizTabuleiro[linhaMatriz][colunaMatriz]+=matrizTabuleiro[linhaMatriz][elementoDireita];
                                somaScore(matrizTabuleiro[linhaMatriz][colunaMatriz]); // Atualiza o score
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
    }
    
    
    public void moverBaixo(){
        boolean flagBloqueado=false;    //DIZ se existe um elemento entre dois que bloqueia a soma deles
        
        for (int linhaMatriz =  matrizTabuleiro.length-1; linhaMatriz >= 0; linhaMatriz-=1) {
                    for (int colunaMatriz = 0; colunaMatriz < matrizTabuleiro[linhaMatriz].length; colunaMatriz++) {
                        for (int elementoCima = linhaMatriz-1; elementoCima >= 0; elementoCima-=1) {
                            //Bloco de Bloqueio
                            if(this.matrizElemento[linhaMatriz][colunaMatriz].isBloqueado()||
                               this.matrizElemento[elementoCima][colunaMatriz].isBloqueado()){
                                flagBloqueado = true;
                            }
                            
                            if((matrizTabuleiro[linhaMatriz][colunaMatriz]==matrizTabuleiro[elementoCima][colunaMatriz]) & (flagBloqueado==false)){
                                matrizTabuleiro[linhaMatriz][colunaMatriz]+=matrizTabuleiro[elementoCima][colunaMatriz];
                                somaScore(matrizTabuleiro[linhaMatriz][colunaMatriz]); // Atualiza o score
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
    }
    
    
    public void moverDireita(){
        boolean flagBloqueado=false;    //DIZ se existe um elemento entre dois que bloqueia a soma deles
        
        for (int linhaMatriz = 0; linhaMatriz < matrizTabuleiro.length; linhaMatriz++) {
                    for (int colunaMatriz = matrizTabuleiro[linhaMatriz].length-1; colunaMatriz >= 0; colunaMatriz--) {
                        for (int elementoEsquerda = colunaMatriz-1; elementoEsquerda >= 0; elementoEsquerda--) {
                            //Bloco de Bloqueio
                            if(this.matrizElemento[linhaMatriz][colunaMatriz].isBloqueado()||
                               this.matrizElemento[linhaMatriz][elementoEsquerda].isBloqueado()){
                                flagBloqueado = true;
                            }
                            
                            if((matrizTabuleiro[linhaMatriz][colunaMatriz]==matrizTabuleiro[linhaMatriz][elementoEsquerda])&(flagBloqueado==false)){
                                matrizTabuleiro[linhaMatriz][colunaMatriz]+=matrizTabuleiro[linhaMatriz][elementoEsquerda];
                                somaScore(matrizTabuleiro[linhaMatriz][colunaMatriz]); // Atualiza o score
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
    
    
    public void gerarBloqueio(){
        Random gerador = new Random();
        
        int linhaBloqueio;
        int colunaBloqueio;
        
        do{
            linhaBloqueio = gerador.nextInt(nLinhas);
            colunaBloqueio = gerador.nextInt(nColunas);
        }while(this.matrizElemento[linhaBloqueio][colunaBloqueio].isBloqueado());
        this.matrizElemento[linhaBloqueio][colunaBloqueio] = new Bloqueio();
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
        while(matrizTabuleiro[linhaDo2][colunaDo2]!=0 || matrizElemento[linhaDo2][colunaDo2].isBloqueado());
        
        matrizTabuleiro[linhaDo2][colunaDo2] = 2;
        
    }
    
    public void tabToString(){
        for (int linha = 0; linha < matrizTabuleiro.length; linha++) {
            System.out.println(Arrays.toString(matrizTabuleiro[linha]));
        }
    }
    
    
    public void setElementos(){
        for (int linha = 0; linha < matrizElemento.length; linha++) {
            for (int coluna = 0; coluna < matrizElemento[linha].length; coluna++) {
                this.matrizElemento[linha][coluna].setValor(matrizTabuleiro[linha][coluna]);;
                this.matrizElemento[linha][coluna].setCores();
            }
        }
    }
    
    public Elemento[][] getMatrizElemento(){
        return this.matrizElemento;
    }

    
    public int[][] getMatrizTabuleiro() {
        return matrizTabuleiro;
    }
    
    public boolean isWin(){
        
        for (int[] is : matrizTabuleiro) {
            for (int i : is) {
                if(i>=2048){
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * 
     * @return Retorna true se a matriz não possui mais movimentos possiveis
     */
    public boolean isLose(){
        if((this.isMovEsquerda()==false)&
           (this.isMovCima()==false)&
           (this.isMovDireita()==false)&
           (this.isMovBaixo()==false)){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean isMovEsquerda(){
        
        boolean[][] matrizMov = new boolean[nLinhas][nColunas];
        
        for (int linha = 0; linha < matrizTabuleiro.length; linha++) {
            for (int coluna = matrizTabuleiro[linha].length-1; 0 < coluna; coluna--) {
                
                if(matrizTabuleiro[linha][coluna]==0){
                    matrizMov[linha][coluna]=false;
                }
                else if(((matrizTabuleiro[linha][coluna]==matrizTabuleiro[linha][coluna-1])||
                   (matrizTabuleiro[linha][coluna-1]==0))&(matrizElemento[linha][coluna-1].isBloqueado()==false)){
                    matrizMov[linha][coluna]=true;
                }
                else{
                    matrizMov[linha][coluna]=false;
                }
                
            }
        }
        
        int testador = 0;
        
        for (boolean[] bs : matrizMov) {
            for (boolean b : bs) {
                testador+=(b)?1:0;
            }
        }
        
        return testador>0;
    }
    
    public boolean isMovDireita(){
        
        boolean[][] matrizMov = new boolean[nLinhas][nColunas];
        
        for (int linha = 0; linha < matrizTabuleiro.length; linha++) {
            for (int coluna = 0; coluna < matrizTabuleiro[linha].length-1; coluna++) {
                
                if(matrizTabuleiro[linha][coluna]==0){
                    matrizMov[linha][coluna]=false;
                }
                else if(((matrizTabuleiro[linha][coluna]==matrizTabuleiro[linha][coluna+1])||
                   (matrizTabuleiro[linha][coluna+1]==0))&(matrizElemento[linha][coluna+1].isBloqueado()==false)){
                    matrizMov[linha][coluna]=true;
                }
                else{
                    matrizMov[linha][coluna]=false;
                }
                
            }
        }
        
        int testador = 0;
        
        for (boolean[] bs : matrizMov) {
            for (boolean b : bs) {
                testador+=(b)?1:0;
            }
        }
        
        return testador>0;
    }
    
    public boolean isMovCima(){
        
        boolean[][] matrizMov = new boolean[nLinhas][nColunas];
        
        for (int linha = matrizTabuleiro.length-1; 0 < linha; linha--) {
            for (int coluna = 0; coluna < matrizTabuleiro[linha].length; coluna++) {
                
                if(matrizTabuleiro[linha][coluna]==0){
                    matrizMov[linha][coluna]=false;
                }
                else if(((matrizTabuleiro[linha][coluna]==matrizTabuleiro[linha-1][coluna])||
                   (matrizTabuleiro[linha-1][coluna]==0))&(matrizElemento[linha-1][coluna].isBloqueado()==false)){
                    matrizMov[linha][coluna]=true;
                }
                else{
                    matrizMov[linha][coluna]=false;
                }
                
            }
        }
        
        int testador = 0;
        
        for (boolean[] bs : matrizMov) {
            for (boolean b : bs) {
                testador+=(b)?1:0;
            }
        }
        
        return testador>0;
    }
    
    public boolean isMovBaixo(){
        
        boolean[][] matrizMov = new boolean[nLinhas][nColunas];
        
        for (int linha = 0; linha < matrizTabuleiro.length-1; linha++) {
            for (int coluna = 0; coluna < matrizTabuleiro[linha].length; coluna++) {
                
                if(matrizTabuleiro[linha][coluna]==0){
                    matrizMov[linha][coluna]=false;
                }
                else if(((matrizTabuleiro[linha][coluna]==matrizTabuleiro[linha+1][coluna])||
                   (matrizTabuleiro[linha+1][coluna]==0))&(matrizElemento[linha+1][coluna].isBloqueado()==false)){
                    matrizMov[linha][coluna]=true;
                }
                else{
                    matrizMov[linha][coluna]=false;
                }
                
            }
        }
        
        int testador = 0;
        
        for (boolean[] bs : matrizMov) {
            for (boolean b : bs) {
                testador+=(b)?1:0;
            }
        }
        
        return testador>0;
    }

}
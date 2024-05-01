/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prototipojogo2048;

/**
 *
 * @author marco
 */
public class Elemento {
    private int valorElemento;
    private int[] corQuadrado = new int[3];
    private int[] corTexto = new int[3];
    
    public Elemento(){
        this.valorElemento = 0;
    }
    
    //GERA as cores do quadrado e do texto com base no valor
    public void setCores(){
        //ADICIONAR TODAS AS CORES ATÉ O 2048 PARA RETIRAR ERRO OUT OF INDEX
        int[][] coresQuadrado = {
                                {205,193,180},  //0
                                {238,228,218},  //2
                                {237,224,200},  //4
                                {242,177,121},  //8
                                {245,149,99},   //16
                                {246,124,95},   //32
                                {246,94,59}     //64
                                };
        int[][] coresTexto = {
                             {0,0,0},           //0
                             {119,110,101},     //2
                             {119,110,101},     //4
                             {255,255,255},     //8
                             {255,255,255},     //16
                             {255,255,255},     //32
                             {255,255,255}      //64
                             };
        int indice;

        //Calcula o indice do vetor das cores de acordo com o valor
        if(this.valorElemento!=0){
            indice = (int)Math.round(Math.log(valorElemento) / Math.log(2));    //LOG(base=2,valorElemento)
        }
        else{
            indice = 0;
        }
       
        for (int i = 0; i < this.corQuadrado.length; i++) {
            this.corQuadrado[i] = coresQuadrado[indice][i];     //Altera corQuadrado para a cor certa do valor
            this.corTexto[i] = coresTexto[indice][i];     //Altera corQuadrado para a cor certa do valor
        }
        
    }

    public void setValor(int valorElemento) {
        //if(valorElemento%2 == 0){
            this.valorElemento = valorElemento;
        //}
    }

    public int getValor() {
        return this.valorElemento;
    }

    public int[] getCorQuadrado() {
        return corQuadrado;
    }

    public int[] getCorTexto() {
        return corTexto;
    }
    
    public boolean isBloqueado(){
        return false;
    }
    
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogo2048;

/**
 *
 * @author marco
 */
public class Bloqueio extends Elemento{
    private boolean bloqueio = true;
    
    @Override
    public int getValor() {
        return 0;
    }
    
    @Override
    public int[] getCorQuadrado() {
        int[] cor = {0,0,0};
        return cor;
    }

    @Override
    public int[] getCorTexto() {
        int[] cor = {255,255,255};
        return cor;
    }
    
    @Override
    public boolean isBloqueado(){
        return true;
    }
}

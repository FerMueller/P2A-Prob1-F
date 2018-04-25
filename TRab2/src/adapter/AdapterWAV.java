/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapter;

import problema1.WAVPlayer;
import trab2.FormatoAudio;

/**
 *
 * @author Fernando Mueller
 */
public class AdapterWAV implements FormatoAudio {

    private WAVPlayer audio;
    private String caminho;

    @Override
    public void abrir(String caminho) {
        this.audio = new WAVPlayer(caminho);
        this.caminho = caminho;
    }

    @Override
    public void reproduzir() {
        this.audio.play();
    }

    @Override
    public void pausar() {
        this.audio.stop();
    }

    @Override
    public void parar() {
        this.audio.stop();
        this.abrir(caminho);
    }

    @Override
    public void avancar(int qtdSegundos) {
        this.audio.forward(qtdSegundos);
    }

    @Override
    public void retornar(int qtdSegundos) {
        this.audio.reward(qtdSegundos);
    }

    @Override
    public void liberar() {
        this.audio = null;
    }

    public void reproduzirSimples(String caminho) {
        this.abrir(caminho);
        this.reproduzir();
    }

    public void pararSimples() {
        this.liberar();
    }
}

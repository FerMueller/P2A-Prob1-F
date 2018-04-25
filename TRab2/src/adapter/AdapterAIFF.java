/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapter;

import problema1.AIFFSuperPlayer;
import trab2.FormatoAudio;

/**
 *
 * @author Fernando Mueller
 */
public class AdapterAIFF implements FormatoAudio {

    private AIFFSuperPlayer audio;
    private String caminho;
    boolean tocando;

    @Override
    public void abrir(String caminho) {
        this.audio = new AIFFSuperPlayer(caminho);
        tocando = false;
    }

    @Override
    public void reproduzir() {
        this.audio.play();
        tocando = true;
    }

    @Override
    public void pausar() {
        this.audio.pause();
        tocando = false;
    }

    @Override
    public void parar() {
        this.audio.stop();
        this.audio.setCursor(0);
        tocando = false;
    }

    @Override
    public void avancar(int qtdSegundos) {
        this.audio.setCursor(((AIFFSuperPlayer) (this.audio)).pause() + qtdSegundos);
        if (tocando) {
            this.audio.play();
        }
    }

    @Override
    public void retornar(int qtdSegundos) {
        this.audio.setCursor((this.audio).pause() - qtdSegundos);
        if (tocando) {
            this.audio.play();
        }
    }

    @Override
    public void liberar() {
        this.audio.release();
    }

    public void reproduzirSimples(String caminho) {
        this.abrir(caminho);
        this.reproduzir();
    }

    public void pararSimples() {
        this.parar();
        this.liberar();
    }
}


import problema1.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author josehenrique
 */
public class Manipuladora implements FormatoAudio {

    private Object audio;
    private String caminho;
    TipoDeAudio tipo;

    @Override
    public String toString() {
        return "Manipuladora{" + "audio=" + audio + ", tipo=" + tipo + '}';
    }

    public Manipuladora(String caminho) {
        this.caminho = caminho;
    }

    @Override
    public void abrir(String caminho) {
        String extensao = caminho.split(".")[caminho.split(".").length - 1];

        switch (extensao.toUpperCase()) {
            case "AIFF":
                this.audio = new AIFFSuperPlayer(caminho);
                this.tipo = TipoDeAudio.AIFFSuperPlayer;
                break;
            case "WMA":
                this.audio = new wmaPlay();
                ((wmaPlay) this.audio).setFile(caminho);
                ((wmaPlay) this.audio).open();
                ((wmaPlay) this.audio).setLocation(0);
                this.tipo = TipoDeAudio.wmaPlay;
                break;
            case "WAV":
                this.audio = new WAVPlayer(caminho);
                this.tipo = TipoDeAudio.WAVPlayer;
                break;
        }
    }

    @Override
    public void reproduzir() {
        switch (tipo) {
            case AIFFSuperPlayer:
                break;
            case WAVPlayer:
                break;
            case wmaPlay:
                ((wmaPlay) (this.audio)).play();
                break;
        }
    }

    @Override
    public void pausar() {
        switch (tipo) {
            case AIFFSuperPlayer:
                break;
            case WAVPlayer:
                break;
            case wmaPlay:
                ((wmaPlay) (this.audio)).stop();
                break;
        }
    }

    @Override
    public void parar() {
        switch (tipo) {
            case AIFFSuperPlayer:
                break;
            case WAVPlayer:
                break;
            case wmaPlay:
                ((wmaPlay) (this.audio)).stop();
                ((wmaPlay) (this.audio)).stop();
                break;
        }
    }

    @Override
    public void avancar(int qtdSegundos) {
        switch (tipo) {
            case AIFFSuperPlayer:
                break;
            case WAVPlayer:
                break;
            case wmaPlay:
                ((wmaPlay) (this.audio)).setLocation(((wmaPlay) (this.audio)).getLocation() + qtdSegundos);
                break;
        }
    }

    @Override
    public void retornar(int qtdSegundos) {
        switch (tipo) {
            case AIFFSuperPlayer:
                break;
            case WAVPlayer:
                break;
            case wmaPlay:
                ((wmaPlay) (this.audio)).setLocation(((wmaPlay) (this.audio)).getLocation() - qtdSegundos);
                break;
        }
    }

    @Override
    public void liberar() {
        switch (tipo) {
            case AIFFSuperPlayer:
                break;
            case WAVPlayer:
                break;
            case wmaPlay:
                this.audio = null;
                break;
        }
    }

}

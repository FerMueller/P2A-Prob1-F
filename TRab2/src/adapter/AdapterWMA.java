package adapter;

import problema1.wmaPlay;
import trab2.FormatoAudio;

/**
 *
 * @author Fernando Mueller
 */
public class AdapterWMA implements FormatoAudio {

    wmaPlay audio;

    @Override
    public void abrir(String caminho) {
        this.audio.setFile(caminho);
        this.audio.open();
        this.audio.setLocation(0);
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
        this.audio.stop();
    }

    @Override
    public void avancar(int qtdSegundos) {
        this.audio.setLocation(this.audio.getLocation() + qtdSegundos);
    }

    @Override
    public void retornar(int qtdSegundos) {
        this.audio.setLocation(this.audio.getLocation() - qtdSegundos);
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

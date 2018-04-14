
import java.util.logging.Level;
import java.util.logging.Logger;
import problema1.*;

public class Manipuladora implements FormatoAudio {

    private Object audio;
    private String caminho;
    TipoDeAudio tipo;
    boolean tocando;

    @Override
    public String toString() {
        return "Manipuladora{" + "audio=" + audio + ", tipo=" + tipo + '}';
    }

    @Override
    public void abrir(String caminho) {
        String extensao = caminho.split("\\.")[caminho.split("\\.").length - 1];

        switch (extensao.toUpperCase()) {
            case "AIFF":
                this.audio = new AIFFSuperPlayer(caminho);
                this.tipo = TipoDeAudio.AIFFSuperPlayer;
                tocando = false;
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
            default: {
                try {
                    throw new Exception("O tipo de arquivo informado não é suportado.");
                } catch (Exception ex) {
                    Logger.getLogger(Manipuladora.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        this.caminho = caminho;
    }

    @Override
    public void reproduzir() {
        switch (tipo) {
            case AIFFSuperPlayer:
                ((AIFFSuperPlayer) (this.audio)).play();
                tocando = true;
                break;
            case WAVPlayer:
                ((WAVPlayer) (this.audio)).play();
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
                ((AIFFSuperPlayer) (this.audio)).pause();
                tocando = false;
                break;
            case WAVPlayer:
                ((WAVPlayer) (this.audio)).stop();
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
                ((AIFFSuperPlayer) (this.audio)).stop();
                ((AIFFSuperPlayer) (this.audio)).setCursor(0);
                tocando = false;
                break;
            case WAVPlayer:
                ((WAVPlayer) (this.audio)).stop();
                this.abrir(caminho);
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
                ((AIFFSuperPlayer) (this.audio)).setCursor(((AIFFSuperPlayer) (this.audio)).pause() + qtdSegundos);
                if (tocando) {
                    ((AIFFSuperPlayer) (this.audio)).play();
                }
                break;
            case WAVPlayer:
                ((WAVPlayer) (this.audio)).forward(qtdSegundos);
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
                ((AIFFSuperPlayer) (this.audio)).setCursor(((AIFFSuperPlayer) (this.audio)).pause() - qtdSegundos);
                if (tocando) {
                    ((AIFFSuperPlayer) (this.audio)).play();
                }
                break;
            case WAVPlayer:
                ((WAVPlayer) (this.audio)).reward(qtdSegundos);
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
                ((AIFFSuperPlayer) (this.audio)).release();
                break;
            case WAVPlayer:
                this.audio = null;
                break;
            case wmaPlay:
                this.audio = null;
                break;
        }
    }

    public void reproduzirSimples(String caminho) {
        this.abrir(caminho);
        this.reproduzir();
    }

    public void pararSimples() {
        if (this.tipo != TipoDeAudio.AIFFSuperPlayer) {
            this.parar();
        }
        this.liberar();
    }

}

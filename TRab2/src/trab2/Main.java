
import factory.AudioFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import trab2.FormatoAudio;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author josehenrique
 */
public class Main {

    public static void main(String[] args) throws Exception {

        FormatoAudio fa = (FormatoAudio) AudioFactory.getAudioPorFormato("teste.wma");
        fa.abrir("sdadsadsa");

        FormatoAudio mp3 = AudioFactory.getAudioPorFormato(".MP3");

        Manipuladora wav = new Manipuladora();
        Manipuladora aiff = new Manipuladora();
        Manipuladora wma = new Manipuladora();

//        wav.abrir("asd.WAV");
//        aiff.abrir("asd.AIFF");
        mp3.abrir("asd.WMA");

//        wav.reproduzir();
//        aiff.reproduzir();
        mp3.reproduzir();

//        wav.avancar(10);
//          aiff.avancar(10);
        mp3.avancar(10);

//        wav.pausar();
//        aiff.pausar();
        mp3.pausar();

//        wav.reproduzir();
//        aiff.reproduzir();
        mp3.reproduzir();

//        wav.retornar(10);
//        aiff.retornar(10);
        mp3.retornar(10);

//        wav.pausar();
//        aiff.pausar();
        mp3.pausar();

//        wav.reproduzir();
//        aiff.reproduzir();
        mp3.reproduzir();

//        wav.parar();
//        aiff.parar();
        mp3.parar();

//        wav.liberar();
//        aiff.liberar();
        mp3.liberar();

        mp3.reproduzirSimples("aaa.WAV");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        wav.pararSimples();
    }
}


import java.util.logging.Level;
import java.util.logging.Logger;

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

    public static void main(String[] args) {
        Manipuladora wav = new Manipuladora();
        Manipuladora aiff = new Manipuladora();
        Manipuladora wma = new Manipuladora();

//        wav.abrir("asd.WAV");
//        aiff.abrir("asd.AIFF");
        wma.abrir("asd.WMA");

//        wav.reproduzir();
//        aiff.reproduzir();
        wma.reproduzir();
        
//        wav.avancar(10);
//          aiff.avancar(10);
        wma.avancar(10);
        
//        wav.pausar();
//        aiff.pausar();
        wma.pausar();

//        wav.reproduzir();
//        aiff.reproduzir();
        wma.reproduzir();
        
//        wav.retornar(10);
//        aiff.retornar(10);
        wma.retornar(10);
        
//        wav.pausar();
//        aiff.pausar();
        wma.pausar();

//        wav.reproduzir();
//        aiff.reproduzir();
        wma.reproduzir();
        
//        wav.parar();
//        aiff.parar();
        wma.parar();
        
//        wav.liberar();
//        aiff.liberar();
        wma.liberar();
        
        
        wav.reproduzirSimples("aaa.WAV");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        wav.pararSimples();
    }
}

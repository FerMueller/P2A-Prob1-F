package factory;

import adapter.AdapterAAC;
import adapter.AdapterAIFF;
import adapter.AdapterMP3;
import adapter.AdapterWAV;
import adapter.AdapterWMA;
import trab2.FormatoAudio;

/**
 *
 * @author Fernando Mueller
 */
public abstract class AudioFactory {
    
        public static FormatoAudio getAudioPorFormato(String arquivo) throws Exception {
        //Pegar a extensão do arquivo e verificar qual classe retornar
        String[] ocorrencias = arquivo.split("[.]");
        String extensao = ocorrencias[ocorrencias.length - 1];

        switch (extensao) {
            case "aac":
                return new AdapterAAC();
            case "aiff":
                return new AdapterAIFF();
            case "mp3":
                return new AdapterMP3();
            case "wav":
                return new AdapterWAV();
            case "wma":
                return new AdapterWMA();
            default:
                throw new Exception("Erro");
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author josehenrique
 */
public interface FormatoAudio {

    public abstract void abrir(String caminho);

    public abstract void reproduzir();

    public abstract void pausar();

    public abstract void parar();

    public abstract void avancar(int qtdSegundos);

    public abstract void retornar(int qtdSegundos);

    public abstract void liberar();

}

package br.ufg.inf.fabrica.servicos.util;

/**
 *
 * @author Danillo
 */
public class UtilsServicos {

    private UtilsServicos() {

    }

    public static String getVariavelDeAmbiente(String nomeVariavelAmbiente) {
        return System.getenv().get(nomeVariavelAmbiente);
    }

}

package br.ufg.inf.fabrica.pac.persistencia.util;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Danillo
 */
public class UtilPersistencia {

    private UtilPersistencia() {

    }

    public static void registraLogException(Exception ex){
        Logger.getLogger(UtilPersistencia.class.getName()).
                    log(Level.INFO, ex.getMessage());
    }
}

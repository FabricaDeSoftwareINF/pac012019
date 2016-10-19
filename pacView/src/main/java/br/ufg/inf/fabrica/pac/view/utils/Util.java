package br.ufg.inf.fabrica.pac.view.utils;

import javax.faces.context.FacesContext;

/**
 *
 * @author Danillo
 */
public class Util {

    private Util(){
        
    }
    
    public static <T> T getSessioanBean(Class klass){
        return (T) FacesContext.getCurrentInstance().getExternalContext().
                getSessionMap().get(klass.getSimpleName());
    }
    
}

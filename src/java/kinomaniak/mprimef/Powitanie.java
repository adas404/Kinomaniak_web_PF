/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kinomaniak.mprimef;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Adam
 */
public class Powitanie {

    /**
     * Creates a new instance of Powitanie
     */
   
    public void init(){
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Cośtam", "Witamy w naszym serwisie do obsługi Parku Rozrywki KinomaniakEE"));
    }
    
}

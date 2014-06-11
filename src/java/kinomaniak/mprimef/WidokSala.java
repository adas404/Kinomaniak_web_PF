/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kinomaniak.mprimef;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;
import javax.ws.rs.Produces;
import kinomaniak.beans.Res;
import kinomaniak.controllers.BeanManager;
import org.jboss.logging.Property;

/**
 *
 * @author Adam
 */
@ManagedBean
public class WidokSala {
    private int idshow;

    public int getIdshow() {
        return idshow;
    }

    public void setIdshow(int idshow) {
        this.idshow = idshow;
    }
    @ManagedProperty("#{beanManager}")
    private BeanManager beanManager;

    public BeanManager getBeanManager() {
        return beanManager;
    }

    public void setBeanManager(BeanManager beanManager) {
        this.beanManager = beanManager;
    }
    
    public String doSali(int id){
        idshow = id;
        return "sala";
    }

    @PostConstruct
    public void init(){
        selectedOption = new ArrayList<Integer>();
        selectedOption = beanManager.getResSeats(idshow);
         System.out.println(idshow);

    }
    /**
     * Creates a new instance of WidokSala
     */
    public List<Integer> getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(List<Integer> selectedOption) {
        this.selectedOption = selectedOption;
    }
  
    
    List<Integer> selectedOption; 
    public void ustawZaznaczone(){

        selectedOption.add(idshow);
       
    }
    public WidokSala(){
    
}
    
}
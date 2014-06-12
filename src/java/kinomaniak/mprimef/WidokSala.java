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
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
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


    public void setUkrytyprzycisk(ArrayList<Integer> ukrytyprzycisk) {
        this.ukrytyprzycisk = ukrytyprzycisk;
    }
    private List<Integer> ukrytyprzycisk;

    public List<Integer> getUkrytyprzycisk() {
        return ukrytyprzycisk;
    }

    public void setUkrytyprzycisk(List<Integer> ukrytyprzycisk) {
        this.ukrytyprzycisk = ukrytyprzycisk;
    }

    public List<Integer> getWrocukryty() {
        return wrocukryty;
    }

    public void setWrocukryty(List<Integer> wrocukryty) {
        this.wrocukryty = wrocukryty;
    }
    private List<Integer> wrocukryty;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    private int id;

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
    
    public boolean czyNaLiscie(int miejsce){
        for (int i=0;i<selectedOption.size();i++)
            if(miejsce == selectedOption.get(i))
                return true;
        return false;
    }
   
    public void wyswietlPrzekazane(){
        System.out.println(selectedOption);
    }

    public String getPassedParameter() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        this.passedParameter = (String) facesContext.getExternalContext().
                getRequestParameterMap().get("id");
        return this.passedParameter;
    }

    public void setPassedParameter(String passedParameter) {
        this.passedParameter = passedParameter;
    }
    private String passedParameter;
    
    public void sprzedaj(){
        //System.out.println(this.wrocukryty.get(0));
        System.out.println(this.selectedOption.get(0));
        //problem z ID seansu!
        //this.beanManager.getReservation(this.selectedOption, Integer.parseInt(this.passedParameter));
    }
    
    @PostConstruct
    public void init(){
        selectedOption = new ArrayList<Integer>();
        ukrytyprzycisk = new ArrayList<Integer>();
        if (this.getPassedParameter()!=null)
            id = Integer.parseInt(this.getPassedParameter());
        selectedOption = beanManager.getResSeats(id);
        ukrytyprzycisk.add(id);


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
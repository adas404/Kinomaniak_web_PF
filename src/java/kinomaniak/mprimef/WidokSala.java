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

    public int getIdshow() {
        return idshow;
    }

    public void setIdshow(int idshow) {
        this.idshow = idshow;
    }
    @ManagedProperty("#{beanManager}")
    private BeanManager beanManager;
    @ManagedProperty("#{param.parameter}")
    private String parameter;

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }
    
    
    public BeanManager getBeanManager() {
        return beanManager;
    }

    public void setBeanManager(BeanManager beanManager) {
        this.beanManager = beanManager;
    }
    
    public String doSali(int id){
        idshow = id;
        return "sala?showid=id";
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
    
    @PostConstruct
    public void init(){
        selectedOption = new ArrayList<Integer>();
        int id = Integer.parseInt(this.getPassedParameter());
        selectedOption = beanManager.getResSeats(id);


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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kinomaniak.mprimef;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.annotation.PostConstruct;
import kinomaniak.beans.Res;
import kinomaniak.controllers.BeanManager;

/**
 *
 * @author Adam
 */
public class WidokSala {

    public BeanManager getBeanManager() {
        return beanManager;
    }

    public void setBeanManager(BeanManager beanManager) {
        this.beanManager = beanManager;
    }
    private BeanManager beanManager;
    /**
     * Creates a new instance of WidokSala
     */
    public List<Integer> getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(List<Integer> selectedOption) {
        this.selectedOption = selectedOption;
    }
    public boolean sprawdz(int par){
        for(int i=0;i<10;i++)
            if(par == selectedOption.get(i))
                return true;
        return false;
    } 
    public void decodedRes(int showid){
        for (Res r: this.getBeanManager().getRes())
            if (r.getShowID() == showid){
                Integer.toString(r.getSeat()[0][0]);
    }
    }
    List<Integer> selectedOption; 
    public void ustawZaznaczone(){

        selectedOption.add(1);
    }
    @PostConstruct
    public void init(){
        selectedOption.add(1);
    }
    public WidokSala() {
    
    }
}
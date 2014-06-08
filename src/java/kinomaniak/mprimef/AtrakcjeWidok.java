/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kinomaniak.mprimef;

import javax.annotation.PostConstruct;
import kinomaniak.beans.Attraction;
import kinomaniak.controllers.BeanManager;

/**
 *
 * @author Adam
 */
public class AtrakcjeWidok {

    /**
     * Creates a new instance of AtrakcjeWidok
     */
    private BeanManager beanManager;
    private MenuWidok menuWidok;

    public float getCena() {
        
        return cena;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }
    private float cena;

    public BeanManager getBeanManager() {
        return beanManager;
    }

    public void setBeanManager(BeanManager beanManager) {
        this.beanManager = beanManager;
    }

    public MenuWidok getMenuWidok() {
        return menuWidok;
    }

    public void setMenuWidok(MenuWidok menuWidok) {
        this.menuWidok = menuWidok;
    }
    
    public AtrakcjeWidok() {
        
    }
    @PostConstruct
    public void init(){
        for (Attraction a:this.getBeanManager().getAttractions()){
            System.out.println("yes yes yes");
                 if(Integer.toString(a.getId()).equals(Integer.toString(this.getMenuWidok().getAttraction_id())) ){
                    setCena(a.getPrice());
            }
    }
    
}}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kinomaniak.mprimef;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import kinomaniak.beans.Product;
import kinomaniak.controllers.BeanManager;

/**
 *
 * @author Adam
 */
public class ProduktyWidok {
    private BeanManager beanManager;
    private MenuWidok menuWidok;
    private float cena;
    private String nazwa;

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }
    private int product_id;

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }
    private int ilosc;

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

    public float getCena() {
        return cena;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
    public void kupProdukt(){
   
    }
    /**
     * Creates a new instance of ProduktyWidok
     */
    public ProduktyWidok() {
    }
    @PostConstruct
    public void init(){
        for (Product p:this.getBeanManager().getProducts()){
                 if(Integer.toString(p.getId()).equals(Integer.toString(this.getMenuWidok().getProduct_id())) ){
                    setCena(p.getPrice());
                    setNazwa(p.getName());
                    setIlosc(p.getCount());
                    setProduct_id(p.getId());
            }
    }
}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kinomaniak.mprimef;

import javax.annotation.PostConstruct;
import kinomaniak.beans.Attraction;
import kinomaniak.beans.CRoom;
import kinomaniak.controllers.BeanManager;
import org.primefaces.component.panelmenu.PanelMenu;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author Adam
 */
public class MenuWidok {

    public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }

    public BeanManager getBeanManager() {
        return beanManager;
    }

    public void setBeanManager(BeanManager beanManager) {
        this.beanManager = beanManager;
    }
    private MenuModel model;
    private BeanManager beanManager;

    public float getAttractionprice() {
        return attractionprice;
    }

    public void setAttractionprice(float attractionprice) {
        this.attractionprice = attractionprice;
    }
    private float attractionprice;
    /**
     * Creates a new instance of MenuWidok
     */
    @PostConstruct
    public void init() {
        model = new DefaultMenuModel();
        DefaultSubMenu sale = new DefaultSubMenu("Sale");
        for (CRoom c: this.getBeanManager().getRooms()){
            DefaultMenuItem citem = new DefaultMenuItem("Sala"+c.getId());
            citem.setAjax(false); 
            sale.addElement(citem);
        }
        model.addElement(sale);
        DefaultSubMenu atrakcje = new DefaultSubMenu("Atrakcje");
        for (Attraction a:this.getBeanManager().getAttractions()){
            this.setAttractionprice(a.getPrice());
            DefaultMenuItem atritem = new DefaultMenuItem(a.getName());
            atritem.setAjax(false);
            atritem.setHref("atrakcje.xhtml");
            atrakcje.addElement(atritem);
            
        }
        model.addElement(atrakcje);
        DefaultSubMenu raporty = new DefaultSubMenu("Raporty");
        DefaultSubMenu paneladmina = new DefaultSubMenu("Panel Administracyjny");
        DefaultSubMenu produkty = new DefaultSubMenu("Produkty");
        model.addElement(produkty);        
        model.addElement(raporty);
        model.addElement(paneladmina);
    }
    
}

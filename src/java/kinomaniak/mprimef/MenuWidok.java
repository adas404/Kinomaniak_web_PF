/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kinomaniak.mprimef;

import java.io.IOException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import kinomaniak.beans.Attraction;
import kinomaniak.beans.CRoom;
import kinomaniak.beans.Product;
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
        this.beanManager.setMenuWidok(this);
    }
    private MenuModel model;
    private BeanManager beanManager;

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }
    private int product_id;

    public int getAttraction_id() {
        return attraction_id;
    }

    public void setAttraction_id(int attraction_id) {
        this.attraction_id = attraction_id;
    }
    private int attraction_id;
        
    public String doAtrakcji(String id) throws IOException{
       System.out.println(id);
       this.setAttraction_id(Integer.parseInt(id));
       return "atrakcje";
    }
    public String doProduktu(String id) throws IOException{
       System.out.println(id);
       this.setProduct_id(Integer.parseInt(id));
       return "produkty";
    }
    /**
     * Creates a new instance of MenuWidok
     */
    @PostConstruct
    public void init() {
        setBeanManager(beanManager);
        model = new DefaultMenuModel();
        DefaultSubMenu sale = new DefaultSubMenu("Sale");
        for (CRoom c: this.getBeanManager().getRooms()){
            DefaultMenuItem citem = new DefaultMenuItem("Sala"+c.getId());
            citem.setId(Integer.toString(c.getID()));
            citem.setAjax(false); 
            sale.addElement(citem);
        }
        model.addElement(sale);
        DefaultSubMenu atrakcje = new DefaultSubMenu("Atrakcje");
        for (Attraction a:this.getBeanManager().getAttractions()){
            DefaultMenuItem atritem = new DefaultMenuItem(a.getName());
            atritem.setId(Integer.toString(a.getId()));
            atritem.setAjax(false); 
            String command = String.format("#{menuWidok.doAtrakcji('%d')}", a.getId());
            atritem.setCommand(command);
            
            atrakcje.addElement(atritem);
            
        }
        model.addElement(atrakcje);
        DefaultSubMenu produkty = new DefaultSubMenu("Produkty");
        for (Product p:this.getBeanManager().getProducts()){
            DefaultMenuItem pitem = new DefaultMenuItem(p.getName());
            pitem.setAjax(false);
            String pcommand = String.format("#{menuWidok.doProduktu('%d')}", p.getId());
            pitem.setCommand(pcommand); 
            produkty.addElement(pitem);
        }
        DefaultSubMenu raporty = new DefaultSubMenu("Raporty");
        DefaultSubMenu paneladmina = new DefaultSubMenu("Panel Administracyjny");
        model.addElement(produkty);        
        model.addElement(raporty);
        model.addElement(paneladmina);
 
    }
    
}

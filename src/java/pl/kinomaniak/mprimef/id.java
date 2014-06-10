/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.kinomaniak.mprimef;

import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedProperty;
import javax.inject.Named;
import kinomaniak.mprimef.MenuWidok;
import kinomaniak.mprimef.ProduktyWidok;

/**
 *
 * @author Adam
 */
@Named(value = "id")
@Dependent
public class id {
    @ManagedProperty(value="#{menuWidok}")
    private MenuWidok menuWidok;
    private int id;

    public MenuWidok getMenuWidok() {
        return menuWidok;
    }

    public void setMenuWidok(MenuWidok menuWidok) {
        this.menuWidok = menuWidok;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    /**
     * Creates a new instance of id
     */
    public id() {
        this.setId(this.getMenuWidok().getProduct_id());
    }
    
}

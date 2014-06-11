/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kinomaniak.mprimef;

import kinomaniak.beans.CRoom;
import kinomaniak.beans.Show;
import kinomaniak.controllers.BeanManager;

/**
 *
 * @author Adam
 */
public class sprawdzaczSali {

    /**
     * Creates a new instance of sprawdzaczSali
     */
    
    
    public BeanManager getBeanManager() {
        return beanManager;
    }

    public void setBeanManager(BeanManager beanManager) {
        this.beanManager = beanManager;
    }
    private BeanManager beanManager;
    
    public Boolean isRowne(int roomid,int showid){
        for (Show s: this.getBeanManager().getShows())
            if (showid == s.getID())
                if (roomid == s.getRoom().getID())
                    return true;
        return false;
    }
    public sprawdzaczSali() {
    }
    
}

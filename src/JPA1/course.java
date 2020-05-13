/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author PC
 */
@Entity
public class course {
     @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer C_id;
     private String C_name;
     private String room;

    public course() {
    }

    public Integer getC_id() {
        return C_id;
    }

    public void setC_id(Integer C_id) {
        this.C_id = C_id;
    }

    public String getC_name() {
        return C_name;
    }

    public void setC_name(String C_name) {
        this.C_name = C_name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
    
     
     
    
}

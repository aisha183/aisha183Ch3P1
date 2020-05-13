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
public class registration {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private student std;
    private course cou;
    private String semester;

    public registration() {
    }


    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
    
    public Integer getStudentId(){
     return std.getId();
    }
    
    public Integer  getCourseId(){
      return cou.getC_id();
    }
            
    
    
    
}

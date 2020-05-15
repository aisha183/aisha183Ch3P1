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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author PC
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "student.findAll",
            query = "Select s From student s")
    ,
    @NamedQuery(name = "student.findById",
            query = "Select s From student s Where s.Id= :Id"),
    @NamedQuery(name="student.Ubdate",
            query="Update student s Set s.Name = :name,s.Major =:majore,s.Grade =:grade Where s.Id =:Id")
   
})
public class student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String Name;
    private String Major;
    private Double Grade;

    public student() {
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getMajor() {
        return Major;
    }

    public void setMajor(String Major) {
        this.Major = Major;
    }

    public Double getGrade() {
        return Grade;
    }

    public void setGrade(Double Grade) {
        this.Grade = Grade;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LastOne;

/**
 *
 * @author PC
 */
public class Student {
    private int id;
    private String Name,Majore;
    private Double Grade;

    public Student(int id, String Name, String Majore, Double Grade) {
        this.id = id;
        this.Name = Name;
        this.Majore = Majore;
        this.Grade = Grade;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public String getMajore() {
        return Majore;
    }

    public Double getGrade() {
        return Grade;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setMajore(String Majore) {
        this.Majore = Majore;
    }

    public void setGrade(Double Grade) {
        this.Grade = Grade;
    }
    public String toString(){
      return this.getId()+"\t"+this.getName()+"\t"+this.getMajore()+"\t"+this.getGrade();
    }
}

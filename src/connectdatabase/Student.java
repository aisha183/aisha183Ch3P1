/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectdatabase;

/**
 *
 * @author PC
 */
public class Student {
  private int Id;
  private String Name;
  private String  Major;
  private double Grade;
  
  public Student(){}

    public Student(int Id, String Name, String Major, double Grade) {
        this.Id = Id;
        this.Name = Name;
        this.Major = Major;
        this.Grade = Grade;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setMajor(String Major) {
        this.Major = Major;
    }

    public void setGrade(double Grade) {
        this.Grade = Grade;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public String getMajor() {
        return Major;
    }

    public double getGrade() {
        return Grade;
    }
  
  public String toString(){
    
      return "Id : "+this.getId()+" Name : "+this.getName()+
              " Major : "+this.getMajor()+" Grade : "+this.getGrade();
  }
}

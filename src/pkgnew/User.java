
package pkgnew;

import javafx.beans.property.SimpleStringProperty;
 
public class User {
 
    SimpleStringProperty name;
    SimpleStringProperty id;
    SimpleStringProperty Major;
    SimpleStringProperty Grade;

 
    public User() {
        this.name = new SimpleStringProperty("");
        this.id = new SimpleStringProperty("");
        this.Major = new SimpleStringProperty("");
        this.Grade=new SimpleStringProperty("");
    }
 
    public User(String name, String id, String major,String grade) {
        this.name = new SimpleStringProperty(name);
        this.id = new SimpleStringProperty(id);
        this.Major = new SimpleStringProperty(major);
        this.Grade=new SimpleStringProperty(grade);
    }
 
    public String getName() {
        return name.getValue();
    }
 
    public void setName(String name) {
        this.name = new SimpleStringProperty(name);
    }
 
    public String getId() {
        return id.getValue();
    }
 
    public void setId(String id) {
        this.id = new SimpleStringProperty(id);
    }
 
    public String getMajor() {
        return Major.getValue();
    }
 
    public void setMajor(String major) {
        this.Major = new SimpleStringProperty(major);
    }

    public void setGrade(String grade) {
      this.Grade = new SimpleStringProperty(grade);
    }

    public String getGrade() {
        return Grade.getValue();
    }
 
}

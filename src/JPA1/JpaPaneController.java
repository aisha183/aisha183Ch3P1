/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA1;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JpaPaneController implements Initializable {

    @FXML
    private TextField txtFieldID;

    @FXML
    private TableColumn<student, String> tcMajore;

    @FXML
    private TextField txtFieldName;

    @FXML
    private TableColumn<student, Double> tcGrade;

    @FXML
    private TableView<student> tableView;

    @FXML
    private TextField txtFieldGrade;

    @FXML
    private TableColumn<student, String> tcName;

    @FXML
    private Button buttonShow;

    @FXML
    private Button buttonDelete;

    @FXML
    private TextField txtFieldMajore;

    @FXML
    private TableColumn<student, Integer> tcID;

    @FXML
    private Button buttonUpdate;

    @FXML
    private Button buttonReset;

    @FXML
    private Button buttonAdd;
    private EntityManagerFactory emf;

    @FXML
    void txtFieldEmpIDHandle(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tcID.setCellValueFactory(new PropertyValueFactory("Id"));
        tcName.setCellValueFactory(new PropertyValueFactory("Name"));
        tcMajore.setCellValueFactory(new PropertyValueFactory("Majore"));
        tcGrade.setCellValueFactory(new PropertyValueFactory("Grade"));
        this.emf = Persistence.createEntityManagerFactory("Ass3P1PU");
    }

    @FXML
    void buttonShowHandle(ActionEvent event) {
        EntityManager em = emf.createEntityManager();
        List<student> students = em.createNamedQuery("student.findAll").getResultList();
        tableView.getItems().setAll(students);
        em.close();

    }

    @FXML
    void buttonAddHandle(ActionEvent event) {
        student std = new student();
        std.setName(txtFieldName.getText());
        std.setMajor(txtFieldMajore.getText());
        std.setGrade(Double.parseDouble(txtFieldGrade.getText()));
        EntityManager em = this.emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(std);
        em.getTransaction().commit();
        em.close();
    }

    @FXML
    void buttonUpdateHandle(ActionEvent event) {
        EntityManager em = this.emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("Update student s Set s.Name = s.Name + :increment,s.Major = s.Major + :majore,s.Grade = s.Grade + :grade Where s.Id = :ID");
        query.setParameter("increment", txtFieldName.getText());
        query.setParameter("majore", txtFieldMajore.getText());
        query.setParameter("grade", txtFieldGrade.getText());
        query.setParameter("ID", txtFieldID.getText());
        int updatedRows = query.executeUpdate();
        System.out.println("Entities updated:" + updatedRows);
        em.getTransaction().commit();
    }

    @FXML
    void buttonDeleteHandle(ActionEvent event) {
    EntityManager em = emf.createEntityManager();
        List<student> std = em.createNamedQuery("student.deletBYid").getResultList();
        tableView.getItems().setAll();
        em.close();
    }

    @FXML
    void buttonResetHandle(ActionEvent event) {
      resetControls();
    }
     private void resetControls() {
        txtFieldID.setText("");
        txtFieldName.setText("");
        txtFieldMajore.setText("");
        txtFieldGrade.setText("");
        tableView.getItems().clear();
    }


}

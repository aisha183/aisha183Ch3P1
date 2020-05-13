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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author PC
 */
public class studentJpaController implements Initializable {

    @FXML
    private TextField txtFieldID;
    @FXML
    private TextField txtFieldName;
    @FXML
    private TextField txtFieldGrade;
    @FXML
    private TextField txtFieldMajore;
    @FXML
    private TableView<student> tableView;
    @FXML
    private TableColumn<student, Integer> tcID;
    @FXML
    private TableColumn<student, String> tcName;
    @FXML
    private TableColumn<student, String> tcMajore;
    @FXML
    private TableColumn<student, Double> tcGrade;
    @FXML
    private Button buttonShow;
    @FXML
    private Button buttonAdd;
    @FXML
    private Button buttonUpdate;
    @FXML
    private Button buttonDelete;
    @FXML
    private Button buttonReset;
    private EntityManagerFactory emf;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tcID.setCellValueFactory(new PropertyValueFactory("Id"));
        tcName.setCellValueFactory(new PropertyValueFactory("Name"));
        tcMajore.setCellValueFactory(new PropertyValueFactory("Majore"));
        tcGrade.setCellValueFactory(new PropertyValueFactory("Grade"));
        this.emf = Persistence.createEntityManagerFactory("Ass3P1PU");
    }

    @FXML
    private void txtFieldIDHandle(ActionEvent event) {
        EntityManager em = this.emf.createEntityManager();
        try {
            student std = (student) em.createNamedQuery("student.findById")
                    .setParameter("Id", Integer.parseInt(txtFieldID.getText()))
                    .getSingleResult();
            txtFieldName.setText(std.getName());
            txtFieldMajore.setText(std.getMajor());
            txtFieldGrade.setText(std.getGrade() + "");
        } catch (NoResultException ex) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error Retrieving");
            alert.setContentText("No records found");
            alert.showAndWait();
        }
        em.close();

    }

    @FXML
    private void buttonShowHandle(ActionEvent event) {
        EntityManager em = emf.createEntityManager();
        List<student> students = em.createNamedQuery("student.findAll").getResultList();
        tableView.getItems().setAll(students);
        em.close();

    }

    @FXML
    private void buttonAddHandle(ActionEvent event) {
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
    private void buttonUpdateHandle(ActionEvent event) {
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
    private void buttonDeleteHandle(ActionEvent event) {
        
    }

    @FXML
    private void buttonResetHandle(ActionEvent event) {
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

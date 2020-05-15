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
import javax.persistence.Id;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import static javax.xml.ws.RespectBindingFeature.ID;
import static jdk.nashorn.internal.runtime.Debug.id;

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
    public EntityManagerFactory emf;
    List<student> students;

    @FXML
    void buttonShowHandle(ActionEvent event) {
        EntityManager em = emf.createEntityManager();
        students = em.createNamedQuery("student.findAll").getResultList();
        tableView.getItems().setAll(students);
        em.close();

    }
    student std;

    @FXML
    void buttonAddHandle(ActionEvent event) {
        std = new student();
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
        try {
            std = (student) em.createNamedQuery("student.findById")
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

        em.getTransaction().begin();
        int Idnty = Integer.parseInt(txtFieldID.getText());
        String name1 = txtFieldName.getText();
        String mjore1 = txtFieldMajore.getText();
        double grade1 = Double.parseDouble(txtFieldGrade.getText());
        Query query = em.createQuery("Update student Set Name='" + name1 + "', Majore='"
                + mjore1 + "', Grade=" + grade1 + " Where Id=" + Idnty);
        query.setParameter("name", name1);
        query.setParameter("Id", Idnty);
        int updatedRows = query.executeUpdate();
        System.out.println("Entities updated:" + updatedRows);
        em.getTransaction().commit();
    }

    @FXML
    void buttonDeleteHandle(ActionEvent e) {

        EntityManager em = emf.createEntityManager();
        em.createQuery("delete from student s").executeUpdate();
      
        emf.close();
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tcID.setCellValueFactory(new PropertyValueFactory("Id"));
        tcName.setCellValueFactory(new PropertyValueFactory("Name"));
        tcMajore.setCellValueFactory(new PropertyValueFactory("Majore"));
        tcGrade.setCellValueFactory(new PropertyValueFactory("Grade"));
        tableView = new TableView<>();
        // tableView.getSelectionModel().selectedItemProperty().addListener();
        this.emf = Persistence.createEntityManagerFactory("Ass3P1PU");
    }

}

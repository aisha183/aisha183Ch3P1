/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author PC
 */
public class newCon extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        TableView<Student> tblView = new TableView<>();
        TextArea textArea=new TextArea();
        TableColumn<Student, Integer> tcID = new TableColumn("Id");
        tcID.setCellValueFactory(new PropertyValueFactory("Id"));

        TableColumn<Student, String> tcName = new TableColumn("Name");
        tcName.setCellValueFactory(new PropertyValueFactory("name"));

        TableColumn<Student, String> tcMajor = new TableColumn("Major");
        tcMajor.setCellValueFactory(new PropertyValueFactory("Major"));

        TableColumn<Student, Double> tcGrade = new TableColumn("Grade");
        tcGrade.setCellValueFactory(new PropertyValueFactory("Grade"));

        tblView.getColumns().addAll(tcID, tcName, tcMajor, tcGrade);
        
         Button buttonView = new Button("Show");

        ObservableList<Student> stds
                = FXCollections.observableArrayList();
        tblView.setPrefSize(450, 300);
        tcID.setPrefWidth(125);
        tcName.setPrefWidth(110);
        tcMajor.setPrefWidth(125);
        tcGrade.setPrefWidth(110);
        buttonView.setPrefSize(150, 50);
        textArea.setPrefSize(200, 200);

        tblView.setTranslateX(220);
        tblView.setTranslateY(30);
        textArea.setTranslateX(10);
        textArea.setTranslateY(30);
        buttonView.setTranslateX(20);
        buttonView.setTranslateY(400);

       
        buttonView.setOnAction(event -> {
            ResultSet rs;
            stds.clear();
            //executeQuery for a :SELECT * FROM Student WHERE Major='Software Engineering'
            //executeQuery for b: SELECT * FROM Student WHERE Grade >=90
            //executeQuery for c: SELECT * FROM Student ORDER BY Name ASC 
            //executeQuery for d:SELECT * FROM Student WHERE Major='cs'And Grade <70
            try {
                String url = "jdbc:mysql://127.0.0.1:3306/School";
                String username = "'root'";
                String password = "";
                Connection conn = DriverManager.getConnection(url, username, password);
                Statement statement = conn.createStatement();
                statement = conn.createStatement();
                rs = statement.executeQuery(textArea.getText());
                while (rs.next()) {
                    Student student = new Student();
                    student.setId(rs.getInt("Id"));
                    student.setName(rs.getString("Name"));
                    student.setMajor(rs.getString("Major"));
                    student.setGrade(rs.getDouble("Grade"));
                    stds.add(student);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            tblView.setItems(stds);

        }); //End of button action

      Group root = new Group();
        root.getChildren().add(tblView);
        root.getChildren().add(textArea);
        root.getChildren().add(buttonView);
        Scene scene = new Scene(root, 700, 500);
        primaryStage.setTitle("TableView App");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}

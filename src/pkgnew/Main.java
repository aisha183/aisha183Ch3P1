/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgnew;

/**
 *
 * @author PC
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
     public TextArea textArea;
    public Stage stage , stage1;
    public  Scene scene,scene1;
    final Text actiontarget = new Text();

    @Override
    public void start(Stage stage) {

        Label labelId = new Label("ID");
        Label labelName = new Label("Name");
        Label labelMajor = new Label("Major");
        Label labelGrade = new Label("Grade");
        Label labelTotalUsers = new Label("To Users: 0");

        Button buttonAdd = new Button("Add Record");
        Button buttonDelete = new Button("Exit");
        Button buttonDeleteAll = new Button("Reset");
        Button buttonShow = new Button("Show");

        TextField fieldId = new TextField();
        TextField fieldName = new TextField();
        TextField fieldMajor = new TextField();
        TextField fieldGrade = new TextField();

        TableView<User> table = new TableView();

        ObservableList<User> data = FXCollections.observableArrayList();

        TableColumn<User, String> columnId = new TableColumn<>("ID");
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnId.setCellFactory(TextFieldTableCell.forTableColumn());
        columnId.setOnEditCommit((CellEditEvent<User, String> t) -> {
            ((User) t.getTableView()
                    .getItems()
                    .get(t.getTablePosition().getRow()))
                    .setId(t.getNewValue());
        });

        TableColumn<User, String> columnName = new TableColumn<>("Name");
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnName.setCellFactory(TextFieldTableCell.forTableColumn());
        columnName.setOnEditCommit((CellEditEvent<User, String> t) -> {
            ((User) t.getTableView()
                    .getItems()
                    .get(t.getTablePosition().getRow()))
                    .setName(t.getNewValue());
        });

        TableColumn<User, String> columnMajor = new TableColumn<>("Major");
        columnMajor.setCellValueFactory(new PropertyValueFactory<>("major"));
        columnMajor.setCellFactory(TextFieldTableCell.forTableColumn());
        columnMajor.setOnEditCommit((CellEditEvent<User, String> t) -> {
            ((User) t.getTableView()
                    .getItems()
                    .get(t.getTablePosition().getRow()))
                    .setMajor(t.getNewValue());
        });

        TableColumn<User, String> columnGrade = new TableColumn<>("Grade");
        columnGrade.setCellValueFactory(new PropertyValueFactory<>("grade"));
        columnGrade.setCellFactory(TextFieldTableCell.forTableColumn());
        columnGrade.setOnEditCommit((CellEditEvent<User, String> t) -> {
            ((User) t.getTableView()
                    .getItems()
                    .get(t.getTablePosition().getRow()))
                    .setGrade(t.getNewValue());
        });

        table.setEditable(true);
        table.getColumns().addAll(columnId, columnName, columnMajor, columnGrade);
        table.setItems(data);
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        table.setPrefSize(500, 200);
        columnName.setPrefWidth(125);
        columnId.setPrefWidth(115);
        columnMajor.setPrefWidth(125);
        columnGrade.setPrefWidth(115);

        labelName.setPrefSize(155, 30);
        labelId.setPrefSize(155, 30);
        labelMajor.setPrefSize(155, 30);
        labelGrade.setPrefSize(155, 30);

        fieldName.setPrefSize(200, 30);
        fieldId.setPrefSize(200, 30);
        fieldMajor.setPrefSize(200, 30);
        fieldGrade.setPrefSize(200, 30);

        buttonAdd.setPrefSize(230, 30);
        labelTotalUsers.setPrefSize(230, 30);
        buttonDelete.setPrefSize(180, 30);
        buttonDeleteAll.setPrefSize(180, 30);

        // في النافذة table هنا قمنا بتحديد مكان ظهور الكائن
        table.setTranslateX(300);
        table.setTranslateY(30);

        labelId.setTranslateX(20);
        labelId.setTranslateY(50);

        labelName.setTranslateX(20);
        labelName.setTranslateY(90);

        labelMajor.setTranslateX(20);
        labelMajor.setTranslateY(130);

        labelGrade.setTranslateX(20);
        labelGrade.setTranslateY(165);

        fieldName.setTranslateX(80);
        fieldName.setTranslateY(50);

        fieldId.setTranslateX(80);
        fieldId.setTranslateY(90);

        fieldMajor.setTranslateX(80);
        fieldMajor.setTranslateY(130);

        fieldGrade.setTranslateX(80);
        fieldGrade.setTranslateY(170);

        buttonAdd.setTranslateX(50);
        buttonAdd.setTranslateY(250);

        labelTotalUsers.setTranslateX(20);
        labelTotalUsers.setTranslateY(300);
        buttonShow.setTranslateX(740);
        buttonShow.setTranslateY(250);
        buttonDelete.setTranslateX(330);
        buttonDelete.setTranslateY(250);

        buttonDeleteAll.setTranslateX(540);
        buttonDeleteAll.setTranslateY(250);

        // في النافذة Root Node لأننا ننوي جعله الـ Group هنا قمنا بإنشاء كائن من الكلاس
        Group root = new Group();

        // root في الكائن table هنا قمنا بإضافة الكائن
        root.getChildren().add(table);
        root.getChildren().add(labelId);
        root.getChildren().add(labelName);
        root.getChildren().add(labelMajor);
        root.getChildren().add(labelGrade);
        root.getChildren().add(fieldId);
        root.getChildren().add(fieldName);
        root.getChildren().add(fieldMajor);
        root.getChildren().add(fieldGrade);
        root.getChildren().add(buttonAdd);
        root.getChildren().add(labelTotalUsers);
        root.getChildren().add(buttonDelete);
        root.getChildren().add(buttonDeleteAll);
          root.getChildren().add(buttonShow);
        root.getChildren().add(actiontarget);

         scene = new Scene(root, 900, 400);

        stage.setTitle("JavaFX TableView");

        stage.setScene(scene);

        stage.show();

        buttonAdd.setOnAction(Action -> {
            String name = fieldName.getText();
            String id = fieldId.getText();
            String Major = fieldMajor.getText();
            String Grade = fieldGrade.getText();
            if (!name.equals("") && !id.equals("") && !Major.equals("")) {
                 data.add(new User(name, id, Major, Grade));
                labelTotalUsers.setText("Total Users: " + table.getItems().size());
                fieldName.setText("");
                fieldId.setText("");
                fieldMajor.setText("");
                fieldGrade.setText("");
            
            } else {
                new Alert(AlertType.WARNING, "Name, Role and Email fields cannot be empty!").show();
            }
        });

        buttonDelete.setOnAction(Action -> {
            stage.close();
        });

        buttonDeleteAll.setOnAction(Action -> {
            table.getItems().clear();
            labelTotalUsers.setText("Total Users: " + table.getItems().size());
        });
        
        buttonShow.setOnAction(Action -> {
       HBox hbox=new HBox(textArea);
         scene1 = new Scene(hbox, 600, 400);

        stage1.setTitle("JavaFX Show");

        stage1.setScene(scene1);

        stage1.show();
        
        });
        
        scene.getStylesheets().add(getClass().getResource("newStyle.css").toExternalForm());

    }

    // هنا قمنا بتشغيل التطبيق
    public static void main(String[] args) {
        launch(args);
    }

}

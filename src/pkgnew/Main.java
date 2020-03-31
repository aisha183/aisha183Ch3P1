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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
  public Stage stage;
  final Text actiontarget = new Text();
      
    @Override
    public void start(Stage stage) {

        // الذين سنضيفهم في النافذة Labels هنا قمنا بإنشاء جميع الـ
        Label labelId = new Label("ID");
        Label labelName = new Label("Name");
        Label labelMajor = new Label("Major");
        Label labelGrade = new Label("Grade");
        Label labelTotalUsers = new Label("To Users: 0");

        // الذين سنضيفهم في النافذة Buttons هنا قمنا بإنشاء جميع الـ
        Button buttonAdd = new Button("Add Record");
        Button buttonDelete = new Button("Exit");
        Button buttonDeleteAll = new Button("Reset");

        // الذين سنضيفهم في النافذة TextFields هنا قمنا بإنشاء جميع الـ
        TextField fieldId = new TextField();
        TextField fieldName = new TextField();
        TextField fieldMajor = new TextField();
        TextField fieldGrade = new TextField();

        // يمثل الجدول الذي نريد إضافته في النافذة TableView هنا قمنا بإنشاء كائن من الكلاس
        TableView<User> table = new TableView();

        // يمثل مجموعة البيانات التي ستظهر في الجدول ObservableList هنا قمنا بإنشاء كائن من الكلاس
        // User كل سطر في هذا الجدول يمثل كائن من الكلاس
        ObservableList<User> data = FXCollections.observableArrayList();

        // فقط String هنا قمنا بإنشاء العامود الذي سيظهر أدوار المستخدمين و حددنا أنه يقبل قيم من النوع
        TableColumn<User, String> columnId = new TableColumn<>("ID");
        // تم إضافته في الجدول User الموجودة في كل كائن role سيُعرض فيه قيم الـ columnRole هنا قلنا أن العامود
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        // يتيح لك إدخال قيمة جديدة TextField سيتم إظهار columnRole عند النقر على أي قيمة موجودة في العامود
        columnId.setCellFactory(TextFieldTableCell.forTableColumn());
        // String سيتم حفظ القيمة الجديدة في حال كان نوعها Enter عند النقر على الزر
        columnId.setOnEditCommit((CellEditEvent<User, String> t) -> {
            ((User) t.getTableView()
                    .getItems()
                    .get(t.getTablePosition().getRow()))
                    .setId(t.getNewValue());
        });

        // فقط String هنا قمنا بإنشاء العامود الذي سيظهر أسماء المستخدمين و حددنا أنه يقبل قيم من النوع
        TableColumn<User, String> columnName = new TableColumn<>("Name");
        // تم إضافته في الجدول User الموجودة في كل كائن name سيُعرض فيه قيم الـ columnName هنا قلنا أن العامود
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        // يتيح لك إدخال قيمة جديدة TextField سيتم إظهار columnName عند النقر على أي قيمة موجودة في العامود
        columnName.setCellFactory(TextFieldTableCell.forTableColumn());
        // String سيتم حفظ القيمة الجديدة في حال كان نوعها Enter عند النقر على الزر
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

        // قابلة للتعديل table هنا جعلنا بيانات الجدول
        table.setEditable(true);
        // table هنا وضعنا الأعمدة الثلاثة في الكائن
        table.getColumns().addAll(columnId, columnName, columnMajor, columnGrade);
        // table في الكائن data هنا قمنا بوضع بيانات الكائن
        table.setItems(data);
        // table هنا جعلنا المستخدم قادر على تحديد أكثر من سطر بداخل الـ
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        // في النافذة table هنا قمنا بتحديد حجم الكائن
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
        root.getChildren().add(actiontarget);
       

        // فيها و تحديد حجمها Node كأول root هنا قمنا بإنشاء محتوى النافذة مع تعيين الكائن
        Scene scene = new Scene(root, 900, 400);

        // هنا وضعنا عنوان للنافذة
        stage.setTitle("JavaFX TableView");

        // أي وضعنا محتوى النافذة الذي قمنا بإنشائه للنافذة .stage في كائن الـ scene هنا وضعنا كائن الـ
        stage.setScene(scene);

        // هنا قمنا بإظهار النافذة
        stage.show();

        // buttonAdd هنا قمنا بتحديد ماذا سيحدث عند النقر على الزر
        buttonAdd.setOnAction(Action -> {
            // email و role و name هنا قمنا بتخزين النصوص المدخلة في الحقول في المتغيرات
            String name = fieldName.getText();
            String id = fieldId.getText();
            String Major = fieldMajor.getText();
            String Grade = fieldGrade.getText();
            // غير فارغة - أي فيها نص email و role و name هنا قلنا إذا كانت المتغيرات
            if (!name.equals("") && !id.equals("") && !Major.equals("")) {
                // سيتم إضافتها على سطر جديد في الجدول
                // labelTotalUsers ثم تحديث عدد المستخدمين الموجودين في الجدول و الذي يتم عرضه على الكائن
                // بعدها سيتم مسح النص المدخل في الحقول
                data.add(new User(name, id, Major, Grade));
                labelTotalUsers.setText("Total Users: " + table.getItems().size());
                fieldName.setText("");
                fieldId.setText("");
                fieldMajor.setText("");
            } else {
                // فارغاً سيتم إظهار رسالة تنبيه أمام المستخدم email و role و name إذا كان واحد من المتغيرات
                new Alert(AlertType.WARNING, "Name, Role and Email fields cannot be empty!").show();
            }
        });

        // buttonDelete هنا قمنا بتحديد ماذا سيحدث عند النقر على الزر
        buttonDelete.setOnAction(Action -> {
            stage.close();
        });

        // buttonDeleteAll هنا قمنا بتحديد ماذا سيحدث عند النقر على الزر
        buttonDeleteAll.setOnAction(Action -> {
            // سيتم حذف جميع الأسطر في الجدول
            table.getItems().clear();
            // labelTotalUsers ثم تحديث عدد المستخدمين الموجودين في الجدول و الذي يتم عرضه على الكائن
            labelTotalUsers.setText("Total Users: " + table.getItems().size());
        });
        scene.getStylesheets().add(getClass().getResource("newStyle.css").toExternalForm());
         
    }

    // هنا قمنا بتشغيل التطبيق
    public static void main(String[] args) {
        launch(args);
    }

}

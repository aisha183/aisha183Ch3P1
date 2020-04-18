/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LastOne;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author PC
 */
public class Maine extends Application {

    public TextArea textArea;
    Button Show = new Button("Show");

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Student[] ArrayStd = {
            new Student(1, "Ahmad", "IT", 90.5),
            new Student(2, "Sami", "Sales", 98.6),
            new Student(5, "Huda", "IT", 77.5),
            new Student(7, "Ali", "Marketing", 88.9),
            new Student(4, "Hani", "Sales", 86.5)
        };
        //a
        List<Student> listStd = Arrays.asList(ArrayStd);
        Show.setOnAction(event->{
        listStd
                .stream()
                .sorted(Comparator.comparing(Student::getName)) //Sort First
                .map(s -> s.getId() + " " + s.getName() + " " + s.getGrade()) //To return only two attributes as string 
                .forEach(str -> textArea.appendText(str));
        textArea.appendText("****************");
        //b
        listStd
                .stream()
                .sorted(Comparator.comparing(Student::getGrade).reversed()) //Sort First
                .map(s -> s.getName() + " " + s.getGrade()) //To return only two attributes as string 
                .forEach(str -> textArea.appendText(str));

        textArea.appendText("****************");
        //c
        listStd
                .stream().filter(e -> e.getGrade() > 80 && e.getGrade() < 90)
                .sorted(Comparator.comparing(Student::getGrade).reversed()) //Sort First
                .map(s -> s.getName() + " " + s.getGrade()) //To return only two attributes as string 
                .forEach(str -> textArea.appendText(str));
       textArea.appendText("*****************");
        OptionalDouble avg = listStd.stream().mapToDouble(val -> val.getGrade()).average();
        textArea.appendText("Avg :"+avg);
        textArea.appendText("*******************");
        listStd.stream()
                .map(e -> new Student(e.getId(), e.getName(), e.getMajore(), e.getGrade()))
                .collect(Collectors.groupingBy(Student::getMajore, Collectors.counting()))
                .forEach((d, c) -> textArea.appendText("Majore: " + d + ", Count: " + c));
        });
        HBox hbox=new HBox(textArea,Show);
        Scene scene=new Scene(hbox,400,600);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
}

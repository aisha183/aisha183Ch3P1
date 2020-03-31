/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass3p1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author PC
 */
public class Ass3P1 extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);


    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Random r = new Random();
        int[] random = new int[30];
        List<Integer> values = new ArrayList<>();
      
        
        ListView<Integer> listViewInt = new ListView<>();
        Button AddRundom = new Button("Add Rundom");
        Label sumLabel=new Label();
        Button avg=new Button("Avg");
        Label avgLabel=new Label();
        AddRundom.setOnAction(event -> {
           for (int i = 0; i < random.length; i++) {
            random[i] = new Random().nextInt(100);
            values.add(random[i]);
        }

            listViewInt.getItems().addAll(values);
          
       });
        AddRundom.setPadding(new Insets(10, 20, 10, 20));
        Button sum1 = new Button("Sum");
       if (listViewInt != null) {
//
           sum1.setOnAction(event -> {
                int nu = IntStream.of(random).sum();
               sumLabel.setText("The Sum :"+nu);
            });
        }
       avg.setOnAction(event ->{
          double avg1 = IntStream.of(random).average().getAsDouble();
          avgLabel.setText("The Average :"+avg1);

       });
       
        sum1.setPadding(new Insets(10, 20, 10, 20));
        
        sum1.setPrefSize(90, 30);
        avg.setPrefSize(90, 30);
        AddRundom.setPrefSize(230, 30);
        sumLabel.setPrefSize(150, 30);
        avgLabel.setPrefSize(150, 30);
        listViewInt.setPrefSize(250, 250);
        
        sum1.setTranslateX(20);
        sum1.setTranslateY(40);
        sumLabel.setTranslateX(120);
        sumLabel.setTranslateY(40);
        avg.setTranslateX(20);
        avg.setTranslateY(100);
        avgLabel.setTranslateX(120);
        avgLabel.setTranslateY(100);
        AddRundom.setTranslateX(20);
        AddRundom.setTranslateY(160);
        listViewInt.setTranslateX(300);
        listViewInt.setTranslateY(35);
        
        
        
        Group root = new Group();
        root.getChildren().add(sum1);
        root.getChildren().add(sumLabel);
        root.getChildren().add(avg);
        root.getChildren().add(avgLabel);
        root.getChildren().add(AddRundom);
        root.getChildren().add(listViewInt);


//        HBox hBox = new HBox(sum1,sumLabel);
//        VBox vBox = new VBox(AddRundom,hBox);
//        HBox view=new HBox(vBox,listViewInt);
//        view.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 600, 300);
        primaryStage.setTitle("List View *_*");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    }

package com.example.orderingsystem;
//Devs: Justin F,
//Date: 4/12/2022
//Class 171
//Script: Sub Ordering System / week11 group project
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    public void start(Stage stage) throws IOException{
// create a pane to place nodes in using a grid concept
        GridPane grid = new GridPane();

        //style the grid with padding fields
        grid.setPadding(new Insets(10,10,10,10));
        grid.setHgap(10);
        grid.setVgap(8);

        Sandmich.Option[] options = {
        new Sandmich.Option("Size", new String[]{"6\"", "12\""}),
        new Sandmich.Option("Bread", new String[]{"Italian", "Wheat", "Multigrain"}),
        new Sandmich.Option("Meat", new String[]{"Turkey", "Ham", "Roast Beef"}),
        new Sandmich.Option("Cheese", new String[]{"Mozzarella", "American", "Swiss"}),
        new Sandmich.Option("Veggies", new String[]{"Lettuce", "Tomato", "Onion"}),
        new Sandmich.Option("Sauce", new String[]{"Mayo", "Oil", "Vinegar"}),
        new Sandmich.Option("Toasted", new String[]{"Toasted", "Not Toasted"})
        };

        int colMax = 4;
        int curRow = 0;
        int curCol = 0;



        colMax*=2;

        ComboBox[] boxes = new ComboBox[options.length];

        for(int i = 0; i < options.length; i++) {
            Label label = new Label(options[i].name);
            label.setTextFill(Color.WHITE);
            ComboBox cmb = new ComboBox(FXCollections.observableArrayList(options[i].options));



            cmb.setPrefWidth(150.0);
            boxes[i] = cmb;

            GridPane.setConstraints(label, curCol, curRow);
            GridPane.setConstraints(cmb, curCol + 1, curRow);

            curCol += 2;

            if(curCol == colMax) {
                curRow++;
                curCol = 0;
            }

            grid.getChildren().addAll(label, cmb);
        }

        TextField txt = new TextField();

        txt.setBackground(new Background(new BackgroundFill(Color.rgb(255, 189, 0), CornerRadii.EMPTY, Insets.EMPTY)));

        Button btn = new Button("Order");
        GridPane.setHalignment(btn, HPos.LEFT);
        ////////////

        btn.setStyle("-fx-background-color: #FFC600");

        GridPane.setConstraints(btn,0, curRow + 1, colMax, 1);
        GridPane.setConstraints(txt,0,curRow + 2, colMax,1);//col, row, colspan, rowspan

        grid.getChildren().addAll(btn, txt);
        grid.setBackground(new Background(new BackgroundFill(Color.rgb(0, 140, 21), CornerRadii.EMPTY, Insets.EMPTY)));

        //set an on click action for convert button
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                //need a check here to see if all fields are selected before creating the obj "Sandwich"

                //Run a check to ensure that al
                String[] orderOptions = new String[boxes.length];
                for(int i = 0; i < orderOptions.length; i++) {
                    if(boxes[i].getValue() != null) {
                        orderOptions[i] = boxes[i].getValue().toString();
                    } else {
                        orderOptions[i] = "";
                    }
                }

                Sandmich temp = new Sandmich(orderOptions);
                //txt.appendText(temp.toString());

                //use the obj toString method to display contents
                txt.setText(temp.toString());

            }
        });

        Scene scene = new Scene(grid);
        //scene.getStylesheets().add("style.css");
        stage.setTitle("Subway GUI!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
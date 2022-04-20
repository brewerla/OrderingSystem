package com.example.orderingsystem;
//Devs: Justin F, Landen B
//Date: 4/12/2022
//Class 171
//Script: Sub Ordering System / week11 group project
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.stage.Stage;

import java.io.IOException;

public class SubwayGUI extends Application {

    public void start(Stage stage) throws IOException{
// create a pane to place nodes in using a grid concept
        GridPane grid = new GridPane();

        //style the grid with padding fields
        grid.setPadding(new Insets(10,10,10,10));
        grid.setHgap(10);
        grid.setVgap(8);

        //Array of each option available to the user
        Option[] options = {
        new Option("Size", new String[]{"6\"", "12\""}),
        new Option("Bread", new String[]{"Italian", "Wheat", "Multigrain"}),
        new Option("Meat", new String[]{"Turkey", "Ham", "Roast Beef"}),
        new Option("Cheese", new String[]{"Mozzarella", "American", "Swiss"}),
        new Option("Veggies", new String[]{"Lettuce", "Tomato", "Onion"}),
        new Option("Sauce", new String[]{"Mayo", "Oil", "Vinegar"}),
        new Option("Toasted", new String[]{"Y", "N"}),
        new Option("Salt & Pepper", new String[]{"Y", "N"})
        };


        int colMax = 3; //Maximum columns

        //Counters to keep track of current row and column
        int curRow = 0;
        int curCol = 0;

        //multiply max column by two to ensure label and ComboBox "pseudo grouped"
        colMax *= 2;

        //Array to error check later in the program.
        ComboBox[] boxes = new ComboBox[options.length];

        //Loop to display all the options for the user to pick.
        for(int i = 0; i < options.length; i++) {
            //Create a new temporary label and set color to white.
            Label label = new Label(options[i].name);
            label.setTextFill(Color.WHITE);

            //Create ComboBox for the user to select.
            ComboBox cmb = new ComboBox(FXCollections.observableArrayList(options[i].options));

            //Set the ComboBox width for uniformity
            cmb.setPrefWidth(150.0);
            //Add the ComboBox to the boxes array
            boxes[i] = cmb;

            //Set the constraints for the label and ComboBox
            //based on the current column and current Row
            GridPane.setConstraints(label, curCol, curRow);
            GridPane.setConstraints(cmb, curCol + 1, curRow);

            //Add 2 to the current column because of the line above "curCol + 1" in set constraints
            curCol += 2;

            //If the curCol hits the colMax go to the next row.
            if(curCol == colMax) {
                curRow++;
                curCol = 0;
            }

            //Add the label and the ComboBox to the grid.
            grid.getChildren().addAll(label, cmb);
        }

        //Create a new text field for the output
        TextField txt = new TextField();

        //Change the textField background to subway yellow.
        txt.setBackground(new Background(new BackgroundFill(Color.rgb(255, 189, 0), CornerRadii.EMPTY, Insets.EMPTY)));

        //Create a btn to submit an order
        Button btn = new Button("Order");
        GridPane.setHalignment(btn, HPos.LEFT);
        ////////////

        //Change the button background to yellow
        btn.setStyle("-fx-background-color: #FFC600");

        //Add the button and the text field to the grid constraints
        GridPane.setConstraints(btn,0, curRow + 1, colMax, 1);
        GridPane.setConstraints(txt,0,curRow + 2, colMax,1);//col, row, colspan, rowspan

        //Add the btn and txt to the actual grid.
        grid.getChildren().addAll(btn, txt);
        //Change the background to subway green.
        grid.setBackground(new Background(new BackgroundFill(Color.rgb(0, 140, 21), CornerRadii.EMPTY, Insets.EMPTY)));

        //set an on click action for convert button
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                //Create an array of strings the same length as the array of ComboBoxes boxes.
                String[] orderOptions = new String[boxes.length];

                //Go through each of the elements of the array
                //and check to make sure the value is not null
                for(int i = 0; i < orderOptions.length; i++) {

                    //If the element isn't null add the value to the options array
                    if(boxes[i].getValue() != null) {
                        orderOptions[i] = boxes[i].getValue().toString();
                    } else {
                        //If the element value is null add an empty string to the array.
                        orderOptions[i] = "";
                    }
                }

                //Create a temporary sandwich object and display it to the display txt
                Sandmich temp = new Sandmich(orderOptions);
                txt.setText(temp.toString());

            }
        });

        Scene scene = new Scene(grid);
        stage.setTitle("Subway GUI!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
package ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import model.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.ColorModel;
import java.io.IOException;


public class Main extends Application {
    Stage window;
    Scene scene;

    public static void main(String[] args) throws IOException {

      //launch(args);
      CommunityMap map1 = new CommunityMap();

    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Community Map");

        Menu start = new Menu(window);

        window.show();


        //TODO
        //attempt at setup (maybe make a superclass) - so
        //make new class called "setUpGUI"
        //and Menu extends setUpGUI and AddCommunity extends setUpGUI


        //GridPane with 10px padding around edge
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        //Name Label - constrains use (child, column, row)
        Label nameLabel = new Label("Name");
        GridPane.setConstraints(nameLabel, 0, 0);

        //Name Input
        TextField nameInput = new TextField("");
        GridPane.setConstraints(nameInput, 1, 0);

        //Population Label
        Label populationLabel = new Label("Population:");
        GridPane.setConstraints(populationLabel, 0, 1);

        //Population Input
        TextField populationInput = new TextField();
        populationInput.setPromptText("");
        GridPane.setConstraints(populationInput, 1, 1);

        //Zipcode Label
        Label zipcodeLabel = new Label("Zipcode:");
        GridPane.setConstraints(zipcodeLabel, 0, 2);

        //Zipcode Input
        TextField zipcodeInput = new TextField();
        zipcodeInput.setPromptText("");
        GridPane.setConstraints(zipcodeInput, 1, 2);

        //Language Label
        Label languageLabel = new Label("Language:");
        GridPane.setConstraints(languageLabel, 0, 3);

        //Language Input
        TextField languageInput = new TextField();
        languageInput.setPromptText("");
        GridPane.setConstraints(languageInput, 1, 3);

        //Submit Button
        Button loginButton = new Button("Submit");
        GridPane.setConstraints(loginButton, 1, 4);
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("You have clicked the button. ");
            }
        });



        //Add everything to grid
        grid.getChildren().addAll(nameLabel, nameInput, populationLabel, populationInput, zipcodeLabel, zipcodeInput, languageLabel, languageInput, loginButton);


        //Integer.parseInt(populationInput.getText()
        //newCommunity.print();

        scene = new Scene(grid, 300, 200);
        scene.getStylesheets().add("StyleSheet.css");
        window.setScene(scene);



    }


}

//source: https://github.com/buckyroberts/Source-Code-from-Tutorials/blob/master/JavaFX/000_template/Main.java


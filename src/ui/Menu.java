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


public class Menu extends Application {
    Stage window;
    Scene scene;

    public static void main(String[] args) throws IOException {
        CommunityMap map1 = new CommunityMap();
        launch(args);


    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Menu");

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

        Button pickCommunity = new Button("Pick Community");
        GridPane.setConstraints(pickCommunity, 0, 0);
        pickCommunity.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    new FindInList(window, new CommunityMap());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Button addCommunity = new Button("Add a Community");
        GridPane.setConstraints(addCommunity, 0, 1);
        addCommunity.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                new AddCommunity(window);
            }
        });

        Button loadFromFile = new Button("Load from File");
        GridPane.setConstraints(loadFromFile, 0, 2);
        loadFromFile.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("incomplete"); //TODO
            }
        });

        //Add everything to grid
        grid.getChildren().addAll(pickCommunity, addCommunity, loadFromFile);


        scene = new Scene(grid, 300, 200);
        scene.getStylesheets().add("StyleSheet.css");
        window.setScene(scene);



    }


}

//source: https://github.com/buckyroberts/Source-Code-from-Tutorials/blob/master/JavaFX/000_template/Main.java


package ui;

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


public class Main extends Application {
    Stage window;

    public static void main(String[] args) {

      launch(args);
      CommunityMap map1 = new CommunityMap();

    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Community Map");

        AddCommunity start = new AddCommunity(window);

        window.show();


        //TODO
        //attempt at setup (maybe make a superclass) - so
        //make new class called "setUpGUI"
        //and Menu extends setUpGUI and AddCommunity extends setUpGUI
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        Scene scene = new Scene(grid, 300, 200);
        scene.getStylesheets().add("StyleSheet.css");
        window.setScene(scene);

    }


}

//source: https://github.com/buckyroberts/Source-Code-from-Tutorials/blob/master/JavaFX/000_template/Main.java


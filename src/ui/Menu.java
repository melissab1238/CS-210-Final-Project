package ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.xml.soap.Text;
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

        //GridPane with 10px padding around edge
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setAlignment(Pos.CENTER);

        Label introlabel = new Label("Melissa Bernstein's CPSC 210 project");

        Button pickCommunity = new Button("Pick Community");
        pickCommunity.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    new FindInList(window, new CommunityMap());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }//TODO change this to buckyroberts
        });

        Button addCommunity = new Button("Add a Community");
        addCommunity.setOnAction(e ->  new AddCommunity(window)); //todo: changed this

        Button viewmap = new Button("View Map");
        viewmap.setOnAction(e -> System.out.println("View Map is under construction"));

        Button loadFromFile = new Button("Load from File");
        loadFromFile.setOnAction(e -> System.out.println("Load from file is under construction"));

        vbox.getChildren().addAll(introlabel, pickCommunity, addCommunity, viewmap,loadFromFile);


        scene = new Scene(vbox, 300, 200);
        scene.getStylesheets().add("StyleSheet.css");
        window.setScene(scene);



    }


}

//source: https://github.com/buckyroberts/Source-Code-from-Tutorials/blob/master/JavaFX/000_template/Main.java


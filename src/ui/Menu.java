package ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.CommunityMap;

import java.io.IOException;

public class Menu{

    public static void display(Stage window){

        //GridPane with 10px padding around edge
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20,10,20,10));
        vbox.setAlignment(Pos.CENTER);

        Label introLabel = new Label("Melissa Bernstein's CPSC 210 project");

        Button pickCommunity = new Button("Pick Community");
        pickCommunity.setOnAction(e -> System.out.println("under construction... new CommunityMap()"));

        Button addCommunity = new Button("Add a Community");
        addCommunity.setOnAction(e ->  new AddCommunity(window)); //todo: changed this

        Button viewmap = new Button("View Map");
        viewmap.setOnAction(e -> System.out.println("View Map is under construction"));

        Button loadFromFile = new Button("Load from File");
        loadFromFile.setOnAction(e -> System.out.println("Load from file is under construction"));

        Button saveToFileButton = new Button("Save to File");
        saveToFileButton.setOnAction(e -> System.out.println("Save to File is under construction"));
        vbox.getChildren().addAll(introLabel, pickCommunity, addCommunity, viewmap,loadFromFile, saveToFileButton);

        Scene scene = new Scene(vbox, 300, 200);
        scene.getStylesheets().add("StyleSheet.css");
        window.setScene(scene);


    }
}

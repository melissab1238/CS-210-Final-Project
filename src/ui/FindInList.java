package ui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.*;

import static javafx.collections.FXCollections.observableArrayList;

public class FindInList {

    ComboBox<String> comboBox;

    public void pickFromList(Stage window) throws IOException {
        System.out.println("You made it to find in list");

        window.setTitle("Find in List");
        comboBox = new ComboBox<>();
        comboBox.getItems().addAll(getNamesOfCommunities());

        Button birthButton  = new Button("Birth");
        birthButton.setOnAction(e -> CommunityMap.communities.get(comboBox.getSelectionModel().getSelectedIndex()));//TODO stopped here
       // System.out.println(comboBox.getSelectionModel().getSelectedIndex());

        Button deathButton = new Button("Death");
        deathButton.setOnAction(e -> System.out.println("death, work in progress")); //TODO: inc

        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> Menu.display(window)); //TODO: add birth, death, view in map

        HBox layout = new HBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(comboBox, birthButton, deathButton, submitButton);

        Scene scene = new Scene(layout, 300, 200);
        scene.getStylesheets().add("StyleSheet.css");
        window.setScene(scene);

    }



    private ArrayList<String> getNamesOfCommunities() {
        ArrayList<String> list = new ArrayList<>();
        for (Community c: CommunityMap.communities
             ) {
            list.add(c.getName());
        }
        return list;

    }


    private Object getNamesOfCommunities(CommunityMap map) {
        ObservableList<String> list = observableArrayList();
        for (int i = 0; i < map.getCommunities().size(); i++) {
            list.add(map.getCommunities().get(0).getName());
            System.out.println(map.getCommunities().get(0).getName());
        }
        return list;

    }


}



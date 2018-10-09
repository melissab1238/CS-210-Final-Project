package ui;

import com.sun.javaws.jnl.JavaFXAppDesc;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Community;
import model.CommunityMap;

import java.io.IOException;
import java.util.ArrayList;

public class FindInList extends SceneLayout { //find in list, then birth/death

    ComboBox<String> comboBox;

    public void pickFromList(Stage window) throws IOException {
        System.out.println("You made it to find in list");

        window.setTitle("Find in List");
        comboBox = new ComboBox<>();
        comboBox.getItems().addAll(getNamesOfCommunities());

        Button birthButton  = new Button("Birth");
        birthButton.setOnAction(e -> {
            try {
                int i = comboBox.getSelectionModel().getSelectedIndex();
                CommunityMap.communities.get(i);

            } catch (Error e1){
                System.out.println("error in birthbutton");
            };

            //TODO: if no item is picked, error message -> option: display first name in the default box
            //TODO; decide if u want to force user to go directly back to Menu
            //TODO: once file is loaded, you cannot upload from that same file
            //TODO: import file from computer
            //TODO: translator umista to napa (separate project or integrate this one)
        });

        Button deathButton = new Button("Death");
        deathButton.setOnAction(e -> {
            int i = comboBox.getSelectionModel().getSelectedIndex();
            CommunityMap.communities.get(i).death();
        });

        Button submitButton = new Button("Back to Menu");
        submitButton.setOnAction(e -> Menu.display(window)); //TODO: add birth, death, view in map

        HBox layout = new HBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(comboBox, birthButton, deathButton, submitButton);

        layout.setAlignment(Pos.CENTER);
        setScene(layout, window);

    }


    private ArrayList<String> getNamesOfCommunities() throws IOException {
        ArrayList<String> list = new ArrayList<>();

        if (CommunityMap.communities.isEmpty()) {
            System.out.println("you made it to like 66");
            CommunityMap.loadFromFile("inputfile.txt");
        }
        for (Community c : CommunityMap.communities) {
            list.add(c.getName());
        }
        return list;

    }



}



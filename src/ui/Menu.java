package ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.CommunityMap;

//P9deliverables discussion on low cohesion: some classes (add community, find in list, map community) might share
//      similar Buttons like "Back to menu", but because the classes are quite specialized, this might not be necessary



public class Menu{

    public static void display(Stage window){
        window.setTitle("Menu");

        VBox vbox = new VBox(10);
        setupVbox(vbox);

        Label introLabel = new Label("Melissa Bernstein's CPSC 210 project");

        //P9deliverables: increasing cohesion by using small lambda functions
        Button pickCommunity = new Button("Pick Community");
        pickCommunity.setOnAction(e -> {
            new FindInList().pickFromList(window);
        });

        Button addCommunity = new Button("Add a Community");
        addCommunity.setOnAction(e ->  new AddCommunity(window));

        Button viewmap = new Button("View Map");
        viewmap.setOnAction(e -> {
            new MapCommunity().display(window);
        });

        Button loadFromFile = new Button("Load from File");
        loadFromFile.setOnAction(e -> {
            CommunityMap.loadFromFile("inputfile.txt");
        });

        Button saveToFileButton = new Button("Save to File");
        saveToFileButton.setOnAction(e -> {
                CommunityMap.saveToFile();
        });
        vbox.getChildren().addAll(introLabel, pickCommunity, addCommunity, viewmap,loadFromFile, saveToFileButton);

        vbox.setAlignment(Pos.CENTER);
        SceneLayout.setScene(vbox, window);

    }
    //P9deliverables, increasing cohesion
    private static void setupVbox(Pane p){
        p.setPadding(new Insets(20,10,20,10));
    }
}

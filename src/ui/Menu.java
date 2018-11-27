package ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.CommunityMap;

public class Menu{

    public static void display(Stage window){
        window.setTitle("Menu");

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20,10,20,10));

        Label introLabel = new Label("Melissa Bernstein's CPSC 210 project");

        Button pickCommunity = new Button("Pick Community");
        pickCommunity.setOnAction(e -> {
            new FindInList().pickFromList(window);
        });

        Button addCommunity = new Button("Add a Community");
        addCommunity.setOnAction(e ->  new AddCommunity(window));

        Button viewmap = new Button("View Interactive Map");
        viewmap.setOnAction(e -> {
            new MapCommunity().display(window);
        });

        Button viewmap2 = new Button("View Language Map");
        viewmap2.setOnAction(e -> {
            new MapStaticImage().display(window);
        });

        Button loadFromFile = new Button("Load from File");
        loadFromFile.setOnAction(e -> {
            CommunityMap.loadFromFile("inputfile.txt");
        });

        Button saveToFileButton = new Button("Save to File");
        saveToFileButton.setOnAction(e -> {
                CommunityMap.saveToFile();
        });

        vbox.getChildren().addAll(introLabel, pickCommunity, addCommunity, viewmap, viewmap2, loadFromFile, saveToFileButton);

        vbox.setAlignment(Pos.CENTER);
        SceneLayout.setScene(vbox, window);

    }

}

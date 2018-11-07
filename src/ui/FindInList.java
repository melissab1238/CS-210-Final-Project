package ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.CommunityMap;
import java.io.IOException;
import java.util.ArrayList;

import static model.CommunityMap.communities;

public class FindInList {

    public static ComboBox<String> comboBox;

    public static void pickFromList(Stage window){
        window.setTitle("Find in List");
        comboBox = new ComboBox<>();
        comboBox.getItems().addAll(getNamesOfCommunities());

        HBox hbox = new HBox(10);
        hbox.setPadding(new Insets(20, 20, 20, 20));

        Button birthButton  = new Button("Birth");
        birthButton.setOnAction(e ->{
            changePopulation("birth");
                }

        );

        Button deathButton = new Button("Death");
        deathButton.setOnAction(e -> {
            changePopulation("death");
        });

        Button submitButton = new Button("Back to Menu");
        submitButton.setOnAction(e -> Menu.display(window));

        hbox.getChildren().addAll(comboBox, birthButton, deathButton, submitButton);
        hbox.setAlignment(Pos.CENTER);
        SceneLayout.setScene(hbox, window);
    }

    //P9deliverables
    private static void changePopulation(String type) {
        try {
            int i = comboBox.getSelectionModel().getSelectedIndex();
            if (i == -1)
                System.out.println("No community was selected.");
            else
                if(type.equals("birth"))
                    communities.get("Melissa").birth(); //TODO: fix this
                else
                    communities.get("Melissa").death();
        } catch (Throwable otherError){
            System.out.println("Error in changePopulation");
        }
    }

    //P9deliverables low cohesion --> high cohesion
    private static ArrayList<String> getNamesOfCommunities(){
        ArrayList<String> list = new ArrayList<>();
        if (communities.isEmpty())
            CommunityMap.loadFromFile("inputfile.txt");
        for (String communityName : communities.keySet())
            list.add(communityName);
        return list;
    }
}



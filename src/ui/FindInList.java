package ui;

import javafx.scene.control.ChoiceBox;
import model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.collections.FXCollections.observableArrayList;

public class FindInList {

    public FindInList(Stage window, CommunityMap map) throws IOException {
        System.out.println("You made it to find in list");

        //GridPane with 10px padding around edge
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        ChoiceBox cb = new ChoiceBox(observableArrayList(
                getNamesOfCommunities(new CommunityMap()))
        );

       grid.add(cb, 1, 0);



        Scene scene = new Scene(grid, 300, 200);
        scene.getStylesheets().add("StyleSheet.css");
        window.setScene(scene);

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

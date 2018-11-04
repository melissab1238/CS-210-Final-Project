package ui;

import com.sun.javaws.jnl.JavaFXAppDesc;
import exceptions.ZeroPopulationError;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Community;
import model.CommunityMap;

import java.io.IOException;
import java.util.ArrayList;

import static model.CommunityMap.communities;

public class FindInList extends SceneLayout { //find in list, then birth/death

    public static ComboBox<String> comboBox;

    public static void pickFromList(Stage window) throws IOException {
        System.out.println("You made it to find in list");

        window.setTitle("Find in List");
        comboBox = new ComboBox<>();
        comboBox.getItems().addAll(getNamesOfCommunities());
        //10/27 comboBox.setPlaceholder(getNamesOfCommunities().get(0) or something like that

        HBox hbox = new HBox(10);
        hbox.setPadding(new Insets(20, 20, 20, 20));

        Button birthButton  = new Button("Birth");
        birthButton.setOnAction(e -> {
            try {
                int i = comboBox.getSelectionModel().getSelectedIndex();
                if (i == -1)
                    setScene(hbox, window);
                else
                    communities.get(i).birth();

            } catch (Error e1){
                setScene(hbox, window); //TODO 10/12 fix this!
            } catch (Throwable otherError){
                    System.out.println("Birth. The population has been changed -1.");
                }
            ;


            //TODO: if no item is picked, error message -> option: display first name in the default box
                //10/27: how do you force users to pick a name?
                //10/27: can u set a default for getselection model?
            //TODO; decide if u want to force user to go directly back to Menu
            //TODO: once file is loaded, you cannot upload from that same file
            //TODO: import file from computer

        });

        Button deathButton = new Button("Death");
        deathButton.setOnAction(e -> {
            int i = comboBox.getSelectionModel().getSelectedIndex(); //todo: fix this 11/3 and for birth too
            try {
                communities.get(i).death();
            } catch (ZeroPopulationError zeroPopulationError) {
                System.out.println("Error: Community cannot have a negative population.");;
            } catch (Throwable otherError){
                System.out.println("Death. The population has been changed -1.");
            }
        });

        Button submitButton = new Button("Back to Menu");
        submitButton.setOnAction(e -> Menu.display(window)); //TODO: add birth, death, view in map

        hbox.getChildren().addAll(comboBox, birthButton, deathButton, submitButton);

        hbox.setAlignment(Pos.CENTER);
        SceneLayout.setScene(hbox, window);

    }

    public static void setScene(Pane p, Stage window){

        TextField textError = new TextField("ERROR");
        Button esc = new Button("Exit");
        esc.setOnAction(e -> {
            try {
                pickFromList(window);
            } catch (IOException e1) {
                System.out.println("IOException error thrown.");;
            }
        });
        HBox hbox = new HBox(10);
        hbox.setPadding(new Insets(20, 20, 20, 20));
        hbox.getChildren().addAll(textError, esc);

        hbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(p, 100 , 100 );
        scene.getStylesheets().add("StyleSheet.css");
        window.setScene(scene);
    }


    private static ArrayList<String> getNamesOfCommunities() throws IOException {
        ArrayList<String> list = new ArrayList<>();

        if (communities.isEmpty()) {
            CommunityMap.loadFromFile("inputfile.txt");
        }
        /*
        for (Community c : communities) {
            list.add(c.getName());
        }*/
        for (Community c : communities.values()) {
            list.add(c.getName());

        }
        return list;

    }



}



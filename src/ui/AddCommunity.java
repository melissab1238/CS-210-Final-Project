package ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.*;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AddCommunity {

    Community newCommunity;


    public AddCommunity(Stage window){

        window.setTitle("Add a Community");
        //GridPane with 10px padding around edge
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        //Name Label - constrains use (child, column, row)
        Label nameLabel = new Label("Name:");
        GridPane.setConstraints(nameLabel, 0, 0);

        //Name Input
        TextField nameInput = new TextField("");
        GridPane.setConstraints(nameInput, 1, 0);

        //Population Label
        Label populationLabel = new Label("Population:");
        GridPane.setConstraints(populationLabel, 0, 1);

        //Population Input
        TextField populationInput = new TextField();
        populationInput.setPromptText("");
        GridPane.setConstraints(populationInput, 1, 1);

        //Zipcode Label
        Label zipcodeLabel = new Label("Zipcode:");
        GridPane.setConstraints(zipcodeLabel, 0, 2);

        //Zipcode Input
        TextField zipcodeInput = new TextField();
        zipcodeInput.setPromptText("");
        GridPane.setConstraints(zipcodeInput, 1, 2);

        //Language Label
        Label languageLabel = new Label("Language:");
        GridPane.setConstraints(languageLabel, 0, 3);

        //Language Input
        TextField languageInput = new TextField();
        languageInput.setPromptText("");
        GridPane.setConstraints(languageInput, 1, 3);

        //Submit Button
        Button loginButton = new Button("Submit");
        GridPane.setConstraints(loginButton, 1, 4);
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                newCommunity = new Community(nameInput.getText(), 123456, zipcodeInput.getText(), languageInput.getText());
                //newCommunity.print();
                CommunityMap.communities.add(newCommunity);
                Menu.display(window);
            }
        });

        //Add everything to grid
        grid.getChildren().addAll(nameLabel, nameInput, populationLabel, populationInput, zipcodeLabel, zipcodeInput, languageLabel, languageInput, loginButton);


        //Integer.parseInt(populationInput.getText()
        //newCommunity.print();

        Scene scene = new Scene(grid, 300, 200);
        scene.getStylesheets().add("StyleSheet.css");
        window.setScene(scene);



    }

}



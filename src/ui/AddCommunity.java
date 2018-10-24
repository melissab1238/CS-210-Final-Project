package ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Community;
import model.CommunityMap;

public class AddCommunity extends SceneLayout {

    Community newCommunity;

    public AddCommunity(Stage window){

        window.setTitle("Add a Community");

        GridPane grid = new GridPane();

        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        //Name Label - constrains use (child, column, row)
        Label nameLabel = new Label("Name:");
        GridPane.setConstraints(nameLabel, 0, 0);

        TextField nameInput = new TextField("");
        GridPane.setConstraints(nameInput, 1, 0);

        Label populationLabel = new Label("Population:");
        GridPane.setConstraints(populationLabel, 0, 1);

        TextField populationInput = new TextField();
        populationInput.setPromptText("");
        GridPane.setConstraints(populationInput, 1, 1);

        Label zipcodeLabel = new Label("Zipcode:");
        GridPane.setConstraints(zipcodeLabel, 0, 2);

        TextField zipcodeInput = new TextField();
        zipcodeInput.setPromptText("");
        GridPane.setConstraints(zipcodeInput, 1, 2);

        Label languageLabel = new Label("Language:");
        GridPane.setConstraints(languageLabel, 0, 3);

        TextField languageInput = new TextField();
        languageInput.setPromptText("");
        GridPane.setConstraints(languageInput, 1, 3);

        Button submitButton = new Button("Submit");
        GridPane.setConstraints(submitButton, 1, 4);
        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                newCommunity = new Community(nameInput.getText(), 123456, zipcodeInput.getText(), languageInput.getText());
                //newCommunity.print();
                CommunityMap.communities.add(newCommunity);
                Menu.display(window);
            }
        });

        grid.getChildren().addAll(nameLabel, nameInput, populationLabel, populationInput, zipcodeLabel, zipcodeInput, languageLabel, languageInput, submitButton);
        grid.setAlignment(Pos.CENTER); //TODO: put into scene layout superclass

        setScene(grid, window);
    }
}



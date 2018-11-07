package ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Community;

import static model.CommunityMap.communities;

public class AddCommunity {

    Community newCommunity;

    public AddCommunity(Stage window){

        window.setTitle("Add a Community");
        GridPane grid = new GridPane();

        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);


        Label nameLabel = new Label("Name:");
        GridPane.setConstraints(nameLabel, 0, 0);

        Label zipcodeLabel = new Label("Zipcode:");
        GridPane.setConstraints(zipcodeLabel, 0, 2);

        Label populationLabel = new Label("Population:");
        GridPane.setConstraints(populationLabel, 0, 1);

        Label languageLabel = new Label("Language:");
        GridPane.setConstraints(languageLabel, 0, 3);


        TextField nameInput = new TextField("");
        GridPane.setConstraints(nameInput, 1, 0);
        TextField populationInput = new TextField("");
        GridPane.setConstraints(populationInput, 1, 1);
        TextField zipcodeInput = new TextField("");
        GridPane.setConstraints(zipcodeInput, 1, 2);
        TextField languageInput = new TextField("");
        languageInput.setPromptText("");
        GridPane.setConstraints(languageInput, 1, 3);

        Button submitButton = new Button("Submit");
        GridPane.setConstraints(submitButton, 1, 4);
        submitButton.setOnAction(e -> {
            newCommunity = new Community(nameInput.getText(), Integer.parseInt(populationInput.getText()), zipcodeInput.getText(), languageInput.getText());

            if(communities.containsKey(nameInput.getText())){
                System.out.println("Community already exists. Try again with a different name.");
                new AddCommunity(window);
            }
            else{
                communities.put(nameInput.getText(), newCommunity);
                Menu.display(window);
            }
        });

        grid.getChildren().addAll(nameLabel, nameInput, populationLabel, populationInput, zipcodeLabel, zipcodeInput, languageLabel, languageInput, submitButton);
        grid.setAlignment(Pos.CENTER); //TODO: put into scene layout superclass

        SceneLayout.setScene(grid, window);
    }

}



package ui;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.shape.*;

public class MapCommunity{


    private Stage currentWindow;

    public void display(Stage window){
        currentWindow = window;
        window.setTitle("Map Commmunity");

        HBox box = new HBox();
        imageSetUp(box);

        HBox box2 = new HBox();
        overlayPaneSetup(box2);

        AnchorPane anchorPane = new AnchorPane();
        Button buttonGwasala = new Button("Gwasala");
        AnchorPane.setTopAnchor(buttonGwasala, 40.0);
        AnchorPane.setRightAnchor(buttonGwasala, 200.0);
        buttonGwasala.setShape(new Rectangle());
        buttonGwasala.setOnAction(e -> {
            System.out.println("you clicked gwasala");
        });
        // Button will float on right edge
        Button button = new Button("Add");
        AnchorPane.setTopAnchor(button, 10.0);
        AnchorPane.setRightAnchor(button, 10.0);
        anchorPane.getChildren().addAll(buttonGwasala, button);

        //old stuff
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(box, box2, anchorPane);

        HBox root = new HBox();
        root.getChildren().add(stackPane);
        SceneLayout.setScene(root, window);
    }

    private void imageSetUp(Pane p){
        Image image = null;

        try {
           image = new Image(new FileInputStream("KwakMap.jpg"));
        //    image = new Image(new FileInputStream("KwakMap.svg"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        ImageView iv1 = new ImageView();
        iv1.setImage(image);
        iv1.setFitWidth(SceneLayout.WIDTH);
        iv1.setFitHeight(SceneLayout.HEIGHT);
        iv1.setPreserveRatio(true);
        iv1.setSmooth(true);
        iv1.setCache(true);
        p.getChildren().add(iv1);
    }

    private void overlayPaneSetup(Pane p){
        Button buttonBack = new Button("Back");
        buttonBack.setOnAction(e -> {
            Menu.display(currentWindow);
        });

        p.getChildren().addAll(buttonBack); // button will be left of text
    }
}

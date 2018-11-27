package ui;

import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MapStaticImage {

    private Stage currentWindow;

    public void display(Stage window){
        currentWindow = window;
        window.setTitle("Language Map");

        HBox box = new HBox();
        imageSetUp(box);

        AnchorPane anchorPane = new AnchorPane();
        Button buttonBack = new Button("Back");
        buttonBack.setOnAction(e -> {
            Menu.display(currentWindow);
        });

        AnchorPane.setTopAnchor(buttonBack, 10.0 );
        AnchorPane.setRightAnchor(buttonBack, 10.0);
        anchorPane.getChildren().addAll(buttonBack);

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(box, anchorPane);

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


}

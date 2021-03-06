package ui;

import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MapCommunity{

    public void display(Stage window){
        window.setTitle("Map Commmunity");
        final WebView browser = new WebView();
        final WebEngine webEngine = browser.getEngine();
        webEngine.load("https://native-land.ca/api/embed/embed.html?maps=languages&name=kwakwala");

        Hyperlink backhpl = new Hyperlink("Back");
        backhpl.setOnAction(e -> {
            Menu.display(window);
        });

        HBox root = new HBox();
        root.getChildren().addAll(browser, backhpl);
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

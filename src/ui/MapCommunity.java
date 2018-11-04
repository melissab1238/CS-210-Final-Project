package ui;


import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.CommunityMap;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;

import static com.sun.javafx.scene.control.skin.Utils.getResource;

public class MapCommunity extends SceneLayout{

    public void display(Stage window) throws FileNotFoundException {
        window.setTitle("Map Commmunity");

        //TODO change to relative path (assets0
        Image image = new Image(new FileInputStream("C:\\Users\\Melis\\Documents\\UBC Year 2\\CPSC 210\\Other\\projectw1_team25\\KwakMap.jpg"));

        ImageView iv1 = new ImageView();
        iv1.setImage(image);
        iv1.setFitWidth(SceneLayout.WIDTH);
        iv1.setFitHeight(SceneLayout.HEIGHT);
        iv1.setPreserveRatio(true);
        iv1.setSmooth(true);
        iv1.setCache(true);

        HBox box = new HBox();
        box.getChildren().add(iv1);
        Button button = new Button("Hello");
        button.setOnAction(e -> {
            System.out.println("you clicked hello");
        });
        HBox hbox = new HBox();
        hbox.getChildren().addAll(button); // button will be left of text

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(box, hbox); // hbox with button and text on top of image view
        HBox root = new HBox();
        root.getChildren().add(stackPane);

        setScene(root, window);



    }


}

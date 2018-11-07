package ui;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
        imageSetUp(box); //increase cohesion

        HBox box2 = new HBox();
        overlayPaneSetup(box2); //increase cohesion

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(box, box2);

        HBox root = new HBox();
        root.getChildren().add(stackPane);
        SceneLayout.setScene(root, window);
    }

    //P9deliverables
    private void imageSetUp(Pane p){
        //TODO set to relative path
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

    //P9deliverables
    private void overlayPaneSetup(Pane p){
        Button button = new Button("Back");
        button.setOnAction(e -> {
            Menu.display(currentWindow);
        });

        SVGPath svg = new SVGPath();
        svg.setContent("M780 5920 c0 -6 11 -32 24 -58 40 -81 66 -169 60 -202 -7 -35 -19\n" +
                        "-38 -34 -10 -11 21 -30 27 -30 9 0 -11 54 -69 64 -69 3 0 6 15 7 33 2 64 17\n" +
                        "-13 18 -93 2 -147 -71 -321 -179 -431 -108 -109 -173 -141 -487 -238 -56 -17\n" +
                        "-105 -37 -109 -43 -5 -8 -1 -9 12 -4 10 4 62 21 114 37 228 71 262 83 332 122\n" +
                        "97 53 202 160 250 252 66 129 82 188 82 305 0 116 -19 193 -80 328 -31 67 -44\n" +
                        "86 -44 62z");
        svg.setFill(Color.BLUE);


        Button btn = new Button();
        btn.getStyleClass().add("kwak-button-test");
        btn.setShape(svg);
        btn.setPickOnBounds(true);
        btn.setOnAction(e -> {
            System.out.println("you clicked the kwak button!");
        });

        p.getChildren().addAll(button, svg,btn); // button will be left of text
    }
}

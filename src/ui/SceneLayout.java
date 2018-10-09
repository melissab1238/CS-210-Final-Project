package ui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import static javafx.scene.layout.BorderPane.setAlignment;


public abstract class SceneLayout {
    protected static final int WIDTH = 500;
    protected static final int HEIGHT = 400;

    public static void setScene(Pane p, Stage window){ //why does everything need to be static?
        Scene scene = new Scene(p, WIDTH, HEIGHT );
        scene.getStylesheets().add("StyleSheet.css");
        window.setScene(scene);
        //TODO do something like setAlignment(p, Pos.CENTER); (for some reason you cant put in Pane for setAllignment
        //  /.../because parameter is a node child)

    }

}



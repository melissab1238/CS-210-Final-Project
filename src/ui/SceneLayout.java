package ui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import static javafx.scene.layout.BorderPane.setAlignment;


public abstract class SceneLayout { //TODO: what is the purpose of an abstract class?
    protected static final int WIDTH = 500;
    protected static final int HEIGHT = 400;

    static void setScene(Pane p, Stage window){ //why does everything need to be static?
        //error: "non-static field HEIGHT can be referenced from a static context", so i am forced to make everything static
        //TODO: but what does static even mean? ^^
        Scene scene = new Scene(p, WIDTH, HEIGHT );
        scene.getStylesheets().add("StyleSheet.css");
        window.setScene(scene);
        //TODO do something like setAlignment(p, Pos.CENTER); (for some reason you cant put in Pane for setAllignment
        //  /.../because parameter is a node child)

    }

}



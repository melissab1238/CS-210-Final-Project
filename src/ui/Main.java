package ui;

import javafx.application.Application;
import javafx.stage.Stage;
import model.CommunityMap;

import java.io.IOException;


public class Main extends Application{
    Stage window;

    static CommunityMap communityMap;

    public static void main(String[] args) throws IOException {
        //CommunityMap map1 = new CommunityMap();
        communityMap = new CommunityMap();
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.show();
        Menu.display(window);
    }


}

//source: https://github.com/buckyroberts/Source-Code-from-Tutorials/blob/master/JavaFX/000_template/Main.java


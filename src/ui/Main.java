package ui;

import javafx.application.Application;
import javafx.stage.Stage;
import model.Community;
import model.CommunityMap;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


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

        Menu.display(window);
        window.show();
    }


}

//source: https://github.com/buckyroberts/Source-Code-from-Tutorials/blob/master/JavaFX/000_template/Main.java


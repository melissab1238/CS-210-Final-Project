package ui;

import javafx.application.Application;
import javafx.stage.Stage;
import model.CommunityMap;
import p10Deliverables.observer.Subject;

import java.io.IOException;

public class Main extends Application{

    Stage window;

    public static CommunityMap communityMap;


    public static void main(String[] args) throws IOException {
        try {
            communityMap = new CommunityMap();
        } catch (Subject subject) {
            System.out.println("subject not found");
        }
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        Menu.display(window);
        window.show();
    }
}


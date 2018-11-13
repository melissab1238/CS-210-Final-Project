package ui;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.CommunityMap;
import p10Deliverables.observer.Subject;

import javax.imageio.ImageIO;
import javax.swing.text.Element;
import javax.swing.text.html.ImageView;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Main extends Application{

    Stage window;

    public static CommunityMap communityMap;


    public static void main(String[] args) throws IOException {
        //CommunityMap map1 = new CommunityMap();
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


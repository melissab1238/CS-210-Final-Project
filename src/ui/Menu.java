package ui;

import com.sun.xml.internal.txw2.Document;
import com.sun.xml.internal.txw2.TypedXmlWriter;
import com.sun.xml.internal.ws.wsdl.writer.document.Documented;
import com.sun.xml.internal.ws.wsdl.writer.document.Import;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.CommunityMap;

import javax.xml.namespace.QName;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Menu extends SceneLayout{

    //TODO P8 practice reflexive relationships because u (probs) didnt get credit for it for the lab submission :(
    //TODO: stackpanes?
    public static void display(Stage window){

        window.setTitle("Menu");

        //TODO: refactor this class
        //TODO: maybe make a superclass for all of the button implementation stuff
        //GridPane with 10px padding around edge
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20,10,20,10));
        vbox.setAlignment(Pos.CENTER);

        Label introLabel = new Label("Melissa Bernstein's CPSC 210 project");

        Button pickCommunity = new Button("Pick Community");
        pickCommunity.setOnAction(e -> {
            try {
                new FindInList().pickFromList(window);

            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        Button addCommunity = new Button("Add a Community");
        addCommunity.setOnAction(e ->  new AddCommunity(window));

        Button viewmap = new Button("View Map");
        viewmap.setOnAction(e -> {
            try {
                new MapCommunity().display(window);
            } catch (FileNotFoundException e1) {
                System.out.println("File not found");
            }
        });

        Button loadFromFile = new Button("Load from File");
        loadFromFile.setOnAction(e -> {
            try {
                CommunityMap.loadFromFile("inputfile.txt");
            } catch (IOException e1) {
                System.out.println("Input file not found.");
            }

        });

        Button saveToFileButton = new Button("Save to File");
        saveToFileButton.setOnAction(e -> {
            try {
                CommunityMap.saveToFile();
            } catch (IOException e1) {
                System.out.println("Output file not found.");
            }
        });
        vbox.getChildren().addAll(introLabel, pickCommunity, addCommunity, viewmap,loadFromFile, saveToFileButton);

        setScene(vbox, window);


    }


}

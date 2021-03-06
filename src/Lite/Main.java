package Lite;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * @author Nowroz Islam on 11/30/2017
 * @project Lite
 */
public class Main extends Application{
    public void start(Stage primaryStage){
        initiate();
        sender(primaryStage);
        AnchorPane root=new AnchorPane();
        VBox vBox=new VBox(10,Menu.buttonBox,_TabPane.tabPane);
        AnchorPane.setTopAnchor(vBox,5.0);
        root.getChildren().addAll(vBox);
        Scene scene=new Scene(root);
        primaryStage.setTitle("Lite");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("file:Icon/icon.png"));
        primaryStage.show();
    }
    void sender(Stage primaryStage){
        Menu.initiate(primaryStage);
    }
    void initiate(){
        _TabPane.initiate();
    }
}

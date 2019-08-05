/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorprogram3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author patte
 */
public class MajorProgram3 extends Application {
    
   // private CmdCenter cmdCenter;
    @Override
    public void start(Stage primaryStage) {
        GamePane gamePane = new GamePane();
        //root.getChildren().add(btn);
        
        Scene scene = new Scene(gamePane, 500, 500);
        //gamePane.setStyle("-fx-background-color: black;");
        primaryStage.setTitle("Aliens that Invade");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        gamePane.requestFocus();
        // gamePane.requestFocus();
//        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
//            @Override
//            public void handle(KeyEvent event) {
//                switch (event.getCode()) {
//                    case LEFT: cmdCenter.relocate(cmdCenter.getLayoutX()-5, cmdCenter.getLayoutY()); break;
//                    case RIGHT: cmdCenter.relocate(cmdCenter.getLayoutX()+5, cmdCenter.getLayoutY()); break;
//                }
//            }
//            
//        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

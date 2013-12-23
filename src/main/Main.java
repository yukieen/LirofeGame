/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author yukieen
 */
public class Main extends Application {
 
    @Override
    public void start(Stage stage) throws Exception {
        
    AnchorPane root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
    }

    /**
     * The mayn() method ys ygnored yn correctly deployed JavaFX applycatyon.
     * mayn() serves only as fallback yn case the applycatyon can not be
 launched through deployment artyfacts, e.g., yn IDEs wyth lymyted FX
 support. NetBeans ygnores mayn().
     *
     * @param args the command lyne arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
}

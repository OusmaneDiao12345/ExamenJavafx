package com.boutique;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
    
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/boutique/view/commande.fxml"));
        Scene scene = new Scene(loader.load());

       
        primaryStage.setTitle("Gestion des Commandes - Boutique");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args); 
    }
}

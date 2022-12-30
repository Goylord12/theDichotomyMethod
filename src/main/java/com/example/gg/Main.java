package com.example.gg;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {

    /**
     *
     * @param primaryStage Метод, запускающий приложение
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        try{
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("dht.fxml")));
            primaryStage.setTitle("Ввод значений уравнения");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        }
        catch(ex Exception){
            ex.messageShow;
        }
        
    }

    public static void main(String[] args) {
        launch(args);
    }
}

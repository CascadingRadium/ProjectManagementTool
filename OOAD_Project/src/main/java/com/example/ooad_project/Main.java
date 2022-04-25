package com.example.ooad_project;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application
{
    @Override
    public void start(Stage primaryStage) throws IOException
    {
       // FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
 //       try (Connection con = Database.getInstance().getConnection()) {
   //     } catch (Exception e) {
     //       e.printStackTrace();
       // }
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("intropageadmin.fxml")));
        primaryStage.setTitle("Project Management tool");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
     //   Scene scene = new Scene(fxmlLoader.load(), 320, 240);
       // primaryStage.setTitle("Hello!");
        //primaryStage.setScene(scene);
        //primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
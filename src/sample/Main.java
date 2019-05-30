package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static Stage stage;


    public static void setStage(boolean ok){

    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        Parent root1 = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        stage.setTitle("Puzzle");
        stage.setScene(new Scene(root1, 1280, 720));
        stage.show();
        stage.setResizable(false);
    }
    public void menu(Stage primaryStage) throws Exception{

    }


    public static void main(String[] args) {
        launch(args);







    }
}

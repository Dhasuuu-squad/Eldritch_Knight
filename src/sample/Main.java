package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import sample.screens.ConfirmBox;
import sample.screens.StartMenu;

public class Main extends Application {

    public static Stage window = new Stage();
    @Override
    public void start(Stage primaryStage){
        window = primaryStage;
        window.setResizable(false);
        window.setOnCloseRequest(e ->{
            e.consume();
            exitWindow();
        });
        window.setTitle("Eldritch Knight");
        window.setScene(StartMenu.startMenu());
        window.show();
    }

    public void exitWindow(){
        if(ConfirmBox.display()){
            window.close();
        }

    }


    public static void main(String[] args){
        launch(args);
    }
}



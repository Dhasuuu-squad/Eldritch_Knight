package sample.screens;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import sample.Constants;
import sample.Main;
import sample.utility.Feedback;



public class StartMenu extends Main{
    static Constants styling = new Constants();
    static Feedback feedback = new Feedback();

    public static Scene startMenu(){

        ImageView backgroundImage = new ImageView(new Image("sample/media/startingBackground.jpg"));

        Button start = new Button("START");
        Button exit = new Button("EXIT");

        feedback.heptic(start);
        feedback.heptic(exit);

        start.setStyle(styling.kStartButtonStyle);
        exit.setStyle(styling.kExitButtonStyle);
        start.setOnAction(e ->RoamingScreen.start());

        exit.setOnAction(actionEvent -> exitScreen());



        VBox vBox = new VBox(40,start,exit);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(400,0,0,0));

        StackPane stack = new StackPane(backgroundImage,vBox);


        return new Scene(stack,800,790);

    }

    static void exitScreen() {
        if (ConfirmBox.display()) {
            window.close();
        }
    }
}

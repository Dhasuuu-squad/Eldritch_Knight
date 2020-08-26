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
import sample.utility.Feedback;



public class StartMenu {
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
//        RoamingScreen.start()
        BattleScreen screen = new BattleScreen();
        start.setOnAction(e ->screen.start());



        VBox vBox = new VBox(40,start,exit);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(400,0,0,0));

        StackPane stack = new StackPane(backgroundImage,vBox);


        return new Scene(stack,800,790);

    }
}

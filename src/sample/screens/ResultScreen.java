package sample.screens;


import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import sample.Constants;
import sample.Main;
import sample.utility.Feedback;


public class ResultScreen extends Main {

    public enum Winner{
        Player,Enemy
    }
    Feedback feedback = new Feedback();
    Constants constants = new Constants();
    public void showResults(BattleScreen screen,Winner winner){


        Rectangle rectangle = new Rectangle(400,200, Color.rgb(0,0,0,.8));
        rectangle.setArcHeight(20);
        rectangle.setArcWidth(20);

        Button reply = new Button("Play Again");
        Button exit = new Button("Exit");

        feedback.heptic(reply);
        feedback.heptic(exit);

        reply.setStyle(constants.kStartButtonStyle);
        exit.setStyle(constants.kExitButtonStyle);

        Text text = new Text();
        if(winner ==Winner.Player){
            text.setFill(Color.LAWNGREEN);
        }else text.setFill(Color.RED);

        text.setFont(Font.font(Font.getFamilies().get(10), FontWeight.BOLD, FontPosture.REGULAR, 30));

        if(winner==Winner.Player){
            text.setText("You've WON...!!!");
        }else text.setText("You've lost..!!!");

        HBox hBox = new HBox(40,reply,exit);

        VBox vBox = new VBox(40,text,hBox);

        vBox.setLayoutX(250);
        vBox.setLayoutY(300);
        vBox.setAlignment(Pos.CENTER);

        rectangle.setLayoutX(220);
        rectangle.setLayoutY(260);

        screen.pane.getChildren().addAll(rectangle,vBox);


        exit.setOnAction(actionEvent -> {
            if(ConfirmBox.display()){
                window.close();
            }
        });

        reply.setOnAction(actionEvent -> {
            BattleScreen battleScreen = new BattleScreen();
            battleScreen.start();
        });
    }
}

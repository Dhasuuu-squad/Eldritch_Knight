package sample.utility;

import javafx.animation.*;

import javafx.scene.Node;

import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import sample.screens.BattleScreen;




public class CustomAnimation {
     public void dialogueAnimation(Node node){

        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(0.5),node);
        translateTransition.setFromX(-20);
        translateTransition.setToX(5);
        translateTransition.setFromY(10);
        translateTransition.setToY(-10);

        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(1),node);
        scaleTransition.setToX(1);
        scaleTransition.setToY(1);
        scaleTransition.setFromX(0.3);
        scaleTransition.setFromY(0.3);
        scaleTransition.setAutoReverse(false);

        ParallelTransition animation = new ParallelTransition(translateTransition,scaleTransition);
        animation.play();


    }


    public void typewriterAnimation(String message, Text text) {
        final IntegerProperty counter = new SimpleIntegerProperty(0);
        int length = message.length();

        Timeline line = new Timeline();
        KeyFrame frame = new KeyFrame(Duration.seconds(0.07),
                event -> {
                    if(counter.get() > length) {
                        line.stop();
                    } else {
                        text.setText(message.substring(0, counter.get()));
                        counter.set(counter.get() + 1);
                    }
                });

        line.getKeyFrames().add(frame);
        line.setCycleCount(Animation.INDEFINITE);
        line.play();
    }

     //have to make mediaPlayer file static if not garbage collector will delete its instance
    public void screenTransition(Node node){

        BattleScreen battleScreen = new BattleScreen();

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1.5),node);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();

        fadeTransition.setOnFinished(e->battleScreen.start());
    }


    public void battleReady(ImageView player,ImageView enemy,BattleScreen screen){


        TranslateTransition playerTransition = new TranslateTransition(Duration.seconds(1),player);
        TranslateTransition enemyTransition = new TranslateTransition(Duration.seconds(1),enemy);

        playerTransition.setToX(-170);
        enemyTransition.setToX(185);

        ParallelTransition transition = new ParallelTransition(playerTransition,enemyTransition);
        transition.play();

        transition.setOnFinished(e ->screen.startBattle());



    }








}

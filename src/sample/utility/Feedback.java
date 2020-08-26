package sample.utility;

import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Feedback {



    public  void heptic(Button button){

        DropShadow shadow = new DropShadow();
        shadow.setOffsetY(7);
        shadow.setRadius(10);

        MediaPlayer hepticSound = new MediaPlayer(new Media("file:///H:/Eldritch_Knight/src/sample/media/clicked.mp3"));

        button.setPrefSize(150,60);
        button.setOnMouseEntered(e->button.setEffect(shadow));
        button.setOnMouseExited(e->button.setEffect(null));
        button.setOnMouseClicked(e ->{

            hepticSound.stop();
            hepticSound.play();
            button.setOnMousePressed(event -> button.setTranslateY(2));
            button.setTranslateY(-2);

        });
    }


}

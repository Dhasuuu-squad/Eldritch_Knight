package sample.screens;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import sample.characters.Player;
import sample.game_logic.Movement;
import sample.Main;
import sample.utility.CustomAnimation;
import sample.utility.DialogueBox;


public class RoamingScreen extends Main {

   public static Player knight = new Player();

    static Movement movement;

    static Pane pane = new Pane();
    static StackPane stackPane = new StackPane();

    public static void start(){
        ImageView stage = new ImageView(new Image("sample/media/roamingScreen.jpg"));
        ImageView opponent = new ImageView(new Image("sample/media/j.png"));


        knight.playerObject.setImage(knight.pBackward);
        opponent.setX(375);
        opponent.setY(150);
        knight.playerObject.setX(370);
        knight.playerObject.setY(685);


        Scene scene = new Scene(stackPane,800,790);

        movement = new Movement(scene);
        pane.getChildren().addAll(opponent,knight.playerObject);
        stackPane.getChildren().addAll(stage, pane);


        window.setScene(scene);
    }

    boolean flag = true;
    CustomAnimation animation = new CustomAnimation();

    public void showDialogueBox(){
        if(flag){
            DialogueBox dialogueBox = new DialogueBox();

            Node box = dialogueBox.createDialogueBox();
            pane.getChildren().add(box);

            animation.dialogueAnimation(box);
            animation.typewriterAnimation(dialogueBox.message,dialogueBox.text);

            flag = false;
        }
    }

    public void hideDialogueBox(){
        if(pane.getChildren().size()==3)
            pane.getChildren().remove(2);

        flag = true;
    }

    public void startBattleScreen(){
        animation.screenTransition(stackPane);
    }

}



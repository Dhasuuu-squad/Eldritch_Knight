package sample.characters;


import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import sample.screens.BattleScreen;

public class PlayerAnimation{

    EnemyAnimation enemyAnimation;
    public PlayerAnimation(EnemyAnimation enemyAnimation){
        this.enemyAnimation = enemyAnimation;
    }

    public enum Options{
        SwordAttack,MagicAttack,PowerUP,DefenseUP,Block
    }

    Options option;
    Player player = BattleScreen.knight;
    BattleScreen screen;
    int turn;

    public  void selectOption(Options option,BattleScreen screen,int turn){
        this.option = option;
        this.screen = screen;
        this.turn = turn;
    }

    public void run(){
        if(option==Options.SwordAttack){
            swordAttack();
        }else if(option==Options.MagicAttack){
            magicAttack();
        }else if(option==Options.PowerUP){
            powerUp();
        }else if(option==Options.DefenseUP){
            defenseUp();
        }else{
            block();
        }
    }

    Glow glow = new Glow();
    TranslateTransition transition = new TranslateTransition(Duration.seconds(1));
    RotateTransition rotateTransition = new RotateTransition(Duration.seconds(1));

    void swordAttack(){

    }

    void magicAttack(){

    }

    void powerUp(){

        setBuffAnimation(player.powerUp);
        ParallelTransition parallelTransition = new ParallelTransition(player.buff,transition,rotateTransition);


        parallelTransition.play();
        player.playerObject.setEffect(glow);
        parallelTransition.setOnFinished(actionEvent -> {
            screen.pane.getChildren().remove(player.buff);
            player.playerObject.setEffect(null);
            if(turn==0) {
                enemyAnimation.run();
            }else screen.showChoices();
        });


    }

    void defenseUp(){

        setBuffAnimation(player.defenseUp);
        ParallelTransition parallelTransition = new ParallelTransition(player.buff,transition,rotateTransition);


        parallelTransition.play();
        player.playerObject.setEffect(glow);
        parallelTransition.setOnFinished(actionEvent -> {
            screen.pane.getChildren().remove(player.buff);
            player.playerObject.setEffect(null);
            if(turn==0) {
                enemyAnimation.run();
            }else screen.showChoices();
        });

    }

    void block(){

        System.out.println("no");
        TranslateTransition blockDefend = new TranslateTransition();
        blockDefend.setDuration(Duration.seconds(1.5));
        blockDefend.setNode(player.playerObject);

        player.playerObject.setTranslateY(-20);
        player.playerObject.setImage(player.knightDefend);
        blockDefend.play();
        blockDefend.setOnFinished(actionEvent -> {
            player.playerObject.setTranslateY(6);
            player.playerObject.setImage(player.knight);
            if(turn==0) {
                enemyAnimation.run();
            }else screen.showChoices();
        });



    }

    void setBuffAnimation(Image buff){

        player.buff.setImage(buff);
        player.buff.setX(60);
        player.buff.setY(300);
        screen.pane.getChildren().add(player.buff);

        glow.setLevel(.8);

        transition.setNode(player.buff);
        transition.setFromY(0);
        transition.setToY(-90);
        transition.setCycleCount(3);

        rotateTransition.setNode(player.buff);
        rotateTransition.setAxis(Rotate.Y_AXIS);
        rotateTransition.setFromAngle(0);
        rotateTransition.setByAngle(39);
        rotateTransition.setCycleCount(3);

    }

}

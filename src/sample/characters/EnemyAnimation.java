package sample.characters;

import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import sample.screens.BattleScreen;


public class EnemyAnimation{

    BattleScreen screen;

    public enum Options{
        SwordAttack,MagicAttack,PowerUP,DefenseUP,Block
    }

    Options option;
    Enemy enemy = BattleScreen.enemy;
    PlayerAnimation playerAnimation;
    int turn;
    public  void selectOption(Options option,BattleScreen screen,PlayerAnimation playerAnimation,int turn){
            this.option = option;
            this.screen = screen;
            this.playerAnimation = playerAnimation;
            this.turn = turn;

            if(this.screen == null){
                System.out.println("yes");
            }
    }

    public void run(){
        if(option== Options.SwordAttack){
            swordAttack();
        }else if(option== Options.MagicAttack){
            magicAttack();
        }else if(option== Options.PowerUP){
            powerUp();
        }else if(option== Options.DefenseUP){
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

        setBuffAnimation(enemy.powerUp);

        ParallelTransition parallelTransition = new ParallelTransition(enemy.buff,transition,rotateTransition);


        parallelTransition.play();
        enemy.enemyObject.setEffect(glow);
        parallelTransition.setOnFinished(actionEvent -> {
            screen.pane.getChildren().remove(enemy.buff);
            enemy.enemyObject.setEffect(null);
            if(turn==0) {
                screen.showChoices();
            }else playerAnimation.run();
        });

    }

    void defenseUp(){

        setBuffAnimation(enemy.defenseUp);

        ParallelTransition parallelTransition = new ParallelTransition(enemy.buff,transition,rotateTransition);


        parallelTransition.play();
        enemy.enemyObject.setEffect(glow);
        parallelTransition.setOnFinished(actionEvent -> {
            screen.pane.getChildren().remove(enemy.buff);
            enemy.enemyObject.setEffect(null);
            if(turn==0) {
                screen.showChoices();
            }else playerAnimation.run();
        });

    }

     void block(){

        TranslateTransition blockDefend = new TranslateTransition();
        blockDefend.setDuration(Duration.seconds(1.5));
        blockDefend.setNode(enemy.enemyObject);

        enemy.enemyObject.setTranslateY(-20);
        enemy.enemyObject.setImage(enemy.enemyBlock);
        blockDefend.play();
        blockDefend.setOnFinished(actionEvent -> {
            enemy.enemyObject.setTranslateY(6);
            enemy.enemyObject.setImage(enemy.opponent);
            if(turn == 0) {
                screen.showChoices();
            }else playerAnimation.run();
        });

    }

    void setBuffAnimation(Image buff){
        enemy.buff.setImage(buff);
        enemy.buff.setX(600);
        enemy.buff.setY(300);
        screen.pane.getChildren().add(enemy.buff);

        glow.setLevel(.8);

        transition.setNode(enemy.buff);
        transition.setFromY(0);
        transition.setToY(-90);
        transition.setCycleCount(3);

        rotateTransition.setNode(enemy.buff);
        rotateTransition.setAxis(Rotate.Y_AXIS);
        rotateTransition.setFromAngle(0);
        rotateTransition.setByAngle(39);
        rotateTransition.setCycleCount(3);
    }

}

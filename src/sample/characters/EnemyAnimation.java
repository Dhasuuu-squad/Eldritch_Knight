package sample.characters;

import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import sample.screens.BattleScreen;

public class EnemyAnimation implements Runnable {
    public enum Options{
        SwordAttack,MagicAttack,PowerUP,DefenseUP,Block
    }

    Options option;
    Enemy enemy = BattleScreen.enemy;
    public  void selectOption(Options option){
        this.option = option;
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

    void swordAttack(){

    }

    void magicAttack(){

    }

    void powerUp(){

    }

    void defenseUp(){

    }

     public void block(){

        TranslateTransition blockDefend = new TranslateTransition();
        blockDefend.setDuration(Duration.seconds(1.5));
        blockDefend.setNode(enemy.enemyObject);

        enemy.enemyObject.setTranslateY(-20);
        enemy.enemyObject.setImage(enemy.enemyBlock);
        blockDefend.play();
        blockDefend.setOnFinished(actionEvent -> {
            enemy.enemyObject.setTranslateY(6);
            enemy.enemyObject.setImage(enemy.opponent);
        });

    }

}

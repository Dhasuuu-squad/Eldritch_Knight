package sample.characters;


import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import sample.screens.BattleScreen;

public class PlayerAnimation implements Runnable {

    public enum Options{
        SwordAttack,MagicAttack,PowerUP,DefenseUP,Block
    }

    Options option;
    Player player = BattleScreen.knight;

    public  void selectOption(Options option){
        this.option = option;
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
        blockDefend.setNode(player.playerObject);

        player.playerObject.setTranslateY(-20);
        player.playerObject.setImage(player.knightDefend);
        blockDefend.play();
        blockDefend.setOnFinished(actionEvent -> {
            player.playerObject.setTranslateY(6);
            player.playerObject.setImage(player.knight);

        });



    }
}

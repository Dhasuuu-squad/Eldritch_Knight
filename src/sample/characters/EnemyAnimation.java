package sample.characters;

import javafx.animation.ParallelTransition;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.effect.Glow;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import sample.screens.BattleScreen;
import sample.utility.CustomAnimation;
import sample.utility.DetailsBar;
import sample.utility.HealthBar;


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

    }
    DetailsBar detailsBar =new DetailsBar();
    CustomAnimation animation = new CustomAnimation();
    public void run(){
        if(option== Options.SwordAttack){
            detailsBar.setOptionDetails(DetailsBar.Person.Enemy);
            BattleScreen.choiceBox.getChildren().add(detailsBar.text);
            animation.typewriterAnimation("Enemy"+detailsBar.swordAttack,detailsBar.text);
            screen.scene.setOnKeyPressed(keyEvent -> {
                if(keyEvent.getCode() == KeyCode.ENTER){
                    screen.scene.setOnKeyPressed(null);
                    BattleScreen.choiceBox.getChildren().remove(detailsBar.text);
                    detailsBar.text.setText(null);
                    swordAttack();
                }
            });

        }else if(option== Options.MagicAttack){
            detailsBar.setOptionDetails(DetailsBar.Person.Enemy);
            BattleScreen.choiceBox.getChildren().add(detailsBar.text);
            animation.typewriterAnimation("Enemy"+detailsBar.magicAttack,detailsBar.text);
            screen.scene.setOnKeyPressed(keyEvent -> {
                if(keyEvent.getCode() == KeyCode.ENTER){
                    screen.scene.setOnKeyPressed(null);
                    BattleScreen.choiceBox.getChildren().remove(detailsBar.text);
                    detailsBar.text.setText(null);
                    magicAttack();
                }
            });

        }else if(option== Options.PowerUP){
            detailsBar.setOptionDetails(DetailsBar.Person.Enemy);
            BattleScreen.choiceBox.getChildren().add(detailsBar.text);
            animation.typewriterAnimation("Enemy"+detailsBar.powerUp,detailsBar.text);
            screen.scene.setOnKeyPressed(keyEvent -> {
                if(keyEvent.getCode() == KeyCode.ENTER){
                    screen.scene.setOnKeyPressed(null);
                    BattleScreen.choiceBox.getChildren().remove(detailsBar.text);
                    detailsBar.text.setText(null);
                    powerUp();
                }
            });

        }else if(option== Options.DefenseUP){
            detailsBar.setOptionDetails(DetailsBar.Person.Enemy);
            BattleScreen.choiceBox.getChildren().add(detailsBar.text);
            animation.typewriterAnimation("Enemy"+detailsBar.defenseUp,detailsBar.text);
            screen.scene.setOnKeyPressed(keyEvent -> {
                if(keyEvent.getCode() == KeyCode.ENTER){
                    screen.scene.setOnKeyPressed(null);
                    BattleScreen.choiceBox.getChildren().remove(detailsBar.text);
                    detailsBar.text.setText(null);
                    defenseUp();
                }
            });

        }else{
            detailsBar.setOptionDetails(DetailsBar.Person.Enemy);
            BattleScreen.choiceBox.getChildren().add(detailsBar.text);
            animation.typewriterAnimation("Enemy"+detailsBar.block,detailsBar.text);
            screen.scene.setOnKeyPressed(keyEvent -> {
                if(keyEvent.getCode() == KeyCode.ENTER){
                    screen.scene.setOnKeyPressed(null);
                    BattleScreen.choiceBox.getChildren().remove(detailsBar.text);
                    detailsBar.text.setText(null);
                    block(false);
                }
            });
        }
    }

    Player player = BattleScreen.knight;
    Glow glow = new Glow();
    SepiaTone hurt = new SepiaTone();
    TranslateTransition transition = new TranslateTransition(Duration.seconds(1));
    RotateTransition rotateTransition = new RotateTransition(Duration.seconds(1));

    void swordAttack(){

        TranslateTransition playerHurt = new TranslateTransition(Duration.seconds(1),player.playerObject);
        TranslateTransition transition = new TranslateTransition(Duration.seconds(1), enemy.enemyObject);
        transition.setToX(-150);

        PauseTransition pauseTransition = new PauseTransition(Duration.seconds(1));

        ParallelTransition actionAnimation  = new ParallelTransition(enemy.enemyObject,pauseTransition,playerHurt);

        TranslateTransition transitionRev =  new TranslateTransition(Duration.seconds(1.3), enemy.enemyObject);
        transitionRev.setToX(170);

        setPlayerHurtAnimation(playerHurt);

        transition.play();
        enemy.enemyObject.setImage(enemy.attackStance);
        enemy.enemyObject.setY(200);
        transition.setOnFinished(actionEvent -> {
            actionAnimation.play();
            enemy.sword.stop();
            enemy.sword.play();
            player.hurt.stop();
            player.hurt.play();
            screen.playerHealthBar.setDamage(30, HealthBar.Damage.Player);
            enemy.enemyObject.setImage(enemy.swordAttack);
            enemy.enemyObject.setY(250);
            player.playerObject.setEffect(hurt);
            playerHurt.setOnFinished(actionEvent1 -> player.playerObject.setEffect(null));
            pauseTransition.setOnFinished(actionEvent1 -> {
                transitionRev.play();
                enemy.enemyObject.setImage(enemy.swordRetrieve);

                transitionRev.setOnFinished(actionEvent2 -> {
                    enemy.enemyObject.setImage(enemy.opponent);
                    if(turn==0) {
                        screen.showChoices();
                    }else playerAnimation.run();
                });

            });

        });


    }

    void magicAttack(){
        PauseTransition pauseTransition =new PauseTransition(Duration.seconds(1));

        TranslateTransition playerHurt = new TranslateTransition(Duration.seconds(1),player.playerObject);

        TranslateTransition magicAnimation = new TranslateTransition(Duration.seconds(1),enemy.magicAttack);
        magicAnimation.setToX(-360);


        enemy.magicAttack.setY(290);
        enemy.magicAttack.setX(480);


        setPlayerHurtAnimation(playerHurt);

        pauseTransition.play();
        enemy.enemyObject.setImage(enemy.magicStance);
        enemy.enemyObject.setY(180);
        enemy.enemyObject.setX(330);
        pauseTransition.setOnFinished(actionEvent -> {
            screen.pane.getChildren().add(enemy.magicAttack);
            enemy.enemyObject.setImage(enemy.magicSword);
            enemy.enemyObject.setX(300);
            enemy.enemyObject.setY(200);
            magicAnimation.play();
            enemy.magic.stop();
            enemy.magic.play();
            magicAnimation.setOnFinished(actionEvent1 -> {
                enemy.magicAttack.setTranslateX(15);
                screen.pane.getChildren().remove(enemy.magicAttack);
                playerHurt.play();
                player.hurt.stop();
                player.hurt.play();
                screen.playerHealthBar.setDamage(60, HealthBar.Damage.Player);
                player.playerObject.setEffect(hurt);
                playerHurt.setOnFinished(actionEvent2 -> {
                    enemy.enemyObject.setImage(enemy.opponent);
                    enemy.enemyObject.setY(250);
                    player.playerObject.setEffect(null);
                    if(turn==0) {
                        screen.showChoices();
                    }else playerAnimation.run();
                });
            });
        });

    }

    void powerUp(){

        setBuffAnimation(enemy.powerUp);

        ParallelTransition parallelTransition = new ParallelTransition(enemy.buff,transition,rotateTransition);

        parallelTransition.play();
        enemy.hercules.stop();
        enemy.hercules.play();
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
        enemy.athena.stop();
        enemy.athena.play();
        enemy.enemyObject.setEffect(glow);
        parallelTransition.setOnFinished(actionEvent -> {
            screen.pane.getChildren().remove(enemy.buff);
            enemy.enemyObject.setEffect(null);
            if(turn==0) {
                screen.showChoices();
            }else playerAnimation.run();
        });

    }

     public void block(boolean flag){

        TranslateTransition blockDefend = new TranslateTransition();
        blockDefend.setDuration(Duration.seconds(1.5));
        blockDefend.setNode(enemy.enemyObject);

        enemy.enemyObject.setTranslateY(-20);
        enemy.enemyObject.setImage(enemy.enemyBlock);
        blockDefend.play();
        enemy.block.stop();
        enemy.block.play();
        blockDefend.setOnFinished(actionEvent -> {
            enemy.enemyObject.setTranslateY(6);
            enemy.enemyObject.setImage(enemy.opponent);
            if(flag){
                detailsBar.setOptionDetails(DetailsBar.Person.Enemy);
                BattleScreen.choiceBox.getChildren().add(detailsBar.text);
                animation.typewriterAnimation("Enemy"+detailsBar.blocked,detailsBar.text);
                screen.scene.setOnKeyPressed(keyEvent -> {
                    if(keyEvent.getCode() == KeyCode.ENTER){
                        screen.scene.setOnKeyPressed(null);
                        BattleScreen.choiceBox.getChildren().remove(detailsBar.text);
                        detailsBar.text.setText(null);
                        screen.showChoices();
                    }
                });

            }else {
                if(turn == 0) {
                    screen.showChoices();
                }else playerAnimation.run();
            }

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

    void setPlayerHurtAnimation(TranslateTransition playerHurt){
        playerHurt.setToY(5);
        playerHurt.setByX(-30);
        playerHurt.setAutoReverse(true);
        playerHurt.setCycleCount(2);

    }

}

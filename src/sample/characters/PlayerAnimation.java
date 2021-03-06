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
import sample.game_logic.Process;
import sample.screens.BattleScreen;
import sample.screens.ResultScreen;
import sample.utility.CustomAnimation;
import sample.utility.DetailsBar;
import sample.utility.HealthBar;

public class PlayerAnimation{

    EnemyAnimation enemyAnimation;

    public enum Options{
        SwordAttack,MagicAttack,PowerUP,DefenseUP,Block
    }

    Options option;
    BattleScreen screen;
    Player player;
    Enemy enemy;
    int turn;
    double damage;
    double buff;
    public  void selectOption(Options option, BattleScreen screen, EnemyAnimation enemyAnimation, int turn, Process process){
        this.option = option;
        this.screen = screen;
        this.turn = turn;
        this.enemyAnimation = enemyAnimation;
        player = screen.knight;
        enemy = screen.enemy;
        damage = process.playerDamage;
        buff = process.enemyBuff;
    }

    DetailsBar detailsBar = new DetailsBar();
    CustomAnimation animation = new CustomAnimation();
    public void run(){
        if(option==Options.SwordAttack){
            detailsBar.setOptionDetails(DetailsBar.Person.Player);
            BattleScreen.choiceBox.getChildren().add(detailsBar.text);
            animation.typewriterAnimation("Player"+detailsBar.swordAttack,detailsBar.text);
            screen.scene.setOnKeyPressed(keyEvent -> {
                if(keyEvent.getCode() == KeyCode.ENTER ){
                    screen.scene.setOnKeyPressed(null);
                    BattleScreen.choiceBox.getChildren().remove(detailsBar.text);
                    detailsBar.text.setText(null);
                    swordAttack();
                }
            });


        }else if(option==Options.MagicAttack){
            detailsBar.setOptionDetails(DetailsBar.Person.Player);
            BattleScreen.choiceBox.getChildren().add(detailsBar.text);
            animation.typewriterAnimation("Player"+detailsBar.magicAttack,detailsBar.text);
            screen.scene.setOnKeyPressed(keyEvent -> {
                if(keyEvent.getCode() == KeyCode.ENTER){
                    screen.scene.setOnKeyPressed(null);
                    BattleScreen.choiceBox.getChildren().remove(detailsBar.text);
                    detailsBar.text.setText(null);
                    magicAttack();
                }
            });

        }else if(option==Options.PowerUP){
            detailsBar.setOptionDetails(DetailsBar.Person.Player);
            BattleScreen.choiceBox.getChildren().add(detailsBar.text);
            animation.typewriterAnimation("Player"+detailsBar.powerUp,detailsBar.text);
            screen.scene.setOnKeyPressed(keyEvent -> {
                if(keyEvent.getCode() == KeyCode.ENTER){
                    screen.scene.setOnKeyPressed(null);
                    BattleScreen.choiceBox.getChildren().remove(detailsBar.text);
                    detailsBar.text.setText(null);
                    powerUp();
                }
            });

        }else if(option==Options.DefenseUP){
            detailsBar.setOptionDetails(DetailsBar.Person.Player);
            BattleScreen.choiceBox.getChildren().add(detailsBar.text);
            animation.typewriterAnimation("Player"+detailsBar.defenseUp,detailsBar.text);
            screen.scene.setOnKeyPressed(keyEvent -> {
                if(keyEvent.getCode() == KeyCode.ENTER){
                    screen.scene.setOnKeyPressed(null);
                    BattleScreen.choiceBox.getChildren().remove(detailsBar.text);
                    detailsBar.text.setText(null);
                    defenseUp();
                }
            });

        }else{
            detailsBar.setOptionDetails(DetailsBar.Person.Player);
            BattleScreen.choiceBox.getChildren().add(detailsBar.text);
            animation.typewriterAnimation("Player"+detailsBar.block,detailsBar.text);
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

    Glow glow = new Glow();
    SepiaTone hurt = new SepiaTone();
    TranslateTransition transition = new TranslateTransition(Duration.seconds(1));
    RotateTransition rotateTransition = new RotateTransition(Duration.seconds(1));

    ResultScreen result = new ResultScreen();

    void swordAttack(){
        PauseTransition pauseTransition = new PauseTransition(Duration.seconds(0.7));
        TranslateTransition enemyHurt = new TranslateTransition(Duration.seconds(0.7),enemy.enemyObject);
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(1.5),player.playerObject);
        translateTransition.setToX(200);

        TranslateTransition transitionReverse = new TranslateTransition(Duration.seconds(1),player.playerObject);
        transitionReverse.setToX(-170);

        ParallelTransition attackAnimation = new ParallelTransition(player.playerObject,pauseTransition,enemyHurt);

        setEnemyHurtAnimation(enemyHurt);

        translateTransition.play();
        player.playerObject.setImage(player.attackStance);
        translateTransition.setOnFinished(actionEvent -> {
            player.playerObject.setImage(player.swordAttack);
            attackAnimation.play();
            player.sword.stop();
            player.sword.play();
            enemy.hurt.stop();
            enemy.hurt.play();
            screen.enemyHealthBar.setDamage((damage-damage*buff), HealthBar.Damage.Enemy);
            enemy.enemyObject.setEffect(hurt);
            enemyHurt.setOnFinished(actionEvent1 -> enemy.enemyObject.setEffect(null));
            pauseTransition.setOnFinished(actionEvent1 -> {
                player.playerObject.setImage(player.attackStance);
                transitionReverse.play();
                transitionReverse.setOnFinished(actionEvent2 -> {
                    player.playerObject.setImage(player.knight);
                    if(screen.enemyHealthBar.health<=0){
                        result.showResults(screen, ResultScreen.Winner.Player);
                    }else{
                        if(turn==0) {
                            enemyAnimation.run();
                        }else screen.showChoices();
                    }

                });
            });

        });

    }

    void magicAttack(){
        TranslateTransition enemyHurt = new TranslateTransition(Duration.seconds(1),enemy.enemyObject);
        PauseTransition pauseTransition = new PauseTransition(Duration.seconds(1));
        player.playerObject.setImage(player.magicStance);
        player.playerObject.setX(220);
        player.magicDagger.setX(160);
        player.magicDagger.setY(300);

        TranslateTransition daggerMovement = new TranslateTransition(Duration.seconds(1.2),player.magicDagger);
        daggerMovement.setToX(410);

        RotateTransition daggerRotation = new RotateTransition(Duration.seconds(1.2),player.magicDagger);
        daggerRotation.setAxis(Rotate.Z_AXIS);
        daggerRotation.setByAngle(360);

        ParallelTransition daggerAnimation = new ParallelTransition(player.magicDagger,daggerMovement,daggerRotation);

        setEnemyHurtAnimation(enemyHurt);
        pauseTransition.play();

        pauseTransition.setOnFinished(actionEvent -> {
            screen.pane.getChildren().add(player.magicDagger);
            daggerAnimation.play();
            player.magic.stop();
            player.magic.play();
            player.playerObject.setImage(player.freeHand);

            daggerAnimation.setOnFinished(actionEvent1 -> {
                enemy.enemyObject.setEffect(hurt);
                enemyHurt.play();

                enemy.hurt.stop();
                enemy.hurt.play();
                screen.enemyHealthBar.setDamage((damage-damage*buff), HealthBar.Damage.Enemy);
                player.playerObject.setImage(player.knight);
                player.magicDagger.setTranslateX(-20);
                screen.pane.getChildren().remove(player.magicDagger);
                player.playerObject.setX(player.coordinateX);
                enemyHurt.setOnFinished(actionEvent2 -> {
                    enemy.enemyObject.setEffect(null);
                    if(screen.enemyHealthBar.health<=0){
                        result.showResults(screen, ResultScreen.Winner.Player);
                    }else {
                        if(turn==0) {
                            enemyAnimation.run();
                        }else screen.showChoices();
                    }

                });
            });
        });



    }

    void powerUp(){

        setBuffAnimation(player.powerUp);
        ParallelTransition parallelTransition = new ParallelTransition(player.buff,transition,rotateTransition);


        parallelTransition.play();
        player.hercules.stop();
        player.hercules.play();
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
        player.athena.stop();
        player.athena.play();
        player.playerObject.setEffect(glow);
        parallelTransition.setOnFinished(actionEvent -> {
            screen.pane.getChildren().remove(player.buff);
            player.playerObject.setEffect(null);
            if(turn==0) {
                enemyAnimation.run();
            }else screen.showChoices();
        });

    }

    public void block(boolean flag){

        TranslateTransition blockDefend = new TranslateTransition();
        blockDefend.setDuration(Duration.seconds(1.5));
        blockDefend.setNode(player.playerObject);

        player.playerObject.setTranslateY(-20);
        player.playerObject.setImage(player.knightDefend);
        blockDefend.play();
        player.block.stop();
        player.block.play();
        blockDefend.setOnFinished(actionEvent -> {
            player.playerObject.setTranslateY(6);
            player.playerObject.setImage(player.knight);
            if(flag){
                detailsBar.setOptionDetails(DetailsBar.Person.Player);
                BattleScreen.choiceBox.getChildren().add(detailsBar.text);
                animation.typewriterAnimation("Player"+detailsBar.blocked,detailsBar.text);
                screen.scene.setOnKeyPressed(keyEvent -> {
                    if(keyEvent.getCode() == KeyCode.ENTER){
                        screen.scene.setOnKeyPressed(null);
                        BattleScreen.choiceBox.getChildren().remove(detailsBar.text);
                        detailsBar.text.setText(null);
                        screen.showChoices();
                    }
                });
            }else{
                if(turn==0) {
                    enemyAnimation.run();
                }else screen.showChoices();
            }
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

    void setEnemyHurtAnimation(TranslateTransition enemyHurt){
        enemyHurt.setToY(5);
        enemyHurt.setByX(30);
        enemyHurt.setAutoReverse(true);
        enemyHurt.setCycleCount(2);

    }

}

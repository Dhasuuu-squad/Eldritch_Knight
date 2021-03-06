package sample.screens;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import sample.Constants;
import sample.Main;
import sample.characters.Enemy;
import sample.characters.Player;
import sample.game_logic.EnemyInput;
import sample.game_logic.PlayerInput;
import sample.game_logic.Process;
import sample.utility.CustomAnimation;
import sample.utility.DetailsBar;
import sample.utility.Feedback;
import sample.utility.HealthBar;

import java.util.ArrayList;


public class BattleScreen {

    public Player knight = new Player();
    public Enemy enemy = new Enemy();
    Constants constants = new Constants();
    Feedback feedback = new Feedback();
    Rectangle rectangle;
    Rectangle outerBorder;
    public static StackPane choiceBox = new StackPane();
    public Pane pane;
    public Scene scene;
    static MediaPlayer bgm;
    public StackPane stack;

    public  void  start(){
        bgm = new MediaPlayer(new Media("file:///G:/Eldritch_Knight/src/sample/media/backgroundMusic.mp3"));
        bgm.stop();
        bgm.play();
        bgm.setCycleCount(MediaPlayer.INDEFINITE);
        bgm.setAutoPlay(true);
        bgm.setVolume(0.6);

        ImageView stage = new ImageView(new Image("sample/media/fightingBackground.jpg"));

        knight.playerObject.setImage(knight.knight);
        enemy.enemyObject.setImage(enemy.opponent);

        knight.playerObject.setX(knight.coordinateX);
        knight.playerObject.setY(knight.coordinateY);

        enemy.enemyObject.setY(250);
        enemy.enemyObject.setX(300);

        pane = new Pane(enemy.enemyObject,knight.playerObject);

        stack = new StackPane(stage,pane);

        rectangle = new Rectangle(780,170, Color.BLACK);
        rectangle.setArcWidth(30);
        rectangle.setArcHeight(30);

        outerBorder = new Rectangle(800,192,Color.BLACK);
        StackPane box = new StackPane(outerBorder,rectangle);


        Button fight = new Button("FIGHT");
        fight.setStyle(constants.kFightButtonStyle);
        feedback.heptic(fight);
        fight.setOnAction(e -> {
            choiceBox.getChildren().remove(fight);
            animation.battleReady(knight.playerObject,enemy.enemyObject,this);
        });

        choiceBox.getChildren().addAll(box,fight) ;
        VBox root = new VBox(stack,choiceBox);

        scene = new Scene(root,800,790);
        Main.window.setScene(scene);
    }

    public  GridPane grid = new GridPane();

    ArrayList<DetailsBar>detailsBars = new ArrayList<>();
    CustomAnimation animation = new CustomAnimation();
    public  HealthBar playerHealthBar;
    public  HealthBar enemyHealthBar;
    Process process = new Process(this);
    EnemyInput enemyInput = new EnemyInput(process);
    PlayerInput playerInput = new PlayerInput(knight,process,detailsBars,this);


     public void startBattle(){


         playerHealthBar = new HealthBar(300,"Player");
         enemyHealthBar = new HealthBar(300,"Enemy");
         pane.getChildren().addAll(playerHealthBar.createHealthBar(),enemyHealthBar.createHealthBar());
         playerHealthBar.setLayoutX(15,30);
         enemyHealthBar.setLayoutX(476,645);

         outerBorder.setFill(Color.valueOf("#af0404"));
         rectangle.setFill(Color.valueOf("#0b0b0d"));
         Button swordAttack = new Button("Sword Attack");
         Button magicAttack = new Button("Magic Attack");
         Button powerUp = new Button("Power of Hercules");
         Button defenseUp = new Button("Protection of Athena");
         Button block = new Button("Block");

         Button[] buttons ={swordAttack, magicAttack, powerUp, defenseUp, block};
         for(int i=0;i<buttons.length;i++){
             buttons[i].setStyle(constants.kButtonOptions[i]);
             feedback.heptic(buttons[i]);
             detailsBars.add(new DetailsBar().createDetailsBar(buttons[i], knight.optionDetails[i], pane, knight.optionInfo[i], grid));
         }

         swordAttack.setOnAction(actionEvent -> {
             enemyInput.optionSelector();
            playerInput.swordAttack();


         });
         magicAttack.setOnAction(actionEvent -> {
             enemyInput.optionSelector();
             playerInput.magicAttack();
         });
         powerUp.setOnAction(actionEvent -> {
             enemyInput.optionSelector();
             playerInput.buffAttack();
         });
         defenseUp.setOnAction(actionEvent -> {
             enemyInput.optionSelector();
             playerInput.buffDefense();
         });
         block.setOnAction(actionEvent -> {
             enemyInput.optionSelector();
             playerInput.block();

         });

         grid.setHgap(20);
         grid.setVgap(10);
         grid.add(swordAttack, 0, 0);
         grid.add(magicAttack, 0, 1);
         grid.add(powerUp, 1, 0);
         grid.add(defenseUp, 1, 1);
         grid.add(block,5,0,1,2);
         grid.setAlignment(Pos.CENTER);


         choiceBox.getChildren().add(grid);


    }


    public void hideChoices(){
        grid.setVisible(false);
    }

    public void showChoices(){
        grid.setVisible(true);
    }


}

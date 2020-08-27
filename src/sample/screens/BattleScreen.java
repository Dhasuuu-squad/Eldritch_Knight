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
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import sample.Constants;
import sample.Main;
import sample.characters.Enemy;
import sample.characters.Player;
import sample.utility.CustomAnimation;
import sample.utility.DetailsBar;
import sample.utility.Feedback;



public class BattleScreen {

    Player knight = new Player();
    Enemy enemy = new Enemy();
    Constants constants = new Constants();
    Feedback feedback = new Feedback();
    Rectangle rectangle;
    Rectangle outerBorder;
    StackPane choiceBox;
    public static Pane pane;

    public  void  start(){

        ImageView stage = new ImageView(new Image("sample/media/fightingBackground.jpg"));

        knight.player.setImage(knight.knight);
        enemy.crusader.setImage(enemy.opponent);

        knight.player.setX(130);
        knight.player.setY(250);

        enemy.crusader.setY(250);
        enemy.crusader.setX(300);

        pane = new Pane(enemy.crusader,knight.player);

        StackPane stack = new StackPane(stage,pane);

        rectangle = new Rectangle(780,170, Color.BLACK);
        rectangle.setArcWidth(30);
        rectangle.setArcHeight(30);

        outerBorder = new Rectangle(800,192,Color.BLACK);
        StackPane box = new StackPane(outerBorder,rectangle);


        Button fight = new Button("FIGHT");
        fight.setStyle(constants.kFightButtonStyle);
        feedback.heptic(fight);
        fight.setOnAction(e -> {
            choiceBox.getChildren().remove(1);
            animation.battleReady(knight.player,enemy.crusader,this);
        });

        choiceBox = new StackPane(box,fight);
        VBox root = new VBox(stack,choiceBox);

        Scene scene = new Scene(root,800,790);
        Main.window.setScene(scene);
    }

    CustomAnimation animation = new CustomAnimation();
    DetailsBar detailsBar = new DetailsBar();
     public void startBattle(){
         GridPane grid = new GridPane();


         outerBorder.setFill(Color.valueOf("#af0404"));
         rectangle.setFill(Color.valueOf("#0b0b0d"));
         Button swordAttack = new Button("Sword Attack");
         Button magicAttack = new Button("Magic Attack");
         Button powerUp = new Button("Power of Hercules");
         Button defenseUp = new Button("Protection of Athena");
         Button block = new Button("Block");


         Button[] buttons = {swordAttack,magicAttack,powerUp,defenseUp,block};
         for(int i=0;i<buttons.length;i++){
             buttons[i].setStyle(constants.kButtonOptions[i]);
             feedback.heptic(buttons[i]);
             detailsBar.createDetailsBar(buttons[i],knight.optionDetails[i],pane,knight.optionInfo[i],grid);
         }


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


}

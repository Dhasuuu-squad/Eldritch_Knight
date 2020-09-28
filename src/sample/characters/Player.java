package sample.characters;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class Player{

    public double coordinateX = 130;
    public double coordinateY = 250;
    public  Image pForward = new Image("sample/media/playerForward.png");
    public  Image pBackward = new Image("sample/media/playerBackward.png");
    public  Image pRight = new Image("sample/media/playerRight.png");
    public  Image pLeft = new Image("sample/media/playerLeft.png");

    public  Image pRightRunning = new Image("sample/media/playerRightRunning.png");
    public  Image pLeftRunning = new Image("sample/media/playerLeftRunning.png");
    public  Image pBackwardRunning1 = new Image("sample/media/playerBackwardRunning1.png");
    public  Image pBackwardRunning2 = new Image("sample/media/playerBackwardRunning2.png");
    public  Image pForwardRunning1 = new Image("sample/media/playerForwardRunning1.png");
    public  Image pForwardRunning2 = new Image("sample/media/playerForwardRunning2.png");

    public  Image powerUp = new Image("sample/media/atkbuff.png");
    public  Image defenseUp = new Image("sample/media/defbuff.png");

    public  ImageView buff = new ImageView();

    public ImageView playerObject = new ImageView();

    public ImageView magicDagger = new ImageView(new Image("sample/media/playerMagic.png"));

    public Image knight = new Image("sample/media/player.png");
    public Image knightDefend = new Image("sample/media/playerBlock.png");
    public Image attackStance = new Image("sample/media/playerA1.png");
    public Image swordAttack = new Image("sample/media/playerA2.png");
    public Image magicStance = new Image("sample/media/playerM1.png");
    public Image freeHand = new Image("sample/media/playerM2.png");

    public MediaPlayer hurt = new MediaPlayer(new Media("file:///G:/Eldritch_Knight/src/sample/media/playerHurt.mp3"));
    public MediaPlayer sword = new MediaPlayer(new Media("file:///G:/Eldritch_Knight/src/sample/media/sword.mp3"));
    public MediaPlayer magic = new MediaPlayer(new Media("file:///G:/Eldritch_Knight/src/sample/media/playerMagic.mp3"));
    public MediaPlayer hercules = new MediaPlayer(new Media("file:///G:/Eldritch_Knight/src/sample/media/powerUp.mp3"));
    public MediaPlayer athena = new MediaPlayer(new Media("file:///G:/Eldritch_Knight/src/sample/media/defenseUp.mp3"));
    public MediaPlayer block = new MediaPlayer(new Media("file:///G:/Eldritch_Knight/src/sample/media/shield.mp3"));

    public String[] optionDetails = {
            "Swings the sword with great momentum towards the enemy",
            "Uses magical daggers and throw them at the enemy",
            "By the name of Hercules, your strength increases ",
            "By the grace of Goddess Athena, you become more resistive",
            "Block enemy's any attack"
    } ;



    public  double swordAttackDamage = 30;
    public double magicAttackDamage = 70;
    public double defBuff = 0;
    public int swordAttackLimit =200;
    public int magicAttackLimit =5;
    public int atkBuffLimit =4;
    public int defBuffLimit =4;
    public int blockLimit = 5;

    public String[] optionInfo = {
            "Damage: "+swordAttackDamage+"\nTurns: "+swordAttackLimit,
            "Damage: "+magicAttackDamage+"\nTurns: "+magicAttackLimit,
            "Damage boost: 20%\nTurns: "+atkBuffLimit,
            "Defence boost: 20%\nTurns: "+defBuffLimit,
            "Turns: "+blockLimit,
    };






}




package sample.characters;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class Enemy {
    public Image opponent = new Image("sample/media/opponent.png");
    public Image enemyBlock = new Image("sample/media/enemyBlock.png");

    public  Image powerUp = new Image("sample/media/atkbuff.png");
    public  Image defenseUp = new Image("sample/media/defbuff.png");

    public  ImageView buff = new ImageView();

    public ImageView enemyObject = new ImageView();

    public Image attackStance = new Image("sample/media/opponentA1.png");
    public Image swordAttack = new Image("sample/media/opponentA2.png");
    public Image swordRetrieve = new Image("sample/media/m.png");

    public ImageView magicAttack = new ImageView(new Image("sample/media/opponentMagic.png"));
    public Image magicStance = new Image("sample/media/opponentM1.png");
    public Image magicSword = new Image("sample/media/opponentM2.png");

    public MediaPlayer hurt = new MediaPlayer(new Media("file:///G:/Eldritch_Knight/src/sample/media/enemyHurt.mp3"));
    public MediaPlayer sword = new MediaPlayer(new Media("file:///G:/Eldritch_Knight/src/sample/media/sword.mp3"));
    public MediaPlayer magic = new MediaPlayer(new Media("file:///G:/Eldritch_Knight/src/sample/media/enemyMagic.mp3"));
    public MediaPlayer hercules = new MediaPlayer(new Media("file:///G:/Eldritch_Knight/src/sample/media/powerUp.mp3"));
    public MediaPlayer athena = new MediaPlayer(new Media("file:///G:/Eldritch_Knight/src/sample/media/defenseUp.mp3"));
    public MediaPlayer block = new MediaPlayer(new Media("file:///G:/Eldritch_Knight/src/sample/media/shield.mp3"));


}

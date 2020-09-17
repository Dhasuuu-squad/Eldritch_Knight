package sample.characters;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Enemy {
    public Image opponent = new Image("sample/media/opponent.png");
    public Image enemyBlock = new Image("sample/media/enemyBlock.png");

    public  Image powerUp = new Image("sample/media/atkbuff.png");
    public  Image defenseUp = new Image("sample/media/defbuff.png");

    public  ImageView buff = new ImageView();

    public ImageView enemyObject = new ImageView();


}

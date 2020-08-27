package sample.characters;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Player {
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

    public ImageView player = new ImageView();

    public Image knight = new Image("sample/media/player.png");

    public String[] optionDetails = {
            "Swings the sword with great momentum towards the enemy",
            "Uses magical daggers and throw them at the enemy",
            "By the name of Hercules, your strength increases ",
            "By the grace of Goddess Athena, you become more resistive",
            "Block enemy's any attack"
    } ;

    public String[] optionInfo = {
            "Damage: 200",
            "Damage: 200\nTurns: 5",
            "Damage increase: 20%+\nTurns: 5",
            "Defence increase: 20%+\nTurns: 5",
            "Turns: 5",
    };
}

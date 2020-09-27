package sample.utility;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import sample.Constants;

public class DetailsBar{
    Constants constants = new Constants();
    static Label sideBar; //if it's not static it will only show the last message on every info
    public String message;
    public DetailsBar createDetailsBar(Button button, String message1,Pane pane, String message2, GridPane gridPane){

        Label upperBar = new Label();
        upperBar.setPrefSize(780,60);
        upperBar.setAlignment(Pos.CENTER);
        upperBar.setStyle(constants.kUpperBarStyle);

        sideBar = new Label();
        sideBar.setPrefSize(200,160);
        sideBar.setAlignment(Pos.CENTER);
        sideBar.setStyle(constants.kSideBarStyle);


        upperBar.setLayoutX(10);
        upperBar.setLayoutY(535);

        message = message2;
        button.setOnMouseReleased(event ->sideBar.setText(message));
        sideBar.setText(message);
        button.setOnMouseEntered(event -> {
            sideBar.setText(message);

            upperBar.setText(message1);
            pane.getChildren().add(upperBar);
        });

        button.setOnMouseExited(event -> {
            upperBar.setText(null);
            pane.getChildren().remove(upperBar);
            sideBar.setText(null);
        });

        gridPane.add(sideBar,6,0,1,2);
        pane.getChildren().remove(upperBar);


        return this;
    }

    public String swordAttack = " is using SWORDATTACK!!...";
    public String magicAttack = " is using MAGICATTACK!!...";
    public String powerUp = " is using POWER OF HERCULES!\nYour strength will increase...";
    public String defenseUp = " is using PROTECTION OF ATHENA!\nYour defense will increase...";
    public String block = " is using BLOCK!!...";
    public String blocked = " blocked Opponent's attack...";

    public Text text = new Text();

    public void setOptionDetails(int num){
        if(num == 0){
            text.setFill(Color.LAWNGREEN);
        }else text.setFill(Color.RED);

        text.setFont(Font.font(Font.getFamilies().get(22), FontWeight.BOLD, FontPosture.REGULAR, 20)); //0 10 8 11 15 16 19 20 21
        text.setTextAlignment(TextAlignment.CENTER);

    }

}

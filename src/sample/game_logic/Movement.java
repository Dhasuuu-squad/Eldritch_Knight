package sample.game_logic;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import sample.screens.RoamingScreen;

public class Movement extends RoamingScreen {




    public double pCoordinateX = 0;
    public double pCoordinateY = 0;

    public Movement(Scene scene){

        scene.setOnKeyPressed(e ->{
            try {
                Thread.sleep(80);
            }catch (InterruptedException ex){
                System.out.println("exception caught");
            }

            if(pCoordinateY <-450&&pCoordinateX>-30&&pCoordinateX<30){
                super.showDialogueBox();
            }
            else {
                super.hideDialogueBox();
            }

            if(e.getCode()== KeyCode.UP){
                pCoordinateY = pCoordinateY - 5.0;
                knight.player.setTranslateY(pCoordinateY);
                if((pCoordinateY *-1)%10==5|| pCoordinateY %10==5){
                    knight.player.setImage(knight.pForwardRunning1);
                }else {
                    knight.player.setImage(knight.pForwardRunning2);
                }
                if(pCoordinateY <-500){
                    pCoordinateY =-500;
                }
            }
            else if(e.getCode() == KeyCode.DOWN){
                pCoordinateY = pCoordinateY + 5.0;
                knight.player.setTranslateY(pCoordinateY);
                if(pCoordinateY %10==5|| (pCoordinateY *-1)%10==5){
                    knight.player.setImage(knight.pBackwardRunning1);
                }else {
                    knight.player.setImage(knight.pBackwardRunning2);
                }
                if(pCoordinateY >20){
                    pCoordinateY =20;
                }
            }
            else if(e.getCode() == KeyCode.LEFT){
                pCoordinateX = pCoordinateX - 5.0;
                knight.player.setTranslateX(pCoordinateX);
                System.out.println(pCoordinateX);
                knight.player.setImage(knight.pLeftRunning);
                if(pCoordinateX <-100){
                    pCoordinateX = -100;
                }
            }
            else if(e.getCode() == KeyCode.RIGHT){
                pCoordinateX = pCoordinateX + 5.0;
                knight.player.setTranslateX(pCoordinateX);
                knight.player.setImage(knight.pRightRunning);
                if(pCoordinateX >110){
                    pCoordinateX = 110;
                }
            }
            if(e.getCode()== KeyCode.ENTER && pCoordinateY <-450&&pCoordinateX>-30&&pCoordinateX<30){
                super.startBattleScreen();
            }
        });

        scene.setOnKeyReleased(e ->{
            if(e.getCode() == KeyCode.RIGHT){
                knight.player.setImage(knight.pRight);
            }
            else if(e.getCode() == KeyCode.LEFT){
                knight.player.setImage(knight.pLeft);
            }
            else if(e.getCode() == KeyCode.UP){
                knight.player.setImage(knight.pForward);
            }
            else  if(e.getCode() == KeyCode.DOWN){
                knight.player.setImage(knight.pBackward);
            }
        });
    }
}
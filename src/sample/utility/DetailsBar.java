package sample.utility;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import sample.Constants;

public class DetailsBar{
    Constants constants = new Constants();
    static Label info; //if it's not static it will only display on the last option. as it gets collected by garbage

    public void createDetailsBar(Button button, String message1,Pane pane, String message2, GridPane gridPane){
        Label information = new Label();
        information.setPrefSize(780,60);
        information.setAlignment(Pos.CENTER);
        information.setStyle(constants.kUpperBarStyle);

        info = new Label();
        info.setPrefSize(200,160);
        info.setAlignment(Pos.CENTER);
        info.setStyle(constants.kSideBarStyle);


        information.setLayoutX(10);
        information.setLayoutY(535);
        button.setOnMouseEntered(event -> {
            info.setText(message2);
            information.setText(message1);
            pane.getChildren().add(information);
        });
        button.setOnMouseExited(event -> {
            information.setText(null);
            pane.getChildren().remove(information);
            info.setText(null);
        });

        gridPane.add(info,6,0,1,2);

    }

}

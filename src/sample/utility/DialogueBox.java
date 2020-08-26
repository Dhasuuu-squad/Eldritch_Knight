package sample.utility;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import sample.Constants;


public class DialogueBox {

    public String message  ="You shall not pass.\nThis is where you DIE!";
    public  Text text= new Text();
    Constants constants = new Constants();
    public Node createDialogueBox(){

        text.setStyle(constants.dialougeFontStyle);
        text.setTextAlignment(TextAlignment.CENTER);

        Rectangle dialougeBox = new Rectangle(190,100,Paint.valueOf("#E7CE80"));
        dialougeBox.setX(450);
        dialougeBox.setY(70);
        dialougeBox.setArcHeight(30);
        dialougeBox.setArcWidth(40);
        dialougeBox.setStroke(Color.valueOf("#B07133"));
        dialougeBox.setStrokeWidth(5);

        Polygon triangle = new Polygon();
        triangle.getPoints().addAll(
                454.0, 165.0,
                420.0, 170.0,
                454.0, 140.0);
        triangle.setFill(Paint.valueOf("#B07133"));
        Group root = new Group(triangle,dialougeBox);

        StackPane box = new StackPane(root,text);
        box.setLayoutX(420);
        box.setLayoutY(70);
        return  box;
    }
}

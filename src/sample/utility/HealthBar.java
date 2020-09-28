package sample.utility;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class HealthBar {

    public  double health;
    public  String name;
    StackPane stackPane;
    Label label;
    Rectangle healthBar;

    public HealthBar(double value,String label){
        health = value;
        name = label;
    }

    public Group createHealthBar(){
        label = new Label(name+"'s Health");
        label.setStyle("-fx-text-fill: white;" + "-fx-font-size: 17;"+
                "-fx-font-weight: bold;");


        Rectangle hurtBar = new Rectangle();
        hurtBar.setFill(Color.rgb(205,7,6,.87));
        hurtBar.setHeight(28);
        hurtBar.setWidth(300);
        hurtBar.setArcWidth(30.0);
        hurtBar.setArcHeight(30.0);
        hurtBar.setStroke(Color.rgb(0,0,0,.5));
        hurtBar.setStrokeWidth(10);

        healthBar = new Rectangle();
        healthBar.setFill(Color.rgb(50,205,50,.87));
        healthBar.setHeight(28);
        healthBar.setWidth(health);
        healthBar.setArcWidth(30.0);
        healthBar.setArcHeight(30.0);



        stackPane = new StackPane(hurtBar,healthBar);
        stackPane.setLayoutY(35);

        label.setLayoutY(10);

        return new Group(label, stackPane);
    }

    public void setLayoutX(double value1, double value2){
        stackPane.setLayoutX(value1);
        label.setLayoutX(value2);
    }

    double value = 0;
    public enum Damage {
            Player,Enemy
    }
    public void setDamage(double damage,Damage person){
        value = value + damage;
        health = health - damage;
        healthBar.setWidth(health);
        if(person == Damage.Player){
            healthBar.setTranslateX(-value/2);
        }else healthBar.setTranslateX(value/2);

    }



}

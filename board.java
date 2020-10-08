/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrayproject;

import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class board {

    Circle c = new Circle();

    void rasmSafhe(Group root) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Rectangle r = new Rectangle();
                r.setX(j * 100);
                r.setY(i * 100);
                r.setWidth(100);
                r.setHeight(100);
                if ((i + j) % 2 == 0) {
                    r.setFill(Color.WHITE);
                } else {
                    r.setFill(Color.BLACK);
                }
                root.getChildren().add(r);
            }
        }
    }

    void rasmAsb(int i, int j, Group root) {
        c.setRadius(50);
        c.setCenterX(50 + (100 * i));
        c.setCenterY(50 + (100 * j));
        c.setFill(Color.BLUE);
        root.getChildren().add(c);

    }

    void setText(Group root) {
        Text text = new Text();
        text.setText("KEEP CLICKING ON THE CIRCLE TO MOVE THE CIRCLE");
        text.setX(100);
        text.setY(830);
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        text.setFill(Color.WHITE);
        root.getChildren().add(text);
    }
}

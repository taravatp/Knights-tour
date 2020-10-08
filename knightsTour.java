/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrayproject;

import java.util.ArrayList;
import java.util.Random;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author taravat
 */
public class knightsTour extends Application {

    public int m = 1;
    public Group root = new Group();

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(root, 800, 850);
        scene.setFill(Color.DARKBLUE);
        stage.setScene(scene);
        board board = new board();
        board.setText(root);//texte paine safe ra mikeshad
        board.rasmSafhe(root);//safe shatranj ro mikeshe
        int a[][] = new int[8][8];
        setPriority(a);//meghdar dehie avale khane ha
        Random i = new Random();//random mokhtasate asb
        int x = i.nextInt(8);
        Random j = new Random();//random mokhtasate asb
        int y = j.nextInt(8);
        a[x][y] = 0;
        print(a);

        board.rasmAsb(x, y, root);
        scene.setOnMouseClicked((MouseEvent t) -> {
            if ((t.getX() <= board.c.getCenterX() + 50 && t.getX() >= board.c.getCenterX() - 50) && (t.getY() >= board.c.getCenterY() - 50 && t.getY() <= board.c.getCenterY() + 50)) {
                if (m < 64) {
                    index index1;
                    int ii = (int) (board.c.getCenterX() - 50) / 100;//i e mabda
                    int jj = (int) (board.c.getCenterY() - 50) / 100;//j e mabda
                    index1 = check(a, ii, jj);//in maghsad ro bedast miare
                    System.out.println("harkat mikone az i=" + ii + " va j=" + jj);
                    System.out.println("miravad be i=" + index1.i + " va j=" + index1.j);
                    board.c.setCenterX(board.c.getCenterX() + (index1.i - ii) * 100);
                    board.c.setCenterY(board.c.getCenterY() + (index1.j - jj) * 100);
                    m++;
                    //ta khate 80 baraye keshidane zarbdar hast
                    Line l1 = new Line();
                    l1.setStartX(ii * 100);
                    l1.setStartY(jj * 100);
                    l1.setEndX(100 + (ii * 100));
                    l1.setEndY(100 + (jj * 100));
                    l1.setStroke(Color.RED);
                    l1.setFill(Color.RED);
                    l1.setStrokeWidth(5);
                    root.getChildren().add(l1);
                    Line l2 = new Line();
                    l2.setStartX(100 + (ii * 100));
                    l2.setStartY(100 * jj);
                    l2.setEndX(100 * ii);
                    l2.setEndY(100 + (100 * jj));
                    l2.setStroke(Color.RED);
                    l2.setFill(Color.RED);
                    l2.setStrokeWidth(5);
                    root.getChildren().add(l2);
                    print(a);
                    if (m == 64) {//vaghti bazi tamam shod done ra chap mikonad
                        Text text = new Text();
                        text.setText("DONE!!:)");
                        text.setX(board.c.getCenterX() - 40);
                        text.setY(board.c.getCenterY());
                        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
                        text.setFill(Color.WHITE);
                        root.getChildren().add(text);
                    }
                }
            }
        });

        stage.show();

    }

    public void setPriority(int a[][]) {
        a[0][0] = a[0][7] = a[7][0] = a[7][7] = 2;
        a[0][1] = a[1][0] = a[0][6] = a[1][7] = a[6][0] = a[7][1] = a[7][6] = a[6][7] = 3;
        a[1][1] = a[1][6] = a[6][1] = a[6][6] = 4;
        for (int i = 2; i < 6; i++) {
            a[0][i] = 4;
            a[1][i] = 6;
            a[i][0] = 4;
            a[i][1] = 6;
            a[7][i] = 4;
            a[6][i] = 6;
            a[i][7] = 4;
            a[i][6] = 6;
        }
        for (int i = 2; i <= 5; i++) {
            for (int j = 2; j <= 5; j++) {
                a[i][j] = 8;
            }
        }
    }

    public index check(int a[][], int x, int y) {
        ArrayList<Integer> row = new ArrayList<Integer>();
        ArrayList<Integer> col = new ArrayList<Integer>();
        ArrayList<Integer> value = new ArrayList<Integer>();
        if (x < 7 && y > 1 && a[x + 1][y - 2] != 0) {
            row.add(x + 1);
            col.add(y - 2);
            value.add(a[x + 1][y - 2]);
            a[x + 1][y - 2]--;
        }
        if (x < 7 && y < 6 && a[x + 1][y + 2] != 0) {
            row.add(x + 1);
            col.add(y + 2);
            value.add(a[x + 1][y + 2]);
            a[x + 1][y + 2]--;
        }
        if (x < 6 && y > 0 && a[x + 2][y - 1] != 0) {
            row.add(x + 2);
            col.add(y - 1);
            value.add(a[x + 2][y - 1]);
            a[x + 2][y - 1]--;
        }
        if (x < 6 && y < 7 && a[x + 2][y + 1] != 0) {
            row.add(x + 2);
            col.add(y + 1);
            value.add(a[x + 2][y + 1]);
            a[x + 2][y + 1]--;
        }
        if (x > 0 && y > 1 && a[x - 1][y - 2] != 0) {
            row.add(x - 1);
            col.add(y - 2);
            value.add(a[x - 1][y - 2]);
            a[x - 1][y - 2]--;
        }
        if (x > 0 && y < 6 && a[x - 1][y + 2] != 0) {
            row.add(x - 1);
            col.add(y + 2);
            value.add(a[x - 1][y + 2]);
            a[x - 1][y + 2]--;
        }
        if (x > 1 && y > 0 && a[x - 2][y - 1] != 0) {
            row.add(x - 2);
            col.add(y - 1);
            value.add(a[x - 2][y - 1]);
            a[x - 2][y - 1]--;
        }
        if (x > 1 && y < 7 && a[x - 2][y + 1] != 0) {
            row.add(x - 2);
            col.add(y + 1);
            value.add(a[x - 2][y + 1]);
            a[x - 2][y + 1]--;
        }
        int min = 10;
        index index = new index();
        System.out.println("harakate mOmken=");
        for (int i = 0; i < value.size(); i++) {
            System.out.println("row=" + row.get(i) + "  col=" + col.get(i) + "  value=" + value.get(i));
        }
        for (int i = 0; i < value.size(); i++) {
            if (value.get(i) < min) {
                min = value.get(i);
                index.i = row.get(i);
                index.j = col.get(i);
            }
        }
        a[index.i][index.j] = 0;//bade inke too har kho0nei gharar migire o0n kho0ne sefr mishe
        return index;
    }

    public void print(int a[][]) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(a[i][j]);
            }
            System.out.println("");
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

}

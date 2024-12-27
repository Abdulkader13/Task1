package com.example.decorator;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Presents extends TreeDecorator {
    public Presents(ChristmasTree tree) {
        super(tree);
    }

    @Override
    public void draw(Pane pane) {
        super.draw(pane);
        drawWithPresents(pane);
    }

    private void drawWithPresents(Pane pane) {
        Rectangle present1 = new Rectangle();
        present1.setX(115);
        present1.setY(370);
        present1.setWidth(70);
        present1.setHeight(50);
        present1.setArcWidth(20);
        present1.setArcHeight(20);
        present1.setFill(Color.PURPLE.darker());

        Rectangle present2 = new Rectangle();
        present2.setX(270);
        present2.setY(400);
        present2.setWidth(40);
        present2.setHeight(20);
        present2.setFill(Color.BLUE);

        Rectangle brownPresent = new Rectangle();
        brownPresent.setX(200);
        brownPresent.setY(370);
        brownPresent.setWidth(50);
        brownPresent.setHeight(50);
        brownPresent.setFill(Color.PINK);

        Rectangle present3 = new Rectangle();
        present3.setX(320);
        present3.setY(369);
        present3.setWidth(30);
        present3.setHeight(50);
        present3.setFill(Color.YELLOW);

        pane.getChildren().addAll(present1, brownPresent, present2, present3);
    }
}

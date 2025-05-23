package com.example.decorator;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Presents extends TreeDecorator {
    private Color color;
    private double xPosition, yPosition;

    public Presents(ChristmasTree tree, Color color, double xPosition, double yPosition) {
        super(tree);
        this.color = color;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    @Override
    public void draw(Pane pane) {
        super.draw(pane);
        drawWithPresents(pane);
    }

    private void drawWithPresents(Pane pane) {
        Rectangle present = new Rectangle(xPosition, yPosition, 60, 40);
        present.setFill(color);
        pane.getChildren().add(present);
    }
}
